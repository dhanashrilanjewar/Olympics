package com.olympic.bean;

import java.util.Scanner;

public class ScannerBean {
    private static Scanner scannerBean;

    private static void newScanner() {
        scannerBean = new Scanner(System.in);
    }

    public static Scanner getScanner() {
        newScanner();
        return scannerBean;
    }

    public static void closeScanner() {
        scannerBean.close();
    }
}
