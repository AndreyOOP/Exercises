package Basics.Premutations;

public class Premutation2 {

    static int[] n = {1 ,2 ,3, 4};

    public static void main(String[] args) {

//        print(n);
        int fact = 1;

        for(int i=n.length-1; i>1; i--)
            fact *= i;

        for (int j=0; j<=fact+1; j++) {

            for(int i=1; i<n.length; i++){

                swap(n, i-1, i);
                print(n);
            }
        }
        //one step & print
    }

    static void print(int[] n){

        for (int i=0; i<n.length; i++)
            System.out.print(n[i] + " ");

        System.out.println();
    }

    //swap elements i, j of array
    static void swap(int[] n, int i, int j){

        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}
