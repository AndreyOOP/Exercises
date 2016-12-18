package ItermidTest1.Rectangle;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * atm the best solution
 * for t - find max
 * for max - find list of all simple figures
 * factorize etc*/
public class Rect5 {

    //region Variables
    static int t;

    static long n;
    static long m;

    static long temp;

    static long mult;
    //endregion

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        t = scanner.nextInt();

        for(int i=0; i<t; i++){

            n = scanner.nextLong(); m = scanner.nextLong();

            if(m < n){ //swap
                temp = m;
                m = n;
                n = temp;
            }

            mult = 1;
            temp = m;

            for(Long l: factorize(n))
                if( temp % l == 0){
                    mult *= l;
                    temp /= l;
                }

            printWriter.println("Case #" + (i+1));
            printWriter.println( n + m - mult);
        }

        printWriter.flush();
    }

    static LinkedList<Long> factorize(long n){

        LinkedList<Long> result = new LinkedList<>();

        for(long i=2; i <= Math.sqrt(n); i++){
            while (n%i == 0){
                n /= i;
                result.add(i);
            }
        }

        if(n != 1)
            result.add(n);

        return result;
    }
}