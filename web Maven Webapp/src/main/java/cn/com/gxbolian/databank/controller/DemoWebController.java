package cn.com.gxbolian.databank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.google.gson.Gson;

import cn.com.gxbolian.databank.entity.BootstrapTreeViewEntity;
import cn.com.gxbolian.databank.entity.ParamsObject;
import cn.com.gxbolian.databank.entity.XtpzXlcs;
import cn.com.gxbolian.databank.service.IDemoService;
import cn.com.gxbolian.databank.util.CommonUtil;

@Controller
// @RequestMapping(value = "/demoWeb")
public class DemoWebController {
	protected final Logger log = LogManager.getLogger(DemoWebController.class);

	@Autowired
	private IDemoService demoService;

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
		// return demoService.getNodeInfoForTree(flbm);
		// Gson gson = new Gson();
		// return
		// gson.toJson(demoService.getNodeInfoForBootstrapTreeviewEntity(flbm));
		return demoService.getNodeInfoForBootstrapTreeviewEntity(flbm);
	}

	@RequestMapping(value = "getSjyByExampleZTree", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getSjyByExampleZTree(HttpServletRequest request, HttpServletResponse response) {
		String flbm = request.getParameter("zdbm") == null ? "0" : request.getParameter("zdbm");
		return demoService.getNodeInfoForTree(flbm);
	}

	@RequestMapping(value = "dealSelectedSQL", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> dealSelectedSQL(HttpServletRequest request, HttpServletResponse response,
			@RequestBody ParamsObject object) {
		Map<String, Object> map = new HashMap<String, Object>();
		String makeupSQL = demoService.makeUpSelectSQL(object);
		log.info(makeupSQL);
		String tableName = demoService.createTableAsSelectSQL(makeupSQL);
		map.put("columns", demoService.getTableColumnNameAndDescription(tableName));
		map.put("tableName", tableName);
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
				orderByMode, limit, offset);
		map.put("tableName", tableName);
		return map;
	}

	@RequestMapping(value = "getColumnDropDownList", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> getColumnDropDownList(HttpServletRequest request, HttpServletResponse response) {
		String zdbm = request.getParameter("zdbm") == null ? "" : request.getParameter("zdbm");
		XtpzXlcs xlcs = new XtpzXlcs();
		xlcs.setZdbm(zdbm);
		List<XtpzXlcs> list = demoService.getXtpzXlcsListByExample(xlcs);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", list);
		return map;
	}

	@RequestMapping(value = "test", produces = "application/json;charset=utf-8", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> test(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();
		graph = demoService.getAllConnectedGraphBySjzd();
		Gson gson = new Gson();
		log.info("graph:" + gson.toJson(graph));
		String[] findArray = { "A", "I", "D", "L" };
		List<String> finalResult = new ArrayList<String>();
		finalResult = CommonUtil.findOutTheBestRoadForTheArray(findArray, graph);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", graph);
		map.put("result", finalResult);
		return map;
	}

}
