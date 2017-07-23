package Graph;

import java.util.Stack;

public class Paths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public Paths(GraphI graph, int s){

        this.s = s;
        marked = new boolean[graph.verticesQty()];
        edgeTo = new int[graph.verticesQty()];

        dfs(graph, s);
    }

    private void dfs(GraphI graph, int v){

        marked[v] = true;

        for(int w: graph.adjacent(v)){
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){

        if( !hasPathTo(v))
            return null;

        Stack<Integer> stack = new Stack<>();

        for(int i=v; i != s; i = edgeTo[i]){
            stack.push(i);
        }

        return stack;
    }

    public void stackToString(Stack stack){

        while (stack.size() != 0)
            System.out.print(stack.pop() + " -> ");

        System.out.println();
    }
}
