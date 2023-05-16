package common;

import java.util.Scanner;

public class InOutUtils {
    public static String inputString(){
        Scanner sc= new Scanner(System.in);
        String string = sc.nextLine();
        return string;
    }
}
