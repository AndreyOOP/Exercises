package Exercices.APS.Calc;

import java.util.LinkedList;
import java.util.Scanner;

public class C1 {

    static LinkedList<Figure> list = new LinkedList<>();
    static int N;
    static int[] n = new int[100];

    //work 1, 5, 9 & plus, minus; max int 100

    public static void main(String[] args) {

        //getInput();

        list.add(new Figure(0, 0));

        int step = 1;

        for(int i=0; i<10; i++){
            list = generateNext(list, step);
            step++;
        }
    }

    static LinkedList<Figure> generateNext(LinkedList<Figure> list, int step){

        LinkedList<Figure> out = new LinkedList<>();

        for(Figure f: list){

            if(f.state == 0){

                pressNumber(1, f, out, step);
                pressNumber(5, f, out, step);
                pressNumber(9, f, out, step);

                pressOperation(1, f, out);
                pressOperation(2, f, out);
            } else {

                pressNumberAfterOperation(1, f, out, step);
                pressNumberAfterOperation(5, f, out, step);
                pressNumberAfterOperation(9, f, out, step);
            }
        }

        return out;
    }

    static void pressOperation(int operation, Figure f, LinkedList<Figure> out) {

        out.add(new Figure(f.value, operation));
    }

    static void pressNumber(int number, Figure f, LinkedList<Figure> out, int step){

        int temp = 10*f.value + number;

        if(temp < 100 && (n[temp] == 0 || n[temp] > step)){

            n[temp] = step;
            out.add( new Figure(temp, 0));
        }
    }

    static void pressNumberAfterOperation(int number, Figure f, LinkedList<Figure> out, int step){

        if(f.state == 1){

            int temp = f.value + number;

            if(temp < 100 && (n[temp] == 0)){

                n[temp] = step;
                out.add( new Figure(temp, 0));
            }
        }

        if(f.state == 2){

            int temp = f.value - number;

            if(temp > 0 && (n[temp] == 0)){

                n[temp] = step;
                out.add( new Figure(temp, 0));
            }
        }
    }

    static class Figure{

        Figure(int value, int state){
            this.value = value;
            this.state = state;
        }

        public int value;
        public int state; //0 - nothing, 1 - plus, 2 - minus

        @Override
        public String toString(){
            return value + " : " + state;
        }
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
    }
}
