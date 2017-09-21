package Exercices.APS;

import java.io.PrintWriter;
import java.util.Scanner;

public class BG {

    static int N, M;
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {

        Set set = new Set(null, null, 10, 1);

        N = sc.nextInt();

        for(int i=0; i<N; i++)
            set.add( sc.nextInt());

        M = sc.nextInt();

        for(int i=0; i<M; i++)
            print( set.getQty( sc.nextInt()));

    }

    static void print(int v){
        pw.print(v + " ");
        pw.flush();
    }

    /**up > left & up < right*/
    static class Set{

        Set left;
        Set right;
        int value;
        int qty;

        public Set(Set left, Set right, int value, int qty) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.qty = qty;
        }

        public int getQty(int v){

            Set curr = this;

            while (true){

                if(v == curr.value) return curr.qty;

                if(v < curr.value){

                    if(curr.left == null) return 0;
                    curr = curr.left;
                } else {

                    if(curr.right == null) return 0;
                    curr = curr.right;
                }
            }
        }

        public void add(int v){

            Set curr = this;

            while (true){

                if(v == curr.value){
                    curr.qty++;
                    return;
                }

                if(v < curr.value){

                    if(curr.left == null){
                        Set n = new Set(null, null, v, 1);
                        curr.left = n;
                        break;
                    }

                    curr = curr.left;
                } else {

                    if(curr.right == null){
                        Set n = new Set(null, null, v, 1);
                        curr.right = n;
                        break;
                    }
                    curr = curr.right;
                }
            }
        }

        @Override
        public String toString(){
            return  String.valueOf(value) + " > " + String.valueOf(qty);
        }
    }
}
