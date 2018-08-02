package linkstream.edition.run;

import java.io.FileNotFoundException;

import linkstream.edition.process.DataReader;
import linkstream.edition.process.LinkStream;

public class TestRollerNet {

	public static void main(String[] args) throws FileNotFoundException {
		LinkStream ls = new LinkStream(DataReader.construct_interval(DataReader.readFile("DataSet/rollernet.dyn")));
		ls.printAllAvl();
		//5950
	}

}
