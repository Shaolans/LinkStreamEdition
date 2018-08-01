package linkstream.edition.process;

import java.io.FileNotFoundException;
import java.util.List;

import linkstream.edition.structure.DiscreteLink;
import linkstream.edition.structure.IntervalLink;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		List<DiscreteLink> l = DataReader.readFile("DataSet/rollernet.dyn");
		List<IntervalLink> il = DataReader.construct_interval(l);
		for(IntervalLink i: il) {
			if(i.getMin() != i.getMax()) {
				System.out.println(i);
			}
		}
		

	}

}
