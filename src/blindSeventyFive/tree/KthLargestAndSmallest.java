package blindSeventyFive.tree;

import binaryTrees.Node;

public class KthLargestAndSmallest {
    //inorder will always be in the sorted order
    int smallest = 0;
    public void getKthSmallest(Node root, int smallest, int k){
        if(root == null){
            return;
        }
        getKthSmallest(root.left, smallest, k);
        smallest ++;
        if(smallest == k){
            System.out.println(root.data);
        }
        getKthSmallest(root.right, smallest, k);
    }
}

//inCase of kth largest, the kth lasrgest node will be N-k(smallest),
//so we'll traverse the tree first, find out total nodes(N) ans same inorder will be called and N-k will be
//passed in place of k
