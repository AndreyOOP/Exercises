package Exercices.APS;

import java.io.PrintWriter;
import java.util.Scanner;

public class Q {

    static String S;
    static long C = 1009, D = 1000000007;

    static long hash, pow, mult;

    public static void main(String[] args) {

        getInput();

        for(int i=0; i<S.length(); i++){

            pow  = modPower(C, i);
            mult = modMultiply(pow, (int)S.charAt(i) );
            hash = modSum(hash, mult);
        }

        print(hash);
    }

    static long modSum(long a, long b){

        return (a + b) % D;
    }

    static long modPower(long n, int pow){

        long temp = 1;

        for(int i=0; i<pow; i++)
            temp = modMultiply(temp, n);

        return temp;
    }

    static long modMultiply(long a, long b){

        return a * b % D;
    }

    static void print(long val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(val);
        pw.flush();
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);
        S = scanner.nextLine();
    }
}
