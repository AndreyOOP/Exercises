package Theory.Graph.GraphAPI;

import java.util.LinkedList;

public class GraphIncidenceMatrix implements GraphI {

    private int[][] incidenceMatrix;

    public GraphIncidenceMatrix(int[][] incidenceMatrix){
        this.incidenceMatrix = incidenceMatrix;
    }

    @Override
    public int verticesQty() {
        return incidenceMatrix[0].length;
    }

    @Override
    public int edgesQty() {

        int qty = 0;

        for(int i=0; i<verticesQty(); i++)
            for(int j=i+1; j<verticesQty(); j++)
                if(incidenceMatrix[i][j] == 1)
                    qty++;

        return qty;
    }

    @Override
    public void addEdge(int v, int w) {

        incidenceMatrix[v][w] = 1;
        incidenceMatrix[w][v] = 1;
    }

    @Override
    public Iterable<Integer> adjacent(int v) {

        LinkedList<Integer> adj = new LinkedList<>();

        for(int i=0; i<verticesQty(); i++)
            if(incidenceMatrix[v][i] == 1)
                adj.add(i);

        return adj;
    }
}
