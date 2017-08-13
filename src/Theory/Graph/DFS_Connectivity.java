package Theory.Graph;

import java.util.Arrays;
import java.util.LinkedList;

/**Algorithms on Java - p492
 * picture Connectivity.jpg*/
public class DFS_Connectivity {

    static LinkedList<Integer>[] G;

    static boolean[] marked;
    static int[] connection;
    static int id;

    public static void main(String[] args) {

        G = getGraph();

        checkConnectivity(G);

        System.out.println("Qty of sub graphs = " + id);
        isConnected(1, 10);
        isConnected(1, 3);
        isConnected(9, 4);
        isConnected(10, 11);

    }

    static boolean isConnected(int v, int w){

        boolean conneced = connection[v] == connection[w];

        if(conneced)
            System.out.println(v + " v " + w + " - connected");
        else
            System.out.println(v + " v " + w + " - not connected");

        return conneced;
    }

    static void checkConnectivity(LinkedList<Integer>[] G){

        marked = new boolean[G.length];
        connection = new int[G.length];

        for(int i=1; i<G.length; i++){

            if(!marked[i]){

                dfs(G, i);
                id++;
            }
        }
    }

    static void dfs(LinkedList<Integer>[] G, int v){

        marked[v] = true;
        connection[v] = id;

        for(int i: adj(G, v)){

            if(!marked[i])
                dfs(G, i);
        }
    }

    static LinkedList<Integer> adj(LinkedList<Integer>[] G, int v){
        return G[v];
    }

    static LinkedList<Integer>[] getGraph(){

        LinkedList<Integer>[] graph = new LinkedList[12];

        for(int i=1; i<=11; i++)
            graph[i] = new LinkedList<>();

//        graph[0].addAll(Arrays.asList());
        graph[1].addAll(Arrays.asList(2, 3));
        graph[2].addAll(Arrays.asList(1));
        graph[3].addAll(Arrays.asList(1));
        graph[4].addAll(Arrays.asList(5));
        graph[5].addAll(Arrays.asList(6, 9));
        graph[6].addAll(Arrays.asList(5, 7));
        graph[7].addAll(Arrays.asList(6, 8, 9));
        graph[8].addAll(Arrays.asList(7, 9));
        graph[9].addAll(Arrays.asList(5, 7, 8));
        graph[10].addAll(Arrays.asList(11));
        graph[11].addAll(Arrays.asList(10));

        return graph;
    }
}
