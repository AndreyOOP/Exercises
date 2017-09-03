package Exercices.APS.B;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class B_1 {

    static int N, K;
    static char[] work;
    static LinkedList<String> sw;

    public static void main(String[] args) {

        getInput();

        work = String.valueOf(N).toCharArray();

        sw = new LinkedList<>();
        //find all possible swaps

        for(int k=0; k<K; k++){

            for(int i=0; i<work.length; i++){

                for(int j=i+1; j<work.length; j++){

//                    swap(work, i, j);
                    sw.add( swap(work, i, j));
                }
            }
        }

        for(String s: sw){
            System.out.println(s);
        }
        test();
    }

    static void test(){

        int n = 1234;
        char[] ch = String.valueOf(n).toCharArray();

        swap(ch, 0, 3);
        System.out.println( new String(ch));

        swap(ch, 2, 1);
        System.out.println( new String(ch));
    }

    static String swap(char[] str, int i, int j){

        char[] x = Arrays.copyOf(str, str.length);

        x[i] = str[j];
        x[j] = str[i];

        return new String(x);
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
    }
}
