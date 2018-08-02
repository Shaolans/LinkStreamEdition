package linkstream.edition.avl.tree;

import java.util.ArrayList;
import java.util.List;

import linkstream.edition.avl.api.AvlTree;
import linkstream.edition.avl.api.Node;

public class AvlTreeInterval implements TreeInterval {
	private AvlTree<Interval> delegate;
	private int vertice1 = -1;
	private int vertice2 = -1;
	private int size = 0; //warning, only working if the deletion and add are correct
	
	public int getSize() {
		return size;
	}
	
	public int getVertice1() {
		return vertice1;
	}


	public void setVertice1(int vertice1) {
		this.vertice1 = vertice1;
	}


	public int getVertice2() {
		return vertice2;
	}


	public void setVertice2(int vertice2) {
		this.vertice2 = vertice2;
	}


	public AvlTreeInterval() {
		delegate = new AvlTree<>();
	}
	

	public boolean equals(Object arg0) {
		return delegate.equals(arg0);
	}


	public Node<Interval> getRootNode() {
		return delegate.getRootNode();
	}


	public int hashCode() {
		return delegate.hashCode();
	}


	public void insert(Interval data) {
		delegate.insert(data);
		size++;
	}


	public void remove(Interval dataToRemove) {
		delegate.remove(dataToRemove);
		size--;
	}


	public void traverse() {
		delegate.traverse();
	}


	public boolean isEmpty() {
		return delegate.isEmpty();
	}


	public void printAvl(String name) {
		delegate.printAvl(name);
	}
	
	public void printAvl() {
		delegate.printAvl(vertice1+""+vertice2);
	}

	public String toString() {
		return delegate.toString();
	}


	private Interval findStart(int start, Node<Interval> root) {
		if(root == null) return null;
		if(root.getData().getStart() == start) return root.getData();
		if(root.getData().getStart() > start) return findStart(start, root.getLeftChild());
		return findStart(start, root.getRightChild());
	}

	private Interval findEnd(int end, Node<Interval> root) {
		if(root == null) return null;
		if(root.getData().getEnd() == end) return root.getData();
		if(root.getData().getEnd() > end) return findEnd(end, root.getLeftChild());
		return findEnd(end, root.getRightChild());
	}


	@Override
	public Interval findStart(int start) {
		return findStart(start, getRootNode());
	}


	@Override
	public Interval findEnd(int end) {
		return findEnd(end, getRootNode());
	}
	
	public List<Interval> getIntervals(){
		List<Interval> l = new ArrayList<>();
		getIntervals(l, getRootNode());
		return l;
	}
	
	public void getIntervals(List<Interval> l, Node<Interval> root) {
		if(root == null) return;
		l.add(root.getData());
		getIntervals(l, root.getLeftChild());
		getIntervals(l, root.getRightChild());
	}

}
