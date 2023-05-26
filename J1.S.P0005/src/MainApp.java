import common.InOutUtils;

import java.util.Arrays;
import java.util.Random;

public class MainApp {
    private static int[] array;

    public static void main(String[] args)
    {
        initArray();
        printArray("Unsorted array: ");
        mergeSort(array);
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

    private static void mergeSort(int[] arr){
        if(arr.length <= 1){
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr,0, left,0,left.length);
        System.arraycopy(arr,mid,right,0,right.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr,left,right);

    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
                k++;
            }else{
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        if(i < left.length){
            while(i < left.length){
                arr[k] = left[i];
                i++;
                k++;
            }
        }
        if(j < right.length){
            while(j < right.length){
                arr[k] = right[j];
                j++;
                k++;
            }
        }
    }




}
