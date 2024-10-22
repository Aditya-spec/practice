package arrays.medium;

public class SubArraySUmEqualsK {
    public static void main(String[] args) {

    }
}

class SubArraySUmEqualsKSolution{
    public void method(int[] arr, int k){
        int sum = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while(i <= j && j < arr.length){
            if(sum == k){
                count++;
            }
            else if(sum < k){
                j++;
                sum += arr[j];
            }else {

            }

        }
    }
}