package linkstream.edition.avl.test;

/**
 * @Author Jay
 */
public interface Tree<T extends Comparable<T>> {
    /**
     * @param data The data to insert
     * */
    void insert(T data);
    /**
     * @param dataToRemove
     * */
    void remove(T dataToRemove);

    /**
     * traverse the tree.
     * */
    void traverse();

    boolean isEmpty();
    
    public void printAvl();
}
