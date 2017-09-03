package Exercices.APS.K;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

/** 100% passed, for K values important to use priority queue (not just sorting array)*/
public class K_2 {

    static int N, K, B, C, M, A1;
    static int prev;

    static PriorityQueue<Integer> pq = new PriorityQueue();
    static PrintWriter            pw = new PrintWriter(System.out);

    public static void main(String[] args) {

        getInput();

        prev = A1; pq.add(prev);

        for(int i=1; i<N; i++){

            prev = calculateA(prev);
            pq.add(prev);

            if(pq.size() > K)
                pq.remove();
        }

        while (!pq.isEmpty())
            print(pw, pq.remove());
    }

    static int calculateA(int aPrev){

        return (modMult(aPrev, B) + C)%M;
    }

    static int modMult(long a, long b){

        return (int)(a * b % M);
    }

    static void print(PrintWriter pw, long val){

        pw.print(val + " ");
        pw.flush();
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N  = sc.nextInt();
        K  = sc.nextInt();
        B  = sc.nextInt();
        C  = sc.nextInt();
        M  = sc.nextInt();
        A1 = sc.nextInt();
    }
}