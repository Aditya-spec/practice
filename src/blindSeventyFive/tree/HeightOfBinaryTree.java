package blindSeventyFive.tree;

import binaryTrees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {
    public int getHeightUsingDFS(Node root){
        if(root == null){
            return 0;
        }
        int left = getHeightUsingDFS(root.left);
        int right = getHeightUsingDFS(root.right);
        return 1 + Math.max(left, right);
    }

    int getHeightUsingBFS(Node root) {
        // If the root is NULL
        // (empty tree), depth is 0
        if (root == null) {
            return 0;
        }

        // Create a queue for
        // level order traversal
        Queue<Node> q = new LinkedList<>();
        int level = 0;

        // Push the root node into the queue
        q.add(root);

        // While there are nodes in the queue
        while (!q.isEmpty()) {
            // Get the number of nodes
            // at the current level
            int size = q.size();

            // Process all nodes
            // at the current level
            for (int i = 0; i < size; i++) {
                // Get the front node in the queue
                Node front = q.poll();

                // Enqueue left child if exists
                if (front.left != null) {
                    q.add(front.left);
                }

                // Enqueue right child if exists
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            // Increment level to
            // move to the next level
            level++;
        }
        // Return the level, which represents
        // the maximum depth of the tree
        return level;
    }

}
