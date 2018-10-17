package ArraysAndStrings;

import java.util.HashMap;

public class IntegerStringConversions {
    public static int convertStringToInt (String s) {
        HashMap<Character, Integer> charToIntMap = getCharToIntMap();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = 10 * result + charToIntMap.get(s.charAt(i));
        }
        return result;
    }

    public static String convertIntToString (int number) {
        HashMap<Integer, Character> intToCharMap = getIntToCharMap();
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.append(intToCharMap.get(number % 10));
            number /= 10;
        }
        return sb.reverse().toString();
    }

    private static HashMap<Character, Integer> getCharToIntMap() {
        HashMap<Character, Integer> result = new HashMap();
        result.put('0', 0);
        result.put('1', 1);
        result.put('2', 2);
        result.put('3', 3);
        result.put('4', 4);
        result.put('5', 5);
        result.put('6', 6);
        result.put('7', 7);
        result.put('8', 8);
        result.put('9', 9);
        return result;
    }

    private static HashMap<Integer, Character> getIntToCharMap() {
        HashMap<Integer, Character> result = new HashMap();
        result.put(0, '0');
        result.put(1, '1');
        result.put(2, '2');
        result.put(3, '3');
        result.put(4, '4');
        result.put(5, '5');
        result.put(6, '6');
        result.put(7, '7');
        result.put(8, '8');
        result.put(9, '9');
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convertStringToInt("123"));
        System.out.println(convertIntToString(123));
    }
}
