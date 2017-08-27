package Exercices.APS.C;

import java.io.PrintWriter;
import java.util.Scanner;

public class C1 {

    static int ax, ay, bx, by;

    public static void main(String[] args) {

        getInput();

        print( gcd(Math.abs(ax-bx), Math.abs(ay-by)) - 1);
    }

    public static int gcd(int q, int p){

        if(p==0) return q;
        return gcd(p, q%p);
    }

    public static void getInput(){

        Scanner scanner = new Scanner(System.in);

        ax = scanner.nextInt();
        ay = scanner.nextInt();
        bx = scanner.nextInt();
        by = scanner.nextInt();
    }

    public static void print(int value){

        PrintWriter writer = new PrintWriter(System.out);
        writer.println(value);
        writer.flush();
    }
}
