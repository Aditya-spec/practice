package basicMaths;

//Given a number n. Count the number of digits in n which evenly divide n. Return an integer, total number of digits of n which divides n evenly.
//
//Note :- Evenly divides means whether n is divisible by a digit i.e. leaves a remainder 0 when divided.

public class CountDigit {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.evenlyDivides(12);
    }
}

class Solution {
    int evenlyDivides(int N) {
        int num = N;
        int count = 0;
        while (N > 0) {
            int digit = N % 10;
            if (digit != 0) {
                if (num % digit == 0) {
                    count = count + 1;
                }

            }
            N = N / 10;
        }
        return count;
    }
}
