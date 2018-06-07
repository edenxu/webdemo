package cn.com.gxbolian.databank.util;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	private List<String[]> result = new ArrayList<String[]>();

	public List<String[]> getResult() {
		return result;
	}

	public void setResult(List<String[]> result) {
		this.result = result;
	}

	public void permutation(String a[], int m, int n) {
		int i;
		String t;
		if (m < n - 1) {
			permutation(a, m + 1, n);
			for (i = m + 1; i < n; i++) {
				t = a[m];
				a[m] = a[i];
				a[i] = t;
				permutation(a, m + 1, n);
				t = a[m];
				a[m] = a[i];
				a[i] = t;
			}
		} else {
			String[] swap = new String[a.length];
			for (int j = 0; j < a.length; j++) {
				swap[j] = a[j];
			}
			result.add(swap);
		}
	}
}
