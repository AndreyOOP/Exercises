package Other.MagicMachine;

import java.io.*;
import java.util.*;

public class Main { //62% - 1 incorrect other out of time

    private static int a;
    private static int b;

    private static int iteration;

    public static List<Integer> input;
    public static List<Integer> output;

    static PrintWriter printWriter;

    public static void main(String[] args) {

        initialize();

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

    private static void initialize(){

        Scanner scanner = new Scanner( System.in);
        printWriter = new PrintWriter( System.out);

        a = scanner.nextInt();
        b = scanner.nextInt();

        input  = new LinkedList<>();
        output = new LinkedList<>();

        iteration = 0;

        input.add(a);

        if(isAnswer(a)){
            printWriter.println(iteration);
            printWriter.flush();
        }
    }

    private static Boolean buttonAction(int value){

        if( isValueOk(value)){

            if( isAnswer(value)){

//                System.out.println( iteration);
                printWriter.println(iteration);
                printWriter.flush();
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
