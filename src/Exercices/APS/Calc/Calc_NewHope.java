package Exercices.APS.Calc;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 1) Lets suppose that = is end of calculations, in other words during calculations use of few = is no allowed, like 1+2=1 -> 31
 * 2) For simplicity for first try lets use LinkedList*/
public class Calc_NewHope {

    static int N, O, M, W;
    static int[] n, o;

    static int[] min = new int[1000];

    static LinkedList<SV> q = new LinkedList<>();
    static SV[] buttons;

    public static void main(String[] args) {

        getInput();

        buttons = precalculation();

        //q.add(new SV(0, 0));

        for(int i=0; i<buttons.length; i++){

            q.add(buttons[i]);

            min[buttons[i].value] = buttons[i].step;
        }

        int step;
        //do operation + button -> move to equals & again
            //add to next iteration result of previoud
        while (true){ //todo

            q = getNext(q);

            updateMin(q);
        }

        //todo print answer
    }

    static void updateMin(LinkedList<SV> q){

        int currStep;

        for(SV sv : q){

            currStep = sv.step+1;

            if(min[sv.value] > currStep && currStep <= M)
                min[sv.value] = currStep;
        }
    }

    static LinkedList<SV> getNext(LinkedList<SV> q){

        SV next;
        LinkedList<SV> out = new LinkedList<>();

        for(SV sv : q){

            for(int i=0; i<buttons.length; i++){ //do all possible operations with all possble buttons

                //based on operation calculate next, check it
                //todo check next, add to check step < M, in range
                //e.g. +
                    out.add(new SV(buttons[i].step + 2 , sv.value+buttons[i].value));
                //e.g. -
                    out.add(new SV(buttons[i].step + 2 , sv.value-buttons[i].value));
            }
        }

        return out;
    }


    static SV[] precalculation(){

        int sz = 0;

        SV[] b = new SV[N + N*N + N*N*N];

        for(int i=0; i<N; i++){
            b[sz++] = new SV(1, n[i]);
        }

        for(int j=0; j<N; j++){
            for(int i=0; i<N; i++){
                b[sz++] = new SV(2, n[j]*10 + n[i]);
            }
        }

        for(int k=0; k<N; k++) {
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    b[sz++] = new SV(3, n[k]*100 + n[j]*10 + n[i]);
                }
            }
        }

        return b;
    }

    public static class SV{

        public int step;
        public int value;

        public SV(int step, int value) {
            this.step = step;
            this.value = value;
        }
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