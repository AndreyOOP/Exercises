package Exercices.ItermidTest1.Seoul;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class S1 {

    static int N, M;
    static LinkedList<Edge>[] G;
    static int[] distTo;
    static MQKeyVal1 pq;

    public static void main(String[] args) {

        getInput();

        distTo = new int[G.length];
        pq = new MQKeyVal1(G.length);

        for(int v=0; v<G.length; v++)
            distTo[v] = Integer.MAX_VALUE;

        distTo[0] = 0;

        pq.add(0, 0);

        while (!pq.isEmpty())
            relax(pq.remove());

        print(2 * getMax());
    }

    static void relax(int v){

        for(Edge e: G[v]){

            if(distTo[e.w] > distTo[e.v] + e.t){

                distTo[e.w] = distTo[e.v] + e.t;

                pq.add(distTo[e.w], e.w);
            }
        }
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

    static int getMax(){

        int max = distTo[0];

        for(int i=1; i<N; i++)
            if(max < distTo[i]) max = distTo[i];

        return max;
    }

    static void print(int t){

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(t);
        printWriter.flush();
    }

    static class Edge{

        public Edge(int v, int w, int t) {
            this.v = v;
            this.w = w;
            this.t = t;
        }

        public int v, w, t;
    }

    static class MQKeyVal1 {

        private int size;
        private int[] queueK, queueV;

        public MQKeyVal1(int maxSize){

            queueK = new int[maxSize + 1];
            queueV = new int[maxSize + 1];

            size = 1;
        }

        public void add(int key, int value){

            queueK[size] = key;
            queueV[size] = value;

            up(size);

            size++;
        }

        public int remove(){

            int top = queueV[1];

            swap(1, --size);

            queueK[size] = 0;
            queueV[size] = 0;

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

            temp = queueV[i];
            queueV[i] = queueV[j];
            queueV[j] = temp;
        }

        public boolean isEmpty(){
            return size <= 1;
        }
    }
}
