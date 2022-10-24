package algorithm.recursion;

public class Factorial {

    public int factorialRecursive(int number){
        if(number < 2){
            return 1;
        }

        return number * factorialRecursive(number - 1);
    }

    public int factorialIterative(int number){
        int factorialResult = 1;

        for(int i = 1; i <= number; i++){
            factorialResult = factorialResult * i;
        }

        return factorialResult;
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();

        System.out.println(factorial.factorialRecursive(5));
    }
}
