//package ItermidTest1.UniqueWord;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static String inStr  = new String();
    static String outStr = new String();

    public static void main(String[] args) {

        getInput();

        solution();

        setOutput();
    }

    private static void solution(){

        LinkedList<Character> answ = new LinkedList<>();

        char next;

        for(int i=0; i<inStr.length(); i++){

            next = inStr.charAt(i);

            if ( !answ.isEmpty()) {

                if( next == answ.peek()){
                    answ.pop();
                }else
                    answ.push(next);

            }else {
                answ.push(next);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=answ.size()-1; i>=0; i--){
            sb.append( answ.get(i));
        }

        outStr = sb.toString();
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
