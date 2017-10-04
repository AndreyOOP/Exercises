package Theory.Basics.PriorityQueue;

public class ForTesting {

    public static void main(String[] args) {

//        MQKeyVal mq = new MQKeyVal(10);
//
//        mq.add(7, 11);
//        mq.add(2, 8);
//        mq.add(3, 6);
//        mq.add(4, 3);
//        mq.add(1, 5);
//        mq.add(12, 4);
//        mq.add(121, 31);
//        mq.add(42, 42);
    }

    void test1(){

        MinQueue mq = new MinQueue(10);

        mq.add(7);
        mq.add(2);
        mq.add(4);
        mq.add(3);
        mq.add(1);
        mq.add(8);
        mq.add(10);

        System.out.println( mq.remove());
        System.out.println( mq.remove());
        System.out.println( mq.remove());
    }
}
