package com.example.lab1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a");
        double a = myObj.nextDouble();
        System.out.println("Enter b");
        double b = myObj.nextDouble();
        System.out.println("Enter c");
        double c = myObj.nextDouble();

        double root1, root2;

        double determinant = b * b - 4 * a * c;

        if (determinant > 0) {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
            System.out.format("root1 = %.2f and root2 = %.2f", root1, root2);
            System.out.println();
        }
        else if (determinant == 0) {
            root1 = root2 = -b / (2 * a);
            System.out.format("root1 = root2 = %.2f;", root1);
            System.out.println();
        }
        else {
            System.out.format("No real roots found");
            System.out.println();
        }
    }
}