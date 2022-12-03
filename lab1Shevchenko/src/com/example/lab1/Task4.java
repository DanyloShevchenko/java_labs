package com.example.lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static int[][] diagonalSortDown(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        //row=0
        for(int col=0;col<n;col++){
            sort(mat,0,col,m,n);
        }

        //col=0
        for(int row=1;row<m;row++){
            sort(mat,row,0,m,n);
        }

        return mat;
    }

    static void sort(int[][] mat, int row, int col, int m, int n){
        List<Integer> values=new ArrayList<>();
        int r=row,c=col;
        while(r<m && c<n){
            values.add(mat[r][c]);
            r++;
            c++;
        }

        Collections.sort(values);

        r=row;
        c=col;
        int ind=0;
        while(r<m && c<n){
            mat[r][c]=values.get(ind++);
            r++;
            c++;
        }
    }

    static int[][] constructMatrix(int n)
    {
        int mat[][] = new int[n][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = ((int) (Math.random() * 50));
            }
        }
        return mat;
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
        System.out.println();
        int res[][] = diagonalSortDown(mat);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0 ; j < n; j++)
                System.out.print(res[i][j]+" ");
            System.out.println();
        }
    }
}
