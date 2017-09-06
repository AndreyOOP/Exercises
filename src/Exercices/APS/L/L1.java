package Exercices.APS.L;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class L1 {

    static int N, M;

    static LinkedList<Edge>[] G;
    static boolean[] visit;
    static int[]  distTo;

    public static void main(String[] args) {

        getInput();

//        visit  = new boolean[N];
//        distTo = new int[N];
//
//        for(int i=0; i<N; i++)
//            distTo[i] = Integer.MAX_VALUE;

        initialize();

        int nextV = 0;
        distTo[0] = 0;

        while (nextV != -1){

            visit[nextV] = true;

            for(Edge e: G[nextV]){

                if(!visit[e.w])
                    relax(e);
            }

            nextV = getNext();
        }

        print(distTo[N-1]);
    }

    static void relax(Edge e){

        if(distTo[e.w] > distTo[e.v] + e.weight){

            distTo[e.w] = distTo[e.v] + e.weight;
        }
    }

    static int getNext(){

        int ind = -1;

        for(int i=0; i<N; i++){

            if( !visit[i] && (ind == -1 || distTo[i] < distTo[ind] ))
                ind = i;
        }

        return ind;
    }

    static void initialize(){

        visit  = new boolean[N];
        distTo = new int[N];

        for(int i=0; i<N; i++)
            distTo[i] = Integer.MAX_VALUE;
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        G = new LinkedList[N];
        for(int i=0; i<N; i++)
            G[i] = new LinkedList<>();

        int u, v, w;

        for(int i=0; i<M; i++){

            u = sc.nextInt()-1;
            v = sc.nextInt()-1;
            w = sc.nextInt();

            G[u].add(new Edge(u, v, w));
            G[v].add(new Edge(v, u, w));
        }
    }

    static void print(int val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(val);
        pw.flush();
    }

    static class Edge{

        int v;
        int w;
        int weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
    }
}
