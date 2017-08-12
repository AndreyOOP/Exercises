package Theory.Graph;

import java.util.Arrays;
import java.util.LinkedList;

public class HasCycles {

    static boolean[] marked;
    static boolean isCycle;

    public static void main(String[] args) {

        System.out.println( hasCycle( cycleGraph()));
    }

    static boolean hasCycle(LinkedList<Integer>[] graph){

        isCycle = false;
        marked  = new boolean[graph.length];

        for(int s=0; s<graph.length; s++){

            if(!marked[s]){
                dfs(graph, s, s);
            }
        }

        return isCycle;
    }

    static void dfs(LinkedList<Integer>[] graph, int v, int u){ /**u - otkuda prishli*/

        marked[v] = true;

        for(int w: graph[v]){

            if(!marked[w]){
                dfs(graph, w, v);
            }
            else if (w != u){ /**esli popadaem v okrashenuu vershuny drugim putem => cukl*/
                isCycle = true;
            }
        }
    }

    static LinkedList<Integer>[] noCycleSampleGraph(){

        LinkedList<Integer>[] adjList = new LinkedList[3];

        for(int i=0; i<adjList.length; i++)
            adjList[i] = new LinkedList<>();

        adjList[0].addAll( Arrays.asList(1, 2));
        adjList[1].addAll( Arrays.asList(0)   );
        adjList[2].addAll( Arrays.asList(0)   );

        return adjList;
    }

    static LinkedList<Integer>[] cycleSampleGraph(){

        LinkedList<Integer>[] adjList = new LinkedList[3];

        for(int i=0; i<adjList.length; i++)
            adjList[i] = new LinkedList<>();

        adjList[0].addAll( Arrays.asList(1, 2));
        adjList[1].addAll( Arrays.asList(0, 2));
        adjList[2].addAll( Arrays.asList(0, 1));

        return adjList;
    }

    static LinkedList<Integer>[] cycleForReview(){

        LinkedList<Integer>[] adjList = new LinkedList[5];

        for(int i=0; i<adjList.length; i++)
            adjList[i] = new LinkedList<>();

        adjList[0].addAll( Arrays.asList(1, 2));
        adjList[1].addAll( Arrays.asList(0));
        adjList[2].addAll( Arrays.asList(0, 3, 4));
        adjList[3].addAll( Arrays.asList(2, 4));
        adjList[4].addAll( Arrays.asList(2, 3));

        return adjList;
    }

    static LinkedList<Integer>[] noCycleGraph(){

        LinkedList<Integer>[] adjList = new LinkedList[11];

        for(int i=0; i<11; i++)
            adjList[i] = new LinkedList<>();

        adjList[0].addAll( Arrays.asList(1, 2, 3)   );
        adjList[1].addAll( Arrays.asList(0, 4, 5, 6));
        adjList[2].addAll( Arrays.asList(0, 7)      );
        adjList[3].addAll( Arrays.asList(0, 8, 9)   );
        adjList[4].addAll( Arrays.asList(1)         );
        adjList[5].addAll( Arrays.asList(1)         );
        adjList[6].addAll( Arrays.asList(1)         );
        adjList[7].addAll( Arrays.asList(2)         );
        adjList[8].addAll( Arrays.asList(3, 10)     );
        adjList[9].addAll( Arrays.asList(3)         );
        adjList[10].addAll(Arrays.asList(8)         );

        return adjList;
    }

    static LinkedList<Integer>[] cycleGraph(){

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
