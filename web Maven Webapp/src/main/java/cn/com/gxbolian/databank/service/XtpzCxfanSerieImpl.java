package cn.com.gxbolian.databank.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.gxbolian.databank.dao.XtpzCxfaMapper;
import cn.com.gxbolian.databank.entity.XtpzCxfa;
import cn.com.gxbolian.databank.util.IdWorker;

@Service
public class XtpzCxfanSerieImpl implements IQueryPlanService {
	protected final Logger log = LogManager.getLogger(XtpzCxfanSerieImpl.class);
	@Autowired
	private XtpzCxfaMapper queryPlanDao;

	@Override
	public void addQueryPlan(XtpzCxfa queryPlan) {
		IdWorker id = new IdWorker(2);
		queryPlan.setLsh(String.valueOf(id.nextId()));
		// 如果创建时间为空，则取当前的系统时间
		if (queryPlan.getCjsj() == null) {
			queryPlan.setCjsj(new Date(System.currentTimeMillis()));
		}
		queryPlanDao.insert(queryPlan);
	}

	@Override
	public void insertNewQeuryPlan(XtpzCxfa queryPlan, String sjybm) {
		// 如果数据域编码为空，则设置为默认值
		if ("".equals(sjybm)) {
			sjybm = "9999";
			queryPlan.setSjybm(sjybm);
		}
		// 写入新的查询方案
		this.addQueryPlan(queryPlan);
	}

	@Override
	public XtpzCxfa getQueryPlanByPrimaryKey(String lsh) {
		return queryPlanDao.selectByPrimaryKey(lsh);
	}

}
