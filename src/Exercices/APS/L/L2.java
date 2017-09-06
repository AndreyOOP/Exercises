package Exercices.APS.L;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**60% of test cases
 * rewrite without edge class ?*/
public class L2 {

    static int N, M;
    static LinkedList<Edge>[] G;
    static boolean[] marked;
    static int[]     distTo;
    static BinaryTree binaryTree;

    public static void main(String[] args) {

        getInput();

        initialize();

        int v = 0;
        distTo[0] = 0;
        binaryTree.set(0, 0);

        while (v != -1 && v != N-1){

            v = binaryTree.getMinIndex();

            marked[v] = true;
            binaryTree.set(v, Integer.MAX_VALUE);

            for(Edge e: G[v]){
                if(!marked[e.w]) relax(e);
            }
        }

        print(distTo[N-1]);
    }

    static void relax(Edge e){

        if(distTo[e.w] > distTo[e.v] + e.weight){

            binaryTree.set(e.w, distTo[e.w] = distTo[e.v] + e.weight);
        }
    }

    static void initialize(){

        marked = new boolean[N];
        distTo = new int[N];

        for(int i=0; i<N; i++)
            distTo[i] = Integer.MAX_VALUE;

        binaryTree = new BinaryTree(N);
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); M = sc.nextInt();

        G = new LinkedList[N];
        for(int i=0; i<N; i++)
            G[i] = new LinkedList<>();

        int u, v, w;

        for(int i=0; i<M; i++){

            u = sc.nextInt()-1;
            v = sc.nextInt()-1;
            w = sc.nextInt();

            G[u].add(new Edge(u, v, w));
            G[v].add(new Edge(v, u, w));
        }
    }

    static void print(int val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(val);
        pw.flush();
    }

    static class Edge{

        int v;
        int w;
        int weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
    }

    static class BinaryTree{

        int size;
        int[] val, ind;

        BinaryTree(int size){

            this.size = size;

            val = new int[2*size];
            ind = new int[2*size];

            for(int i=0; i<size; i++)
                ind[size + i] = i;

            for(int i=0; i<2*size; i++)
                val[i] = Integer.MAX_VALUE;
        }

        void set(int index, int value){

            val[size+index] = value;

            for (int v = (size+index)/2; v>0; v /= 2){

                int l = 2*v;
                int r = l+1;

                if(val[l] <= val[r]){
                    val[v] = val[l];
                    ind[v] = ind[l];
                } else {
                    val[v] = val[r];
                    ind[v] = ind[r];
                }
            }
        }

        int getMinIndex(){

            return val[1] < Integer.MAX_VALUE ? ind[1] : -1;
        }
    }
}
