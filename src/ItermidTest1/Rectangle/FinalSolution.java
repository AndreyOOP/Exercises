package ItermidTest1.Rectangle;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * History
 * 1) try to check each cell - if in different rectangles - +2 otherwise +1 - low performance 3/10
 * 2) factorize n, m - to list -> find same multiplier -> calculae -> performance 9/10
 * 3) same as 2 but with optimizations - factorize only minimum of n,m use formula n+m-nod -> performance 9/10, but it improves time
 * 4) try to calculate all simples for max of set & via the set factorize -> performance 3/10
 * 5) there is Evclid algorithm to calculate NOD just use it & result n+m-nod -> perfomance 10/10 approximately 0,1 sec of 1 for each test case*/

public class FinalSolution {

    //region Variables
    static int t;

    static long n;
    static long m;

    static long nod;

    static Scanner scanner = new Scanner(System.in);

    static PrintWriter printWriter = new PrintWriter(System.out);
    //endregion

    public static void main(String[] args) {

        t = scanner.nextInt();

        for(int i=0; i<t; i++){

            n = scanner.nextLong();
            m = scanner.nextLong();

            nod = findNOD(n, m);

            printWriter.println("Case #" + (i+1));
            printWriter.println( n + m - nod);
        }

        printWriter.flush();
    }

    static long findNOD(long n, long m){

        while (n != m){

            if(n > m)
                n -= m;
            else
                m -= n;
        }

        return n;
    }

    static long findNOD2(long n, long m){

        while (n != 0 && m != 0){

            if(n > m)
                n %= m;
            else
                m %= n;
        }

        return n + m;
    }
}