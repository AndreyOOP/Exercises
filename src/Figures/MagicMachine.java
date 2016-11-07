package Figures;

public class MagicMachine {

    public static void main(String[] args) {

        solveAndMeasureTime(Variant.TEST_1);

        solveAndMeasureTime(Variant.TEST_2);

        solveAndMeasureTime(Variant.TEST_3);

        solveAndMeasureTime(Variant.TEST_4);

//        solveAndMeasureTime(Variant.KEYBOARD);
    }

    private static void solveAndMeasureTime(Variant variant){

        TimeMeasure.setT1();

        Solver.solve(variant);

        TimeMeasure.setT2();

        TimeMeasure.time_ms();
    }

}