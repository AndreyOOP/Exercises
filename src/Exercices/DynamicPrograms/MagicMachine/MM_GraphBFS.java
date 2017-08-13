package Exercices.DynamicPrograms.MagicMachine;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**https://www.e-olymp.com/ru/problems/4850
 * */
public class MM_GraphBFS {

    static int a, b;

    public static void main(String[] args) {

        getInput();

        MM_GraphBFS machine = new MM_GraphBFS();

        print( machine.graphSol2());
    }

    int graphSol2(){

        /**Graph population*/
        LinkedList<Integer>[] G = new LinkedList[10000];

        for(int i=0; i<=9999; i++)
            G[i] = new LinkedList<>();

        for(int i=2; i<=9999; i++)
            G[i].add(i-2);

        for(int i=0; i<=9967; i++)
            G[i].add(i + figuresSum(i));

        for(int i=0; i<=3333; i++)
            G[i].add(3*i);
        /******************/


        /**BSF & find shortest path to any figure or till b*/
        int t = -1;
        int[]          edgeTo = new int[10000];
        boolean[]      marked = new boolean[10000];
        Queue<Integer> queue  = new LinkedList<>();

        queue.add(a);
        marked[a] = true;

        while ( !queue.isEmpty() && t != b){

            t = queue.remove();

            for(int i : G[t]){

                if(!marked[i]){

                    marked[i] = true;
                    edgeTo[i] = t;
                    queue.add(i);
                }
            }
        }
        /******************/


        /**Count steps needed for transformation one figure to another*/
        int steps = 0;

        for(int i=b; i != a; i = edgeTo[i])
            steps++;
        /******************/

        return steps;
    }

    static int figuresSum(int n){

        int s = 0;

        while (n > 0){
            s += n % 10;
            n = n / 10;
        }

        return s;
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();
    }

    static void print(int i){

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(i);
        printWriter.flush();
    }
}
