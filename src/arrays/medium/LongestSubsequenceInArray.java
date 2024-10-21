package arrays.medium;

import java.util.Arrays;

public class LongestSubsequenceInArray {
    public static void main(String[] args) {
       int[] arr = {100,200,101,101,1,3,4,2,2,1,4,100,102};
        LongestSubsequenceInArraySolution obj = new LongestSubsequenceInArraySolution();
        obj.method(arr);
    }
}

class LongestSubsequenceInArraySolution{
    public void method(int[] arr){
        Arrays.sort(arr);
        int last = arr[0];
        int count = 1;
        int maxCount = count;
        for(int i = 1; i< arr.length;i++){
            if(arr[i] == 1 + last){
                count ++;
                last = arr[i];
            }else if((arr[i] != 1 + last) && (arr[i] != last)){
                maxCount = Math.max(count, maxCount);
                count = 1;
                last = arr[i];
            }
        }
        System.out.println(maxCount);

    }
}