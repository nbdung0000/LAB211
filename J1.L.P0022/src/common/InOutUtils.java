package common;

import java.util.Scanner;

public class InOutUtils {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputInt(String msg, int min, int max) {
        int num = 0;
        boolean isValid = false;

        do {
            try {
                printMsg(msg);
                num = sc.nextInt();
                sc.nextLine();
                if (num >= min && num <= max) {
                    isValid = true;
                } else {
                    printMsg("Please enter a number between " + min +" and "+max+".\n");
                }
            } catch (Exception e) {
                printMsg("Invalid input. Please enter an integer number.\n");
                isValid = false;
                sc.nextLine();
            }
        } while (!isValid);
        return num;
    }

    public static String inputString(String msg, int limit) {
        String str = "";
        boolean isValid = false;
        while (!isValid) {
            printMsg(msg);
            str = sc.nextLine();
            if (str.length() <= limit) {
                isValid = true;
            } else {
                printMsg("Input string is too long. Please enter string less than " + limit + " characters in length.\n");
            }
        }
        return str;
    }

    public static void printMsg(String msg) {
        System.out.print(msg);
    }
}
