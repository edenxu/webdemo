package cn.com.gxbolian.databank.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.gxbolian.databank.algorithm.Distance;
import cn.com.gxbolian.databank.algorithm.DistanceDijkstraImpl;
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
		sb.append("SELECT ");
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

}
