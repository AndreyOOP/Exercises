package Theory.Graph.GraphAPI;

import java.util.LinkedList;

/**not safe to use linked list vertice could already exist but will be added again... */
public class GraphAdjList implements GraphI {

    private int                   edges;
    private int                   vertices;
    private LinkedList<Integer>[] adjList;

    public GraphAdjList(LinkedList<Integer>[] adjList) {

        this.adjList = adjList;

        vertices = adjList.length;

        for(int i=0; i<vertices; i++)
            edges += adjList[i].size();

        edges /= 2;
    }

    @Override
    public int verticesQty() {
        return vertices;
    }

    @Override
    public int edgesQty() {
        return edges;
    }

    @Override
    public void addEdge(int v, int w) {

        adjList[v].add(w);
        adjList[w].add(v);
        edges++;
    }

    @Override
    public Iterable<Integer> adjacent(int v) {
        return adjList[v];
    }
}
