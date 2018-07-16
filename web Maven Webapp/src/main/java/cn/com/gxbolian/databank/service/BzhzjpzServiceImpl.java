package cn.com.gxbolian.databank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cn.com.gxbolian.databank.dao.IGreenplumCommonDAO;
import cn.com.gxbolian.databank.dao.XtpzBzhzjpzGlMapper;
import cn.com.gxbolian.databank.dao.XtpzBzhzjpzMapper;
import cn.com.gxbolian.databank.dao.XtpzBzhzjpzScMapper;
import cn.com.gxbolian.databank.dao.XtpzBzhzjpzSrMapper;
import cn.com.gxbolian.databank.dao.XtpzSjglysGxhMapper;
import cn.com.gxbolian.databank.dao.XtpzSjyGxhMapper;
import cn.com.gxbolian.databank.dao.XtpzSjzdGxhMapper;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpz;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpzGl;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpzGlExample;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpzSc;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpzScExample;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpzSr;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpzSrExample;
import cn.com.gxbolian.databank.entity.XtpzSjglysGxh;
import cn.com.gxbolian.databank.entity.XtpzSjyGxh;
import cn.com.gxbolian.databank.entity.XtpzSjzdGxh;
import cn.com.gxbolian.databank.util.IdWorker;

@Service
public class BzhzjpzServiceImpl implements IBzhzjpzService {
	protected final Logger log = LogManager.getLogger(BzhzjpzServiceImpl.class);
	@Autowired
	private XtpzBzhzjpzMapper bzhzjpzDao;
	@Autowired
	private XtpzBzhzjpzSrMapper srDao;
	@Autowired
	private XtpzBzhzjpzScMapper scDao;
	@Autowired
	private XtpzBzhzjpzGlMapper glDao;
	@Autowired
	private IGreenplumCommonDAO greenplumCommonDAOImpl;
	@Autowired
	private IDemoService demoService;
	@Autowired
	private XtpzSjyGxhMapper sjyGxhDao;
	@Autowired
	private XtpzSjzdGxhMapper sjzdGxhDao;
	@Autowired
	private XtpzSjglysGxhMapper sjzdglysGxhDao;

	@Override
	public List<XtpzBzhzjpzSr> getBzhzjpzSrQd(String lsh) {
		XtpzBzhzjpzSrExample srExample = new XtpzBzhzjpzSrExample();
		srExample.createCriteria().andBzhlshEqualTo(lsh);
		srExample.setOrderByClause(" lsh asc ");
		return srDao.selectByExample(srExample);
	}

