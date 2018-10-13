package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 7, 8, 9, 11, 13, 15};
        int value = 5;
        System.out.println(findIndexInArray(array, value));
    }

    private static int findIndexInArray(int[] array, int value) {
        return findIndexInArray(array, value, 0, array.length - 1);
    }

    private static int findIndexInArray(int[] array, int value, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        int middleIndex = (startIndex + endIndex) / 2;
        if (value == array[middleIndex]) {
            return middleIndex;
        } else if (value < array[middleIndex]) {
            return findIndexInArray(array, value, startIndex, middleIndex - 1);
        } else {
            return findIndexInArray(array, value, middleIndex + 1, endIndex);
        }
    }
}
