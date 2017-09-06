package Exercices.ItermidTest1.SavikShuster;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class N {

    static PrintWriter pw;
    static int Q, N, a, b, conA, conB;
    static int[] connect;
    static LinkedList<Integer>[] C;
    static String line, type;
    static String[] temp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        N = sc.nextInt();
        Q = sc.nextInt();
        line = sc.nextLine();

        connect = new int[N+1];
        C = new LinkedList[N+1];
        for(int i=0; i<=N; i++)
            C[i] = new LinkedList<>();

        for(int i=1; i<=N; i++)
            connect[i] = i;


        for(int i=0; i<Q; i++){

            temp = sc.nextLine().split(" ");

            type = temp[0];
            a    = Integer.valueOf(temp[1]);
            b    = Integer.valueOf(temp[2]);

            conA = connect[a]; conB = connect[b];

            if(type.contentEquals("U")){

//                printMessage(conA == conB, "BORE", "NEWS!");
                printMessage( isTheSame(conA, conB), "BORE", "NEWS!");


                LinkedList<Integer> temp = C[a];
                C[a].addAll(C[b]);
                C[b].addAll(temp);

                for(int j: C[b])
                    connect[j] = conA;
//                for(int j=0; j<=N; j++)
//                    if(connect[j] == conB) connect[j] = conA;

            } else {

                printMessage( isTheSame(conA, conB), "MUSIC", "SHOW!");
            }
        }
    }

    static boolean isTheSame(int a, int b){

        for(int i: C[a])
            if(i == b) return true;

        return false;
    }

    static void printMessage(boolean isTheSame, String same, String notSame){

        if(isTheSame)
            print(same);
        else
            print(notSame);
    }

    static void print(String message){

        pw.println(message);
        pw.flush();
    }
}