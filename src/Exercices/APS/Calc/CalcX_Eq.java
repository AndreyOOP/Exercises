package Exercices.APS.Calc;

import java.util.LinkedList;
import java.util.Scanner;

public class CalcX_Eq {

    static int N, O, M, W;
    static int[] n, o;

    static int[] min = new int[1000];
    static int[] buttons;
    static LinkedList<Integer> q = new LinkedList<>();

    public static void main(String[] args) {

        getInput();

        buttons = precalcButtons(); //preCalculate Buttons, add them to init min array

        //first queue
        for(int i=0; i<buttons.length; i++){
            min[buttons[i]] = getSize(i);
            q.add(buttons[i]);
        }


        while (q.size()>0) {

            q = generateNext(q);
        }
    }

    static LinkedList<Integer> generateNext(LinkedList<Integer> q){

        int next;
        LinkedList<Integer> nq = new LinkedList<>();

        for(Integer i: q){

            for(int j=0; j<buttons.length; j++){

                for(int k=0; k<O; k++){

                    if(o[k]==1){

                        next = i + buttons[j];
                        checkAndAdd(nq, next, j, i);
                    }

                    if(o[k]==2){

                        next = i - buttons[j];
                        checkAndAdd(nq, next, j, i);
                    }

                    if(o[k]==3){

                        next = i * buttons[j];
                        checkAndAdd(nq, next, j, i);
                    }

                    if(o[k]==4 && buttons[j] != 0){

                        next = i / buttons[j];
                        checkAndAdd(nq, next, j, i);
                    }
                }
            }
        }

        return nq;
    }

    static void checkAndAdd(LinkedList<Integer> nq, int next, int j, int i){

        if(next < 0 || next > 999) return;

        if(min[next] == 0 || min[next] > min[i] + 1 + getSize(j)){
            min[next] = min[i] + 1 + getSize(j);
            nq.add(next);
        }
    }

    static int getSize(int s){

        if(s >= N + N*N) return 3;
        if(s >= N) return 2;
        return 1;
    }

    static int[] precalcButtons(){

        int sz = 0;
        int[] b = new int[N + N*N + N*N*N];

        for(int k=0; k<N; k++){
            b[sz++] = n[k];
        }

        for(int j=0; j<N; j++){

            for(int k=0; k<N; k++){
                b[sz++] = n[j]*10 + n[k];
            }
        }

        for(int i=0; i<N; i++){

            for(int j=0; j<N; j++){

                for(int k=0; k<N; k++){
                    b[sz++] = n[i]*100 + n[j]*10 + n[k];
                }
            }
        }

        return b;
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //figures
        O = sc.nextInt(); //operations
        M = sc.nextInt(); //qty of button press

        n = new int[N]; //figures
        for(int i=0; i<N; i++)
            n[i] = sc.nextInt();

        o = new int[O]; //operations
        for(int i=0; i<O; i++)
            o[i] = sc.nextInt();

        W = sc.nextInt(); //required figure
    }
}
