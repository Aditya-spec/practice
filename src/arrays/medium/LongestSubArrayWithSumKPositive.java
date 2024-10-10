package arrays.medium;

public class LongestSubArrayWithSumKPositive {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        LongestSubArrayWithSumKPositiveSolution obj = new LongestSubArrayWithSumKPositiveSolution();
        int ans = obj.method(arr, k);
        System.out.println(ans);
    }
}

class LongestSubArrayWithSumKPositiveSolution{
    public int method(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int right = arr.length;
        int sum = arr[0];
        int maxLength = Integer.MIN_VALUE;
        while(i <= j && j < right){
            if(sum == k){
                int length = j - i + 1;
                maxLength = Math.max(maxLength, length);
            }
            while(sum > k){
                sum -= arr[i];
                i++;
            }
            j++;
            if(j < right){
                sum = sum + arr[j];
            }
        }
        return maxLength;
    }
}
