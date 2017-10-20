package Exercices.APS;

import java.util.Iterator;

public class LinkedList {

    public static void main(String[] args) {

        LinkedL lst = new LinkedL();

        lst.add(5);
        lst.add(6);
        lst.add(7);
        lst.add(8);
        lst.add(9);
        lst.add(17);

        LinkedL n = lst;

        while (n.next != null){
            System.out.println(n.value);
            n = n.next;
        }
    }

    public static class LinkedL implements Iterable{

        public static LinkedL first;
        public static LinkedL curr;

        int value;
        LinkedL next;

        public LinkedL(){

            first = this;
            curr = first;
            next  = null;
        }

        public LinkedL(int i){
            //value = i;
        }

        public void add(int i){

            curr.value = i;
            curr.next =  new LinkedL(i);

            curr = curr.next;
        }


        @Override
        public Iterator iterator() {
            return null;
        }
    }
}
