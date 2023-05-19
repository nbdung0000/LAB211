import common.InOutUtils;

import javax.xml.bind.annotation.XmlID;
import java.util.Arrays;
import java.util.Random;

public class MainApp {
    private static int[] array;
    private static int value;

    public static void main(String[] args) {
        initArray();
        inputSearchValue();
        mergeSort(array);
        printArray("Sorted array: ");
        displayResult();
    }

    private static void initArray() {
        int size = InOutUtils.inputInt("Enter number of array: \n", 0, Integer.MAX_VALUE);
        array = new int[size];
        createRandomArray();
    }

    private static void inputSearchValue() {
        value = InOutUtils.inputInt("Enter search value: \n", Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static void createRandomArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    private static void printArray(String msg) {
        InOutUtils.printMsg(msg + Arrays.toString(array) + "\n");
    }

    private static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);

    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        if (i < left.length) {
            while (i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }
        }
        if (j < right.length) {
            while (j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
    }

    private static int binarySearch(int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            return binarySearch(left, mid - 1);
        } else {
            return binarySearch(mid + 1, right);
        }
    }

    private static void displayResult() {
        int foundIndex = binarySearch(0, array.length - 1);
        InOutUtils.printMsg("Found " + value + " at index: " + foundIndex);
    }
}


