package Exercices.ItermidTest1.StopACoder;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//todo to refactor...
public class StopCoder {

    static int n;

    static LinkedList<Coder> coders = new LinkedList<>();

    static LinkedList<Coder> output;

    static LinkedList<Integer> pointsForPlace = new LinkedList<>();

    public static void main(String[] args) {

        coders = getInput();

        Collections.sort( coders, Coder.getPointsComparator());

        int i = 0;

        pointsForPlace.add( new Integer(coders.get(0).points));

        do{ //find points for 1, 2 ,3 places //todo it is possible to find place & create max output for place

            if( pointsForPlace.getLast() != coders.get(i).points)
                pointsForPlace.add( new Integer(coders.get(i).points));

            i++;

        } while (i<n && pointsForPlace.size()<3);


        PrintWriter printWriter = new PrintWriter(System.out);

        for(int j=0; j<pointsForPlace.size(); j++){

            output = new LinkedList<>();

            for(int k=0; k<n; k++) //todo this is double work
                if(coders.get(k).points == pointsForPlace.get(j))
                    output.add(coders.get(k));

            Collections.sort(output, Coder.getNameComparator());

            for(int k=0; k<output.size(); k++)
                printWriter.print(output.get(k).name + " ");

            printWriter.println();
            printWriter.flush();
        }
    }

    static LinkedList<Coder> getInput(){

        LinkedList<Coder> coders = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        for(int i=0; i<n; i++)
            coders.add( new Coder(scanner.next(), scanner.nextInt()));

        return coders;
    }

    static class Coder{

        int points;
        String name;

        public Coder( String name, int points) {
            this.points = points;
            this.name = name;
        }

        public static Comparator<Coder> getPointsComparator(){

            return new Comparator<Coder>() {

                @Override
                public int compare(Coder o1, Coder o2) {

                    if(o1.points > o2.points)
                        return -1;

                    if(o1.points < o2.points)
                        return 1;

                    return 0;
                }
            };
        }

        public static Comparator<Coder> getNameComparator(){

            return new Comparator<Coder>() {

                @Override
                public int compare(Coder o1, Coder o2) {

                    return o1.name.compareTo(o2.name);
                }
            };
        }
    }
}