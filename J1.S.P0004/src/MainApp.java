import common.InOutUtils;

import java.util.Arrays;
import java.util.Random;

public class MainApp {
    private static int[] array;

    public static void main(String[] args) {
        initArray();
        printArray("Unsorted array: ");
        quickSort(0, array.length - 1);
        printArray("Sorted array: ");
    }
    private static void initArray(){
        int size = InOutUtils.inputInt("Enter number of array: \n", 0, Integer.MAX_VALUE);
        array = new int[size];
        createRandomArray();
    }

    private static void createRandomArray(){
        Random random = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100);
        }
    }

    private static void printArray(String msg){
        InOutUtils.printMsg(msg + Arrays.toString(array) + "\n");
    }

    private static void quickSort(int low, int high){
        if(low < high){
            int pivotIndex = partition(low, high);
            quickSort(low,pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }

    }

    private static int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(array[j] <= pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;;
        return i + 1;
    }


}
