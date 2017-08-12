package Theory.Basics.Sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortObject {

    public static void main(String[] args) {

        LinkedList<ClassForSort> list = populateList();
        print( list, "Before sort");

        Collections.sort( list, ClassForSort.getAComparator());
        print( list, "After sort by a field");

        Collections.sort( list, ClassForSort.getBComparator());
        print( list, "After sort by b field");
    }


    static class ClassForSort{

        public int a;
        public int b;

        public ClassForSort(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public static Comparator<SortObject.ClassForSort> getAComparator(){

            return new Comparator<ClassForSort>() {

                @Override
                public int compare(ClassForSort o1, ClassForSort o2) {

                    if(o1.a>o2.a)
                        return 1;

                    if(o1.a<o2.a)
                        return -1;

                    return 0;
                }
            };
        }

        public static Comparator<SortObject.ClassForSort> getBComparator(){

            return new Comparator<ClassForSort>() {

                @Override
                public int compare(ClassForSort o1, ClassForSort o2) {

                    if(o1.b > o2.b)
                        return 1;

                    if(o1.b < o2.b)
                        return -1;

                    return 0;
                }
            };
        }

        @Override
        public String toString() {
            return "a " + a + ", b " + b;
        }
    }

    public static LinkedList<ClassForSort> populateList(){

        LinkedList<ClassForSort> list = new LinkedList<>();

        list.add( new ClassForSort(1, 8));
        list.add( new ClassForSort(0, 2));
        list.add( new ClassForSort(4, 9));
        list.add( new ClassForSort(2, 1));
        list.add( new ClassForSort(1, 2));
        list.add( new ClassForSort(2, 3));

        return list;
    }

    public static void print(LinkedList<ClassForSort> list, String message){

        System.out.println(message);

        for(ClassForSort cfs: list)
            System.out.println( cfs);

        System.out.println();
    }
}
