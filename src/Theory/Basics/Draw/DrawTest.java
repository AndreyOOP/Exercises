package Theory.Basics.Draw;

import Theory.Basics.StdDraw;

import java.awt.*;

public class DrawTest {

    public static void main(String[] args) {

        drawTest(100);
    }

    static void drawTest(int n){

        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n*n);
        StdDraw.setPenRadius(.01);

        StdDraw.setPenColor(Color.BLUE);
        for(int i=0; i<n; i++){
            StdDraw.point(i, i*i);
            StdDraw.point(i, i);
            StdDraw.point(i, 8*i);
        }
    }
}
