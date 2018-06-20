package cn.com.gxbolian.databank.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;

import cn.com.gxbolian.databank.algorithm.Distance;
import cn.com.gxbolian.databank.algorithm.DistanceDijkstraImpl;
import cn.com.gxbolian.databank.entity.XtpzSjzd;

public class CommonUtil {

	public static Logger log = LogManager.getLogger(CommonUtil.class);
	@Value("${export.dir}")
	public static String EXPORT_DIR = "D:\\360Downloads\\";

	/**
	 * 根据字段清单计算并返回一个去重后的涉及数据表数组
	 * 
	 * @param list
	 *            统计查询字段清单
	 * @return
	 */
	public static String[] TableListDuplicateRemoval(List<XtpzSjzd> list) {
		int j = list.size();
		String[] container = new String[j];
		for (int i = 0; i < j; i++) {
			container[i] = list.get(i).getYbmc();
		}
		return StringArrayDuplicateRemoval(container);
	}

	/**
	 * 根据字段清单计算并返回一个查询语句的前段SQL 比如：SELECT A.AAA,B.BBB,C.CCC
	 * 
	 * @param list
	 *            统计查询字段清单
	 * @return
	 */
	public static String pickUpSelectedColumns(List<XtpzSjzd> list) {
		int j = list.size();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT DISTINCT ");
		for (int i = 0; i < j; i++) {
			/** 源表字段非空的情况下才放到SELECT字段列表，因为部分因Where条件拓展引入的数据表只有表名称、无字段，并且是不需要字段展示的，需要排除掉 */
			if (null != list.get(i).getYbzd() && !"".equals(list.get(i).getYbzd())) {
				sb.append(list.get(i).getYbzd()).append(" AS \"").append(list.get(i).getYbzd()).append("\",");
			}
		}
		return sb.toString();
	}

	/**
	 * 字符数组去重
	 * 
	 * @param input
	 *            需要去重的数组
	 * @return
	 */
	public static String[] StringArrayDuplicateRemoval(String[] input) {
		List<String> list = new ArrayList<>();
		list.add(input[0]);
		for (int i = 1; i < input.length; i++) {
			if (list.indexOf(input[i]) == -1) {
				list.add(input[i]);
			}
		}
		String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
		return arrayResult;
	}

	/**
	 * 返回数组序列中，某一个数组前后两两最优路线的合并总线路
	 * 
	 * @param array
	 *            序列数组
	 * @return 合并以后的路线
	 */
	public static List<String> mixBestRoadForArrayByBesideNodes(String[] array,
			HashMap<String, HashMap<String, Integer>> stepLength) {
		int arraySize = array.length;
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < arraySize - 1; i++) {
			String a = array[i], b = array[i + 1];
			List<String> temp = new ArrayList<String>();
			Distance distance = new DistanceDijkstraImpl();
			// 找出两个节点之间的最短路径
			temp = distance.getMinStep(a, b, stepLength).getStep();
			if (temp != null) {
				if (i != 0) {
					// 去掉第一个重叠的节点
					temp.remove(0);
					result.addAll(temp);
				} else {
					result.addAll(temp);
				}
			}
		}
		return result;
	}

	/**
	 * 找出图中必经某些节点的最优路线
	 * 
	 * @param array
	 *            必经节点数组
	 * @param stepLength
	 *            网络图结构
	 * @return 最优路线
	 */
	public static List<String> findOutTheBestRoadForTheArray(String[] nodes,
			HashMap<String, HashMap<String, Integer>> nodeMap) {
		// 找出必经节点的所有序列数组
		List<String[]> list = new ArrayList<String[]>();
		Permutation p = new Permutation();
		p.permutation(nodes, 0, nodes.length);
		list = p.getResult();
		// 假设最大的成本为999999
		int sizeFlag = 999999;
		List<String> finalResult = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String[] tempArray = list.get(i);
			List<String> road = CommonUtil.mixBestRoadForArrayByBesideNodes(tempArray, nodeMap);
			if (road.size() < sizeFlag) {
				finalResult = road;
				sizeFlag = road.size();
			}
		}
		return finalResult;
	}

	public static String exportDataToExcel(List<Map<String, Object>> head, List<List<Map<String, Object>>> body) {
		if (head.size() <= 0 || body.size() <= 0) {
			return "";
		}
		// 创建工作簿
		XSSFWorkbook workBook = new XSSFWorkbook();
		// 创建工作表
		XSSFSheet sheet = workBook.createSheet("数据统计结果");
		Iterator<Map<String, Object>> itHead = head.iterator();
		// 创建行
		int rowNum = 0, cellNum = 0;
		XSSFRow row = sheet.createRow(rowNum);
		while (itHead.hasNext()) {
			// 创建单元格，操作第三行第三列
			XSSFCell cell = row.createCell(cellNum, CellType.STRING);
			String tempValue = itHead.next().get("title").toString();
			log.debug("tempValue:" + tempValue);
			cell.setCellValue(tempValue);
			cellNum++;
		}
		rowNum++;
		cellNum = 0;
		Iterator<List<Map<String, Object>>> itBody = body.iterator();
		while (itBody.hasNext()) {
			row = sheet.createRow(rowNum);
			List<Map<String, Object>> mapList = itBody.next();
			Iterator<Map<String, Object>> it = mapList.iterator();
			while (it.hasNext()) {
				Map<String, Object> map = it.next();
				for (Object entry : map.values()) {
					// 数据库中字段内容为NULL时，如不进行处理会报出空指针异常，因此需要特殊处理
					String cellValue = entry == null ? "" : entry.toString();
					String cellType = entry == null ? "" : entry.getClass().getName();
					if ("java.lang.String".equals(cellType)) {
						XSSFCell cell = row.createCell(cellNum, CellType.STRING);
						cell.setCellValue(cellValue);
					} else if ("java.math.BigDecimal".equals(cellType)) {
						XSSFCell cell = row.createCell(cellNum, CellType.NUMERIC);
						cell.setCellValue(cellValue);
					} else {
						XSSFCell cell = row.createCell(cellNum, CellType.STRING);
						cell.setCellValue(cellValue);
					}
					cellNum++;
				}
			}
			rowNum++;
			cellNum = 0;
		}
		FileOutputStream outputStream = null;
		String fileName = UUID.randomUUID().toString().replace("-", "").toLowerCase() + ".xlsx";
		try {
			log.debug("EXPORT_DIR:" + CommonUtil.EXPORT_DIR);
			// 创建文件
			createDirectoryAndFile(CommonUtil.EXPORT_DIR, fileName);
			File f = new File(CommonUtil.EXPORT_DIR + fileName);
			outputStream = new FileOutputStream(f);
			workBook.write(outputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				workBook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fileName;
	}

	/**
	 * 在指定的路径下创建文件
	 * 
	 * @param path
	 *            文件夹路径
	 * @param fileName
	 *            文件名
	 */
	public static void createDirectoryAndFile(String path, String fileName) {
		File file = new File(path);
		if (!file.exists()) {
			log.debug("Create directory in path:" + path);
			file.mkdir();
		}
		file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
