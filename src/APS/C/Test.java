package APS.C;

import java.io.PrintWriter;
import java.util.Scanner;

public class Test {

    static int ax, ay, bx, by;
    static int nod;

    public static void main(String[] args) {

        getInput();

        nod = getNOD( Math.abs(ax - bx), Math.abs(ay - by));

        print(nod - 1);
    }

    public static void getInput(){

        Scanner scanner = new Scanner(System.in);

        ax = scanner.nextInt();
        ay = scanner.nextInt();
        bx = scanner.nextInt();
        by = scanner.nextInt();
    }

    public static int getNOD(int n, int m){

        if(n==0 && m==0) return 1;
        if(n==0)         return m;
        if(m==0)         return n;

        int a, b, saveA, nod;

        nod = Math.min(n,m);
        a   = Math.min(n,m);
        b   = Math.max(n,m) % Math.min(n,m);

        while (b != 0){

            nod = b;
            saveA = a;

            a = b;
            b = saveA % b;
        }

        return nod;
    }

    public static void print(int value){

        PrintWriter writer = new PrintWriter(System.out);
        writer.println(value);
        writer.flush();
    }
}
