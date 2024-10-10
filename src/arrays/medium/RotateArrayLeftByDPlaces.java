package arrays.medium;

public class RotateArrayLeftByDPlaces {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        RotateArrayLeftByDPlacesSolution obj = new RotateArrayLeftByDPlacesSolution();
        obj.method(arr,12);
    }
}

/**first rotate from 0 to d-1 then d to length - 1 then rotate the whole array
*/
class RotateArrayLeftByDPlacesSolution{
    public void method(int[] arr, int d){
        d = d % arr.length;
        reverse(arr, 0, d-1);
        reverse(arr,d, arr.length - 1);
        reverse(arr, 0, arr.length-1);
        for (int j : arr) {
            System.out.println(j);
        }
    }

    private void reverse(int[] arr, int i, int d) {
        while(i < d){
            int temp = arr[i];
            arr[i] = arr[d];
            arr[d] = temp;
            i++;
            d--;
        }
    }
}


