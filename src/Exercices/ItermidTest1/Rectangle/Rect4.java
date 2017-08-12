package Exercices.ItermidTest1.Rectangle;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Rect4 {

    //region Variables
    static int t;

    static long n;
    static long m;

    static long min;
    static long max;

    static long mult;
    //endregion

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        t = scanner.nextInt();

        for(int i=0; i<t; i++){

            n = scanner.nextLong();
            m = scanner.nextLong();

            if(n == m){
                printWriter.println("Case #" + (i+1));
                printWriter.println(n);
                printWriter.flush();
                continue;
            }

            min = Math.min(n,m);
            max = Math.max(n,m);

            mult = 1;

            for(Long l: factorize(min)){
                if(max%l == 0){
                    mult *= l;
                    max /= l;
                }
            }

            min /= mult;

            printWriter.println("Case #" + (i+1));
            printWriter.println( mult * (min + max - 1));
            printWriter.flush();
        }
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