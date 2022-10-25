package algorithm.recursion;

public class ReverseString {

    public char[] reverseStringIterative(String text) {
        char[] textToArray = text.toCharArray();
        char[] reversedString = new char[textToArray.length];

        for(int i = 0; i < textToArray.length; i++){
            reversedString[i] = textToArray[textToArray.length-1-i];
        }

        return reversedString;
    }

    public String reverseStringRecursive(String text){
        if (text.equals("")) {
            return text;
        } else {
            return reverseStringRecursive(text.substring(1)) + text.charAt(0);
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();

        System.out.println(reverseString.reverseStringRecursive("mateus"));
    }
}
