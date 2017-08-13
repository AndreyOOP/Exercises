package Theory.Graph;

import java.util.Arrays;
import java.util.LinkedList;

public class DFS_TwoColour {

    static LinkedList<Integer>[] G;
    static boolean[] marked;
    static boolean[] colour;

    static boolean twoColour;

    public static void main(String[] args) {

//        G = graph();
        G = graphTwoColor();

        marked = new boolean[G.length];
        colour = new boolean[G.length];
        twoColour = true;

        for (int i=0; i<G.length; i++) { /**Just for check if it works from any vertice*/
            dfs(G, i);
            System.out.println("Is graph two colour? - " + (twoColour ? "Yes" : "No"));
        }
    }

    static void dfs(LinkedList<Integer>[] G, int s){

        marked[s] = true;

        for(int w: G[s]){

            if( !marked[w]){

                colour[w] = !colour[s];
                dfs(G, w);

            } else if (colour[w] == colour[s]){
                twoColour = false;
            }
        }
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