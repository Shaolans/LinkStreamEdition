package linkstream.edition.avl.tree;

import linkstream.edition.avl.api.Tree;

public interface TreeInterval extends Tree<Interval>{
	
	public Interval findStart(int start);
	public Interval findEnd(int end);
}
