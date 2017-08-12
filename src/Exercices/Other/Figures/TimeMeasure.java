package Exercices.Other.Figures;

public class TimeMeasure {

    private static long t1;
    private static long t2;

    public static void setT1(){
        t1 = System.nanoTime();
    }

    public static void setT2(){
        t2 = System.nanoTime();
    }

    public static void time_ms(){
        System.out.println( "ms = " + (t2-t1)/1000000 + "\n");
    }
}
