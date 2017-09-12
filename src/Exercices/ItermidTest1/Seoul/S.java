package Exercices.ItermidTest1.Seoul;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**5 of 10, other time limit...*/
public class S {

    static int N, M;
    static LinkedList<Edge>[] G;
    static int[] distTo;
    static PriorityQueue<Vertice> pq;
    static Vertice preV;

    public static void main(String[] args) {

        getInput();

        distTo = new int[G.length];
        pq = new PriorityQueue<>(G.length);

        for(int v=0; v<G.length; v++)
            distTo[v] = Integer.MAX_VALUE;

        distTo[0] = 0;
        pq.add(new Vertice(0, 0));

        preV = new Vertice(0,0);

        while (!pq.isEmpty())
            relax(pq.remove());

        print(2 * getMax());
    }

    static void relax(Vertice v){

        for(Edge e: G[v.vertice]){

            if(distTo[e.w] > distTo[e.v] + e.t){

                preV.vertice = e.w;
                preV.priority = distTo[e.w];

                distTo[e.w] = distTo[e.v] + e.t;

                pq.remove(preV);
                pq.add(new Vertice(e.w, distTo[e.w]));
            }
        }
    }

    static int getMax(){

        int max = distTo[0];

        for(int i=1; i<N; i++)
            if(max < distTo[i]) max = distTo[i];

        return max;
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        G = new LinkedList[N];
        for(int i=0; i<N; i++)
            G[i] = new LinkedList<>();

        int v, w, t;

        for(int i=0; i<M; i++){

            v = scanner.nextInt();
            w = scanner.nextInt();
            t = scanner.nextInt();

            G[v].add(new Edge(v, w, t));
            G[w].add(new Edge(w, v, t));
        }

    }

    static void print(int t){

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(t);
        printWriter.flush();
    }

    static class Edge{

        public Edge(int v, int w, int t) {
            this.v = v;
            this.w = w;
            this.t = t;
        }

        public int v, w, t;
    }

    static class Vertice implements Comparable{

        public Vertice(int vertice, int priority) {
            this.vertice = vertice;
            this.priority = priority;
        }

        public int vertice, priority;

        @Override
        public int compareTo(Object o) {

            Vertice z = (Vertice)o;
            if(this.priority > z.priority) return 1;
            if(this.priority < z.priority) return -1;
            return 0;
        }
    }
}