package Exercices.APS.Calc;

import java.util.Scanner;

public class Calculator {

    static int N, O, M, W;
    static int[] n, o;

    static int[] minButtonPress;
    static int[] next; //figures for next operations
    static int[] tempNext; //figures for next operations
    static int nextSize = 0;
    static int tempNextSize = 0;

    static int currentFigure;
    static int pressed, pressedOper;
    static int m;

    public static void main(String[] args){

        getInput();

        initialization();

        //for each from array of next
            //press all figures
            //press all operations for each figure
            //if minButtonPress 0 - add to minButton, create temp array of next figures
            //do all checks 0, 999, if less than add, do we in result?


        while (nextSize != 0 && m<M-1){ //qty of possible press

            tempNextSize = 0;

            for(int i=0; i<nextSize; i++){

                pressFigure(next[i]);

                doOperation(next[i]);
            }

            pressed++;
            next = copy();
            m++;
        }

        printResult();
    }

    static void doOperation(int current){

        for(int i=0; i<O; i++){

            if(o[i] == 1){ //plus
                for(int j=0; j<N; j++){
                    check(current + n[j], current, true);
                }
            } else if (o[i] == 2) { //minus
                for(int j=0; j<N; j++){
                    check(current - n[j], current, true);
                }
            } else if (o[i] == 3) { //*
                for(int j=0; j<N; j++){
                    check(current * n[j], current, true);
                }
            } else if (o[i] == 4) { // /
                for(int j=0; j<N; j++){
                    if(n[j]!=0)
                        check(current / n[j], current, true);
                }
            }
        }
    }

    static void printResult(){

        int result = minButtonPress[W];

        if(result==0)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    static int[] copy(){

        nextSize = 0;
        for(nextSize=0; nextSize<tempNextSize; nextSize++)
            next[nextSize] = tempNext[nextSize];

        return next;
    }

    static void pressFigure(int currentFigure){

        for(int j=0; j<N; j++){

            check( currentFigure*10 + n[j], currentFigure, false);
        }
    }

    static void check(int temp, int curr, boolean operation){

        if(temp>=0 && temp<=999){

            if(minButtonPress[temp] == 0){

                minButtonPress[temp] = operation ? minButtonPress[curr]+3 : minButtonPress[curr]+1;

                tempNext[tempNextSize++] = temp;

            } else {

                if(minButtonPress[temp] > pressed + 1) {

                    minButtonPress[temp] = operation ? minButtonPress[curr]+3 : minButtonPress[curr]+1;

                    tempNext[tempNextSize++] = temp;
                }
            }
        }
    }

    static void initialization(){ //todo add check about 0

        minButtonPress = new int[1000];
        next = new int[1000];
        tempNext = new int[1000];

        for(int i=0; i<N; i++){
            minButtonPress[ n[i]] = 1;
            next[nextSize++] = n[i];
        }
        pressed = 1;
        m = 1;
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        O = sc.nextInt();
        M = sc.nextInt();

        n = new int[N]; //figures
        for(int i=0; i<N; i++)
            n[i] = sc.nextInt();

        o = new int[O]; //operations
        for(int i=0; i<O; i++)
            o[i] = sc.nextInt();

        W = sc.nextInt();
    }
}

