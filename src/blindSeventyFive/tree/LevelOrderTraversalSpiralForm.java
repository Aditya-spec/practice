package blindSeventyFive.tree;

import binaryTrees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalSpiralForm {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> getSpiralForm(Node root){
        if (root == null){
            return new ArrayList<>();
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node poll = q.poll();
                level.add(poll.data);
                if(poll.right != null){
                    q.add(poll.right);
                }
                if(poll.left != null){
                    q.add(poll.left);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
