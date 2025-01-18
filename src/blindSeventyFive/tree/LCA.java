package blindSeventyFive.tree;

import binaryTrees.Node;

public class LCA {
    public Node getLCA(Node node, Node p, Node q){
        if(node == null){
            return null;
        }
        int curr = node.data;
        if(curr < p.data && curr < q.data){//means bth nodes are right to the current node
            return getLCA(node.right, p, q);
        }
        if(curr > p.data && curr > q.data){//means bth nodes are left to the current node
            return getLCA(node.left, p, q);
        }
        return node;
    }
}
