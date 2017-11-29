package Exercices.DynamicPrograms;

import java.util.Scanner;

public class RJ {

    static int T, N;
    static int[] n; //or long ?

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t=0; t<T; t++){

            N = sc.nextInt();

//            n = new int[N+3];
//            n[0] = 1; n[1] = 1; n[2] = 1; n[3] = 1;

//            System.out.println( getPrimes(f(N)));
            System.out.println( getPrimes( qtyOfPics(N)));
        }

        sc.close();
    }

    static int qtyOfPics(int N){

        int[] dp = new int[N+3];

        dp[0] = 1; dp[1] = 1; dp[2] = 1; dp[3] = 1;

        for(int i=4; i<=N; i++)
            dp[i] = dp[i-1] + dp[i-4];

        return dp[N];
    }

    static int f(int i){

        if(n[i] != 0) return n[i];

        n[i] = f(i-1) + f(i-4);

        return n[i];
    }

    static int getPrimes(int M){

        int[] p = new int[M+1];

        for(int i=1; i<=M; i++)
            p[i] = i;

        for(int i=2; i<=Math.sqrt(M); i++){

            if(p[i] != 0){

                for(int j = i+1; j<=M; j++)
                    if(p[j] % p[i] == 0) p[j] = 0;
            }
        }

        int qty = 0;

        for(int i=2; i<=M; i++)
            if(p[i] != 0) qty++;

        return qty;
    }
}
