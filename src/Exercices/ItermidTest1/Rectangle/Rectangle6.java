//package Exercices.ItermidTest1.Rectangle;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Rectangle6 {

    static int t;
    static LinkedList<NM> inputList;
    static LinkedList<Long> simples;

    static long n;
    static long m;
    static long mult;
    static long temp;

    static long min;
    static long max;

    public static void main(String[] args) {

        getInput();

        int x = (int)Math.sqrt( NM.max);

        simples = findSimples(x);
        PrintWriter pw = new PrintWriter(System.out);

        for(int i=0; i<inputList.size(); i++){

            n = inputList.get(i).n; m = inputList.get(i).m;

//            min = Math.min(n,m);
//            max = Math.max(n,m);

            mult = 1;
            temp = m;

            for(Long l: factorize(simples, n)){
                if(temp % l == 0){
                    temp /= l;
                    mult *= l;
                }
            }

            pw.println("Case #" + (i+1));
            pw.println(n + m - mult);
        }

        pw.flush();
    }

    static LinkedList<Long> factorize(LinkedList<Long> simples ,long n){

        LinkedList<Long> result = new LinkedList<>();

        long sqrt = (long) Math.sqrt(n);

        for(Long l: simples){

            if(l>sqrt)
                break;

            while (n % l == 0){
                result.add(l);
                n /= l;
            }
        }

        if(n != 1)
            result.add(n);

        return result;
    }

    static LinkedList<Long> findSimples(int n){

        long[] list = new long[n+1];

        for(int i=1; i <= n; i++)
            list[i] = i+1;

        for(int i=2; i <= Math.sqrt(n); i++){

            for(int j = i+1; j<n; j++){
                if(j % i == 0)
                    list[j] = 0;
            }
        }

        LinkedList<Long> result = new LinkedList<>();

        for(int i=0; i < n; i++){
            if( list[i] != 0)
                result.add(list[i]);
        }

        return result;
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        t = scanner.nextInt();

        inputList = new LinkedList<>();

        for(int i=0; i<t; i++)
            inputList.add( new NM(scanner.nextLong(), scanner.nextLong()) );
    }

    static class NM{

        long n;
        long m;
        static long max;

        NM(long n, long m){

            if(n > max)
                max = n;

            if(m > max)
                max = m;

            this.n = n;
            this.m = m;
        }
    }
}
