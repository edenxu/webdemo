package cn.com.gxbolian.databank.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import cn.com.gxbolian.databank.util.Permutation;

public class FindBestRoadHandler {
	protected final Logger log = LogManager.getLogger(FindBestRoadHandler.class);
	private String[] array;
	private HashMap<String, HashMap<String, Integer>> stepLength;

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public HashMap<String, HashMap<String, Integer>> getStepLength() {
		return stepLength;
	}

	public void setStepLength(HashMap<String, HashMap<String, Integer>> stepLength) {
		this.stepLength = stepLength;
	}

	public FindBestRoadHandler(String[] array, HashMap<String, HashMap<String, Integer>> stepLength) {
		this.array = array;
		this.stepLength = stepLength;
	}

	/**
	 * 返回数组序列中，某一个数组前后两两最优路线的合并总线路
	 * 
	 * @param array
	 *            序列数组
	 * @return 合并以后的路线
	 */
	public List<String> mixBestRoadForArrayByBesideNodes(String[] array,
			HashMap<String, HashMap<String, Integer>> stepLength) {
		int arraySize = array.length;
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < arraySize - 1; i++) {
			String a = array[i], b = array[i + 1];
			List<String> temp = new ArrayList<String>();
			Distance distance = new DistanceDijkstraImpl();
			log.info("A:" + a + ",B:" + b);
			log.info("stepLength:" + new Gson().toJson(stepLength));
			// 找出两个节点之间的最短路径
			temp = distance.getMinStep(a, b, stepLength).getStep();
			log.info("查找两个节点间的最短线路:" + temp);
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
	public List<String> findOutTheBestRoadForTheArray() {
		// 找出必经节点的所有序列数组
		List<String[]> list = new ArrayList<String[]>();
		Permutation p = new Permutation();
		p.permutation(array, 0, array.length);
		list = p.getResult();
		log.info("涉及表穷举序列：" + new Gson().toJson(list));
		// 假设最大的成本为999999
		int sizeFlag = 999999;
		List<String> finalResult = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String[] temp = list.get(i);
			log.info("temp：" + new Gson().toJson(temp));
			List<String> road = mixBestRoadForArrayByBesideNodes(temp, stepLength);
			log.info("road：" + new Gson().toJson(road));
			if (road.size() < sizeFlag) {
				finalResult = road;
				sizeFlag = road.size();
			}
		}
		return finalResult;
	}

}
