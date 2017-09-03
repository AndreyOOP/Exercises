package Exercices.APS.K;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class K_1 {

    static int N, K;
    static long B, C, M, A1;
    static long [] a;
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {

        getInput();

        a = new long[N];

        a[0] = A1;

        for(int i=1; i<N; i++){

            a[i] = ((a[i-1] * B)%M + C) % M;
        }


        Arrays.sort(a);

        for(int i= a.length-K; i<N; i++)
            pw.print(a[i] + " ");

        pw.flush();
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        B = sc.nextLong();
        C = sc.nextLong();
        M = sc.nextLong();
        A1 = sc.nextLong();
    }

}
