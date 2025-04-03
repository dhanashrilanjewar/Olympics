package com.olympic.bean;

import java.util.Scanner;

public class ScannerBean {
    private static Scanner scanner;

    private static void newScanner() {
        scanner = new Scanner(System.in);
    }

    public static Scanner getScanner() {
        newScanner();
        return scanner;
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static String readStringInput(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static int readIntInput(String msg) {
        System.out.println(msg);
        return scanner.nextInt();
    }
}
