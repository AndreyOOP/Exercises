package OlympWeight;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static int n;
    private static int iteration;
    private static int sum;
    private static int delta;
    private static LinkedList<Integer> in;
    private static LinkedList<Integer> out;
    private static int[] weights = {1, 2, 4, 8, 16, 32, 64, 128};

    public static void main(String[] args) {

        input();

        initialization();

        while ( !findAllPossibleWeights()){}

        out();
    }

    public static void initialization(){

        in  = new LinkedList<>();
        out = new LinkedList<>();

        in.add(0);

        iteration = 1;
    }

    public static Boolean findAllPossibleWeights(){

        for(Integer i: in){

            for(int j=0; j<weights.length; j++){

                sum   = i + weights[j];
                delta = i - weights[j];

                if( isAnswerFound(n))
                    return true;

                if(isInRange(sum))
                    out.add( sum);

                if(isInRange(delta))
                    out.add( delta);
            }
        }

        in = out;
        out = new LinkedList<>();

        iteration++;

        return false;
    }

    public static Boolean isInRange(int x){
        return x >= 40 && x <= 130;
    }

    public static Boolean isAnswerFound(int n){
        return sum==n || delta==n;
    }

    public static void out(){

        PrintWriter printWriter = new PrintWriter( System.out);
        printWriter.println(iteration);
        printWriter.flush();
    }

    public static void input(){

        Scanner scanner = new Scanner( System.in);

        n = scanner.nextInt();
    }
}
