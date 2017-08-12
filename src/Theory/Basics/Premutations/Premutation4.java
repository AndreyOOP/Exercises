package Theory.Basics.Premutations;

import java.util.LinkedList;

public class Premutation4 {

    public static void main(String[] args) {

        FigureBase fig = new FigureBase(3, 3);

        fig.print();

        for (int i=0; i<27; i++) {
            fig.next();
            fig.print();
        }
    }

    static class FigureBase{

        static int base;
        static int size;

        static LinkedList<Integer> figure = new LinkedList<>();

        public FigureBase(int base, int size) {
            this.base = base;
            this.size = size;

            for(int i=0; i<size; i++)
                figure.add(i, 0);
        }

        public static void next(){

            int lastInd = figure.size()-1;

            figure.set(lastInd, figure.get(lastInd)+1);

            while (figure.get(lastInd) % base == 0 && lastInd > 0){

                figure.set(lastInd, 0);
                figure.set(lastInd-1, figure.get(lastInd-1)+1);
                lastInd--;
            }
        }

        public static void print(){

            for(Integer i: figure)
                System.out.print(i);

            System.out.println();
        }
    }
}
