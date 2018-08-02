package linkstream.editing.avl.visualizer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import linkstream.edition.avl.test.Node;

public class GraphvizPrint {
	//permet d'attribuer les noeuds null du TH
	private static int cptnull = 0;
	private static int cptfile = 0;
	/**
	 * Ecrit dans un fichier la representation du Trie Hybride en langage DOT
	 * @param file le fichier de sortie
	 * @param th le TH
	 */
	public static <T extends Comparable<T>> void printAVL(Node<T> th) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		String file = "Graphviz/avl_t"+cptfile+".dot";
		cptfile++;
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
	
	/**
	 * Ecrit le noeud courant du Trie Hybride dans un fichier
	 * @param printWriter l'instance d'ecriture
	 * @param th le Trie Hybride
	 */
	public static <T extends Comparable<T>> void printAvlNode(PrintWriter printWriter, Node<T> th) {
		String name = ""+th.hashCode();
		printWriter.println(name+" [label=\""+th.toString()+"\"]");
		if(th.getLeftChild() != null) {
			printWriter.println(name+" -> "+th.getLeftChild().hashCode());
			GraphvizPrint.printAvlNode(printWriter, th.getLeftChild());
		}else {
			printWriter.println(name+" -> null"+cptnull);
			printWriter.println("null"+cptnull+" [label=\"null\"]");
			cptnull++;
		}
		
		if(th.getRightChild() != null) {
			printWriter.println(name+" -> "+th.getRightChild().hashCode());
			GraphvizPrint.printAvlNode(printWriter, th.getLeftChild());
		}else {
			printWriter.println(name+" -> null"+cptnull);
			printWriter.println("null"+cptnull+" [label=\"null\"]");
			cptnull++;
		}
		
	}
	

}