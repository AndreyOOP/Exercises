package Theory.Basics.List;

import java.util.Iterator;

/**Simple list implementation, to avoid array size check & easy for implementation*/
public class LLSample {

    public static void main(String[] args) {

        LinkLst list = new LinkLst();

        list.add(11);
        list.add(22);
        list.add(33);
        list.add(31);
        list.add(33);
        list.add(55);

        for(Node n: list)
            System.out.println(n.value);

        list = new LinkLst(); list.add(123); list.add(1); list.add(4);
        for(Node n: list)
            System.out.println(n.value);
    }

    public static class LinkLst implements Iterable<Node>{

        private Node head;
        private Node last;

        public LinkLst(){

            last = new Node(null, 0);
            head = last;
        }

        public void add (int v){

            Node n = new Node(null, 0);

            last.value = v;
            last.next = n;
            last = n;
        }

        @Override
        public Iterator<Node> iterator() {

            return new Iterator<Node>() {

                private Node curr = head;
                private Node temp;

                @Override
                public boolean hasNext() {
                    return curr.next != null;
                }

                @Override
                public Node next() {

                    if(curr.next == null) return null;

                    temp = curr;
                    curr = curr.next;

                    return temp;
                }
            };
        }
    }

    public static class Node{

        public Node next;
        public int value;

        public Node(Node next, int value) {
            this.value = value;
            this.next = next;
        }
    }
}
