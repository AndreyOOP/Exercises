package Exercices.ItermidTest1.Generator;

import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    private static PrintWriter printWriter = new PrintWriter(System.out);
    private static Scanner     scanner     = new Scanner( System.in);

    public static void main(String[] args) {

        String in = scanner.nextLine();

        int oneCounter  = 0;
        int zeroCounter = 0;

        for(int i=0; i<in.length(); i++){

            if(in.charAt(i) == '0'){
                zeroCounter++;
                oneCounter = 0;
            }

            if( check(zeroCounter))
                return;


            if(in.charAt(i) == '1'){
                oneCounter++;
                zeroCounter = 0;
            }

            if( check(oneCounter))
                return;
        }

        printResult("OK");
    }

    private static Boolean check(int ch){

        if(ch>6){
            printResult("FAIL");
            return true;
        }

        return false;
    }

    private static void printResult(String message){

        printWriter.print( message);
        printWriter.flush();
    }

}
