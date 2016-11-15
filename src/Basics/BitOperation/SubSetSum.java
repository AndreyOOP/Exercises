package Basics.BitOperation;

public class SubSetSum {

    static int[] set = {-7, -3, -2, 5, 8, 1, 2, 6};
    static int[] subset;

    static int k;

    public static void main(String[] args) {

        int n = set.length;
        subset = new int[n];

        for(int i=0; i<( 1<<n ); i++){

            k = 0;
            subset = new int[n];

            for(int j=0; j<n; j++){

                if( (i & (1<<j)) != 0){
                    subset[k] = set[j];
                    k++;
                }
            }

            checkSubset(subset);
        }
    }

    static void checkSubset(int[] sub){

        int n = sub.length;
        int sum = 0;

        for(int i=0; i<n; i++)
            sum += sub[i];

        if(sum == 0){

            for(int i=0; i<n; i++)
                System.out.print(sub[i] + " ");

            System.out.println();
        }
    }
}
