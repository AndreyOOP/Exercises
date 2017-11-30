package Exercices.DynamicPrograms;

import java.util.Scanner;

public class Dim {

    static int n, k;
    static int[] a, b, w;


    public static void main(String[] args) {

        getInput();


    }

    static int f(int N, int W){



        int max = -1;

        for(int i=0; i<n; i++){
            int temp = Math.max( f(n-1, W), f(n-1, W - w[i]) + a[i]);
            max = Math.max(max, temp);
        }

        return -1;

    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        a = new int[n];
        b = new int[n];
        w = new int[n];

        for(int i=0; i<n; i++)
            a[i] = sc.nextInt();

        for(int i=0; i<n; i++)
            b[i] = sc.nextInt();

        for(int i=0; i<n; i++)
            w[i] = a[i] - k*b[i];

        sc.close();
    }
}
