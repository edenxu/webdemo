package cn.com.gxbolian.databank.util;

import java.io.File;
import java.io.FileInputStream;
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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.com.gxbolian.databank.algorithm.Distance;
import cn.com.gxbolian.databank.algorithm.DistanceImpl;
import cn.com.gxbolian.databank.entity.XtpzSjzd;

public class CommonUtil {

	public static Logger log = LogManager.getLogger(CommonUtil.class);

	/**
	 * 根据字段清单计算并返回一个去重后的涉及数据表数组
	 * 
	 * @param list
	 *            统计查询字段清单
	 * @return
	 */
	public static String[] TableListDuplicateRemoval(List<XtpzSjzd> list) {
		int j = list.size();
		List<String> swapList = new ArrayList<String>();
		for (int i = 0; i < j; i++) {
			// 如果源表名称为空则跳过[诸如COUNT(1)等聚合类的操作源表名称是空的,在考虑连通图的时候不需要参与处理]
			if ("".equals(list.get(i).getYbmc())) {
				continue;
			}
			swapList.add(list.get(i).getYbmc());
		}
		String[] container = new String[swapList.size()];
		swapList.toArray(container);
		// log.info("container:" + container.length);
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
				// 将字段名中的单个双引号转义为两个双引号
				// sb.append(list.get(i).getYbzd()).append(" AS
				// \"").append(list.get(i).getYbzd()).append("\",");
				sb.append(list.get(i).getYbzd()).append(" AS \"").append(list.get(i).getYbzd().replaceAll("\"", "\"\""))
						.append("\",");
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
	 * 返回数组序列中，相邻两个节点最优路线的合并总线路【穷举法】
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
			Distance distance = new DistanceImpl();	
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

	/**
	 * 数据量少于50000的时候采用的简单Excel导出处理方法
	 * 
	 * @param head
	 *            表头信息
	 * @param body
	 *            数据表内容信息
	 * @return
	 */
	public static String exportDataToExcel(List<Map<String, Object>> head, List<List<Map<String, Object>>> body) {
		if (head.size() <= 0 || body.size() <= 0) {
			return "";
		}
		// 创建工作簿
		SXSSFWorkbook workBook = new SXSSFWorkbook(10000); // 内存中只保存1000行数据，超出部分刷到缓存，避免内存溢出的情况发生
		// 创建工作表
		Sheet sheet = workBook.createSheet("数据统计结果");
		Iterator<Map<String, Object>> itHead = head.iterator();
		// 创建行
		int rowNum = 0, cellNum = 0;
		Row row = sheet.createRow(rowNum);
		while (itHead.hasNext()) {
			Cell cell = row.createCell(cellNum, CellType.STRING);
			String tempValue = itHead.next().get("title").toString();
			log.debug("tempValue:" + tempValue);
			cell.setCellValue(tempValue);
			cellNum++;
		}
		rowNum++;
		cellNum = 0;
		String cellValue = "", cellType = "";
		Cell cell = null;
		Iterator<List<Map<String, Object>>> itBody = body.iterator();
		List<Map<String, Object>> mapList = null;
		Iterator<Map<String, Object>> it = null;
		while (itBody.hasNext()) {
			row = sheet.createRow(rowNum);
			// 对每一行数据进行处理【数据中每一个Map只有一对键值，即一个字段，分别为字段名和值】
			mapList = itBody.next();
			it = mapList.iterator();
			while (it.hasNext()) {
				Map<String, Object> map = it.next();
				for (Object entry : map.values()) {
					// 数据库中字段内容为NULL时，如不进行处理会报出空指针异常，因此需要特殊处理
					cellValue = entry == null ? "" : entry.toString();
					cellType = entry == null ? "" : entry.getClass().getName();
					if ("java.lang.String".equals(cellType)) {
						cell = row.createCell(cellNum);
						cell.setCellValue(String.valueOf(cellValue));
					} else if ("java.math.BigDecimal".equals(cellType) || "java.lang.Long".equals(cellType)) {
						cell = row.createCell(cellNum);
						cell.setCellValue(Double.parseDouble(cellValue));
					} else {
						cell = row.createCell(cellNum);
						cell.setCellValue(String.valueOf(cellValue));
					}
					cellNum++;
					cell = null;
				}
			}
			rowNum++;
			cellNum = 0;
			row = null;
		}
		FileOutputStream outputStream = null;
		String fileName = UUID.randomUUID().toString().replace("-", "").toLowerCase() + ".xlsx";
		try {
			// 创建文件
			PropertiesUtil propUtil = new PropertiesUtil("config.properties");
			String exportDir = propUtil.get("export.dir");
			createDirectoryAndFile(exportDir, fileName);
			File f = new File(exportDir + fileName);
			f.setWritable(true, false);
			f.setReadable(true, false);
			outputStream = new FileOutputStream(f);
			workBook.write(outputStream);
			outputStream.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				workBook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (outputStream != null) {
					outputStream.close();
				}
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
			file.mkdir();
		}
		file = new File(path + fileName);
		file.setWritable(true, false);
		file.setReadable(true, false);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 生成导出Excel的模板文件
	 * 
	 * @param fileName
	 *            文件名【含路径】
	 * @param head
	 *            表头数据信息
	 */
	public static void exportDataToExcelHead(String fileName, List<Map<String, Object>> head) {
		if (head.size() <= 0) {
			return;
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
			XSSFCell cell = row.createCell(cellNum, CellType.STRING);
			String tempValue = itHead.next().get("title").toString();
			cell.setCellValue(tempValue);
			cellNum++;
		}

		FileOutputStream outputStream = null;
		try {
			File f = new File(fileName);
			f.setWritable(true, false);
			f.setReadable(true, false);
			outputStream = new FileOutputStream(f);
			workBook.write(outputStream);
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workBook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 导出数据到Excel
	 * 
	 * @param templateFileName
	 *            模板文件【数据表头】
	 * @param fileIndex
	 *            当前文件的序号【数据量大的时候需要拆分成多个Excel文件】
	 * @param body
	 *            需要写入数据的内容
	 */
	public static void exportDataToExcelBody(String templateFileName, int fileIndex,
			List<List<Map<String, Object>>> body) {
		if (body.size() == 0) {
			return;
		}
		FileInputStream excelFileInputStream = null;
		SXSSFWorkbook workBook = null;
		XSSFWorkbook wb = null;
		try {
			excelFileInputStream = new FileInputStream(templateFileName);
			// 创建工作簿
			wb = new XSSFWorkbook(excelFileInputStream);
			workBook = new SXSSFWorkbook(wb, 1000);
			workBook.setCompressTempFiles(true);
			excelFileInputStream.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建工作表
		Sheet sheet = workBook.getSheet("数据统计结果");
		// 创建行
		int cellNum = 0, rowNum = 1;
		Row row = null;
		String cellValue = "", cellType = "";
		Cell cell = null;
		Iterator<List<Map<String, Object>>> itBody = body.iterator();
		List<Map<String, Object>> mapList = null;
		Iterator<Map<String, Object>> it = null;
		while (itBody.hasNext()) {
			row = sheet.createRow(rowNum);
			// 对每一行数据进行处理【数据中每一个Map只有一对键值，即一个字段，分别为字段名和值】
			mapList = itBody.next();
			it = mapList.iterator();
			while (it.hasNext()) {
				Map<String, Object> map = it.next();
				for (Object entry : map.values()) {
					// 数据库中字段内容为NULL时，如不进行处理会报出空指针异常，因此需要特殊处理
					cellValue = entry == null ? "" : entry.toString();
					cellType = entry == null ? "" : entry.getClass().getName();
					if ("java.lang.String".equals(cellType)) {
						cell = row.createCell(cellNum);
						cell.setCellValue(String.valueOf(cellValue));
					} else if ("java.math.BigDecimal".equals(cellType) || "java.lang.Long".equals(cellType)) {
						cell = row.createCell(cellNum);
						cell.setCellValue(Double.parseDouble(cellValue));
					} else {
						cell = row.createCell(cellNum);
						cell.setCellValue(String.valueOf(cellValue));
					}
					cellNum++;
					cell = null;
				}
			}
			rowNum++;
			cellNum = 0;
			row = null;
		}
		FileOutputStream outputStream = null;
		try {
			String outputFileNmae = templateFileName.substring(0, templateFileName.indexOf("template")) + fileIndex
					+ ".xlsx";
			outputStream = new FileOutputStream(outputFileNmae, true);
			workBook.write(outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workBook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 删除临时文件
			if (wb != null) {
				workBook.dispose();
			}
		}
	}

}
