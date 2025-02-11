package blindSeventyFive.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
     public List<List<Integer>> mergeIntervals(int[][] arr){
         Arrays.sort(arr, new Comparator<int[]>() {
             public int compare(int[] a, int[] b) {
                 return a[0] - b[0];
             }
         });
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> list = Arrays.asList(arr[0][0], arr[0][1]);
         ans.add(list);
         for (int i = 1; i < arr.length; i++){
             List<Integer> l = ans.get(ans.size() - 1);
             if(arr[i][0] < l.get(1)){
                 ans.get(ans.size() - 1).set(1,
                         Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
             }else {
                 ans.add(Arrays.asList(arr[i][0], arr[i][1]));
             }
             }
         return ans;
         }
     }
