package blindSeventyFive.tree;

import binaryTrees.Node;

public class CheckSymmetricalTree {
    public boolean isSymmetrical(Node p, Node q){
        if(p == null || q == null){
            return p == q;
        }
        return (p.data == q.data) && isSymmetrical(p.left, q.right) && isSymmetrical(p.right, q.left);
    }
}
