package algorithm.recursion;

public class Fibonacci {

    public int fibonacciRecursive(int number){
        if(number < 2){
            return number;
        }

        return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
    }

    public int fibonacciIterative(int number){
        if(number == 0){
            return 0;
        }

        int fibonacciResult = 1;
        int lastNumber = 0;

        for(int i = 1; i < number; i++){
            int numberAux = fibonacciResult;
            fibonacciResult = fibonacciResult + lastNumber;
            lastNumber = numberAux;
        }

        return fibonacciResult;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.fibonacciRecursive(6));
    }
}
