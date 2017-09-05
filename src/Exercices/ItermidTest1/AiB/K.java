package Exercices.ItermidTest1.AiB;

import java.io.PrintWriter;
import java.util.Scanner;

/**Note:
 *1) Power operation is ossible to do on lon(n) complexity, instead x^n = x*x*...*x use x^n/2 * x^n/2
 *2) Fibonachi n is [0,0] element of matrix (11;10)^(n-1) */
public class K {

    static long N;
    static int Mod = 1000000007;
    static int[][] startMatrix = {{1, 1},
                                  {1, 0}};

    public static void main(String[] args) {

        getInput();

        int answer = (2* power(startMatrix, N-1)[0][0]) %Mod;

        print(answer);
    }

    static int[][] power(int[][] m, long n){

        if(n == 1) return startMatrix;

        int[][] temp = power(m, n/2);

        temp = multiplyMatrixMod(temp, temp, Mod);

        return n % 2 == 0 ? temp : multiplyMatrixMod(temp, startMatrix, Mod);
    }

    static int[][] multiplyMatrixMod(int[][] a, int[][] b, int mod){

        int[][] c = new int[2][2];

        c[0][0] = (modMult(a[0][0], b[0][0], mod) + modMult(a[1][0], b[0][1], mod)) %mod;
        c[0][1] = (modMult(a[0][0], b[0][1], mod) + modMult(a[1][0], b[1][1], mod)) %mod;
        c[1][0] = (modMult(a[0][1], b[0][0], mod) + modMult(a[1][1], b[1][0], mod)) %mod;
        c[1][1] = (modMult(a[0][1], b[1][0], mod) + modMult(a[1][1], b[1][1], mod)) %mod;

        return c;
    }

    static int modMult(int a, int b, int mod){

        long aa = a;
        long bb = b;

        return (int)(aa*bb % mod);
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
    }

    static void print(int val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.print(val);
        pw.flush();
    }
}