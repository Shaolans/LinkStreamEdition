package linkstream.edition.comparison;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import linkstream.edition.avl.tree.AvlTreeInterval;
import linkstream.edition.avl.tree.Interval;
import linkstream.edition.link.DiscreteLink;
import linkstream.edition.link.IntervalLink;
import linkstream.edition.process.DataReader;
import linkstream.edition.process.LinkStream;

public class DeletionRunningTimeGeneratedData {

	public static void main(String[] args) throws IOException {
		List<DiscreteLink> originaldata = DataReader.readFile("DataSet/generated_rollernet.dyn");
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		String file = "Comparison/generated_rollernet.time";
		fileWriter = new FileWriter(file);
		printWriter = new PrintWriter(fileWriter);
		
		for(int i = 30000; i < 1830000; i+=10000) {
			List<DiscreteLink> ltmp = originaldata.subList(0, i);
			List<IntervalLink> liltmp = DataReader.construct_interval(ltmp);
			LinkStream ls = new LinkStream(liltmp);
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
			
			for(IntervalLink tmp: liltmp) {
				if((tmp.getV1() == avli.getVertice1() && tmp.getV2() == avli.getVertice2()) || (tmp.getV2() == avli.getVertice1() && tmp.getV1() == avli.getVertice2())) {
					lils.add(tmp);
				}
			}
			for(int j = 0; j < 10000; j++) {
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
			printWriter.println(i+" "+elapsed);
			
		}
		
		printWriter.close();

	}
	


}
