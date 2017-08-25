package Exercices.APS;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class H {

    static int N, K;
    static LinkedList<Integer>[] G;
    static boolean[] marked;
    static Stack<Integer> stack;

    public static void main(String[] args) {

        getInput();

        for(int v=0; v<N; v++)
            if( !marked[v])
                dfs(v);

        print(stack);
    }

    static void dfs(int s){

        marked[s] = true;

        for(int i: G[s])
            if( !marked[i]) dfs(i);

        stack.push(s);
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        marked = new boolean[N];
        G      = new LinkedList[N];
        for(int i=0; i<N; i++)
            G[i] = new LinkedList<>();

        K = scanner.nextInt();

        for(int i=0; i<K; i++){

            int v = scanner.nextInt()-1;
            int w = scanner.nextInt()-1;
            G[v].add(w);
        }

        stack = new Stack<>();
    }

    static void print(Stack<Integer> stack){

        PrintWriter pw = new PrintWriter(System.out);

        while (!stack.isEmpty())
            pw.print((stack.pop()+1) + " ");

        pw.flush();
    }
}