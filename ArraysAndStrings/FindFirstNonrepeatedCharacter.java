package ArraysAndStrings;

import java.util.HashMap;

public class FindFirstNonrepeatedCharacter {
    public static Character findFirstNonrepeatedCharacter(String s) {
        HashMap<Character, Integer> charCountMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            charCountMap.putIfAbsent(s.charAt(i), 0);
            charCountMap.compute(s.charAt(i), (key, value) -> value + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCountMap.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(findFirstNonrepeatedCharacter("teeter"));
    }
}
