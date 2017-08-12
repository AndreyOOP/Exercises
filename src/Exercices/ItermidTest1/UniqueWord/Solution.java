package Exercices.ItermidTest1.UniqueWord;

import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    static String inStr  = new String();
    static String outStr = new String();

    public static void main(String[] args) {

        getInput();

        solutionFaster();

        setOutput();
    }

    private static void solutionFaster(){

        StringBuilder answ = new StringBuilder( inStr.length());

        char next;
        int  lastInd;

        for(int i=0; i<inStr.length(); i++){

            next = inStr.charAt(i);

            lastInd = answ.length() - 1;

            if(lastInd > -1){

                if(next == answ.charAt( lastInd)){
                    answ.deleteCharAt(lastInd);
                }else
                    answ.append(next);
            }else {
                answ.append(next);
            }
        }

        outStr = answ.toString();
    }

    private static void getInput(){

        Scanner scanner = new Scanner( System.in);

        inStr = scanner.nextLine();
    }

    private static void setOutput(){

        PrintWriter printWriter = new PrintWriter(System.out);

        printWriter.print(outStr);
        printWriter.flush();
    }
}
