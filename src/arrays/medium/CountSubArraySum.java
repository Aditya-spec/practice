package arrays.medium;

import java.util.HashMap;
import java.util.Map;


/**
 * Problem Statement: Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class CountSubArraySum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        CountSubArraySumSolution obj = new CountSubArraySumSolution();
        obj.method(arr, 3);

    }
}

class CountSubArraySumSolution{
    public void method(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum =0;
        int count = 0;
        map.put(0,1);
        for(int i = 0; i < arr.length; i++){
            prefixSum += arr[i];
            int val = prefixSum - k;
            count += map.getOrDefault(val, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        System.out.println(count);
    }
}