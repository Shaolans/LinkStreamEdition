package linkstream.edition.comparison;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import linkstream.edition.link.DiscreteLink;
import linkstream.edition.process.DataReader;

public class GenerateData {

	public static void main(String[] args) throws FileNotFoundException {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		String file = "DataSet/generated_rollernet.dyn";
		List<DiscreteLink> ll = DataReader.readFile("DataSet/rollernet.dyn");
		List<DiscreteLink> list = new ArrayList<>();
		for(DiscreteLink l: ll) {
			if(l.getV1() == 59 && l.getV2() == 50) {
				list.add(l);
			}
		}
		
		try {
			fileWriter = new FileWriter(file);
			printWriter = new PrintWriter(fileWriter);
			/*for(DiscreteLink l: ll) {
				printWriter.println(l.getV1()+" "+l.getV2()+" "+l.getTime());
			}*/
			
			for(int i = 0; i < 10000; i++) {
				for(DiscreteLink l: list) {
					printWriter.println(l.getV1()+" "+l.getV2()+" "+(l.getTime()+100*i));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			printWriter.close();
		}

	}

}
