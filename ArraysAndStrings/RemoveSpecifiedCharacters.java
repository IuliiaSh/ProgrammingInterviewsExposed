package ArraysAndStrings;

import java.util.HashSet;

public class RemoveSpecifiedCharacters {
    public static String removeSpecifiedCharacters(String s, String r) {
        HashSet<Character> toBeRemovedSet = new HashSet();
        for (int i = 0; i < r.length(); i++) {
            toBeRemovedSet.add(Character.toLowerCase(r.charAt(i)));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toBeRemovedSet.contains(Character.toLowerCase(s.charAt(i)))) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeSpecifiedCharacters("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
    }
}
