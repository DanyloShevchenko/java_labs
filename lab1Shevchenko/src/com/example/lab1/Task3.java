package com.example.lab1;

import java.util.Scanner;

public class Task3 {
    static int[][] constructMatrix(int n)
    {
        int mat[][] = new int[n][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = ((int) (Math.random() * 100));
            }
        }
        return mat;
    }

    public static int getMaxValue(int[][] numbers) {
        int maxValue = numbers[0][0];
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers[j].length; i++) {
                if (numbers[j][i] > maxValue) {
                    maxValue = numbers[j][i];
                }
            }
        }
        return maxValue;
    }

    public static int getMinValue(int[][] numbers) {
        int minValue = numbers[0][0];
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers[j].length; i++) {
                if (numbers[j][i] < minValue ) {
                    minValue = numbers[j][i];
                }
            }
        }
        return minValue ;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the matrix NxN size: ");
        int n = input.nextInt();

        int mat[][] = constructMatrix(n);

        for (int i = 0; i < n; i++)
        {
            for (int j = 0 ; j < n; j++)
                System.out.print(mat[i][j]+" ");
            System.out.println();
        }
        int max = getMaxValue(mat);
        int min = getMinValue(mat);
        System.out.println("min: " + min + " max: " + max);
    }
}
