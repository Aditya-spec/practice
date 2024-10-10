package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3,4,5,6,7,8,9,10};
        int[] arr2 = {1,1,2,2,3,4,4,5,11,12};
        UnionOfTwoArraysSolution obj = new UnionOfTwoArraysSolution();
        obj.method(arr1,arr2);
    }
}

class UnionOfTwoArraysSolution {
    public void method(int[] arr, int[] arr2) {
        int i = 0;
        int j = 0;
        List<Integer> unionList = new ArrayList<>();
        while (i < arr.length && j < arr2.length) {
            if (!unionList.isEmpty()) {
                while (arr[i] == unionList.get(unionList.size() - 1)) {
                    i++;
                }
                while (arr2[j] == unionList.get(unionList.size() - 1)) {
                    j++;
                }
            }
            if (arr[i] < arr2[j]) {
                unionList.add(arr[i]);
                i++;
            }
            else if (arr2[j] < arr[i]) {
                unionList.add(arr2[j]);
                j++;
            } else {
                unionList.add(arr[i]);
                i++;
                j++;
            }
        }
        while(i < arr.length){
            while (arr[i] == unionList.get(unionList.size() - 1)) {
                i++;
            }
            unionList.add(arr[i]);
            i++;
        }
        while(j < arr2.length){
            while (arr2[j] == unionList.get(unionList.size() - 1)) {
                j++;
            }
            unionList.add(arr2[j]);
            j++;
        }
        for (Integer k : unionList){
            System.out.println(k);
        }

    }
}