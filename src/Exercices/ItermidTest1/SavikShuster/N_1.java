package Exercices.ItermidTest1.SavikShuster;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class N_1 {

    static Scanner sc;
    static PrintWriter pw;
    static int N, Q, a, b;
    static String line, type;
    static LinkedList<Integer>[] G;
    static int[] connect;
    static boolean[] marked;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        N = sc.nextInt();
        Q = sc.nextInt();
        line = sc.nextLine();

        connect = new int[N+1];

        G = new LinkedList[N+1];
        for(int i=0; i<N+1; i++){
            G[i] = new LinkedList<>();
            G[i].add(i);
            connect[i] = i;
        }

        for(int i=0; i<Q; i++){

            parseNextLine();

            if(type.contentEquals("U")){

                printMessage(connect[a] == connect[b],"BORE", "NEWS!");

                addEdge(a, b);

                marked = new boolean[N+1];
                dfs(a, connect[a]);


            }else {
                printMessage(connect[a] == connect[b], "MUSIC", "SHOW!");
            }
        }

    }

    static void dfs(int v, int con){

        marked[v] = true;
        connect[v]  = con;

        for(int w: G[v]){
            if(!marked[w]){
                dfs(w, con);
            }
        }
    }

    static void parseNextLine(){

        String[] temp = sc.nextLine().split(" ");

        type = temp[0];
        a    = Integer.valueOf(temp[1]);
        b    = Integer.valueOf(temp[2]);
    }

    static void printMessage(boolean isTheSame, String same, String notSame){

        if(isTheSame)
            print(same);
        else
            print(notSame);
    }

    static void print(String message){

        pw.println(message);
        pw.flush();
    }

    static void addEdge(int v, int w){

        G[v].add(w);
        G[w].add(v);
    }
}
