package Exercices.DynamicPrograms.Eagle;

import java.util.Scanner;

public class E_2 {

    static int n, k, x = 0;
    static Scanner sc = new Scanner(System.in);
    static int[][] cache = new int[1001][1001];

    public static void main(String[] args) {

        for(int i=1; i<=1000; i++) //k = 1
            cache[i][1] = i;

        cache[2][2] = 2; //k = 2

        for (int k=2; k<=1000; k++) {
            for(int i=1; i<=1000; i++){
                f(i, k);
            }
        }

        while (true){

            k = sc.nextInt(); n = sc.nextInt();

            if(n == 0 && k == 0) return;

            System.out.println( f(n, k));
//            System.out.println( x);
            x = 0;
        }
    }

    static int f(int n, int k){

        int temp, answ = 1001;

        //if(k>100) return cache[n][100];
        if(cache[n][k] != 0) return cache[n][k];

        if(k > 11){

            int mn = 1001;

            for(int i=1; i<=11; i++){
                int t = f(n, i);
                mn = Math.min(mn, t);
            }
            return mn;
        }

        if(k > n ) return f(n, n);
        if(k == n) return f(n, n-1);

        for(int i=2; i<n; i++){ //from 2 should be...

            temp = Math.max( f(i-1, k-1), f(n-i, k));
            answ = Math.min(answ, temp);
            x++;
        }

        cache[n][k] = answ + 1;

        return answ + 1;
    }
}