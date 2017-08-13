package Theory.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**picture Connectivity.jpg*/
public class BFS_Connectivity {

    static LinkedList<Integer>[] G;

    static boolean[] marked;
    static int[] connection;
    static int id;

    public static void main(String[] args) {

        G = getGraph();

        checkConnectivity(G);

        System.out.println("Qty of sub graphs = " + (id-1));
        isConnected(1, 10);
        isConnected(1, 3);
        isConnected(9, 4);
        isConnected(10, 11);
    }

    static void checkConnectivity(LinkedList<Integer>[] G){

        id = 1;
        int V = G.length;
        marked = new boolean[V];
        connection = new int[V];

        for(int i=1; i<V; i++){

            if(!marked[i]){
                bfs(G, i);
                id++;
            }
        }
    }

    static void bfs(LinkedList<Integer>[] G, int v){

        Queue<Integer> queue = new LinkedList<>();

        marked[v] = true;
        connection[v] = id;

        queue.add(v);

        while ( !queue.isEmpty()){

            v = queue.remove();

            for(int i: adj(G, v)){

                if(!marked[i]){
                    marked[i] = true;
                    connection[i] = id;
                    queue.add(i);
                }
            }
        }
    }

    static Iterable<Integer> adj(LinkedList<Integer>[] G, int v){
        return G[v];
    }

    static LinkedList<Integer>[] getGraph(){

        LinkedList<Integer>[] graph = new LinkedList[12];

        for(int i=1; i<=11; i++)
            graph[i] = new LinkedList<>();

//        graph[0].addAll(Arrays.asList()); - it is better to start graph from 0
        graph[1].addAll(Arrays.asList(2, 3));
        graph[2].addAll(Arrays.asList(1));
        graph[3].addAll(Arrays.asList(1));
        graph[4].addAll(Arrays.asList(5));
        graph[5].addAll(Arrays.asList(9, 6));
        graph[6].addAll(Arrays.asList(5, 7));
        graph[7].addAll(Arrays.asList(6, 9, 8));
        graph[8].addAll(Arrays.asList(9, 7));
        graph[9].addAll(Arrays.asList(7, 5, 8));
        graph[10].addAll(Arrays.asList(11));
        graph[11].addAll(Arrays.asList(10));

        return graph;
    }

    static boolean isConnected(int v, int w){

        boolean conneced = connection[v] == connection[w];

        if(conneced)
            System.out.println(v + " v " + w + " - connected");
        else
            System.out.println(v + " v " + w + " - not connected");

        return conneced;
    }
}
