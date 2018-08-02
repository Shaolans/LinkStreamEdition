package linkstream.edition.run;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import linkstream.edition.link.DiscreteLink;
import linkstream.edition.link.IntervalLink;
import linkstream.edition.process.LinkStream;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		/*List<DiscreteLink> l = DataReader.readFile("DataSet/rollernet.dyn");
		List<IntervalLink> il = DataReader.construct_interval(l);
		for(IntervalLink i: il) {
			if(i.getMin() != i.getMax()) {
				System.out.println(i);
			}
		}*/
		
		List<IntervalLink> l = new ArrayList<>();
		LinkStream ls = new LinkStream(l);
		
		ls.addLink(1, 4, 1, 5);
		ls.addLink(6, 7, 1, 5);
		ls.addLink(9, 10, 1, 5);
		ls.addLink(15, 20, 1, 5);
		ls.addLink(24, 26, 1, 5);
		
		ls.getLinks().get("15").printAvl();
		
		ls.addLink(7, 9, 1, 5);
		
		ls.getLinks().get("15").printAvl();
		
		//ls.delLink(6, 10, 1, 5);
		//ls.delLink(8, 10, 1, 5);
		ls.delLink(6, 9, 1, 5);
		ls.delLink(10, 10, 1, 5);
		
		ls.getLinks().get("15").printAvl();

	}

}
