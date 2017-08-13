package Theory.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_TwoColor {

    static LinkedList<Integer>[] G;
    static boolean[] marked, colour;

    public static void main(String[] args) {

        G = graph();
//        G = graphTwoColor();

        for(int i=0; i<G.length; i++)
            System.out.println("Is graph two colour? - " + ( bfs(G, i) ? "Yes" : "No"));
    }

    static boolean bfs(LinkedList<Integer>[] G, int v){

        int t;
        Queue<Integer> queue = new LinkedList<>();
        marked = new boolean[G.length];
        colour = new boolean[G.length];

        marked[v] = true;
        queue.add(v);

        while ( !queue.isEmpty()){

            t = queue.remove();

            for(int w: G[t]){

                if( !marked[w]){

                    marked[w] = true;
                    queue.add(w);
                    colour[w] = !colour[t];

                } else if (colour[w] == colour[t])
                    return false;
            }
        }

        return true;
    }

    static LinkedList<Integer>[] graph(){

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

    static LinkedList<Integer>[] graphTwoColor(){

        LinkedList<Integer>[] adjList = new LinkedList[11];

        for(int i=0; i<11; i++)
            adjList[i] = new LinkedList<>();

        adjList[0].addAll( Arrays.asList(1, 2, 3)   );
        adjList[1].addAll( Arrays.asList(0, 4, 5)   );
        adjList[2].addAll( Arrays.asList(0, 7)      );
        adjList[3].addAll( Arrays.asList(0, 8, 9)   );
        adjList[4].addAll( Arrays.asList(1)         );
        adjList[5].addAll( Arrays.asList(1, 6)      );
        adjList[6].addAll( Arrays.asList(5)         );
        adjList[7].addAll( Arrays.asList(2)         );
        adjList[8].addAll( Arrays.asList(3, 10)     );
        adjList[9].addAll( Arrays.asList(3, 10)     );
        adjList[10].addAll(Arrays.asList(8, 9)      );

        return adjList;
    }
}
