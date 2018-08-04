package linkstream.edition.process;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import linkstream.edition.avl.tree.AvlTreeInterval;
import linkstream.edition.avl.tree.Interval;
import linkstream.edition.link.IntervalLink;

public class LinkStream {
	private Map<String, AvlTreeInterval> links;
	
	public LinkStream(List<IntervalLink> lil) {
		links = new HashMap<>();
		AvlTreeInterval avli;
		
		for(IntervalLink il: lil) {
			avli = links.get(il.getV1()+""+il.getV2());
			
			if(avli == null) {
				avli = links.get(il.getV2()+""+il.getV1());
				if(avli == null) {
					avli = new AvlTreeInterval();
					avli.setVertice1(il.getV1());
					avli.setVertice2(il.getV2());
					links.put(il.getV1()+""+il.getV2(), avli);
				}
			}
			
			avli.insert(new Interval(il.getMin(), il.getMax()));
		}
	}
	
	
	public Map<String, AvlTreeInterval> getLinks(){
		return links;
	}
	
	public OperationType addLink(int start, int end, int v1, int v2) {
		AvlTreeInterval avli = links.get(v1+""+v2);
		if(avli == null) {
			avli = links.get(v2+""+v1);
			if(avli == null) {
				avli = new AvlTreeInterval();
				avli.setVertice1(v1);
				avli.setVertice2(v2);
				links.put(v1+""+v2, avli);
			}
		}
		Interval merge1 = avli.findEnd(start);
		Interval merge2 = avli.findStart(end);
		if(merge1 != null && merge2 != null) {
			avli.remove(merge1);
			avli.remove(merge2);
			avli.insert(new Interval(merge1.getStart(), merge2.getEnd()));
			return OperationType.MERGE;
		}
		
		Interval iextr = avli.findEnd(start);
		if(iextr != null) {
			avli.remove(iextr);
			avli.insert(new Interval(iextr.getStart(), end));
			return OperationType.EXTEND_RIGHT;
		}
		
		Interval iextl = avli.findStart(end);
		if(iextl != null) {
			avli.remove(iextl);
			avli.insert(new Interval(start, iextl.getEnd()));
			return OperationType.EXTEND_LEFT;
		}
		
		
		avli.insert(new Interval(start, end));
		return OperationType.ADD;
	}
	
	public OperationType delLink(int start, int end, int v1, int v2) {
		AvlTreeInterval avli = links.get(v1+""+v2);
		if(avli == null) {
			avli = links.get(v2+""+v1);
			if(avli == null) {
				return OperationType.NONE;
			}
		}
		
		Interval i1 = avli.findStart(start);
		Interval i2 = avli.findEnd(end);
		
		if(i1 != null && i2 != null) {
			avli.remove(new Interval(start, end));
			return OperationType.DELETE;
		}
		
		if(i1 != null) {
			avli.remove(i1);
			avli.insert(new Interval(end+1, i1.getEnd()));
			return OperationType.SHORT_LEFT;
		}
		
		if(i2 != null) {
			avli.remove(i2);
			avli.insert(new Interval(i2.getStart(), start-1));
			return OperationType.SHORT_RIGHT;
		}
		
		return OperationType.NONE;
	}
	
	public List<IntervalLink> getIntervalLinks(){
		List<IntervalLink> l = new ArrayList<>();
		AvlTreeInterval avli;
		for(Map.Entry<String, AvlTreeInterval> entry: links.entrySet()) {
			avli = entry.getValue();
			for(Interval i: avli.getIntervals()) {
				l.add(new IntervalLink(i.getStart(), i.getEnd(), avli.getVertice1(), avli.getVertice2()));
			}
		}
		
		return l;
	}
	
	public void printAllAvl() {
		for(Map.Entry<String, AvlTreeInterval> entry: links.entrySet()) {
			entry.getValue().printAvl();
		}
	}
	
}
