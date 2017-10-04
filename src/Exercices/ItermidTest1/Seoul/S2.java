package Exercices.ItermidTest1.Seoul;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class S2 {

    static int N, M;
    static LinkedList<Edge>[] G;
    static LinkedList<Edge> q = new LinkedList<>();
    static boolean[] marked;
    static MQKeyVal1 mq;

    public static void main(String[] args) {

        getInput();

        marked = new boolean[N];
        mq = new MQKeyVal1(N);

        int path = 0;

        for(Edge e: G[0])
            if(!marked[e.v]) mq.add(e.t, e);

        marked[0] = true;

        Edge min; int m;

        while (!marked[N-1]){ //till element not reached

            min = mq.remove(); //find min t in q  //for each vertice in queue calculate min length till next vertice

            m = min.t;

            for(Edge e: q) //reach that vertice, update all lenghtes
                e.t -= m;

            path += m;
            marked[min.w] = true;

            for(Edge e: G[min.w])
                if(!marked[e.w]) q.add(e); //add to queue
        }

        print(2 * path);
    }

    static Edge getMinT(){

        Edge min = q.getFirst();

        for(Edge e: q)
            if(e.t < min.t) min = e;

        q.remove(min);

        return min;
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        G = new LinkedList[N];
        for(int i=0; i<N; i++)
            G[i] = new LinkedList<>();

        int v, w, t;

        for(int i=0; i<M; i++){

            v = scanner.nextInt();
            w = scanner.nextInt();
            t = scanner.nextInt();

            G[v].add(new Edge(v, w, t));
            G[w].add(new Edge(w, v, t));
        }
    }

    static void print(int t){

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(t);
        printWriter.flush();
    }

    public static class Edge{

        public Edge(int v, int w, int t) {
            this.v = v;
            this.w = w;
            this.t = t;
        }

        public int v, w, t;

        @Override
        public String toString(){
            return v + " > " + w + " : " + t;
        }
    }

    static class MQKeyVal1 {

        private int size;
        private int[] queueK;
        private Edge[] queueV;

        public MQKeyVal1(int maxSize){

            queueK = new int[maxSize + 1];
            queueV = new Edge[maxSize + 1];

            size = 1;
        }

        public void add(int key, Edge value){

            queueK[size] = key;
            queueV[size] = value;

            up(size);

            size++;
        }

        public Edge remove(){

            Edge top = queueV[1];

            swap(1, --size);

            queueK[size] = 0;
            queueV[size] = null;

            down(1);

            return top;
        }

        private void down(int i){

            while (2*i < size){

                int j = 2*i;

                if(queueK[j+1] < queueK[j]) j++;

                if(queueK[i] > queueK[j]){
                    swap(i, j);
                    i = j;
                } else break;
            }
        }

        private void up(int i){

            while (i > 1 && queueK[i] < queueK[i/2]){

                swap(i, i/2);
                i /= 2;
            }
        }

        private void swap(int i, int j){

            int temp = queueK[i];

            queueK[i] = queueK[j];
            queueK[j] = temp;

            Edge tempE = queueV[i];
            queueV[i] = queueV[j];
            queueV[j] = tempE;
        }

        public boolean isEmpty(){
            return size <= 1;
        }

    }
}
