package linkstream.edition.process;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import linkstream.edition.structure.DiscreteLink;
import linkstream.edition.structure.IntervalLink;


public class DataReader {
	
	public static List<DiscreteLink> readFile(String file) throws FileNotFoundException{
		List<DiscreteLink> ldl = new ArrayList<>();
		Scanner sc = new Scanner(new File(file));
		int time;
		int v1;
		int v2;
		while(sc.hasNext()) {
			v1 = sc.nextInt();
			v2 = sc.nextInt();
			time = sc.nextInt();
			ldl.add(new DiscreteLink(v1, v2, time));
		}
		sc.close();
		return ldl;
	}
	
	public static List<IntervalLink> construct_interval(List<DiscreteLink> l){
		List<IntervalLink> lil = new ArrayList<>();
		
		l.sort((dl1,dl2)->{
			if(dl1.getTime() < dl2.getTime()) {
				return -1;
			}
			if(dl1.getTime() > dl2.getTime()) {
				return 1;
			}
			if(dl1.getV1() < dl2.getV1()) {
				return -1;
			}
			if(dl1.getV1() > dl2.getV1()) {
				return 1;
			}
			if(dl1.getV2() < dl2.getV2()) {
				return -1;
			}
			if(dl1.getV2() > dl2.getV2()) {
				return 1;
			}
			return 0;
		});
		
		
		int v1 = l.get(0).getV1();
		int v2 = l.get(0).getV2();
		int start = l.get(0).getTime();
		int end = l.get(0).getTime();
		l.remove(0);
		
		for(DiscreteLink dl: l) {
			if(!(end+1 == dl.getTime() && v1 == dl.getV1() && v2 == dl.getV2())) {
				lil.add(new IntervalLink(start, end, v1, v2));
				start = dl.getTime();
				end = dl.getTime();
				v1 = dl.getV1();
				v2 = dl.getV2();
			}else {
				end++;
			}
		}
		
		lil.add(new IntervalLink(start, end, v1, v2));
		
		return lil;
	}
}
