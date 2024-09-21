package com.jack.maven;

import  org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a non numeric String:");

        if (isNumeric(scanner.nextLine())) {
            System.out.println("The provided string is numeric");
        } else {
            System.out.println("The provided string is invalid.");
        }
        scanner.close();
    }
    private static boolean isNumeric(String nextLine) {
        return StringUtils.isNumeric(nextLine);
    }
}
