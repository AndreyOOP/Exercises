package Exercices.DynamicPrograms;

import java.util.Scanner;

public class Calculator123 {

    static int N, min;
    static int[] dp;
    static int[] cache;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        dp = new int[N+1];
        dp[1] = 0;
        dp[2] = 1; //*2 +1
        dp[3] = 1; //*3

        for (int i=4; i<=N; i++){

            min = dp[i-1]+1;

            if( i%2 == 0)
                min = Math.min(min, dp[i/2]+1);

            if( i%3 == 0)
                min = Math.min(min, dp[i/3]+1);

            dp[i] = min;

            System.out.println(i + " -> " + dp[i]);
        }

        System.out.println("Recursive " + f(10));

        cache = new int[N+1];

        System.out.println("Recursive Cache " + fCache(10));
    }

    public static int f(int n){

        if(n==1) return 0;
        if(n==2) return 1;
        if(n==3) return 1;

        int min = f(n-1)+1;

        if(n%2 == 0)
            min = Math.min(min, f(n/2)+1);

        if(n%3 == 0)
            min = Math.min(min, f(n/3)+1);

        return min;
    }

    public static int fCache(int n){

        if(cache[n] != 0)
            return cache[n];

        if(n==1) {
            cache[1] = 0;
            return 0;
        }
        if(n==2) {
            cache[2] = 1;
            return 1;
        }
        if(n==3) {
            cache[3] = 1;
            return 1;
        }

        int min = fCache(n-1)+1;

        if(n%2 == 0)
            min = Math.min(min, fCache(n/2)+1);

        if(n%3 == 0)
            min = Math.min(min, fCache(n/3)+1);

        cache[n] = min;

        return min;
    }
}
