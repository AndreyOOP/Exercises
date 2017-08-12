package Theory.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SingleBFS {

    static LinkedList<Integer>[] graph;
    static boolean[] marked;

    public static void main(String[] args) {

        graph = graphAdjacementList();

        marked = new boolean[graph.length];

        bfs(9);
    }

    static void bfs(int s){

        Queue<Integer> queue = new LinkedList<>();

        queue.add(s); /**Add first element to queue and mark it */
        marked[s] = true;

        while (!queue.isEmpty()){

            for(int w: adj(queue.remove())){ /**Find all adjacent vertices for last element in queue*/

                if(!marked[w]){ /**Add not marked elements to queue & mark them*/

                    queue.add(w);
                    marked[w] = true;
                    System.out.print("->" + w);
                }
            }
        }
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
