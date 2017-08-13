package Exercices.DynamicPrograms.MagicMachine;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**https://www.e-olymp.com/ru/problems/4850
 * */
public class MagicMachine {

    static int a, b;

    public static void main(String[] args) {

        getInput();

        MagicMachine machine = new MagicMachine();

        print( machine.solutTwo());
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

        //or
//        int k1, k2, k3;
//
//        for(int i=0; i<=9999; i++){
//
//            G[i] = new LinkedList<>();
//
//            k1 = i - 2;
//            k2 = i + figuresSum(i);
//            k3 = i * 3;
//
//            if(k1 >= 0)     G[i].add(k1);
//            if(k2 <= 9999)  G[i].add(k2);
//            if(k3 <= 9999)  G[i].add(k3);
//        }
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

    int graphSol(){

        //build graph
        LinkedList<Integer>[] G = new LinkedList[10000];
        int k1, k2, k3;

        for(int i=0; i<=9999; i++){

            k1 = i - 2;
            k2 = i + figuresSum(i);
            k3 = i * 3;

            G[i] = new LinkedList<>();

            if(k1 >= 0)     G[i].add(k1);
            if(k2 <= 9999)  G[i].add(k2);
            if(k3 <= 9999)  G[i].add(k3);
        }

        //bfs from a to b
        int t = -1, step = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[10000];
        int[] edgeTo = new int[10000];

        queue.add(a);
        marked[a] = true;

        if(a == b) return 0;

        while (!queue.isEmpty()){

            t = queue.remove();

            for(int i: G[t]){

                if(!marked[i]){

                    marked[i] = true;
                    edgeTo[i] = t;

                    if(i == b){
//                        showPath(edgeTo);
                        return pathLenght(edgeTo);
                    }
                    else
                        queue.add(i);
                }
            }
        }
        return -1;
    }

    int pathLenght(int[] edgeTo){

        int len = 0;

        for(int i=b; i!=a; i = edgeTo[i]){
            len++;
        }

        return len;
    }

    void showPath(int[] edgeTo){

        System.out.print(b + " <- ");
        for(int i=b; i!=a; i = edgeTo[i]){
            System.out.print(edgeTo[i] + " <- ");
        }
    }

    int f(int n, int s){ //not work...

        if(n==b) return s;

        int min = -1;

        if(n-2 >= 0)
            min = f(n-2, s+1);

        if(n + figuresSum(n) <= 9)
            min = Math.min(min, f(n + figuresSum(n), s+1));

        if(n*3 <= 9)
            min = Math.min(min, f(n*3, s+1));

        if(min == -1)
            return Integer.MAX_VALUE;
        else
            return min;
    }

    int solutTwo(){

        int b1, b2, b3, t;
        Queue<Integer> queue = new LinkedList<>();
        int[] length = new int[10000];

        length[a] = 1;
        queue.add(a);

        while (!queue.isEmpty()){

            t = queue.remove();

            b1 = t - 2;
            b2 = t + figuresSum(t);
            b3 = t * 3;

            if(b1 >= 0){
                length[b1] = length[t] + 1;
                queue.add(b1);
                if(b1 == b) return length[b1]-1;
            }

            if(b2 <= 9999){
                length[b2] = length[t] + 1;
                queue.add(b2);
                if(b2 == b) return length[b2]-1;
            }

            if(b3 <= 9999){
                length[b3] = length[t] + 1;
                queue.add(b1);
                if(b3 == b) return length[b3]-1;
            }
        }

        return -1;
    }

    /**65% of answers, not correct because of time limit*/
    int bruteForceSolution(){

        int b1, b2, b3, st;
        Queue<X> queue = new LinkedList<>();

        X t = new X(a, 0);
        queue.add(t);

        while ( !queue.isEmpty() && t.t != b){

            t = queue.remove();

            b1 = 3*t.t;
            b2 = t.t + figuresSum(t.t);
            b3 = t.t - 2;
            st = t.step + 1;

            if(b1 <= 9999) queue.add(new X(b1, st));
            if(b2 <= 9999) queue.add(new X(b2, st));
            if(b3 >= 0)    queue.add(new X(b3, st));
        }

        return t.step;
    }

    static int figuresSum(int n){

        int s = 0;

        while (n > 0){
            s += n % 10;
            n = n / 10;
        }

        return s;
    }

    class X{

        int t;
        int step;

        X(int t, int step){
            this.t = t;
            this.step = step;
        }
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
