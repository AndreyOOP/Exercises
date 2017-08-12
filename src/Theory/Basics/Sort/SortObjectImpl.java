package Theory.Basics.Sort;

import java.util.Collections;
import java.util.LinkedList;

public class SortObjectImpl {

    public static void main(String[] args) {

        LinkedList<SortObjectImpl.ClassForSort> list = populateList();
        print(list, "Not Sorted List");

        Collections.sort(list);
        print(list, "Sorted by Sum List");
    }

    static class ClassForSort implements Comparable{

        public int a;
        public int b;

        public ClassForSort(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Object o) {

            SortObjectImpl.ClassForSort x = (SortObjectImpl.ClassForSort) o;

            if( a+b > x.a+x.b)
                return 1;

            if( a+b < x.a+x.b)
                return -1;

            return 0;
        }

        @Override
        public String toString() {
            return "a " + a + ", b " + b + ", sum = " + (a+b);
        }
    }

    public static LinkedList<SortObjectImpl.ClassForSort> populateList(){

        LinkedList<SortObjectImpl.ClassForSort> list = new LinkedList<>();

        list.add( new SortObjectImpl.ClassForSort(1, 8));
        list.add( new SortObjectImpl.ClassForSort(0, 2));
        list.add( new SortObjectImpl.ClassForSort(4, 9));
        list.add( new SortObjectImpl.ClassForSort(2, 1));
        list.add( new SortObjectImpl.ClassForSort(1, 2));
        list.add( new SortObjectImpl.ClassForSort(2, 3));

        return list;
    }

    public static void print(LinkedList<SortObjectImpl.ClassForSort> list, String message){

        System.out.println(message);

        for(SortObjectImpl.ClassForSort cfs: list)
            System.out.println( cfs);

        System.out.println();
    }
}
