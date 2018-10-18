package Sorting;

import java.util.Arrays;

public class StableSelectionSort {
    public static void stableSelectionSort(Pair[] a) {
        stableSelectionSortRecursive(a, 0, a.length - 1);
    }

    private static void stableSelectionSortRecursive(Pair[] a, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        Pair[] toBeSorted = Arrays.copyOfRange(a, startIndex, endIndex + 1);
        Pair pivot = a[startIndex];
        int smallerCount = 0;
        int pivotCount = 1;
        for (int i = 1; i < toBeSorted.length; i++) {
            if (toBeSorted[i].key < pivot.key) {
                smallerCount++;
            } else if (toBeSorted[i].key == pivot.key) {
                pivotCount++;
            }
        }

        int smallerIndex = startIndex;
        int pivotIndex = startIndex + smallerCount;
        int biggerIndex = startIndex + smallerCount + pivotCount;
        for (int i = 0; i < toBeSorted.length; i++) {
            if (toBeSorted[i].key < pivot.key) {
                a[smallerIndex] = toBeSorted[i];
                smallerIndex++;
            } else if (toBeSorted[i].key == pivot.key) {
                a[pivotIndex] = toBeSorted[i];
                pivotIndex++;
            } else {
                a[biggerIndex] = toBeSorted[i];
                biggerIndex++;
            }
        }
        stableSelectionSortRecursive(a, startIndex, smallerIndex - 1);
        stableSelectionSortRecursive(a, pivotIndex, endIndex);
    }

    public static void main(String[] args) {
        Pair[] a = {new Pair(2, 1), new Pair(3, 4), new Pair(1, 2), new Pair(2, 2), new Pair(1, 3)};
        stableSelectionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].key + " " + a[i].value);
        }
    }
}

class Pair {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}