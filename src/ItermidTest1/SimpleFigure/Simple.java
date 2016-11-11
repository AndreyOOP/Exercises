package ItermidTest1.SimpleFigure;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**Note: 1 is not simple figure*/
public class Simple {

    static int lastSimple;
    static int sqRoot;

    static LinkedList<Pair>    inputPairs    = new LinkedList<>();
    static LinkedList<Integer> simpleFigures = new LinkedList<>();

    public static void main(String[] args) {

        getInput();

        //region all simple figures in range
        LinkedList<Integer> list = populateRange( Pair.max);

        simpleFigures.add(2);

        sqRoot = (int)Math.sqrt(Pair.max)+1;

        while( lastSimple < sqRoot) {

            lastSimple = list.get(0);

            simpleFigures.add( lastSimple);

            filterForSimple(list, lastSimple);
        }

        simpleFigures.addAll( list);
        //endregion

        for (Pair p: inputPairs) {
            print( figuresInRange(simpleFigures, p.a, p.b));
        }
    }

    public static void getInput(){

        Scanner scanner = new Scanner( System.in);

        int n = scanner.nextInt();

        int a;
        int b;

        for(int i=0; i<n; i++){

            a = scanner.nextInt();
            b = scanner.nextInt();

            inputPairs.add( new Pair(a, b));
        }

    }

    public static LinkedList<Integer> populateRange(int upperLimit){

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=1; i<(upperLimit/2+1); i++){ //todo 6m+-1... (not successfull)
            list.add(2*i+1);
        }

        while (upperLimit < list.getLast()){ //todo error in case of very small range
            list.removeLast();
        }

        return list;
    }

    public static LinkedList<Integer> filterForSimple(LinkedList<Integer> in, int simple){

        LinkedList<Integer> figuresToRemove = new LinkedList<>();

        int forRemove = simple;
        int max       = in.getLast();
        int i = 0;

        figuresToRemove.add( simple);

        while (forRemove <= max){

            forRemove = in.get(i)*simple;

            figuresToRemove.add( forRemove);
            i++;
        }

        for(Integer r: figuresToRemove){
            in.remove(r);
        }

        /*for(Integer i: in) {

            if ( i % simple != 0) {
                out.add(i);
            }
        }*/

        return in;
    }

    public static int figuresInRange(LinkedList<Integer> list, int a, int b){ //todo rewrite

        int qty = 0;

        for(int i=0; i<list.size(); i++){

            if( list.get(i) >= a && list.get(i) <= b){
                qty++;
            }
        }

        return qty;
    }

    public static void print(int answer){

        PrintWriter printWriter = new PrintWriter( System.out);

        printWriter.println(answer);

        printWriter.flush();
    }

    static class Pair{

        public static int max = -1;

        public int a;
        public int b;

        public Pair(int a, int b) {

            this.a = a;
            this.b = b;

            if(b > max)
                max = b;
        }
    }

}
