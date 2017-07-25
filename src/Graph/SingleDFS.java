package Graph;

import java.util.Arrays;
import java.util.LinkedList;

public class SingleDFS {

    static LinkedList<Integer>[] graph;
    static boolean[] marked;

    public static void main(String[] args) {

        graph = graphAdjacementList();

        graphDFS(graph, 0);
    }

    static void graphDFS(LinkedList<Integer>[] graph, int s){

        marked = new boolean[graph.length]; /**Create array of marked vertices*/

        dfs(s);
    }

    static void dfs(int v){

        marked[v] = true; /**mark current vertice*/

        for(int w: adj(v)){ /**for each adjacent not marked vertice call dfs*/

            if(!marked[w]){
                System.out.print("->" + w);
                dfs(w);
            }
        }
    }

    /**Degree(stepen') of vertice*/
    static int degree(int v){
        return ((LinkedList<Integer>)adj(v)).size();
    }

    /** 2*edges / vertices */
    static int averageDegree(){

        int vertices = graph.length;

        int edges = 0;

        for(LinkedList<Integer> i: graph)
            edges += i.size();

        return 2*edges / vertices;
    }

    static int qtyOfSelfLoops(){

        int selfLoops = 0;

        for(int i=0; i<graph.length; i++){

            for(int w: adj(i))
                if(i==w) selfLoops++;
        }

        return selfLoops;
    }



    static Iterable<Integer> adj(int v){
        return graph[v];
    }

    static LinkedList<Integer>[] graphAdjacementList(){

        LinkedList<Integer>[] adjList = new LinkedList[11];

        for(int i=0; i<11; i++)
            adjList[i] = new LinkedList<>();

        adjList[0].addAll( Arrays.asList(1, 2, 3)   );
        adjList[1].addAll( Arrays.asList(0, 4, 5, 6));
        adjList[2].addAll( Arrays.asList(0, 7)      );
        adjList[3].addAll( Arrays.asList(0, 8, 9)   );
        adjList[4].addAll( Arrays.asList(1)         );
        adjList[5].addAll( Arrays.asList(1, 6)      );
        adjList[6].addAll( Arrays.asList(1, 5)      );
        adjList[7].addAll( Arrays.asList(2)         );
        adjList[8].addAll( Arrays.asList(3, 9, 10)  );
        adjList[9].addAll( Arrays.asList(3, 8, 10)  );
        adjList[10].addAll(Arrays.asList(8, 9)      );

        return adjList;
    }
}
