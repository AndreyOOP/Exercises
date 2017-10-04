package Theory.Basics.PriorityQueue;

public class MQKeyVal {

    private int size;
    private int[] queueK;
    private Edge[] queueV;

    public MQKeyVal(int maxSize){

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
}
