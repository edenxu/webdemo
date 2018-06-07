public class Test {
	public static String[] text = { "A", "F", "D", "L" };

	public static void main(String[] args) {
		// List<String[]> list = new ArrayList<String[]>();
		permutation(text, 0, text.length);
		// list = permutationDemo(text, 0, text.length);
		// Gson gson = new Gson();
		// System.out.println(gson.toJson(list));
		// System.out.println("======" + list.size());
		System.exit(0);
	}

	/**
	 * 全排列输出
	 * 
	 * @param a[]
	 *            要输出的字符数组
	 * @param m
	 *            输出字符数组的起始位置
	 * @param n
	 *            输出字符数组的长度
	 */
	public static void permutation(String a[], int m, int n) {
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
			printResult(a);
		}
	}

	/**
	 * 输出指定字符数组
	 * 
	 * @param text
	 *            将要输出的字符数组
	 */
	public static void printResult(String[] text) {
		for (int i = 0; i < text.length; i++) {
			System.out.print(text[i]);
		}
		System.out.println();
	}
}