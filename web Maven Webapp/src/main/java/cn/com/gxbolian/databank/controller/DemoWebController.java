package cn.com.gxbolian.databank.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.gxbolian.databank.entity.BootstrapTreeViewEntity;
import cn.com.gxbolian.databank.entity.ParamsObject;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpzSr;
import cn.com.gxbolian.databank.entity.XtpzCxfa;
import cn.com.gxbolian.databank.entity.XtpzXlcs;
import cn.com.gxbolian.databank.service.IBzhzjpzService;
import cn.com.gxbolian.databank.service.IDemoService;
import cn.com.gxbolian.databank.service.IQueryPlanService;
import cn.com.gxbolian.databank.util.CommonUtil;
import cn.com.gxbolian.databank.util.CompressUtil;
import cn.com.gxbolian.databank.util.IdWorker;
import cn.com.gxbolian.databank.util.PropertiesUtil;

@Controller
// @RequestMapping(value = "/demoWeb")
public class DemoWebController {
	protected final Logger log = LogManager.getLogger(DemoWebController.class);

	@Autowired
	private IDemoService demoService;
	@Autowired
	private IBzhzjpzService bzhzjpzService;
	@Autowired
	private IQueryPlanService queryPlanService;

	/**
	 * 内部页面重定向
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "index", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws Exception {
		String page = request.getParameter("page") == null ? "" : request.getParameter("page");
		ModelAndView mav;
		if (!page.equals("")) {
			mav = new ModelAndView(page, modelMap);
		} else {
			mav = new ModelAndView("error.html", modelMap);
		}
		return mav;
	}

	@RequestMapping(value = "getSjyByExample", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public BootstrapTreeViewEntity getSjyByExample(HttpServletRequest request, HttpServletResponse response) {
		String flbm = request.getParameter("zdbm") == null ? "000" : request.getParameter("zdbm");
		// return demoService.getNodeInfoForBootstrapTreeviewEntity(flbm);
		return demoService.getNodeInfoForBootstrapTreeviewEntity(flbm, "admin");
	}

	@RequestMapping(value = "getSjyByExampleZTree", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getSjyByExampleZTree(HttpServletRequest request, HttpServletResponse response) {
		String flbm = request.getParameter("zdbm") == null ? "0" : request.getParameter("zdbm");
		return demoService.getNodeInfoForTree(flbm, "admin");
	}

	@RequestMapping(value = "dealSelectedSQL", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> dealSelectedSQL(HttpServletRequest request, HttpServletResponse response,
			@RequestBody ParamsObject object) {
		Map<String, Object> map = new HashMap<String, Object>();
		IdWorker id = new IdWorker(2);
		String tableName = "AUTO_" + String.valueOf(id.nextId());
		String makeupSQL = "";
		makeupSQL = demoService.makeUpSelectSQL(tableName, object, "admin");
		if ("".equals(makeupSQL)) {
			map.put("sql", makeupSQL);
			return map;
		}
		log.info("当前结果集对应的SQL语句为:" + makeupSQL);
		// String tableName = demoService.createTableAsSelectSQL(makeupSQL);
		demoService.createTableAsSelectSQL(tableName, makeupSQL);
		// 获取新数据集的元数据信息
		List<Map<String, Object>> resultMeta = demoService.getTableColumnNameAndDescription(tableName, "admin");
		// 数据结果集在分析处理
		if ("Y".equals(object.getSaveFlag())) {
			// 1. 写入数据集基础信息
			demoService.insertAutoGenerateTableInfo(tableName, object.getMyTableName(), "admin", "N");
			// 2. 写入数据个性化数据字典
			// 已经放入在构造SQL语句的过程中进行处理
			// demoService.insertPersonalDirectory("admin", tableName,
			// object.getMyTableName(), resultMeta);
			// 3. 将数据集放入个性化的关系图中
			// demoService.insertPersonalGridInfo("admin", tableName,
			// resultMeta);
		} else {
			// 1. 写入数据集基础信息
			demoService.insertAutoGenerateTableInfo(tableName, object.getMyTableName(), "admin", "T");
		}
		map.put("columns", resultMeta);
		map.put("tableName", tableName);
		map.put("sql", makeupSQL);
		return map;
	}

	@RequestMapping(value = "getTableDataByTableName", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> getTableDataByTableName(HttpServletRequest request, HttpServletResponse response) {
		String tableName = request.getParameter("tableName") == null ? "" : request.getParameter("tableName");
		String limit = request.getParameter("limit") == null ? "999999999999" : request.getParameter("limit");
		String offset = request.getParameter("offset") == null ? "0" : request.getParameter("offset");
		String orderByColumn = request.getParameter("sort") == null ? "" : request.getParameter("sort");
		String orderByMode = request.getParameter("order") == null ? "asc" : request.getParameter("order");
		Map<String, Object> map = demoService.getDataForBootstrapDataTable(tableName, "", "", orderByColumn,
				orderByMode, limit, offset, "admin");
		map.put("tableName", tableName);
		return map;
	}

	@RequestMapping(value = "getColumnDropDownList", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> getColumnDropDownList(HttpServletRequest request, HttpServletResponse response) {
		String xlzdbm = request.getParameter("xlzdbm") == null ? "" : request.getParameter("xlzdbm");
		List<XtpzXlcs> list = demoService.getXtpzXlcsListByZdbm(xlzdbm);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", list);
		return map;
	}

	@RequestMapping(value = "exportData", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> exportData(HttpServletRequest request, HttpServletResponse response) {
		String tableName = request.getParameter("tableName") == null ? "" : request.getParameter("tableName");
		Map<String, Object> map = new HashMap<String, Object>();
		if ("".equals(tableName)) {
			map.put("fileName", tableName);
			return map;
		}
		long totalRows = demoService.getTotoalRowcountByTableName(tableName);
		String fileName = "";
		// 每个Excel文件的记录条数，超过的需要分多个文件保存
		int fileRecordSize = 50000;
		// 如果记录数少于50000条，则直接导出
		if (totalRows <= fileRecordSize) {
			List<Map<String, Object>> head = demoService.getTableColumnNameAndDescription(tableName, "admin");
			List<List<Map<String, Object>>> body = demoService.getDataForBootstrapDataTableToExport(tableName, "", "",
					"", "", "99999999", "0", "admin");
			fileName = CommonUtil.exportDataToExcel(head, body);
			head = null;
			body = null;
			map.put("fileName", fileName);
		} else {
			List<Map<String, Object>> head = demoService.getTableColumnNameAndDescription(tableName, "admin");
			String preFileName = UUID.randomUUID().toString().replace("-", "").toLowerCase();
			fileName = preFileName + "-template.xlsx";
			// 创建文件
			PropertiesUtil propUtil = new PropertiesUtil("config.properties");
			String exportDir = propUtil.get("export.dir");
			CommonUtil.createDirectoryAndFile(exportDir + preFileName + "\\", fileName);
			CommonUtil.exportDataToExcelHead(exportDir + preFileName + "\\" + fileName, head);
			String templateFileName = exportDir + preFileName + "\\" + fileName;
			int fileIndex = 1;
			List<List<Map<String, Object>>> body = null;
			for (long i = 0; i <= totalRows; i += fileRecordSize) {
				body = demoService.getDataForBootstrapDataTableToExport(tableName, "", "", "", "",
						String.valueOf(fileRecordSize), String.valueOf(i), "admin");
				CommonUtil.exportDataToExcelBody(templateFileName, fileIndex++, body);
				body.clear();
			}
			// 将结果集打包
			try {
				CompressUtil.compress(exportDir + preFileName, exportDir + preFileName + ".zip");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("fileName", preFileName + ".zip");
		}
		return map;
	}

	@RequestMapping(value = "drawRelationShip", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> drawRelationShip(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, HashMap<String, Integer>> relation = demoService.getAllConnectedGraphBySjzd();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rela", relation);
		return map;
	}

	@RequestMapping(value = "getBzhzjpzSrList", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> getBzhzjpzSrList(HttpServletRequest request, HttpServletResponse response) {
		String lsh = request.getParameter("lsh") == null ? "" : request.getParameter("lsh");
		Map<String, Object> map = new HashMap<String, Object>();
		List<XtpzBzhzjpzSr> list = bzhzjpzService.getBzhzjpzSrQd(lsh);
		map.put("result", list);
		return map;
	}

	@RequestMapping(value = "getBzhzjpzGrenerate", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> getBzhzjpzGrenerate(HttpServletRequest request, HttpServletResponse response,
			@RequestBody List<String> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		String tableName = bzhzjpzService.generateDataInSpecialPlugin(params, "admin");
		// 获取新数据集的元数据信息
		List<Map<String, Object>> resultMeta = demoService.getTableColumnNameAndDescription(tableName, "admin");
		// map = demoService.getDataForBootstrapDataTable(tableName, "", "", "",
		// "asc", "99999999999", "0", "admin");
		map.put("tableName", tableName);
		map.put("columns", resultMeta);
		return map;
	}

	@RequestMapping(value = "insertQueryPlan", produces = "application/json;charset=utf-8", method = {
			RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> insertQueryPlan(HttpServletRequest request, HttpServletResponse response,
			@RequestBody XtpzCxfa queryPlan) {
		Map<String, Object> map = new HashMap<String, Object>();
		queryPlan.setCzybm("admin");
		queryPlanService.insertNewQeuryPlan(queryPlan, "");
		map.put("result", "ok");
		return map;
	}

	@RequestMapping(value = "getQueryPlanByLsh", produces = "application/json;charset=utf-8", method = {
			RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> getQueryPlanByLsh(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String lsh = request.getParameter("lsh") == null ? "" : request.getParameter("lsh");
		XtpzCxfa cxfa = queryPlanService.getQueryPlanByPrimaryKey(lsh);
		map.put("result", cxfa);
		return map;
	}

}
