package Exercices.Other.FigureGame;

import java.util.Scanner;

public class InputData {

    public Out getData(TestCase tCase){

        switch (tCase){

            case TEST_1:
                return new Out(1234, 4321);

            case TEST_2:
                return new Out(2345, 2344);

            case TEST_3:
                return new Out(1111, 1113);

            case TEST_4:
                return new Out(1461, 2991);

            case TEST_5:
                return new Out(1461, 9129);

            case KEYBOARD:{

                Scanner scanner = new Scanner(System.in);
                Out out = new Out();


                System.out.println("Input a ");
                out.a = scanner.nextInt();

                System.out.println("Input b ");
                out.b =  scanner.nextInt();

                return out;
            }

            default:
                return new Out(1111, 1111);
        }
    }

    class Out{

        public int a;
        public int b;

        public Out(){}

        public Out(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
