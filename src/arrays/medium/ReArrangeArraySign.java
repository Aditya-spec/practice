package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Rearrange Array Elements by Sign
 */

public class ReArrangeArraySign {
    public static void main(String[] args) {
        int[] arr = {-2, 1, 4, -6, 5, -7};
        int[] arr2 = {1,2,-4,-5,3,4};
        ReArrangeArraySignSolution obj = new ReArrangeArraySignSolution(){};
            obj.method(arr);
    }
}

class ReArrangeArraySignSolution{
    public void method(int[] arr){
        int pos = 0;
        int neg = 1;
        List<Integer> list = new ArrayList<>(Collections.nCopies(arr.length, 0));
        for(int i = 0; i< arr.length; i++){
            if(arr[i] >= 0){
                list.set(pos, arr[i]);
                pos += 2;
            }else{
                list.set(neg, arr[i]);
                neg += 2;
            }
        }for(Integer i : list){
            System.out.println(i);
        }
    }
}