package Exercices.APS.Calc;

import java.util.Scanner;

public class Calculator_2 {

    static int N, O, M, W;
    static int[] n, o;

    static int[] min; //qty of minimum button press to get required figure
    static POV[] curr, nextPOV;
    static int currSize, nextSize;

    public static void main(String[] args) {

        getInput();

        curr = new POV[1000];
        nextPOV = new POV[1000];
        min = new int[1000];
        curr[0] = new POV(-1, -1, 0); currSize = 1;

        for(int buttonPress = 1; buttonPress<=M; buttonPress++)
            curr = getNext(buttonPress);
    }

    static POV[] getNext(int buttonPress){

        POV[] nextP = new POV[10000];
        POV pov, next;
        nextSize = 0;

        for(int i=0; i<currSize; i++){

            pov = curr[i];

            // pov & = -> / / p+v
            if(pov.prev!=-1 && pov.oper!=-1){
                next = new POV(-1, -1, pov.prev + pov.valu);
                addToNext(next, nextP);
                addToMin(next, buttonPress);
            }

            //operation ; //v
            for(int j=0; j<O; j++){

                if(pov.prev==-1 && pov.oper == -1 && pov.valu !=-1){ // //v -> /ov

                    next = new POV(-1, o[j], pov.valu);
                    addToNext(next, nextP);
                    continue;
                }

                if(pov.prev!=-1 && pov.oper != -1 && pov.valu !=-1){ //pov + o -> /o(p+v)

                    next = null;

                    if(o[j] == 1) next = new POV(-1, o[j], pov.prev+pov.valu);
                    if(o[j] == 2) next = new POV(-1, o[j], pov.prev-pov.valu);
                    if(o[j] == 3) next = new POV(-1, o[j], pov.prev*pov.valu);
                    if(o[j] == 4) next = new POV(-1, o[j], pov.valu==0 ? 0 : pov.prev/pov.valu);

                    addToNext(next, nextP);
                }
            }

            //button
            for(int j=0; j<N; j++){ //for each button

                if(pov.oper == -1 && pov.valu != -1){ //just value

                    next = new POV(-1, -1, pov.valu*10 + n[j]);
                    addToNext(next, nextP);
                    addToMin(next, buttonPress);
                    continue;
                }

                if(pov.prev!=-1 && pov.oper != -1 && pov.valu!=-1){ //operation with value with previous
                    next = new POV(pov.prev, pov.oper, 10*pov.valu + n[j]);
                    addToNext(next, nextP);
                    continue;
                }

                if(pov.prev == -1 && pov.oper!=-1 && pov.valu != -1){
                    next = new POV(pov.valu, pov.oper, n[j]);
                    addToNext(next, nextP);
                    continue;
                }
            }
        }

        currSize = nextSize;

        return nextP;
    }

    static void addToNext(POV pov, POV[] p){ //check if possible

        if(pov.oper!=-1 && pov.valu>0 && pov.valu<1000)
            p[nextSize++] = pov;
        else if(pov.valu>0 && pov.valu<1000 && min[pov.valu] == 0){
            p[nextSize++] = pov;
        }
    }

    static void addToMin(POV pov, int buttonPress){ //check if possible

        if(pov.valu>0 && pov.valu<1000){
            if(min[pov.valu] == 0) min[pov.valu] = buttonPress;
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

    public static class POV{

        public POV(int prev, int oper, int valu){
            this.prev = prev;
            this.oper = oper;
            this.valu = valu;
        }

        public int prev;
        public int oper;
        public int valu;

        @Override
        public String toString(){

            String s = "";

            if(oper == 1) s = "+";
            if(oper == 2) s = "-";
            if(oper == 3) s = "*";
            if(oper == 4) s = "/";

            return prev + ":" + s + ":" + valu;
        }
    }
}