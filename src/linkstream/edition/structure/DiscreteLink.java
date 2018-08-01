package linkstream.edition.structure;

public class DiscreteLink {
	private int time;
	private int v1;
	private int v2;
	
	public DiscreteLink(int v1, int v2, int time) {
		this.v1 = v1;
		this.v2 = v2;
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
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
	
	public String toString() {
		return "("+time+", "+v1+", "+v2+")";
	}
	
}
