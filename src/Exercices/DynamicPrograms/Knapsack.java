package Exercices.DynamicPrograms;

import java.util.Scanner;

public class Knapsack {

    static int n, k, T;
    static Scanner sc;
    static int[] a;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int i=0; i<T; i++){

            getInput();

            System.out.println( nearest());
        }

        sc.close();
    }

    static int nearest(){

        boolean[] dp = new boolean[2001];

        for (int j=0; j<n; j++) {

            dp[a[j]] = true;

            for(int i=1; i<=2000; i++){

                if(dp[i])
                    if(i + a[j]<=2000) dp[i + a[j]] = true;
            }

//            print(dp);
        }

        for(int i=k; i>=0; i--)
            if(dp[i]) return i;

        return 0;
    }

    static void print(boolean[] a){

        for(int i=0; i<a.length; i++)
            if(a[i])
                System.out.print(i + " ");

        System.out.println();
    }

    static void getInput(){

        n = sc.nextInt();
        k = sc.nextInt();

        a = new int[n];

        for(int i=0; i<n; i++)
            a[i] = sc.nextInt();
    }
}
