package Exercices.ItermidTest1.SimpleFigure;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**One of the probplems has been related to Print writer - it has been recreated for each output... it greately slow down the program
 * As well Arrays binarySearch looks like work faster than Collections binary search - for Collections time limit exeeded?
 * */
public class SimpleNew {

    static LinkedList<Pair>    inputPairs    = new LinkedList<>();
    static LinkedList<Integer> simpleFigures = new LinkedList<>();
    static PrintWriter         printWriter   = new PrintWriter( System.out);

    static int[] a;
    static int[] simpleFiguresArray;

    static int   lastSimple;
    static int   j = 0;
    static int   index_a;
    static int   index_b;

    public static void main(String[] args) {

        inputPairs = getInput();

        a = populateArray();


        //region Find all simple figures into a maximum range
        lastSimple = 2;
        simpleFigures.add( lastSimple);

        while (lastSimple <= (int)Math.sqrt(Pair.max)) {

            for(int i=lastSimple; i<a.length; i += lastSimple)
                a[i] = 0;

            while ( a[lastSimple] == 0)
                lastSimple++;

            simpleFigures.add(lastSimple);
        }

        for(int i=lastSimple+1; i<=Pair.max; i++)
            if(a[i] != 0)
                simpleFigures.add(a[i]);

        //endregion


        //region Find all simple figures in a range (binary search)
        simpleFiguresArray = new int[simpleFigures.size()];

        for(Integer i: simpleFigures)
            simpleFiguresArray[j++] = i;

        for(Pair p: inputPairs){

            index_a = Arrays.binarySearch(simpleFiguresArray, p.a);
            index_b = Arrays.binarySearch(simpleFiguresArray, p.b);

            if(index_a<0)
                index_a = (-index_a) - 1;

            if(index_b<0)
                index_b = (-index_b) - 2;

            printWriter.println(index_b - index_a + 1);
        }
        //endregion

        printWriter.flush();
    }

    public static int[] populateArray(){

        int[] a = new int[Pair.max+1];

        for(int i=0; i<a.length; i++)  //todo arrays are 0 by default, so it possible to populate only each second one
            a[i] = i;

        return a;
    }

    public static LinkedList<Pair> getInput(){

        Scanner scanner = new Scanner( System.in);

        int n = scanner.nextInt();

        int a, b;

        LinkedList<Pair> pairs = new LinkedList<>();

        for(int i=0; i<n; i++){

            a = scanner.nextInt();
            b = scanner.nextInt();

            pairs.add( new Pair(a, b));
        }

        return pairs;
    }

    static class Pair{

        public static int max = -1;

        public int a;
        public int b;

        public Pair(int a, int b) {

            this.a = a;
            this.b = b;

            if(b > max)
                max = b;
        }
    }
}
