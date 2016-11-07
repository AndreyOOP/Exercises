package Figures;

import java.util.LinkedList;
import java.util.List;

public class Solver {

    private static int a;
    private static int b;

    private static int iteration;

    public static List<Integer> input;
    public static List<Integer> output;

    public static void solve(Variant variant){

        initialize(variant);

        while (true){

            iteration++;

            for (Integer i: input) {

                if( buttonAction( multiply(i)))
                    return;

                if( buttonAction( sum(i)))
                    return;

                if( buttonAction( minus(i)))
                    return;
            }

            input = output;
            output = new LinkedList<>();
        }
    }

    private static void initialize(Variant variant){

        Input.getInput(variant);

        a = Input.a;
        b = Input.b;

        input  = new LinkedList<>();
        output = new LinkedList<>();

        iteration = 0;

        input.add(a);

        if(isAnswer(a))
            System.out.println( iteration);
    }

    private static Boolean buttonAction(int value){

        if( isValueOk(value)){

            if( isAnswer(value)){

                System.out.println( iteration);
                return true;

            }else {
                output.add( value);
                return false;
            }
        }

        return false;
    }

    private static int multiply(int i){
        return 3*i;
    }

    private static int sum(int i){

        int sum = 0;
        int num = i;

        while (num > 0){
            sum += num % 10;
            num = num / 10;
        }

        return i + sum;
    }

    private static int minus(int i){
        return i-2;
    }

    private static Boolean isAnswer(int val){
        return val == b;
    }

    private static Boolean isValueOk(int val){
        return val >= 0 && val <= 9999;
    }
}
