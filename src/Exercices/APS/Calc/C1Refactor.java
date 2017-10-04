package Exercices.APS.Calc;

import java.util.LinkedList;

public class C1Refactor {

    //static boolean[] numberExist        = new boolean[10];
    static boolean[] numberExist        = {false, true, false, false, false, true, false, false, false, true};
    //static boolean[] operationAllowed   = new boolean[5]; //with nothing
    static boolean[] operationAllowed   = {false, true, true, false , false};

    static LinkedList<Figure> list = new LinkedList<>();
    static int[] n = new int[100];
    static int step = 1;
    static int maxQtyOfSteps = 7;

    public static void main(String[] args) {

        list.add(new Figure(0, Operation.NOTHING));

        for(int i=1; i<=7; i++){
            list = generateNext(list);
            step++;
        }

        print(54);
    }

    static void print(int figure){

        int answer = n[figure] != 0 ? n[figure] : -1;
        System.out.println(answer);
    }

    static LinkedList<Figure> generateNext(LinkedList<Figure> list){

        LinkedList<Figure> out = new LinkedList<>();

        for(Figure f: list){

            if(f.state == Operation.NOTHING){

                tryPressNumber(out, 10*f.value + 1, false);
                tryPressNumber(out, 10*f.value + 5, false);
                tryPressNumber(out, 10*f.value + 9, false);

                out.add(new Figure(f.value, Operation.PLUS));
                out.add(new Figure(f.value, Operation.MINUS));

            } else {

                pressNumberAfterOperation(1, f, out);
                pressNumberAfterOperation(5, f, out);
                pressNumberAfterOperation(9, f, out);
            }
        }

        return out;
    }

    static void pressNumberAfterOperation(int number, Figure f, LinkedList<Figure> out){

        if( !operationAllowed[f.state.val]) return;

        switch (f.state){

            case PLUS:{

                tryPressNumber(out, f.value + number, true);
                break;
            }
            case MINUS:{

                tryPressNumber(out, f.value - number, true);
                break;
            }
        }
    }

    static void tryPressNumber(LinkedList<Figure> out, int value, boolean afterOperation){

        //if( ! numberExist[value]) return;

        if(value > 0 && value < 100 && (n[value] == 0)){

            n[value] = afterOperation ? step+1 : step;
            out.add( new Figure(value, Operation.NOTHING));
        }
    }

    static class Figure{

        Figure(int value, Operation state){
            this.value = value;
            this.state = state;
        }

        public int value;
        public Operation state;

        @Override
        public String toString(){
            return value + " : " + state;
        }
    }

    enum Operation{

        PLUS(1), MINUS(2), NOTHING(0);

        int val;

        Operation(int v){
            val = v;
        }
    }
}