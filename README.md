# LinkStreamEdition

Project
=======
This is an implementation of a data structure for link stream edition, it uses an AVL tree to encode the interval, allowing editions on running time O(log(n)).
I used a generic implementation of AVL tree taken from https://github.com/JWLee89/The-Coding-Delight/tree/master/Java/data-structures/AVL-tree, and adapted it to my problem.

How to use
==========
The class LinkStream represents a link stream where it contains two methods, insert and remove.
A dot file representing the AVL tree can be generated via the method printAvl inside the class AvlTreeInterval and LinkStream (printAllAvl).
