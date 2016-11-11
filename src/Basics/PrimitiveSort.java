package Basics;

import java.util.Arrays;

public class PrimitiveSort {

    static int[] x;

    public static void main(String[] args) {

        x = new int[] {5, 1 , 3, 7, 9, 4};

        Arrays.sort(x);
        print(x);
    }

    public static void print(int [] x){

        for(int i=0; i<x.length; i++){
            System.out.print( x[i] + " ");
        }
    }
}
