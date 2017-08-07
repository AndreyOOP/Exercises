package APS.A;

import java.io.PrintWriter;
import java.util.Scanner;

public class Test {

    static int n, p;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        p = scanner.nextInt();

        int a = n/p;
        int b = n%p;

        long r = 1;

        for(int i=0; i<p-b; i++){
            r *= a;
        }

        for(int i=0; i<b; i++){
            r *= (a+1);
        }

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(r);
        pw.flush();
    }
}
