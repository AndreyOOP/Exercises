package Graph;

public interface GraphI {

    /**Return qty of vertices*/
    int verticesQty();

    /**Return qty of edges*/
    public int edgesQty();

    /**add edge v-w*/
    public void addEdge(int v, int w);

    /**vertices adjacent to v*/
    public Iterable<Integer> adjacent(int v);
}
