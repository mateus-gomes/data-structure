package algorithm.dynamic_programming;

import java.util.HashMap;

public class FibonacciMemoized {

    private HashMap<Integer, Integer> fibonnaciSolutions = new HashMap<>();

    public int fibonacciMemoized(int number){
        if(fibonnaciSolutions.containsKey(number)){
            return fibonnaciSolutions.get(number);
        }

        if(number < 2){
            return number;
        }

        fibonnaciSolutions.put(number, fibonacciMemoized(number - 1) + fibonacciMemoized(number - 2));
        return fibonnaciSolutions.get(number);
    }

    public static void main(String[] args) {
        FibonacciMemoized fibonacciMemoized = new FibonacciMemoized();

        System.out.println(fibonacciMemoized.fibonacciMemoized(6));
    }
}
