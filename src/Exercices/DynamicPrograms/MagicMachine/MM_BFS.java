package Exercices.DynamicPrograms.MagicMachine;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** https://www.e-olymp.com/ru/problems/4850 */
public class MM_BFS {

    static int a, b;

    static Queue<Integer> queue = new LinkedList<>();
    static int[]          steps = new int[10000];       /**How many steps(+1) from a (steps[a]=1) to steps[i] should be done*/
    static int            t = -1;

    public static void main(String[] args) {

        getInput();

        print(checkSteps());
    }

    static int checkSteps(){

        steps[a] = 1;
        queue.add(a);

        while (!queue.isEmpty() && t != b){

            t = queue.remove();

            operation(queue, steps, t, t - 2);
            operation(queue, steps, t, t + figuresSum(t));
            operation(queue, steps, t, t * 3);
        }

        return steps[t]-1;
    }

    static void operation(Queue<Integer> queue, int[] steps, int t, int f){

        if(f < 0 || f > 9999 || steps[f] != 0) /**steps[f] != 0 - to avoid double calculations*/
            return;

        steps[f] = steps[t] + 1;
        queue.add(f);
    }

    static int figuresSum(int n){

        if(n < 10) return n;

        return figuresSum(n/10) + n%10;
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