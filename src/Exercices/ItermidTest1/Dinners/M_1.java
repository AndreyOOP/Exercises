package Exercices.ItermidTest1.Dinners;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class M_1 {

    static int F, S, B, K;
    static int[] f, s, b;

    public static void main(String[] args) {

        getInput();

        Arrays.sort(f);
        Arrays.sort(s);
        Arrays.sort(b);

        int[] t = getTempFS();

        int tCount = 0, bCount = 0;
        PrintWriter pw = new PrintWriter(System.out);

        for(int i=0; i<K; i++){

            if(t[tCount] < b[bCount])
                pw.print(t[tCount++] + " ");
            else
                pw.print(b[bCount++] + " ");
        }

        pw.flush();
    }

    static int[] getTempFS(){

        int f1 = 0, s1 = 0;
        int f2 = 1, s2 = 0;

        int next = 1;

        int[] temp = new int[K];

        int i = 0;

        while (next < f.length && i<K){

            if(f[f1] + s[s1] < f[f2] + s[s2]){

                temp[i] = f[f1] + s[s1];

                if(s1 == s.length-1){
                    s1 = 0;
                    next++;
                    f1 = next;
                } else {
                    s1++;
                }

            }else {

                temp[i] = f[f2] + s[s2];

                if(s2 == s.length-1){
                    s2 = 0;
                    next++;
                    f2 = next;
                } else {
                    s2++;
                }
            }

            i++;
        }

        if(f1 != next){
            for(int j=s1; j<s.length && i<K; j++)
                temp[i++] = f[f1] + s[j];
        }

        if(f2 != next){
            for(int j=s2; j<s.length && i<K; j++)
                temp[i++] = f[f2] + s[j];
        }

        return temp;
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        B = sc.nextInt();

        f = new int[F];
        s = new int[S];
        b = new int[B];

        for(int i=0; i<F; i++)
            f[i] = sc.nextInt();

        for(int i=0; i<S; i++)
            s[i] = sc.nextInt();

        for(int i=0; i<B; i++)
            b[i] = sc.nextInt();

        K = sc.nextInt();
    }
}
