package data_structures.hashtables.exercises;

import java.util.HashSet;
import java.util.Hashtable;

public class FirstRecurringCharacter {

    public Integer returnFirstRecurringCharacter(int[] array){
        HashSet<Integer> hashtable = new HashSet<>();

        for(int i = 0; i < array.length; i++){
            if(hashtable.contains(array[i])){
                return array[i];
            }else{
                hashtable.add(array[i]);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        FirstRecurringCharacter firstRecurringCharacter = new FirstRecurringCharacter();
        int[] arrayOne = new int[]{2,5,1,2,3,5,1,2,4};
        int[] arrayTwo = new int[]{2,1,1,2,3,5,1,2,4};
        int[] arrayThree = new int[]{2,3,4, 5};

        System.out.println(firstRecurringCharacter.returnFirstRecurringCharacter(arrayOne));
        System.out.println(firstRecurringCharacter.returnFirstRecurringCharacter(arrayTwo));
        System.out.println(firstRecurringCharacter.returnFirstRecurringCharacter(arrayThree));
    }
}
