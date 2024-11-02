package graphs.questions.courseSchedule;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * We Will solve this using BFS tropical sort
 */
public class CourseScheduleBFS {
    public static void main(String[] args) {
        int[][] preRequisites = {
                {1,0},
                {2,0},
                {3,1},
                {2,3}
        };
        boolean canFinish = canFinish(4, preRequisites);
        System.out.println(canFinish);

    }
    static boolean canFinish(int numCourses, int[][] preRequisites){
        List<List<Integer>> adj = new ArrayList<>();
        for(int u = 0; u < numCourses ; u++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : preRequisites) {
            int from = edge[1];
            int to = edge[0];
            adj.get(from).add(to);
        }
        int[] inDegree = new int[adj.size()];
        for(List<Integer> u : adj){
            for(Integer v : u){
                inDegree[v]++;
            }
        }
        return bfs(adj, inDegree);
    }

    static boolean bfs(List<List<Integer>> adj, int[] inDegree){
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < adj.size(); i++){
            if(inDegree[i] == 0){
                queue.add(i);
                count ++;
            }
        }
        while (!queue.isEmpty()){
            Integer curr = queue.poll();
            for(Integer v : adj.get(curr)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    queue.add(v);//in topologicl sort , we add those nodes in queue whose indegree is 0
                    count++;//incrementing count means we have visited that node
                }
            }
        }
        return count == adj.size();// true means we are able to visit all nodes i.e we are able to visit all courses
        // false means we are unable to visit all the courses so, there is a cycle
    }
}
