package arrays.medium;

public class LeaderInArray {
    public static void main(String[] args) {
        int[] arr = {56,16,2,1,3,5,2};
        LeaderInArraySolution obj = new LeaderInArraySolution();
        obj.method(arr, arr.length);

    }
}

class LeaderInArraySolution{
    public void method(int[] arr, int n){
        int leader = arr[n-1];
        System.out.println(leader);
        for(int i = n-1; i>=0;i--){
            if(arr[i] > leader){
                leader = arr[i];
                System.out.println(leader);
            }
        }
    }
}