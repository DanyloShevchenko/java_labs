package com.example.lab1;

import java.util.Scanner;

public class Task5 {
    public static boolean isPalindrome(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the matrix NxN size: ");
        String word = input.next();

        boolean isPolindromic = isPalindrome(word);
        System.out.println(isPolindromic);
    }
}
