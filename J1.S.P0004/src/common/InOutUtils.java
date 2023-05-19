package common;

import java.util.Scanner;

public class InOutUtils {
    public static int inputInt(String msg, int min, int max ){
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean isValid = false;
        do {
            try {
                printMsg(msg);
                num = sc.nextInt();
                if(num > min && num < max){
                    isValid = true;
                }else{
                    printMsg("Please enter a positive integer!\n");
                }
            }catch (Exception e){
                printMsg("Please enter integer number!\n");
            }
        }while(!isValid);
        return num;
    }

    public static void printMsg(String msg){
        System.out.print(msg);
    }
}
