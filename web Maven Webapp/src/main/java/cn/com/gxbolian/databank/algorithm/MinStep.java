package cn.com.gxbolian.databank.algorithm;
import java.util.List;

public class MinStep {
	private boolean reachable;// 是否可达
	private int minStep;// 最短步长
	private List<String> step;// 最短路径

	public MinStep() {
	}

	public MinStep(boolean reachable, int minStep) {
		this.reachable = reachable;
		this.minStep = minStep;
	}

	public boolean isReachable() {
		return reachable;
	}

	public void setReachable(boolean reachable) {
		this.reachable = reachable;
	}

	public int getMinStep() {
		return minStep;
	}

	public void setMinStep(int minStep) {
		this.minStep = minStep;
	}

	public List<String> getStep() {
		return step;
	}

	public void setStep(List<String> step) {
		this.step = step;
	}
}
