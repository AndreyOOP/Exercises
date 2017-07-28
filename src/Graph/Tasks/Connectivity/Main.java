package Graph.Tasks.Connectivity;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static int V, E;
    static int v, u;
    static boolean[][] incidenceMatrix;
    static boolean[] marked;

    public static void main(String[] args) {

        getInputAndBuildIncidenceMatrix();

        marked = new boolean[V];
        dfs(0);

        PrintWriter pw = new PrintWriter(System.out);

        if(checkAnswer())
            pw.println("YES");
        else
            pw.println("NO");

        pw.flush();
    }

    static boolean checkAnswer(){

        for(boolean b: marked)
            if(!b) return false;

        return true;
    }

    static void dfs(int s){

        marked[s] = true;

        for(int v: adj(s)){
            if(!marked[v])
                dfs(v);
        }
    }

    static LinkedList<Integer> adj(int v){

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0; i<V; i++){
            if(incidenceMatrix[v][i])
                list.add(i);
        }

        return list;
    }

    static void getInputAndBuildIncidenceMatrix(){

        Scanner in = new Scanner(System.in);

        V = in.nextInt();
        E = in.nextInt();

        incidenceMatrix = new boolean[V][V];

        for(int i=0; i<E; i++){

            v = in.nextInt() - 1;
            u = in.nextInt() - 1;

            incidenceMatrix[v][u] = true;
            incidenceMatrix[u][v] = true;
        }
    }

}
