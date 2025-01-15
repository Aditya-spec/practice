package binaryTrees;

public class MaximumHeight {
    Node node = new Node(6);

    public int getHeight(Node root){
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1 + Math.max(left, right);
    }

}
