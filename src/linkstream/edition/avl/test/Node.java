package linkstream.edition.avl.test;

/**
 * The node class for the tree.
 * Make sure that it can only be instantiated by classes inside of this package.
 * */
public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private int height;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
