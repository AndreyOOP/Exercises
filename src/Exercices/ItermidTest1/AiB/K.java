package Exercices.ItermidTest1.AiB;

import java.io.PrintWriter;
import java.util.Scanner;

/**try to power matrix to n
 * 1 1  -> to n
 * 1 0
 *
 * M^n eq M^n/2*M^n/2 etc, so time is log(n)*/

public class K {

    static int m = 1000000007;
    static long N;

    public static void main(String[] args) {

        getInput();

        int f = 0, m1 = 0, m2 = 2;

        for(long i=0; i<N; i++){

            f = (m1 + m2) % m;
            m2 = m1;
            m1 = f;
        }

        print(f);
    }

    static void print(int val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.print(val);
        pw.flush();
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
    }
}
