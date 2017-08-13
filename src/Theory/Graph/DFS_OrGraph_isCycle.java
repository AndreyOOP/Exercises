package Theory.Graph;

import java.util.Arrays;
import java.util.LinkedList;

/** Algorithm Java p523*/
public class DFS_OrGraph_isCycle {

    static int s;
    static LinkedList<Integer>[] G;
    static boolean[] marked, onStack;
    static boolean isCycle;

    public static void main(String[] args) {

//        G = graphWithoutCycle();
        G = graphCycle();

        for(int s=0; s<G.length; s++)
            System.out.println("Is subgraph has cycle? (vertice " + s + ") - " + ( hasCycle(G, s) ? "Yes" : "No"));
    }

    static boolean hasCycle(LinkedList<Integer>[] G, int s){

        isCycle = false;
        marked  = new boolean[G.length];
        onStack = new boolean[G.length];

        dfs(G, s);

        return isCycle;
    }

    static void dfs(LinkedList<Integer>[] G, int v){

        marked[v]  = true;
        onStack[v] = true;

        for(int w: adj(G, v)){

            if(!marked[w]){
                dfs(G, w);

            } else if(onStack[w])
                isCycle = true;
        }

        onStack[v] = false;
    }

    static Iterable<Integer> adj(LinkedList<Integer>[] G, int v){

        return G[v];
    }

    static LinkedList<Integer>[] graphWithoutCycle(){

        LinkedList<Integer>[] G = new LinkedList[9];

        for(int i=0; i<G.length; i++)
            G[i] = new LinkedList<>();

        G[0].addAll(Arrays.asList(1));
        G[1].addAll(Arrays.asList(2));
        G[2].addAll(Arrays.asList(3, 4));
        G[3].addAll(Arrays.asList());
        G[4].addAll(Arrays.asList(5, 7));
        G[5].addAll(Arrays.asList());
        G[6].addAll(Arrays.asList());
        G[7].addAll(Arrays.asList(6));
        G[8].addAll(Arrays.asList(2, 5));

        return G;
    }

    static LinkedList<Integer>[] graphCycle(){

        LinkedList<Integer>[] G = new LinkedList[8];

        for(int i=0; i<G.length; i++)
            G[i] = new LinkedList<>();

        G[0].addAll(Arrays.asList(1, 3));
        G[1].addAll(Arrays.asList(2));
        G[2].addAll(Arrays.asList(3, 5));
        G[3].addAll(Arrays.asList());
        G[4].addAll(Arrays.asList(2));
        G[5].addAll(Arrays.asList(6));
        G[6].addAll(Arrays.asList(7));
        G[7].addAll(Arrays.asList(4));

        return G;
    }
}
