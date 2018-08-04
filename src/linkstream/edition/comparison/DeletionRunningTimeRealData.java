package linkstream.edition.comparison;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import linkstream.edition.avl.tree.AvlTreeInterval;
import linkstream.edition.avl.tree.Interval;
import linkstream.edition.link.IntervalLink;
import linkstream.edition.process.DataReader;
import linkstream.edition.process.LinkStream;

public class DeletionRunningTimeRealData {
	public static void main(String[] args) throws FileNotFoundException {
		List<IntervalLink> lil = DataReader.construct_interval(DataReader.readFile("DataSet/rollernet.dyn"));
		LinkStream ls = new LinkStream(lil);
		AvlTreeInterval avli = null;
		
		for(Map.Entry<String, AvlTreeInterval> entry: ls.getLinks().entrySet()) {
			if(avli == null) {
				avli = entry.getValue();
			}
			if(avli.getSize() < entry.getValue().getSize()) {
				avli = entry.getValue();
			}
		}
		
		List<IntervalLink> todelete = new ArrayList<>();
		int value;
		
		List<IntervalLink> lils = new ArrayList<>();
		
		for(IntervalLink tmp: lil) {
			if((tmp.getV1() == avli.getVertice1() && tmp.getV2() == avli.getVertice2()) || (tmp.getV2() == avli.getVertice1() && tmp.getV1() == avli.getVertice2())) {
				lils.add(tmp);
			}
		}
		
		
		for(int i = 0; i < 40; i++) {
			value = (int)(Math.random()*lils.size());
			todelete.add(lils.get(value));
			lils.remove(value);
		}
		
		Long debut = System.currentTimeMillis();
		for(IntervalLink il: todelete) {
			avli.remove(new Interval(il.getMin(), il.getMax()));
		}
		Long fin = System.currentTimeMillis();
		Long elapsed = fin - debut;

		System.out.println(elapsed);
	}
}
