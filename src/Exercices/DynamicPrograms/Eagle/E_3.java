package Exercices.DynamicPrograms.Eagle;

import java.util.Scanner;

public class E_3 {

    static int n, k;
    static Scanner sc = new Scanner(System.in);
    static int[][] cache = new int[1001][1001];

    public static void main(String[] args) {

        cache[2][2] = 2; //k = 2

        while (true){

            k = sc.nextInt(); n = sc.nextInt();

            if(n == 0 && k == 0) return;

            System.out.println( f(n, k));
        }
    }

    static int f(int n, int k){

        int temp, answ = 1001;

        if(cache[n][k] != 0) return cache[n][k];

        if(k > 10){ //10 is lower limit, e.g in case of infinite qty of balls we can decrease to n/2 on each ball - 1024 => 10

            int mn = 1001, t;

            for(int i=1; i<=10; i++){
                t = f(n, i);
                mn = Math.min(mn, t);
            }
            return mn;
        }

        if(k == 1) return n;
        if(k > n ) return f(n, n);
        if(k == n) return f(n, n-1);

        for(int i=2; i<n; i++){

            temp = Math.max(f(i-1, k-1), f(n-i, k));
            answ = Math.min(answ, temp);
        }

        cache[n][k] = answ + 1;

        return answ + 1;
    }
}