import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import cn.com.gxbolian.databank.util.CommonUtil;

public class DistanceTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, HashMap<String, Integer>> stepLength = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> step1 = new HashMap<String, Integer>();
		stepLength.put("A", step1);
		step1.put("B", 1);
		step1.put("E", 1);
		step1.put("I", 1);

		HashMap<String, Integer> step2 = new HashMap<String, Integer>();
		stepLength.put("B", step2);
		step2.put("A", 1);
		step2.put("F", 1);
		step2.put("C", 1);

		HashMap<String, Integer> step3 = new HashMap<String, Integer>();
		stepLength.put("C", step3);
		step3.put("B", 1);
		step3.put("F", 1);
		step3.put("D", 1);
		step3.put("H", 1);

		HashMap<String, Integer> step4 = new HashMap<String, Integer>();
		stepLength.put("D", step4);
		step4.put("C", 1);

		HashMap<String, Integer> step5 = new HashMap<String, Integer>();
		stepLength.put("E", step5);
		step5.put("A", 1);

		HashMap<String, Integer> step6 = new HashMap<String, Integer>();
		stepLength.put("F", step6);
		step6.put("B", 1);
		step6.put("C", 1);
		step6.put("G", 1);

		HashMap<String, Integer> step7 = new HashMap<String, Integer>();
		stepLength.put("G", step7);
		step7.put("F", 1);
		step7.put("J", 1);

		HashMap<String, Integer> step8 = new HashMap<String, Integer>();
		stepLength.put("H", step8);
		step8.put("K", 1);
		step8.put("L", 1);
		step8.put("C", 1);

		HashMap<String, Integer> step9 = new HashMap<String, Integer>();
		stepLength.put("I", step9);
		step9.put("A", 1);

		HashMap<String, Integer> step10 = new HashMap<String, Integer>();
		stepLength.put("J", step10);
		step10.put("G", 1);

		HashMap<String, Integer> step11 = new HashMap<String, Integer>();
		stepLength.put("K", step11);
		step11.put("H", 1);
		step11.put("L", 1);

		HashMap<String, Integer> step12 = new HashMap<String, Integer>();
		stepLength.put("L", step12);
		step12.put("K", 1);
		step12.put("H", 1);

		/////////////////////////////////////////////////
		Gson gson = new Gson();
		String[] array = { "A", "I", "D", "L" };
		System.out.println(new Gson().toJson(stepLength));
		List<String> finalResult = new ArrayList<String>();
		finalResult = CommonUtil.findOutTheBestRoadForTheArray(array, stepLength);
		// System.out.println("list size:" + list.size());
		System.out.println("==========================final===========================");
		System.out.println(gson.toJson(finalResult));
		System.exit(0);
	}
}
