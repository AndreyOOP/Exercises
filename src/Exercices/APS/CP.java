package Exercices.APS;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CP {

    static Scanner scanner;
    static PrintWriter pw;
    static int N, M, T;
    static int[] x;

    static Queue<int[]> variants;

    public static void main(String[] args) {

        initialize();

        for(int t=0; t<T; t++){

            getInput();

            int[] v = new int[N];

            for(int i=0; i<N; i++) //add first version to queue
                v[i] = x[i];

            variants.add(v);

            for(int i=N; i<M; i++){ //do M-N times

                int sz = variants.size();

                for(int j=0; j<sz; j++) {

                    v = variants.remove();

                    if(i != M-1)
                        variants.addAll( addOnePiece(v, x[i], false));
                    else
                        variants.addAll( addOnePiece(v, x[i], true));
                }
            }

            int min = findMinDiscrimination(variants.remove());

            while (variants.size() > 0){

                int tempp = findMinDiscrimination(variants.remove());

                if(tempp<min) min = tempp;
            }

            print(pw, min);
        }
    }

    static void print(PrintWriter pw, int val){

        pw.println(val);
        pw.flush();
    }

    static int findMinDiscrimination(int[] base){

        int min, max;

        min = base[0]; max = base[0];

        for(int i=1; i<base.length; i++){
            if(base[i] < min) min = base[i];
            if(base[i] > max) max = base[i];
        }

        return max - min;
    }

    static LinkedList<int[]> addOnePiece(int[] base, int xi, boolean circle){

        int[] temp;
        LinkedList<int[]> res = new LinkedList<>();
        int[] arr = new int[N+1];

        arr[N] = xi;

        for(int i=0; i<N; i++)
            arr[i] = base[i];

        for(int i=0; i<N; i++){

            temp = new int[N];
            for(int j=0; j<N; j++)
                temp[j] = base[j]; //array copy

            temp[N-1] = xi;
            temp[i] = arr[i] + arr[i+1];

            res.add(temp);
        }

        if(circle){

            temp = new int[N];
            for(int j=0; j<N; j++)
                temp[j] = base[j]; //array copy

            temp[0] = arr[0] + arr[N];

            res.add(temp);
        }

        return res;
    }

    static void initialize(){

        scanner = new Scanner(System.in);

        T = scanner.nextInt();

        variants = new LinkedList<>();
        pw = new PrintWriter(System.out);
    }

    static void getInput(){

        N = scanner.nextInt();
        M = scanner.nextInt();

        x = new int[M];

        for(int i=0; i<M; i++)
            x[i] = scanner.nextInt();
    }
}
