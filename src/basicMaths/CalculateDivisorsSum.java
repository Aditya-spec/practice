package basicMaths;

public class CalculateDivisorsSum {
    public static void main(String[] args) {
        CalculateDivisorsSumSolution obj = new CalculateDivisorsSumSolution();
        obj.sumOfDivisors(5);
    }


}

class CalculateDivisorsSumSolution{
    long sumOfDivisors(int N){
        int totalSum = 0;
        for(int i = 1; i<=N ; i++){
            int sum = 0;
            for(int j =1; j*j<=i; j++){
                if(i%j == 0){
                    sum = sum + j;
                    if(i/j != j){
                        sum = sum + i/j;
                    }
                }
            }
            totalSum = totalSum + sum;
            sum = 0;
        }
        return totalSum;
    }
}
