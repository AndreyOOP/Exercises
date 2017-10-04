package Exercices.APS.Pizza;

import java.util.Scanner;

public class P2 {

    static int N, M;
    static int[] m;

    public static void main(String[] args) {

        getInput();

        //get best distribution
    }

//    static int[] getBestDistribution(int[] in, int qty){
//
//        int[] out = new int[qty];
//        int j;
//
//        //transform array to increasing sequence
//        int prev = 0;
//
//        for(int i=0; i<in.length; i++){
//            in[i] += prev;
//            prev = in[i];
//        }
//
//        //calculate step
//        double step = in[in.length-1]/qty;
//
//        for(int i=0; i<in.length; i++){
//
//            if(in[i] > step);
//        }
//
//    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        m = new int[M];

        for(int i=0; i<M; i++)
            m[i] = scanner.nextInt();
    }
}
