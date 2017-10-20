package Exercices.DynamicPrograms;

import java.util.Scanner;

//Formula - 3A + 2P
//next A -> 3A+2P
//next P -> A+P

public class Domino {

    static int[] a = new int[31];
    static int[] p = new int[31];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        a[0] = 1; p[0] = 1;
        a[2] = 3; p[2] = 2;

        for(int i = 4; i<=30; i+=2){
            a[i] = 3*a[i-2] + p[i-2];
            p[i] = 2*a[i-2] + p[i-2];
        }

        for(int i=sc.nextInt(); i != -1; ){
            System.out.println(a[i]);
            i = sc.nextInt();
        }
    }
}
