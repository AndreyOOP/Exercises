package Exercices.APS.C;

import java.util.Scanner;

/**n < m */
/**a -> n, b -> m%n   a -> b, b -> a%b  */
public class NODEvklid {

    static int n, m, nod;
    static int a, b, temp;

    //better in C1
    public static void main(String[] args) {

        getInput();


        a = Math.min(n,m);
        b = Math.max(n, m) % Math.min(n,m);
        nod = a;


        while (b != 0){

            nod = b;
            temp = a;
            a = b;
            b = temp%b;
        }

        System.out.println(nod);
    }

    public static void getInput(){

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
    }
}
