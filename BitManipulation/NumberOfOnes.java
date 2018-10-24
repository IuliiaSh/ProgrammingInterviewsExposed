package BitManipulation;

public class NumberOfOnes {
    public static int getNumberOfOnes(int input) {
        int result = 0;
        String binary = Integer.toBinaryString(input);
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfOnes(10));
    }
}
