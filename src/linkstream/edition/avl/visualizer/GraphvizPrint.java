package linkstream.edition.avl.visualizer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import linkstream.edition.avl.api.Node;

public class GraphvizPrint {
	//permet d'attribuer les noeuds null du TH
	private static int cptnull = 0;
	/**
	 * Ecrit dans un fichier la representation du Trie Hybride en langage DOT
	 * @param file le fichier de sortie
	 * @param th le TH
	 */
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
		}
		
		if(th.getRightChild() != null) {
			printWriter.println(name+" -> "+th.getRightChild().hashCode());
			GraphvizPrint.printAvlNode(printWriter, th.getRightChild());
		}
		
	}
	

}