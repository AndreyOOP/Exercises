package Exercices.ItermidTest1.Sake;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class H {

    static int N;
    static int[] r, inc, exc; //inc - max qty if node included, exc - max qty if node excluded
    static LinkedList<Integer>[] G;
    static boolean[] marked;

    public static void main(String[] args) {

        getInput();

        dfs(1);

        print( max(inc[1], exc[1]));
    }

    static void dfs(int v){

        marked[v] = true;

        for(int w: G[v]){

            if(!marked[w]){

                dfs(w);

                inc[v] = inc[v] + exc[w];
                exc[v] = max(exc[v]+inc[w], exc[v]+exc[w]);
            }
        }
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        G   = new LinkedList[N+1]; //G[0] - will not used
        for(int i=0; i<=N; i++)
            G[i] = new LinkedList<>();

        marked = new boolean[N+1];

        r   = new int[N+1];
        inc = new int[N+1];
        exc = new int[N+1];

        for(int i=1; i<=N; i++){
            r[i] = sc.nextInt();
            inc[i] = r[i];
        }

        for(int i=1; i<N; i++)
            G[sc.nextInt()].add(i+1); //sc.nextInt() -> boss of (i+1) engineer
    }

    static int max(int a, int b){

        return a > b ? a : b;
    }

    static void print(int val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(val);
        pw.flush();
    }
}
