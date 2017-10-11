package Exercices.ItermidTest1.Dinners;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**First solution with 100% tests passed
 * key idea - sort f & s;
 * if f[i] + s[j] >= max element in queue -> break (all other elements are greater no need to check them)*/
public class M_3 {

    static int F, S, B, K;
    static int[] f, s, b;
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {

        getInput();

        Arrays.sort(f);
        Arrays.sort(s);
        Arrays.sort(b);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<F; i++){

            for(int j=0; j<S; j++){

                if(pq.size() < K){
                    pq.add(f[i] + s[j]);
                } else {
                    if(f[i] + s[j] >= pq.peek()) break;

                    if(pq.size() >= K) pq.remove();
                    pq.add(f[i] + s[j]);
                }
            }
        }

        //to array
        int[] t = new int[pq.size()];
        int X = pq.size();

        for(int i=0; i<X; i++)
            t[i] = pq.remove();

        Arrays.sort(t);

        //merge two arrays
        int tC = 0, bC = 0, i;

        for(i=0; i<K && tC<t.length && bC<b.length; i++){

            if(t[tC] < b[bC])
                pw.print(t[tC++] + " ");
            else
                pw.print(b[bC++] + " ");
        }

        if(tC<t.length){
            for(int j = i; j<K; j++)
                pw.print(t[tC++] + " ");
        }

        if(bC<b.length){
            for(int j = i; j<K; j++)
                pw.print(b[bC++] + " ");
        }

        pw.flush();
    }

    public static void getInput(){

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