package blindSeventyFive.tree;

import binaryTrees.Node;

public class CheckIdenticalTrees {
    public boolean isSameTree(Node p, Node q){
        if(p == null || q ==null){
            return p == q;
        }
        return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
