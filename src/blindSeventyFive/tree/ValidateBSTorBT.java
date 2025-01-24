package blindSeventyFive.tree;

import binaryTrees.Node;


public class ValidateBSTorBT {
    Node root = new Node(10);
     boolean isBST = validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
     public boolean validateBST(Node root, int min, int max){
         if(root == null){
             return true;
         }
         if(root.data <= min || root.data >= max){
             return false;
         }
         return validateBST(root.left, min, root.data)
          && validateBST(root.right, root.data, max);
     }

}
