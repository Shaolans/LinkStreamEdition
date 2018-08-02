package linkstream.edition.avl.tree;

import linkstream.edition.avl.api.AvlTree;
import linkstream.edition.avl.api.Node;

public class AvlTreeInterval implements TreeInterval {
	private AvlTree<Interval> delegate;
	
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
	}


	public void remove(Interval dataToRemove) {
		delegate.remove(dataToRemove);
	}


	public void traverse() {
		delegate.traverse();
	}


	public boolean isEmpty() {
		return delegate.isEmpty();
	}


	public void printAvl() {
		delegate.printAvl();
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

}
