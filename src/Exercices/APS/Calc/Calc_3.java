package Exercices.APS.Calc;

import java.util.Scanner;

public class Calc_3 {

    static int N, O, M, W;
    static int[] n, o;

    static int[] min; //qty of minimum button press to get required figure

    static POV[] curr;
    static int nextSize, currSize;
    static int bP;

    public static void main(String[] args) {

        getInput();

        curr = new POV[1]; curr[0] = POV.newVal(0);
        min = new int[1000]; nextSize = 1;

        for(bP = 1; bP<=M+1; bP++){

            currSize = nextSize;
            curr = getNext(curr, bP);
        }
    }

    static POV[] getNext(POV[] curr, int buttonPress){

        POV pov;

        //POV[] nextPOV = new POV[curr.length*(O+1) + curr.length*N]; //todo ?
        POV[] nextPOV = new POV[32000];
        nextSize = 0;

        for(int i=0; i<currSize; i++){

            pov = curr[i];

            executeButtons(nextPOV, pov);

            executeOperations(nextPOV, pov);

            executeEquals(nextPOV, pov);
        }

        return nextPOV;
    }

    static void executeEquals(POV[] nextPOV, POV pov){

        if(pov.type == Type.VAL_STATE){
            checkAddNext(nextPOV, POV.newVal(pov));
        }
    }

    static void executeOperations(POV[] nextPOV, POV pov){

        for(int i=0; i<O; i++){

            switch (pov.type){

                case VAL:
                    checkAddNext(nextPOV, POV.newValOper(pov.valu, o[i]));
                    break;

                case VAL_STATE:
                    checkAddNext(nextPOV, POV.newValStateOp(pov, o[i]));
            }
        }
    }

    static void executeButtons(POV[] nextPOV, POV pov){

        for(int i=0; i<N; i++){

            switch (pov.type){

                case VAL:
                    checkAddNext(nextPOV, POV.newVal(pov.valu*10 + n[i]));
                    break;

                case VAL_OPER:
                    checkAddNext(nextPOV, POV.newValStateB(pov, n[i]));
                    break;

                case VAL_STATE:
                    checkAddNext(nextPOV, POV.newValStateB(pov, pov.valu*10 + n[i]));
            }
        }
    }

    static void checkAddNext(POV[] nextPOV, POV pov){

        switch (pov.type){

            case VAL:
                if(pov.valu>0 && pov.valu<1000 && min[pov.valu] == 0){
                    nextPOV[nextSize++] = pov;
                    min[pov.valu] = bP;
                }
                break;

            case VAL_OPER:
                if(pov.valu>0 && pov.valu<1000){
                    nextPOV[nextSize++] = pov;}
                break;

            case VAL_STATE:
                if(pov.valu>0 && pov.valu<1000){ //execute operation & store with + 1

                    POV pov2 = POV.newVal(pov);

                    if(pov2.valu>0 && pov2.valu<1000 && min[pov2.valu] == 0){
                     //   nextPOV[nextSize++] = pov;
                        min[pov2.valu] = bP+1;
                    }
                }
        }
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

        public static POV newVal(int v){
            return new POV(Type.VAL, 0, 0, v);
        }
        public static POV newVal(POV pov){

            if(pov.oper == 1) return POV.newVal(pov.prev+pov.valu);
            if(pov.oper == 2) return POV.newVal(pov.prev-pov.valu);
            if(pov.oper == 3) return POV.newVal(pov.prev*pov.valu);

            if(pov.valu != 0)
                if(pov.oper == 3) return POV.newVal( pov.prev/pov.valu);

            return POV.newVal(0);
        }

        public static POV newValOper(int v, int op){
            return new POV(Type.VAL_OPER, 0, op, v);
        }

        public static POV newValStateB(POV pov, int v){ //button
            return new POV(Type.VAL_STATE, pov.valu, pov.oper, v);
        }

        public static POV newValStateOp(POV pov, int op){ //operation

            if(pov.oper == 1) return POV.newValOper(pov.prev+pov.valu, op);
            if(pov.oper == 2) return POV.newValOper(pov.prev-pov.valu, op);
            if(pov.oper == 3) return POV.newValOper(pov.prev*pov.valu, op);

            if(pov.valu != 0)
                if(pov.oper == 3) return POV.newValOper(pov.prev/pov.valu, op);

            return POV.newVal(0);
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