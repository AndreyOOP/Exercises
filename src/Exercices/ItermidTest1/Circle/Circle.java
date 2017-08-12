package Exercices.ItermidTest1.Circle;

import java.io.PrintWriter;
import java.util.Scanner;

public class Circle {

    static int r;

    public static void main(String[] args) {

        r = readR();

        int sum = 0;

        for(int x=1; x<r; x++){
            sum += getHeight(x);
        }

        printResult( 4*sum);
    }

    public static int getHeight(int x){

        double h = Math.sqrt( r*r - x*x);

        int height = (int)h;

        return height;
    }

    public static int readR(){

        Scanner scanner = new Scanner( System.in);

        return scanner.nextInt();
    }

    public static void printResult(int result){

        PrintWriter printWriter = new PrintWriter( System.out);

        printWriter.print(result);
        printWriter.flush();
    }
}
