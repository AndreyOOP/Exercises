package Exercices.DynamicPrograms;

import java.util.Scanner;

public class CoinProb {

    static int n, m;
    static int[] c;
    static long[] dp;

    public static void main(String[] args) {

        getInput();

        dp[0] = 1;

        for(int j=0; j<m; j++) {

            for(int i=c[j]; i<=n; i++){

                dp[i] += dp[i-c[j]];
            }
        }

        System.out.println(dp[n]);
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        c  = new int[m];
        dp = new long[n+1];

        for(int i=0; i<m; i++)
            c[i] = sc.nextInt();

        sc.close();
    }
}