package Basics.Premutations;


import java.util.LinkedList;

public class Premutation3 {

    static int n = 3;

    static int[] array = {1, 2, 3};

    static int[] tmp = new int[n];

//    static LinkedList< int[]> circles = new LinkedList<>();

    static LinkedList<Circle> circles = new LinkedList<>();

    public static void main(String[] args) {

        for(int i=0; i<n; i++){
            circles.add( new Circle(array, false, 0));
        }

        Boolean turn = true;

        for(int i=n-1; i>=0; i--){

            if(turn)
                turn = circles.get(i).next();
            else
                turn = false;
        }
        //from lowest next value, - if end - to begin & previous turn

    }

    static class Circle{

        int[] circle;
        Boolean fullTurn;
        int currPosition;

        public Circle(int[] circle, Boolean fullTurn, int currPosition) {
            this.circle = circle;
            this.fullTurn = fullTurn;
            this.currPosition = currPosition;
        }

        public Boolean next(){

            currPosition++;

            if(currPosition == circle.length){

                currPosition=0;
                return true;
            }

            return false;
        }
    }


}
