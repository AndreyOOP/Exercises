package Exercices.APS.Calc;

import java.util.Scanner;

public class Calculator_1 {

    static int N, O, M, W;
    static int[] n, o;

    static int[] min; //qty of minimum button press to get required figure
    static int pressCount;
    static boolean[] curr, next; //current array with figures for check, next array with figures for check
    static int currSize, nextSize;
    static int[][] justFigures; //i - qty of button press

    public static void main(String[] args) {

        getInput();

        initialize(); //initialize

        /*for(int j=0; j<justFigures[1].length; j++)
            curr[justFigures[1][j]] = true;
        currSize = justFigures[1].length;*/

        for(int buttonPress=1; buttonPress<M; buttonPress++){ //for max count calculate all figures, in fact i=press count

            curr = getNext(buttonPress); //get next current array
        }

        //print result
    }



    static boolean[] getNext(int press){

        boolean[] next = new boolean[1000];

        for(int i=1; i<=999; i++){

            if(curr[i]){ //mean that we have to calc this

                doAllOperations(next, i, press);
            }
        }

        return next;
    }

    static void doAllOperations(boolean[] next, int i, int press){ //intput figure & state

        // =
            //f - no need
            //o - no need
            //in calc -> add to min & next

        // button
            //in calc ?? - separate array ?
            //f - 10* ..., add to min, add to next
            //o - do operation, add to next

        //+ - / *
            //in calc -> res* - add to oper
            //f - add to oper
            //o - nothing

        //state - figure - no need
        //= add to min array, add to next

        //no operation - button press,

        //add operation, add to next


        int k = getK(press);

        if(false){ //operation(i)
            //= + - / * button press
        }else {

            for(int a=0; a<justFigures[k].length; a++) {

                int nextFigure = i * 10 + justFigures[k][a];

                if(nextFigure>0 && nextFigure<1000){
                    if(min[nextFigure] == 0) {
                        min[nextFigure] = press+1;
                        next[nextFigure] = true;
                    }
                    if(k != 3) next[i] = true;
                }
            }
        }
    }

    static int getK(int press){

        if(press % 3 == 0)
            return 3;

        return press % 3;
    }

    static void print(){

    }

    static void initialize(){

        min = new int[1000];
        curr = new boolean[1000];

        /*justFigures = new int[4][];
        justFigures[1] = new int[N];

        for(int i=0; i<N; i++){
            justFigures[1][i] = n[i];
        }

        justFigures[2] = new int[N*N]; int sz = 0;
        for(int j=0; j<justFigures[1].length; j++){
            for(int i=0; i<N; i++){
                justFigures[2][sz++] = justFigures[1][j]*10 + n[i];
            }
        }

        justFigures[3] = new int[N*N*N]; sz = 0;
        for(int j=0; j<justFigures[2].length; j++){
            for(int i=0; i<N; i++){
                justFigures[3][sz++] = justFigures[2][j]*10 + n[i];
            }
        }*/
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
