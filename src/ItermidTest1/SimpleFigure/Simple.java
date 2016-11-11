package ItermidTest1.SimpleFigure;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Simple {

    static int a;
    static int b;

    static int lastSimple;

    static LinkedList<Integer> simpleFigures = new LinkedList<>();

    static LinkedList<Pair> pairs = new LinkedList<>();


    public static void main(String[] args) {

        getInput();

        for (Pair p: pairs) {

            a = p.a;
            b = p.b;

            LinkedList<Integer> list = new LinkedList<>();

            for(int i=2; i<=b; i++)
                list.add(i);

            simpleFigures.add(1);

            int sq = (int)Math.sqrt(b)+1;

            while( list.size() > 0) {

                lastSimple = list.get(0); //get next simple

                simpleFigures.add( lastSimple);

                if(  lastSimple < sq)
                    list = filterForSimple(list, lastSimple);
                else{
                    list.remove(0);
                    break;
                }
            }

            simpleFigures.addAll( list);

            print( figuresInRange(simpleFigures, a, b));
        }
    }

    public static void print(int answer){

        PrintWriter printWriter = new PrintWriter( System.out);

        printWriter.println(answer);

        printWriter.flush();
    }

    public static LinkedList<Integer> filterForSimple(LinkedList<Integer> in, int simple){

        LinkedList<Integer> out = new LinkedList<>();

        for(Integer i: in) {
            if ( i%simple != 0) {
                out.add(i);
            }
        }

        return out;
    }

    public static void getInput(){

        Scanner scanner = new Scanner( System.in);

        int n = scanner.nextInt();

        a = scanner.nextInt();
        b = scanner.nextInt();

        for(int i=0; i<n; i++)
            pairs.add( new Pair(a, b));

    }

    public static int figuresInRange(LinkedList<Integer> list, int a, int b){

        int qty = 0;

        for(int i=0; i<list.size(); i++){

            if( list.get(i) >= a && list.get(i) <= b){
                qty++;
            }
        }

        return qty;
    }

    static class Pair{

        public int a;
        public int b;

        public Pair(int a, int b) { //todo add sort or find max b, for max b - find range, then find answer for each range
            this.a = a;
            this.b = b;
        }
    }
}
