package linkstream.edition.avl.visualizer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import linkstream.edition.avl.api.Node;

public class GraphvizPrint {

	public static <T extends Comparable<T>> void printAVL(String name, Node<T> th) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		String file = "Graphviz/avl_"+name+".dot";
		try {
			fileWriter = new FileWriter(file);
			printWriter = new PrintWriter(fileWriter);
			printWriter.printf("digraph G{\n");
			GraphvizPrint.printAvlNode(printWriter,th);
			printWriter.print("}");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			printWriter.close();
		}
	}
	
	
	public static <T extends Comparable<T>> void printAvlNode(PrintWriter printWriter, Node<T> th) {
		String name = ""+th.hashCode();
		printWriter.println(name+" [label=\""+th.toString()+"\"]");
		if(th.getLeftChild() != null) {
			printWriter.println(name+" -> "+th.getLeftChild().hashCode());
			GraphvizPrint.printAvlNode(printWriter, th.getLeftChild());
		}
		
		if(th.getRightChild() != null) {
			printWriter.println(name+" -> "+th.getRightChild().hashCode());
			GraphvizPrint.printAvlNode(printWriter, th.getRightChild());
		}
		
	}
	

}