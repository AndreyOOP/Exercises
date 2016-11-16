package Basics.BinarySearch;

import java.util.Arrays;

public class BinSearchMyRealization {

    public static int[] a = {1 ,4, 7, 10, 12, 2, 5, 6, 3, 18, 24, 7, 7, 2, 2};

    public static void main(String[] args) {

        Arrays.sort(a);

        for(int i=0; i<a.length; i++)
            System.out.print(i + " ");

        System.out.println();

        for(int i=0; i<a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();
        System.out.println( binarySearch(11, 0, a.length, a));
        System.out.println( binarySearch(1, 0, a.length, a));
        System.out.println( binarySearch(2, 0, a.length, a));
        System.out.println( binarySearch(3, 0, a.length, a));
        System.out.println( binarySearch(12, 0, a.length, a));
        System.out.println( binarySearch(15, 0, a.length, a));
    }

    static int binarySearch(int key, int from, int to, int[] arr){

        int mid = from + (to - from)/2;

        if(a[mid]==key)
            return mid;

        if(to-from <= 1)
            return -1;

        if(a[mid] > key)
            return binarySearch(key, from, mid, arr);

        if(a[mid] < key)
            return binarySearch(key, mid, to, arr);

        return -1;
    }
}
