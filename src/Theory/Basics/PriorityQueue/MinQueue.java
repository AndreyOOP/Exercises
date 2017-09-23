package Theory.Basics.PriorityQueue;

public class MinQueue {

    private int maxSize;
    private int size;
    private int[] queue;

    public MinQueue(int maxSize){

        this.maxSize = maxSize;

        queue = new int[maxSize + 1];

        size = 1;
    }

    public void add(int key){
        //add to the end of the queue new element, call up operation
        queue[size] = key;

        up(size);

        size++;
    }

    //get top element of the queue
    //return top element, swap last element with head, execute down operation
    public int remove(){

        int top = queue[1];

        swap(1, --size);

        queue[size] = 0;

        down(1);

        return top;
    }

    private void down(int i){

        while (2*i < size){

            int j = 2*i;

            if(queue[j+1] < queue[j]) j++;

            if(queue[i] > queue[j]){
                swap(i, j);
                i = j;
            } else break;
        }
    }

    private void up(int i){

        while (i > 1 && queue[i] < queue[i/2]){

            swap(i, i/2);
            i /= 2;
        }
    }

    private void swap(int i, int j){

        int temp = queue[i];

        queue[i] = queue[j];
        queue[j] = temp;
    }

    public boolean isEmpty(){
        return size > 1;
    }
}
