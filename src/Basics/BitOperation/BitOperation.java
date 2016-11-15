package Basics.BitOperation;

public class BitOperation {

    static int n;

//    static int[] arr = {3, 6, 7, 1, 5, 4};
    static int[] arr = {3, 6, 7};

    public static void main(String[] args) {

        n = arr.length;

        for(int i=0; i<( 1<<n ); i++){

            for(int j=0; j<n; j++){

                if( (i & (1<<j)) != 0)
                    System.out.print( arr[j]);
            }
            System.out.println();
        }

    }
}
