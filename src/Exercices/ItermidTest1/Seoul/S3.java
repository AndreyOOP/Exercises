package Exercices.ItermidTest1.Seoul;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class S3 {

    static int N, M;
    static LinkedList<Edge>[] G;
    static boolean[] marked;
    static LinkedList<Edge> q = new LinkedList<>();

    public static void main(String[] args) {

        getInput();

        marked = new boolean[N];

        marked[0] = true;

        for(Edge e: G[0])
            q.add(e);

        int pth = 0;

        LinkedList<Edge> rem = new LinkedList<>();
        LinkedList<Edge> q2 = new LinkedList<>();

        boolean upd = false;

        while (!marked[N-1]){

            for(Edge e: q)
                e.t--;

            pth++;

            for(Edge e: q){

                if(e.t == 0){

                    marked[e.w] = true;

                    rem.add(e);

                    for(Edge ee: G[e.w])
                        if(!marked[ee.w]) q2.add(ee);

                    upd = true;
                }
            }

            if(upd){
                q.removeAll(rem);
                q.addAll(q2);
                rem.clear();
                q2.clear();

                upd = false;
            }
        }

        print(2*pth);
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
}