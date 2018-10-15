package Recursion;

public class StringPermutationsCombinations {
    public static void main(String[] args) {
        String s = "abc";
        findPermutations(s);
    }

    private static void findPermutations(String s) {
        findPermutations(new StringBuilder(), new StringBuilder(s));
    }

    private static void findPermutations(StringBuilder currentResult, StringBuilder leftChars) {
        if (leftChars.length() == 0) {
            // move just before if to obtain permutations of all possible length
            System.out.println(currentResult.toString());
            return;
        }

        char nextChar;
        for (int i = 0; i < leftChars.length(); i++) {
            nextChar = leftChars.charAt(i);
            // uncomment to obtain combinations
            // if (currentResult.length() == 0 || nextChar >= currentResult.charAt(currentResult.length() - 1)) {
                currentResult.append(nextChar);
                leftChars.deleteCharAt(i);
                findPermutations(currentResult, leftChars);
                currentResult.deleteCharAt(currentResult.length() - 1);
                leftChars.insert(i, nextChar);
            // }
        }
    }
}
