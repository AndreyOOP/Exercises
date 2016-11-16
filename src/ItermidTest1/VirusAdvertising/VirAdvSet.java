package ItermidTest1.VirusAdvertising;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class VirAdvSet {

    static int n;
    static int[][] matrix;

    static HashSet<Integer> set = new HashSet<>();

    static LinkedList<Integer> people = new LinkedList<>();

    static int sz   = 0;
    static int answ = 0;

    public static void main(String[] args) {

        matrix = getInput();

        for(int i=n-1; i>=0; i--)
            people.push(i);

        while (!people.isEmpty()){

            set.add( people.pop());

            while (sz != set.size()){

                sz = set.size();

                set = addFriendsToSet(set); /**Find all friends of input set friends*/
            }

            for(Integer i: set)  /**remove sub list of people which knows each other*/
                people.remove(i);

            answ++;

            set.clear(); sz = 0;
        }

        printAnswer(answ);
    }

    public static HashSet<Integer> addFriendsToSet(HashSet<Integer> inSet){

        HashSet<Integer> outSet = new HashSet<>();

        outSet.addAll(inSet);

        for(Integer s: inSet){

            for(int i=0; i<n; i++)
                if(matrix[s][i] == 1)
                    outSet.add(i);
        }

        return outSet;
    }

    public static void printAnswer(int answer){

        PrintWriter printWriter = new PrintWriter( System.out);
        printWriter.print(answer);
        printWriter.flush();
    }

    static int[][] getInput(){

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        int[][] temp = new int[n][n];

        for(int i=0; i<n; i++){

            for(int j=0; j<n; j++){

                temp[i][j] = scanner.nextInt();
            }
        }

        return temp;
    }
}
