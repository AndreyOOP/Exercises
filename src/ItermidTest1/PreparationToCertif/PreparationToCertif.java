package ItermidTest1.PreparationToCertif;

import java.util.LinkedList;
import java.util.Scanner;

public class PreparationToCertif {

    static int n;

    static int[] tasks;

    static LinkedList<ValSt> in = new LinkedList<>();
    static LinkedList<ValSt> out = new LinkedList<>();

    public static void main(String[] args) {

        getInput();

        for(int i=tasks.length-1; i>=0; i--){
            in.push( new ValSt(i, tasks[i]));
        }

        while ( !in.isEmpty()){

            ValSt x = in.pop();
            out.push(x);

            for(int i=x.position+1; i<tasks.length; i++){

                if( tasks[i] > out.peek().value){
                    out.push( new ValSt(i, tasks[i]));
                }
            }
        }
        //add all list to stack, for each
            //add for item all items which are greater to another stack starting from position
            //inc depth
            //if new stack empty - print depth

        //add all greater

    }

    public static void getInput(){

        Scanner scanner = new Scanner( System.in);

        n = scanner.nextInt();

        tasks = new int[n];

        for(int i=0; i<n; i++){
            tasks[i] = scanner.nextInt();
        }
    }

    static class ValSt{

        public int value;
        public int position;

        public ValSt(int position, int value) {
            this.value = value;
            this.position = position;
        }

        @Override
        public String toString() {
            return "pos " + position + ", val " + value;
        }
    }
}
