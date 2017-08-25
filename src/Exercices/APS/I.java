package Exercices.APS;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class I {

    static int N, K, A, B;
    static LinkedList<Integer>[] G;
    static LinkedList<Integer> queue;
    static boolean[] marked;
    static int[] pathTo;
    static int shortestPath;

    public static void main(String[] args) {

        getInput();

        bfs(A);

        print( findShortestPath());
    }

    static void bfs(int s){

        int w;
        queue = new LinkedList<>();
        marked = new boolean[N+1];
        pathTo = new int[N+1];

        queue.add(s);
        marked[s] = true;

        while ( !queue.isEmpty()){

            w = queue.remove();

            for(int i: G[w]){

                if( !marked[i]){
                    queue.add(i);
                    marked[i] = true;
                    pathTo[i] = w;
                }
            }
        }
    }

    static int findShortestPath(){

        if(marked[B]){ //path exists

            for(int i=B; i!=A; i=pathTo[i])
                shortestPath++;

            return shortestPath-1;
        }

        return -1;
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();

        G = new LinkedList[N+1]; //numering starts from 1, 0 is never used
        for(int i=1; i<=N; i++)
            G[i] = new LinkedList<>();

        for(int i=1; i<=K; i++){

            int v = sc.nextInt();
            int w = sc.nextInt();
            G[v].add(w);
            G[w].add(v);
        }
    }

    static void print(int value){

        PrintWriter pw = new PrintWriter(System.out);
        pw.print(value);
        pw.flush();
    }
}