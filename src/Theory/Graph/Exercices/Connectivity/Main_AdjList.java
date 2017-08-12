package Theory.Graph.Exercices.Connectivity;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_AdjList {

    static int v, e;
    static LinkedList<Integer>[] adjVertices;
    static boolean[] marked;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        v = in.nextInt();
        e = in.nextInt();

        adjVertices = new LinkedList[v];

        for(int i=0; i<v; i++)
            adjVertices[i] = new LinkedList<>();

        for(int i=0; i<e; i++){

            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;

            adjVertices[u].add(v);
            adjVertices[v].add(u);
        }

        marked = new boolean[v];

        dfs(0);

        PrintWriter pw = new PrintWriter(System.out);

        if(getAnswer(marked))
            pw.println("YES");
        else
            pw.println("NO");

        pw.flush();
    }

    static void dfs(int v){

        marked[v] = true;

        for(int i: adjVertices[v]){

            if ( !marked[i]){
                dfs(i);
            }
        }
    }

    static boolean getAnswer(boolean[] marked){

        for(boolean b: marked)
            if(!b)
                return false;

        return true;
    }
}
