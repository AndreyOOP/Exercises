package Exercices.ItermidTest1.Virus;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/** 2/10 test cases passes, 2 wrong answer, other time limit*/
public class T {

    static String D;
    static boolean[][] m;
    static int maxD = -1;
    static HashSet<String> answers = new HashSet<>();
    static String[] virusDNK;

    public static void main(String[] args) {

        getInput();

        populateMatrix();

        for(int d=1; d<m.length; d++)
            checkDiagonal(d);

        virusDNK = new String[answers.size()];
        answers.toArray(virusDNK);

        Arrays.sort(virusDNK);

        for(String s: virusDNK)
            print(s);
    }

    static void checkDiagonal(int d){

        int j = 0;
        int tempMax = 0;
        String tempStr = "";

        for(int i=d; i<m.length; i++){

            if(m[j++][i]){

                tempMax++;
                tempStr += D.charAt(i);

                if(tempMax > maxD){
                    maxD = tempMax;
                    answers.clear();
                    answers.add(tempStr);

                } else if(tempMax == maxD){
                    answers.add(tempStr);
                }

            } else {
                tempMax = 0;
                tempStr = "";
            }
        }
    }

    static void populateMatrix(){

        int size = D.length();

        m = new boolean[size][size];

        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                if(D.charAt(i) == D.charAt(j)) m[i][j] = true;
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);
        D = sc.nextLine();
    }

    static void print(String val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(val);
        pw.flush();
    }

}
