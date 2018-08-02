package linkstream.edition.avl.tree;

/**
 * @author Jay
 */
public class RunAvlTree {
    public static void main(String[] args) {
        TreeInterval avlTree = new AvlTreeInterval();

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
        Interval t = new Interval(6, 7);
        avlTree.insert(new Interval(1, 4));
        avlTree.insert(t);
        avlTree.insert(new Interval(9, 10));
        
        avlTree.printAvl("0");
        
        avlTree.insert(new Interval(11, 12));
        
        avlTree.printAvl("1");
        
        avlTree.insert(new Interval(14, 15));
        
        avlTree.printAvl("2");
        
        System.out.println(avlTree.getRootNode().getLeftChild());
        System.out.println(avlTree.findStart(1));
        System.out.println(avlTree.findEnd(4));
        System.out.println(avlTree.findEnd(9));
        System.out.println(avlTree.findEnd(2));
    }
}