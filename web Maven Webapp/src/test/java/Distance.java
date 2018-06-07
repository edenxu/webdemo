import java.util.HashMap;

public interface Distance {

	public static final MinStep UNREACHABLE = new MinStep(false, -1);

	/**
	 * @param start
	 * @param end
	 * @param stepLength
	 * @return
	 * @Author:lulei
	 * @Description: 起点到终点的最短路径
	 */
	public MinStep getMinStep(String start, String end, final HashMap<String, HashMap<String, Integer>> stepLength);

}
