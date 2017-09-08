package Exercices.ItermidTest1.SavikShuster;

import java.io.PrintWriter;
import java.util.Scanner;

/**Should be used tree-union, if tree it is possible to get - log(n) & union - log(n)
 *  wiki - СНМ (реализация с помощью леса корневых деревьев)*/
public class N_3 {

    static Scanner sc;
    static PrintWriter pw;
    static int[] p, r;
    static int N, Q, a, b;
    static String line, type;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        N = sc.nextInt();
        Q = sc.nextInt();
        line = sc.nextLine();

        p = new int[N+1];
        r = new int[N+1];

        for(int i=0; i<N+1; i++)
            p[i] = i;

        for(int i=0; i<Q; i++){

            parseNextLine();

            if(type.contentEquals("U")){

                printMessage(get(a) == get(b),"BORE", "NEWS!");

                union(a, b);

            }else
                printMessage(get(a) == get(b), "MUSIC", "SHOW!");
        }
    }

    static int get(int v){ //it requires addition memory...

        return p[v] != v ? get(p[v]) : v;
    }

    static void union(int x, int y){

        a = get(x); b = get(y);

        if(a == b) return;

        if(r[a] == r[b])
            r[a]++;

        if(r[a] < r[b])
            p[a] = b;
        else
            p[b] = a;
    }

    static void printMessage(boolean isTheSame, String same, String notSame){

        if(isTheSame)
            pw.println(same);
        else
            pw.println(notSame);

        pw.flush();
    }

    static void parseNextLine(){

        String[] temp = sc.nextLine().split(" ");

        type = temp[0];
        a    = Integer.valueOf(temp[1]);
        b    = Integer.valueOf(temp[2]);
    }

}
