package Recursion;

import java.util.LinkedList;
import java.util.Queue;

public class TelephoneWords {
    public static void main(String[] args) {
        String phone = "8662665";
        findTelephoneWords(phone);
    }

    private static void findTelephoneWords(String phone) {
        char[][] digitToChars = getDigitToChars();
        Queue<StringBuilder> result = new LinkedList<StringBuilder>();
        result.offer(new StringBuilder());
        StringBuilder currentResult;
        char nextDigit;
        StringBuilder[] nextResults;
        while (result.peek().length() < phone.length()) {
            currentResult = result.remove();
            nextDigit = phone.charAt(currentResult.length());
            nextResults = getNextCombinations(currentResult, nextDigit, digitToChars);
            for (int i = 0; i < nextResults.length; i++) {
                result.offer(nextResults[i]);
            }
        }

        while (!result.isEmpty()) {
            System.out.println(result.remove().toString());
        }
    }

    private static char[][] getDigitToChars() {
        char[][] result = {{'0'}, {'1'},
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
                {'J', 'K', 'L'},
                {'M', 'N', 'O'},
                {'P', 'R', 'S'},
                {'T', 'U', 'V'},
                {'W', 'X', 'Y'}};
        return result;
    }

    private static StringBuilder[] getNextCombinations(StringBuilder currentResult, Character nextDigit, char[][] digitToChars) {
        char[] nextChars = digitToChars[Integer.parseInt(nextDigit.toString())];
        StringBuilder[] nextResult = new StringBuilder[nextChars.length];
        for (int i = 0; i < nextResult.length; i++) {
            nextResult[i] = new StringBuilder(currentResult.toString() + nextChars[i]);
        }
        return nextResult;
    }
}
