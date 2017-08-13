package Exercices.APS;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class G {

    static LinkedList<Integer>[] G;
    static int[] sizes;
    static int N;

    public static void main(String[] args) {

        getInput();

        sizes = new int[N+1];

        for(int i=1; i<=N; i++)
            sizes[i] = f(i);

        print();
    }

    static int f(int n){

        if(sizes[n] != 0)  /**Check if values has been calculated already*/
            return sizes[n];

        if(G[n].isEmpty()) { /**if n has no childs -> finish return 1*/
            sizes[n] = 1;
            return 1;
        }

        int sum = 0;

        for(int i: G[n]) /**otherwie retun sum of f(ch) of all childs*/
            sum += f(i);

        sizes[n] = sum + 1;
        return sum + 1;
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        G = new LinkedList[N+1];

        for(int i=0; i<=N; i++)
            G[i] = new LinkedList<>();

        for(int i=0; i<N-1; i++){
            G[sc.nextInt()].add(sc.nextInt());
        }
    }

    static void print(){

        PrintWriter writer = new PrintWriter(System.out);

        for(int i=1; i<=N; i++)
            writer.print(sizes[i] + " ");

        writer.flush();
    }
}
