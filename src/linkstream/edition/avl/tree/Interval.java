package linkstream.edition.avl.tree;

public class Interval implements Comparable<Interval> {
	private int start;
	private int end;
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public int compareTo(Interval o) {
		int starto = o.getStart();
		if(o == this || (starto == start && o.getEnd() == end)) {
			return 0;
		}
		
		if(start > starto) {
			return 1;
		}
		
		return -1;
	}
	
	public String toString() {
		return "["+start+", "+end+"]";
	}
}
