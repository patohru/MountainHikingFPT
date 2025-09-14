package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static String getString(String welcome) {
        boolean check = true;
        String result;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println(welcome);
            result = sc.nextLine();

            if (result.isEmpty()) {
                System.out.println("Input is empty");
            } else {
                check = false;
            }
        } while (check);

        return result;
    }

    public static int getInt(String welcome) {
        boolean check = true;
        int result = 0;

        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(welcome);
                result = sc.nextInt();
                check = false;
            } catch (InputMismatchException e) {
                System.out.println("Input is not a number");
            }

        } while (check);

        return result;
    }

    public static String updateString(String welcome, String oldData) {
        String newData = oldData;

        Scanner sc = new Scanner(System.in);
        System.out.println(welcome);
        String data = sc.nextLine();

        if (!data.isEmpty()) {
            newData = data;
        }

        return newData;
    }

    public static String checkValidString(String welcome, String cases) {
        String data;

        do {
            data = getString(welcome);

            if(Validation.isValid(data, cases)) {
                break;
            }

            System.out.println("Invalid value for " + cases);
        } while(true);

        return data;
    }

    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = getString(welcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }

    public static void promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
