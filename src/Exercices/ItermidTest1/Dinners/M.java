package Exercices.ItermidTest1.Dinners;

import java.io.PrintWriter;
import java.util.*;

/**70%, 3 time limit*/
public class M {

    static int F, S, B, K;
    static int[] f, s, b;

    public static void main(String[] args) {

        getInput();

        PriorityQueue<Integer> pq = new PriorityQueue(K, Collections.reverseOrder());

        for(int i=0; i<F; i++){

            for(int j=0; j<S; j++){

                if(pq.size() < K)
                    pq.add(f[i] + s[j]);
                else{
                    pq.add(f[i] + s[j]);
                    pq.remove();
                }
            }
        }

        for(int i=0; i<B; i++){

            if(pq.size() < K)
                pq.add(b[i]);
            else{
                pq.add(b[i]);
                pq.remove();
            }
        }

        PrintWriter pw = new PrintWriter(System.out);

        Stack<Integer> st = new Stack<>();

        while (!pq.isEmpty())
            st.push(pq.remove());

        while (!st.isEmpty())
            pw.print(st.pop() + " ");

        pw.flush();
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        B = sc.nextInt();

        f = new int[F];
        s = new int[S];
        b = new int[B];

        for(int i=0; i<F; i++)
            f[i] = sc.nextInt();

        for(int i=0; i<S; i++)
            s[i] = sc.nextInt();

        for(int i=0; i<B; i++)
            b[i] = sc.nextInt();

        K = sc.nextInt();
    }
}
