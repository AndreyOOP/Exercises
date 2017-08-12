package Theory.Basics.Arrays;

/**
 * E.g. for life 1 step, used deltas to show directions
 */
public class DeltaMethod {

    static int size = 5;

    static int sum;

    static int[][] a = new int[size][size];
    static int[][] b = new int[size][size];

    /**for all 8 directions*/
    static int[] d_x = {-1, -1, -1,  0,  0,  1,  1, 1};
    static int[] d_y = {-1,  0,  1, -1,  1, -1,  0, 1};

    public static void main(String[] args) {

        populateA_Array();

        printMatrix(a);

        for(int i=0; i<size; i++){

            for(int j=0; j<size; j++){

                sum = 0;

                for(int k=0; k < d_x.length; k++){ //mode of movement e.g. diagonal +1, +1

                    int y = j+d_y[k];
                    int x = i+d_x[k];

                    if( isIndexOk(x) && isIndexOk(y) )
                        sum += a[x][y];
                    else
                        continue;
                }

                if(sum == 3)
                    b[i][j] = 1;
                else
                    b[i][j] = 0;
            }
        }

        printMatrix(b);

    }

    private static void populateA_Array(){

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                a[i][j] = (int)(2*Math.random());
            }
        }
    }

    private static void printMatrix(int[][] arr){

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    private static Boolean isIndexOk(int index){

        return index >= 0 && index < size;
    }
}
