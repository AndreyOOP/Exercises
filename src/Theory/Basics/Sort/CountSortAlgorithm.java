package Theory.Basics.Sort;

public class CountSortAlgorithm {

    static int[] a = new int[] {1, 15, 2, 5, 6, 2, 3, 8, 10, 8};
    static int[] b = new int[11];
    static int[] c;
    static int max = 15;

    public static void main(String[] args) {

        int[] c = new int[max+1]; //max value + 1

        print(a, "Not sorted array");

        for(int i=0; i<a.length; i++)
            c[ a[i]]++;

        print(c, "Count array, how many times each figure has been counted");

        for(int i=1; i<=max; i++)
            c[i] += c[i-1];

        print(c, "Chain sum, to define index where each element should be located");

        for(int j=a.length-1; j>=0; j--){
            b[ c[a[j]]] = a[j];
            c[ a[j]]--;
        }

        print(b, "Sorted array");
    }

    public static void print(int[] arr, String msg){

        System.out.println(msg);

        for(int i=0; i<arr.length; i++)
            System.out.print( arr[i] + " ");

        System.out.println();
        System.out.println();
    }
}
