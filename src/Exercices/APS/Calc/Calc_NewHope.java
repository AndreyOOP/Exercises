package Exercices.APS.Calc;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 1) Lets suppose that = is end of calculations, in other words during calculations use of few = is no allowed, like 1+2=1 -> 31
 * 2) For simplicity for first try lets use LinkedList*/
//todo check 0 intput case, incorrect clculations...
    //todo try same solution for another behaviour of = button; use reqursion
    //todo try to avoid Linked List
public class Calc_NewHope {

    static int N, O, M, W;
    static int[] n, o;

    static int[] min = new int[1000];

    static LinkedList<SV> q = new LinkedList<>();
    static SV[] buttons;

    public static void main(String[] args) {

        getInput();

        buttons = precalculation();

        initialize();

        while (q.size() > 0){

            q = getNext(q);
        }

        answer(W);
    }

    static void initialize(){

        for(int i=0; i<1000; i++)
            min[i] = Integer.MAX_VALUE;

        for(int i=0; i<buttons.length; i++){ //update min

            q.add(buttons[i]);

            if(min[buttons[i].value] > buttons[i].step)
                min[buttons[i].value] = buttons[i].step;
        }
    }

    static LinkedList<SV> getNext(LinkedList<SV> q){

        SV next;
        LinkedList<SV> out = new LinkedList<>();

        for(SV sv : q){

            for(int i=0; i<buttons.length; i++){ //do all possible operations with all possble buttons

                for(int j=0; j<O; j++){

                    if(o[j] == 1){
                        next = new SV(sv.step + 1 + buttons[i].step, sv.value+buttons[i].value);
                        if( isOK(next) && isUnique(next)) out.add(next);
                    }

                    if(o[j] == 2){
                        next = new SV(sv.step + 1 + buttons[i].step, sv.value-buttons[i].value);
                        if( isOK(next) && isUnique(next)) out.add(next);
                    }

                    if(o[j] == 3){
                        next = new SV(sv.step + 1 + buttons[i].step, sv.value*buttons[i].value);
                        if( isOK(next) && isUnique(next)) out.add(next);
                    }

                    if(o[j] == 4 && buttons[i].value != 0){
                        next = new SV(sv.step + 1 + buttons[i].step, sv.value/buttons[i].value);
                        if( isOK(next) && isUnique(next)) out.add(next);
                    }
                }
            }
        }

        return out;
    }

    static boolean isUnique(SV sv){ //todo add to next ?? should be added to next queue

        if(min[sv.value] > sv.step+1){
            min[sv.value] = sv.step+1;
            return true;
        }
        return false;
    }

    static boolean isOK(SV sv){

        if(sv.step > M) return false;

        return sv.value > 0 && sv.value<1000;
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

        @Override
        public String toString(){
            return step + ":" + value;
        }
    }

    static void answer(int w){

        if(min[w] <= W)
            System.out.println(min[w]);
        else
            System.out.println(-1);
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