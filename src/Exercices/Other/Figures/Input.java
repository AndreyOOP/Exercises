package Exercices.Other.Figures;

import java.util.Scanner;

public class Input {

    public static int a;
    public static int b;

    public static void getInput(Variant variant){

        switch (variant){

            case TEST_1:{
                a = 14;
                b = 15;
                break;
            }

            case TEST_2:{
                a = 18;
                b = 12;
                break;
            }

            case TEST_3:{
                a = 14;
                b = 29;
                break;
            }

            case TEST_4:{
                a = 1;
                b = 2345;
                break;
            }

            default: {

                Scanner scanner = new Scanner( System.in);

                System.out.println("Input a ");
                a = scanner.nextInt();

                System.out.println("Input b ");
                b = scanner.nextInt();
            }
        }
    }
}
