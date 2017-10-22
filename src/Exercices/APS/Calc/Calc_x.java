package Exercices.APS.Calc;

import java.util.LinkedList;
import java.util.Scanner;

public class Calc_x {

    static int N, O, M, W;
    static int[] n, o;

    static int[] min = new int[1000];

    static LinkedList<POV> q = new LinkedList<>();

    public static void main(String[] args) {

        getInput();

        q = initialize();

        for(int m=2; m<M; m++){

            q = generateNext(q); //press one more button

            addToMin(q, m); //add to min array
        }

        printAnswer(W);
    }

    static LinkedList<POV> initialize(){

        LinkedList<POV> list = new LinkedList<>();

        for(int i=0; i<N; i++){
            list.add(new POV(Type.VAL, 0, 0, n[i]));
            min[n[i]] = 1;
        }

        return list;
    }

    static void printAnswer(int w){

        if(min[w] == 0)
            System.out.println(-1);
        else
            System.out.println(min[w]);
    }

    static void addToMin(LinkedList<POV> list, int m){

        for(POV pov: list)
            if(pov.type == Type.VAL && min[pov.valu] == 0)
                    min[pov.valu] = m;
    }

    static LinkedList<POV> generateNext(LinkedList<POV> list){ //input - all values after i button press, generate next & add unique values to out list

        POV next = null;
        LinkedList<POV> out = new LinkedList<>();

        for(POV pov: list){

            for(int i=0; i<N; i++){ //press all buttons

                if(pov.type == Type.VAL)       next = new POV(Type.VAL, 0, 0, pov.valu*10 + n[i]);                   //32 press 3 323
                if(pov.type == Type.VAL_OPER)  next = new POV(Type.VAL_STATE, pov.valu, pov.oper, n[i]);             //3- press 2 3-2
                if(pov.type == Type.VAL_STATE) next = new POV(Type.VAL_STATE, pov.prev, pov.oper, pov.valu*10+n[i]); //28-1 press 1 28-11

                if(isOK(next) && isUnique(out, next))
                    out.add(next);
            }

            for(int i=0; i<O; i++){

                if(pov.type == Type.VAL)       next = new POV(Type.VAL_OPER, 0, o[i], pov.valu); //32 press * 32*
                if(pov.type == Type.VAL_STATE) next = new POV(Type.VAL_OPER, 0, o[i], POV.getValue(pov)); //32-4 press * => 28*

                if(isOK(next) && isUnique(out, next))
                    out.add(next);
            }

            if(pov.type == Type.VAL_STATE){ //check equals - if pov state - converts to value

                next = new POV(Type.VAL, 0, 0, POV.getValue(pov));

                if(isOK(next) && isUnique(out, next))
                    out.add(next); //todo depend on = is end or possible to continue - add to min or add to out
            }
        }

        return out;
    }

    static boolean isUnique(LinkedList<POV> list, POV pov){

        for(POV p: list){

            if(p.prev == pov.prev && p.oper == pov.oper && p.valu == pov.valu)
                return false;
        }

        return true;
    }

    static boolean isOK(POV pov){

        if(pov.type == Type.VAL || pov.type == Type.VAL_OPER)
            if(pov.valu>0 && pov.valu<1000)
                return true;

        if(pov.type == Type.VAL_STATE)
            if(POV.getValue(pov)>0 && POV.getValue(pov)<1000)
                return true;

        return false;
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

    static class POV{

        public Type type;
        public int prev;
        public int oper;
        public int valu;

        public POV(Type type, int prev, int oper, int valu) {
            this.type = type;
            this.prev = prev;
            this.oper = oper;
            this.valu = valu;
        }

        public static int getValue(POV pov){

            if(pov.oper == 1) return pov.prev + pov.valu;
            if(pov.oper == 2) return pov.prev - pov.valu;
            if(pov.oper == 3) return pov.prev * pov.valu;
            if(pov.valu == 0) return 99999; //it will not pass check & will be excluded
            if(pov.oper == 4) return pov.prev / pov.valu;

            return -1;
        }

        @Override
        public String toString(){

            String op = "";

            if(oper==1) op = "+";
            if(oper==2) op = "-";
            if(oper==3) op = "*";
            if(oper==4) op = "/";

            return type.toString() +":" + prev + ":" + op + ":" + valu;
        }
    }

    enum Type{
        VAL, VAL_OPER, VAL_STATE;
    }
}