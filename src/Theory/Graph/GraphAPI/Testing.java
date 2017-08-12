package Theory.Graph.GraphAPI;

import Theory.Graph.Paths;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Testing {

    static int[][]               incidenceMatrix;
    static LinkedList<Integer>[] adjList;

    static boolean[] marked;
    static int count;

    //add is contain cycles
    //add connectivity

    //add for directed graphs ?

    public static void main(String[] args) {

        GraphIncidenceMatrix graph = new GraphIncidenceMatrix( fillIncidenceMatrix());

        GraphAdjList graphAdj = new GraphAdjList( fillAdjacementList());


        /*marked = new boolean[ graph.verticesQty()];
        count = 0;

        dfs(graph, 10);

        System.out.println();

        marked = new boolean[ graph.verticesQty()];

        dfs(graphAdj, 10);*/

        Paths paths = new Paths(graphAdj, 10);
        paths.stackToString( (Stack) paths.pathTo(4));
        paths.stackToString( (Stack) paths.pathTo(6));
    }

    static void dfs(GraphI graph, int findV){

        count++;
        marked[findV] = true;
//        System.out.println("Mark " + findV);

        for(int w: graph.adjacent(findV)){

            if( !marked[w]) {
                System.out.print(" -> " + w);
                dfs(graph, w);
            }
        }
    }

    static int degree(GraphI graph, int v){

        int degree = 0;

        for(int i: graph.adjacent(v))
            degree++;

//        return ((LinkedList)graph.adjacent(v)).size();
        return degree;
    }

    static int maxDegree(GraphI graph){

        int max  = 0;
        int temp = 0;

        for(int i=0; i<graph.verticesQty(); i++){

            temp = degree(graph, i);

            if( temp > max)
                max = temp;
        }

        return max;
    }

    static int[][] fillIncidenceMatrix(){

        return new int[][]{
//               0  1  2  3  4  5  6  7  8  9 10
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, //0
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0}, //1
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, //2
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0}, //3
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //4
                {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0}, //5
                {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, //6
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //7
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1}, //8
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1}, //9
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0}  //10
        };
    }

    static LinkedList<Integer>[] fillAdjacementList(){

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