	@Override
	public String generateDataInSpecialPlugin(List<String> params, String operator) {
		// params 第一位为定制化配置流水号，自定义数据集名称
		String lsh = params.get(0);
		String nickName = params.get(1);
		params.remove(0);
		params.remove(0);
		XtpzBzhzjpz bzhzjpz = new XtpzBzhzjpz();
		bzhzjpz = bzhzjpzDao.selectByPrimaryKey(lsh);
		String sql = bzhzjpz.getJb();
		log.info("标准化组件:" + bzhzjpz.getMc() + ",对应脚本:" + sql);
		String finalSql = new String("");
		IdWorker worker = new IdWorker(2);
		Matcher slashMatcher = Pattern.compile("\\?").matcher(sql);
		int index = 0, pointer = 0;
		while (slashMatcher.find()) {
			finalSql += sql.substring(pointer, slashMatcher.start()) + params.get(index);
			pointer = slashMatcher.start() + 1;
			index++;
		}
		finalSql += sql.substring(pointer);
		log.info("标准化组件:" + bzhzjpz.getMc() + ",替换完？后对应脚本:" + finalSql);
		slashMatcher = Pattern.compile("\\@[0-9]+").matcher(finalSql);
		sql = "";
		index = 0;
		pointer = 0;
		while (slashMatcher.find()) {
			// 获取标签的序号，例如：@1 表示用第一个变量填充，下标从0开始
			int idx = Integer.valueOf(finalSql.substring(slashMatcher.start() + 1, slashMatcher.end()));
			sql += finalSql.substring(pointer, slashMatcher.start()) + params.get(idx);
			pointer = slashMatcher.end();
		}
		sql += finalSql.substring(pointer);
		String tableName = "AUTO_" + String.valueOf(worker.nextId());
		log.info("标准化组件:" + bzhzjpz.getMc() + ",代入参数后对应脚本:" + sql);

		IdWorker id = new IdWorker(2); // 生成数据
		greenplumCommonDAOImpl.createTableAsSelectSQL(tableName, sql);
		// 生成数据表基础记录信息
		demoService.insertAutoGenerateTableInfo(tableName, nickName, operator, "N");
		// 生成个性化数据域信息
		XtpzSjyGxh sjy = new XtpzSjyGxh();
		sjy.setSjybm(String.valueOf(id.nextId()));
		sjy.setSjymc(nickName);
		sjy.setFlbm("999");
		sjy.setCzybm(operator);
		sjy.setBz("");
		sjyGxhDao.insert(sjy);
		// 生成数据字典信息
		XtpzBzhzjpzScExample bzhzjpzScExample = new XtpzBzhzjpzScExample();
		bzhzjpzScExample.createCriteria().andBzhlshEqualTo(lsh);
		bzhzjpzScExample.setOrderByClause(" lsh asc ");
		List<XtpzBzhzjpzSc> bzhzjpzScList = new ArrayList<XtpzBzhzjpzSc>();
		bzhzjpzScList = scDao.selectByExample(bzhzjpzScExample);
		for (XtpzBzhzjpzSc sc : bzhzjpzScList) {
			XtpzSjzdGxh gxh = new XtpzSjzdGxh();
			gxh.setZdbm(String.valueOf(id.nextId()));
			gxh.setSjybm(sjy.getSjybm());
			gxh.setZdmc(sc.getZdmc());
			gxh.setYbmc(tableName);
			gxh.setYbzd(tableName + "." + sc.getZdbm());
			gxh.setSjlx(sc.getSjlx());
			gxh.setJhbz(sc.getJhbz());
			gxh.setXlzdbm(sc.getXlzdbm());
			gxh.setCzybm(operator);
			gxh.setZjbz(sc.getZjbz());
			sjzdGxhDao.insert(gxh);
		}
		// 生成个性化关联映射信息
		List<XtpzBzhzjpzGl> glList = new ArrayList<XtpzBzhzjpzGl>();
		XtpzBzhzjpzGlExample bzhzjpzGlExample = new XtpzBzhzjpzGlExample();
		bzhzjpzGlExample.createCriteria().andBzhlshEqualTo(lsh);
		bzhzjpzGlExample.setOrderByClause(" lsh asc");
		glList = glDao.selectByExample(bzhzjpzGlExample);
		Iterator<XtpzBzhzjpzGl> it = glList.iterator();
		while (it.hasNext()) {
			XtpzBzhzjpzGl bzhzjpzGl = it.next();
			log.info("个性化关联映射信息:" + new Gson().toJson(bzhzjpzGl).toString());
			XtpzSjglysGxh sjglysGxh = new XtpzSjglysGxh();
			sjglysGxh.setLsh(String.valueOf(id.nextId()));
			sjglysGxh.setYbmca(tableName);
			sjglysGxh.setYbzda(tableName + "." + bzhzjpzGl.getZdmc());
			sjglysGxh.setYbmcb(bzhzjpzGl.getGlsjb());
			sjglysGxh.setYbzdb(bzhzjpzGl.getGlzd());
			sjglysGxh.setCzybm(operator);
			sjzdglysGxhDao.insert(sjglysGxh);
			sjglysGxh.setLsh(String.valueOf(id.nextId()));
			sjglysGxh.setYbmcb(tableName);
			sjglysGxh.setYbzdb(tableName + "." + bzhzjpzGl.getZdmc());
			sjglysGxh.setYbmca(bzhzjpzGl.getGlsjb());
			sjglysGxh.setYbzda(bzhzjpzGl.getGlzd());
			sjglysGxh.setCzybm(operator);
			sjzdglysGxhDao.insert(sjglysGxh);
		}
		return tableName;
	}

}
