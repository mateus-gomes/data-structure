package data_structures.arrays;

public class ReverseString {

    //First solution to the problem
    private char[] reverseString(String text){
        char[] textInArray = text.toCharArray();
        char[] reversedTextInArray = new char[textInArray.length];
        int textLength = textInArray.length-1;

        for(int i = 0; i < textInArray.length; i++){
            reversedTextInArray[i] = textInArray[textLength-i];
        }

        return reversedTextInArray;
    }

    //Refactor of the solution using Java string properties
    private char[] reverseString2(String text){
        char[] reversedTextInArray = new char[text.length()];
        int textLength = text.length()-1;

        for(int i = 0; i < text.length(); i++){
            reversedTextInArray[i] = text.charAt(textLength-i);
        }

        return reversedTextInArray;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("This string is going to be reversed!"));
    }
}
