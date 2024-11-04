package greedy.easy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {
    public static void main(String[] args) {
        int n = 3, weight = 50;
        Item[] arr = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println(ans);
    }

    private static double fractionalKnapsack(int weight, Item[] arr, int n) {
        int currWeight = 0;
        int currValue = 0;
        Arrays.sort(arr, new ItemComparator());
        for(int i = 0; i < arr.length; i++){
            if(currWeight + arr[i].weight <= weight){
                currWeight +=arr[i].weight;
                currValue +=arr[i].value;
            } else  {
                int remain = weight - currWeight;
                currValue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
        return currValue;
    }
}

class Item {
    int value, weight;
    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class ItemComparator implements Comparator<Item>{

    @Override
    public int compare(Item a, Item b) {
        double r1 = (double)(a.value) / (double)(a.weight);
        double r2 = (double)(b.value) / (double)(b.weight);
        if(r1 < r2) return 1;
        else if(r1 > r2) return -1;
        else return 0;
    }
}
