package linkstream.edition.avl.tree;

public class Node {
	private Node parent;
	private Node leftNode;
	private Node rightNode;
	private Interval data;
	private int height;
	
	public Node(Interval data) {
		parent = null;
		leftNode = null;
		rightNode = null;
		this.data = data;
		height = 0;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node(Node parent, Node leftNode, Node rightNode, Interval data, int height) {
		this(data);
		this.parent = parent;
		this.rightNode = rightNode;
		this.leftNode = leftNode;
		this.height = height;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public Interval getData() {
		return data;
	}

	public void setData(Interval data) {
		this.data = data;
	}
	
	
}
