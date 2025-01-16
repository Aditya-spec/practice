package blindSeventyFive.tree;

import binaryTrees.Node;

public class MaximumPath {

    int maxPathSum(Node root) {

        int[] maxi = {Integer.MIN_VALUE};
        findMaxPathSum(root, maxi);
        return maxi[0];
    }

    public int findMaxPathSum(Node root, int[] maxi){
        if(root == null){
            return 0;
        }
        int maxLeft = Math.max(0, findMaxPathSum(root.left, maxi));
        int maxRight = Math.max(0, findMaxPathSum(root.right, maxi));
        maxi[0] = Math.max(maxi[0], maxLeft + maxRight + root.data);
        return root.data + Math.max(maxLeft, maxRight);
    }
}
