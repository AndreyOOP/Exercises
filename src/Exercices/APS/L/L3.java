package Exercices.APS.L;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**Simple but works only for 1 test case*/
public class L3 {

    static int N, M;
    static LinkedList<Edge>[] G;
    static int[]     distTo;

    public static void main(String[] args) {

        getInput();

        distTo = new int[N];

        for(int i=0; i<N; i++)
            distTo[i] = Integer.MAX_VALUE;

        distTo[0] = 0;

        for(int iteration=1; iteration<N; iteration++){

            for(int v=0; v<N; v++){

                if(distTo[v] < Integer.MAX_VALUE)
                    for(Edge e: G[v])
                        distTo[e.w] = Math.min(distTo[e.w], distTo[e.v] + e.weight);
            }
        }

        print(distTo[N-1]);
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

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); M = sc.nextInt();

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
}
