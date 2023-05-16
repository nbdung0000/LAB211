package common;

import java.util.Arrays;
import java.util.Scanner;

public class InOutUtils {
    public static int inputInt(){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }
    public static void printArrayElements(int[] array){
        System.out.println(Arrays.toString(array));
    }
}
