package Exercices.ItermidTest1.Dinners;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class M_2 {

    static int F, S, B, K;
    static int[] f, s, b;
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {

        getInput();

        Arrays.sort(f);
        Arrays.sort(s);
        Arrays.sort(b);

        PQ pq = new PQ(K);

        int tSum;

        for(int i=0; i<F; i++){

            for(int j=0; j<S; j++){

                tSum = f[i] + s[j];

                if(pq.currSize < K-1){

                    pq.add(tSum);

                } else {

                    if(tSum < pq.pq[1])
                        pq.add(tSum);
                    else
                        break;
                }
            }
        }

        Arrays.sort(pq.pq, 1, pq.currSize+1);

        int bCount = 0, pqCount = 1; int i;

        for(i=0; i<K && pqCount<pq.pq.length && bCount<b.length; i++){

            if(pq.pq[pqCount] < b[bCount])
                pw.print(pq.pq[pqCount++] + " ");
            else
                pw.print(b[bCount++] + " ");
        }

        if(pqCount<pq.pq.length){
            for(int j = i; j<K; j++)
                pw.print(pq.pq[pqCount++] + " ");
        }

        if(bCount<b.length){
            for(int j = i; j<K; j++)
                pw.print(b[bCount++] + " ");
        }
        
//        for(int i=0; i<K; i++){
//
//            if(b[bCount] < pq.pq[pqCount]){
//
//                if(bCount < b.length)
//                    pw.print(b[bCount++] + " ");
//                else
//                    pw.print(pq.pq[pqCount++] + " ");
//            }else {
//                if(pqCount < pq.pq.length)
//                    pw.print(pq.pq[pqCount++] + " ");
//                else
//                    pw.print(b[bCount++] + " ");
//            }
//        }

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

    static class PQ{

        int i, temp;
        public int currSize;
        public int[] pq; //first element is max value

        public PQ(int size){
            pq = new int[size+5];
            currSize = 0;
        }

        //adds figure to queue, if it greater than maxQueue size max value is removed
        public void add(int n){

            if(currSize < pq.length-1){

                pq[++currSize] = n;
                up(n);
            }else {
                pq[1] = n;
                down(n);
            }
        }

        private void up(int n){

            i = currSize;

            while (i>1 && n > pq[i/2]){
                swap(i, i/2);
                i = i/2;
            }
        }

        private void down(int n){

            i = 1;

            while (2*i <= pq.length-2){

                int j = 2*i;
                if(j < pq.length && pq[j] < pq[j+1]) j++;
                if(pq[j] <= n) break;
                swap(j, i);
                i = j;
            }
        }

        private void swap(int i, int j){

            temp = pq[i];
            pq[i] = pq[j];
            pq[j] = temp;
        }
    }
}
