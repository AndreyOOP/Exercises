package FigureGame;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    //<editor-fold desc="Variables">
    public static int a;
    public static int b;

    public static LinkedList<Integer> in;
    public static LinkedList<Integer> out;
    public static LinkedList<Integer> actions;

    public static List<List<Integer>> iterations;
    public static int iter;

    public static Boolean valueFound;

    public static int prevPosition;
    public static int prevAction;
    //</editor-fold>

    public static void solve(TestCase testCase){

        //find figure b
        initialize(testCase);

        //<editor-fold desc="Find Qty of Steps and Lists of Results">
        while ( !valueFound) { //todo update

            for(Integer i: in){

                //implement 4 operations
                if( checkValueAndAddAndValueFound( increaseFirst(i)))
                    break;

                if( checkValueAndAddAndValueFound( decreaseLast(i)))
                    break;

                if( checkValueAndAddAndValueFound( cycleLeft(i)))
                    break;

                if( checkValueAndAddAndValueFound( cycleRight(i)))
                    break;
            }

            in = out;
//            iterations.add( out);
            iter++;
            out = new LinkedList<>();
        }
        //</editor-fold>

 /*       System.out.println( in.size());
        System.out.println( iterations.size());
        System.out.println( in.getLast());*/


        prevPosition = in.size();
        prevAction = prevPosition % 4;
        actions.push( prevAction);

        for(int i=iter-1; i>0; i--){

            prevPosition = prevPosition / 4;
            prevAction   = (prevPosition+1) % 4;
            actions.push( prevAction);
        }

        int x = a;
        System.out.println(" begin " + a);

        while ( !actions.isEmpty()) {

            int act = actions.pop();

            if(act == 1) {
                x = increaseFirst(x);
                System.out.println("+first " + x);
            }
            if(act == 2) {
                x = decreaseLast(x);
                System.out.println("-last  " + x);
            }
            if(act == 3) {
                x = cycleLeft(x);
                System.out.println("  <-   " + x);
            }
            if(act == 0) {
                x = cycleRight(x);
                System.out.println("  ->   " + x);
            }
        }

        System.out.println(" end   " + b);

    }

    public static void initialize(TestCase testCase){

        InputData input = new InputData();

        a = input.getData(testCase).a;
        b = input.getData(testCase).b;

        in         = new LinkedList<>();
        out        = new LinkedList<>();
        actions    = new LinkedList<>();

        iter = 0;

        in.add(a);

        valueFound = false;

        if(a==b){
            System.out.println(b);
            return;
        }
    }

    public static Boolean checkValueAndAddAndValueFound(int value){

        out.add( value);

        return valueFound = (value == b);
    }

    public static int increaseFirst(int value){ //incorrect

        int first = (value - value % 1000)/1000;

        if (first != 9)
            value += 1000;

        return value;
    }

    public static int decreaseLast(int value){

        int last = value % 10;

        if( last != 1)
            value--;

        return value;
    }

    public static int cycleRight(int value){

        int f4 = value % 10;

        value = value / 10;
        int f3 = value % 10;

        value = value / 10;
        int f2 = value % 10;

        value = value / 10;
        int f1 = value % 10;

        return 1000*f4 + 100*f1 + 10*f2 + f3;
    }

    public static int cycleLeft(int value){

        int f4 = value % 10;

        value = value / 10;
        int f3 = value % 10;

        value = value / 10;
        int f2 = value % 10;

        value = value / 10;
        int f1 = value % 10;

        return 1000*f2 + 100*f3 + 10*f4 + f1;
    }
}
