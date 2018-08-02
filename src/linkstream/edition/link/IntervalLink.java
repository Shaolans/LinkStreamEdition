package linkstream.edition.link;

public class IntervalLink {
	private int min;
	private int max;
	private int v1;
	private int v2;
	
	public IntervalLink(int min, int max, int v1, int v2) {
		this. min = min;
		this.max = max;
		this.v1 = v1;
		this.v2 = v2;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getV1() {
		return v1;
	}

	public void setV1(int v1) {
		this.v1 = v1;
	}

	public int getV2() {
		return v2;
	}

	public void setV2(int v2) {
		this.v2 = v2;
	}
	
	@Override
	public String toString() {
		return "(["+min+","+max+"],"+v1+", "+v2+")";
	}
}
