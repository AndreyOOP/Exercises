package ItermidTest1.Sake;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**this one works but too slow for 2 cases...
 * HashMap improved one case*/
public class Sake2 {

    static int n;

    static int[] a;
    static int[] p;

    static HashMap<Integer, Node> graph;

    static LinkedList<Node> stack = new LinkedList<>();

    static int m1;
    static int m2;
    static int maxForTheNode;

    static Node node;


    public static void main(String[] args) {

        getInput();

        graph = buildGraph();

        node = graph.get(0);
        stack.add( node);


        while ( !(stack.size()==1 && node.downNodes.size() == 0)){

            node = stack.peek();

            if( node.downNodes.size() > 0){

                stack.push( graph.get( node.downNodes.pop())); //add next node to stack

            } else {

                m1 = node.max;
                m2 = node.a + node.maxPrev;

                maxForTheNode = Math.max(m1, m2);

                stack.pop();

                node = stack.peek();

                node.max     += maxForTheNode;
                node.maxPrev += m1;
            }
        }


        node = stack.peek();
        printAnswer( Math.max(node.max, node.a + node.maxPrev));
    }

    static HashMap<Integer, Node> buildGraph(){

        HashMap<Integer, Node> list = new HashMap<>();

        Node temp;

        for(int i=0; i<n; i++){

            temp = new Node(a[i], new LinkedList<>());

            for(int j=0; j<n; j++)
                if(p[j] == i+1)
                    temp.downNodes.add( j);

            list.put(i, temp);
        }

        return list;
    }

    static class Node{

        int a;
        int max;
        int maxPrev;

        LinkedList<Integer> downNodes;

        public Node(int a, LinkedList<Integer> downNodes) {
            this.a = a;
            this.downNodes = downNodes;
        }
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        a = new int[n];
        p = new int[n];

        for(int i=0; i<n; i++){
            a[i] = scanner.nextInt();
        }

        p[0] = 0;
        for(int i=1; i<n; i++){
            p[i] = scanner.nextInt();
        }

        scanner.close();
    }

    static void printAnswer(int answer){

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print(answer);
        printWriter.flush();
    }
}
