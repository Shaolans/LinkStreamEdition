package linkstream.edition.avl.test;

import linkstream.edition.avl.tree.Interval;

/**
 * @author Jay
 */
public class RunAvlTree {
    public static void main(String[] args) {
        Tree<Interval> avlTree = new AvlTree<Interval>();

        // Left heavy situation
        /*avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(23);
        avlTree.insert(13);
        avlTree.insert(25);
        avlTree.insert(2);
        avlTree.insert(9);
        avlTree.insert(8);
        avlTree.insert(7);
*/

        // Left heavy situation
        avlTree.insert(new Interval(1, 4));
        avlTree.insert(new Interval(6, 7));
        avlTree.insert(new Interval(9, 10));
        
        avlTree.traverse();
        avlTree.printAvl();
    }
}