package ItermidTest1.Feachure;

import java.io.PrintWriter;
import java.util.*;

public class Main {

    private static int n;

    private static int[] f;

    private static LinkedList<ValQty> vq;
    private static LinkedList<ValQty> answer;

    public static void main(String[] args) {

        getInputData();

        Arrays.sort(f);

        vq = new LinkedList<>();

        vq.push( new ValQty(f[0], 1));

        for(int i=1; i<f.length; i++){

            if( vq.peek().v == f[i])
                vq.peek().qty++;
            else
                vq.push( new ValQty(f[i], 1));
        }

        Collections.sort(vq, ValQty.getComparatorByQty());

        answer = new LinkedList<>();
        answer.push( vq.pop());

        while ( answer.peek().qty == vq.peek().qty)
            answer.push( vq.pop());

        PrintWriter printWriter = new PrintWriter(System.out);

        printWriter.print(answer.pop().v);

        while ( !answer.isEmpty()){
            printWriter.print(" ");
            printWriter.print(answer.pop().v);
        }

        printWriter.flush();

    }

    private static void getInputData(){

        Scanner scanner = new Scanner( System.in);

        n = scanner.nextInt();

        f = new int[n];

        for(int i=0; i<n; i++){
            f[i] = scanner.nextInt();
        }
    }

    static class ValQty{

        public int v;
        public int qty;

        public ValQty(int v, int qty) {
            this.v = v;
            this.qty = qty;
        }

        public static Comparator<ValQty> getComparatorByQty(){

            return new Comparator<ValQty>() {

                @Override
                public int compare(ValQty o1, ValQty o2) {

                    if( o1.qty > o2.qty) return -1;

                    if( o1.qty < o2.qty) return  1;

                    return 0;
                }
            };
        }
    }
}
