package Exercices.APS;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class L {

    static int N, M;

    static LinkedList<Edge>[] G;
    static LinkedList<Pth> vert;

    static Edge[] edgeTo;
    static int[]  distTo;

    public static void main(String[] args) {

        getInput();

        edgeTo = new Edge[N];
        distTo = new int[N];

        for(int i=0; i<N; i++)
            distTo[i] = Integer.MAX_VALUE;

        distTo[0] = 0;

        vert = new LinkedList<>();
        vert.add(new Pth(0,0));

        while (!vert.isEmpty()){
            relax( getMin());
        }

        print(distTo[N-1]);
    }

    static void relax(int v){

        for(Edge e: G[v]){

            if(distTo[e.w] > distTo[e.v] + e.p){

                distTo[e.w] = distTo[e.v] + e.p;
                edgeTo[e.w] = e;

                addOrUpdate(e.w, distTo[e.w]); //add or update vertice
            }
        }
    }

    static int getMin(){

        int min = Integer.MAX_VALUE;
        int ret = 0;

        for(Pth i: vert)
            if(i.weight < min) {
                min = i.weight;
                ret = i.w;
        }

        for(Pth i: vert){
            if(i.weight == min)
                vert.remove(i);
        }

        return ret;
    }

    static void addOrUpdate(int w, int weight){

        for(Pth i: vert){

            if(i.w == w) {
                i.weight = weight;
                return;
            }
        }

        vert.add(new Pth(w, weight));
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
        int p;

        public Edge(int v, int w, int p) {
            this.v = v;
            this.w = w;
            this.p = p;
        }
    }

    static class Pth implements Comparable{

        int w;
        int weight;

        public Pth(int w, int weight) {
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {

            Pth x = (Pth)o;

            if(this.weight > x.weight) return -1;
            if(this.weight < x.weight) return  1;
            return 0;
        }
    }
}
