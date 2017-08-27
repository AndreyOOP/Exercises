package Exercices.APS;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class M {

    static int N, K, count;
    static LinkedList<Integer>[] G;
    static boolean[] marked;
//    static int[] id;

    public static void main(String[] args) {

        getInput();

        for(int v=0; v<G.length; v++){

            if( !marked[v]){
                dfs(v);
                count++;
            }
        }

        print(count - 1);
    }

    static void dfs(int v){

        marked[v] = true;
//        id[v] = count;

        for(int i: G[v]){

            if( !marked[i]){
                dfs(i);
            }
        }
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        marked = new boolean[N];
//        id = new int[N];

        G = new LinkedList[N];

        for(int i=0; i<N; i++)
            G[i] = new LinkedList<>();

        for(int i=0; i<K; i++){

            int v = sc.nextInt() - 1;
            int w = sc.nextInt() - 1;
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
