package net.frank.demos.dsps.maps;

import javax.swing.*;
import java.awt.*;

public class CoordinateFrame extends JFrame {

    static double[][] data = new double[][]{new double[]{119.312,26.0912},new double[]{119.304,26.0896},new double[]{119.302,26.0932},new double[]{119.309,26.1043},new double[]{119.305,26.0848},new double[]{119.302,26.0922},new double[]{119.303,26.1058},new double[]{119.316,26.0843},new double[]{119.303,26.0907},new double[]{119.302,26.0947},new double[]{119.312,26.0944},new double[]{119.304,26.0894},new double[]{119.302,26.0931},new double[]{119.308,26.1055},new double[]{119.305,26.0839},new double[]{119.302,26.0921},new double[]{119.302,26.1056},new double[]{119.315,26.0848},new double[]{119.303,26.0906},new double[]{119.302,26.0945},new double[]{119.311,26.0965},new double[]{119.304,26.0892},new double[]{119.302,26.093},new double[]{119.308,26.1062},new double[]{119.305,26.0836},new double[]{119.303,26.0919},new double[]{119.301,26.1054},new double[]{119.315,26.0855},new double[]{119.303,26.0904},new double[]{119.302,26.0943},new double[]{119.311,26.0976},new double[]{119.304,26.089},new double[]{119.302,26.0929},new double[]{119.305,26.0831},new double[]{119.303,26.0918},new double[]{119.302,26.1017},new double[]{119.314,26.0869},new double[]{119.303,26.0903},new double[]{119.302,26.0941},new double[]{119.311,26.1001},new double[]{119.304,26.0888},new double[]{119.302,26.0928},new double[]{119.308,26.1062},new double[]{119.306,26.0833},new double[]{119.303,26.0916},new double[]{119.302,26.0999},new double[]{119.313,26.0878},new double[]{119.303,26.0902},new double[]{119.302,26.0939},new double[]{119.311,26.1002},new double[]{119.304,26.0885},new double[]{119.302,26.0927},new double[]{119.308,26.1069},new double[]{119.307,26.0836},new double[]{119.303,26.0915},new double[]{119.302,26.0966},new double[]{119.313,26.0895},new double[]{119.303,26.0901},new double[]{119.302,26.0938},new double[]{119.311,26.1005},new double[]{119.304,26.0882},new double[]{119.302,26.0926},new double[]{119.307,26.1068},new double[]{119.309,26.0836},new double[]{119.303,26.0913},new double[]{119.302,26.096},new double[]{119.313,26.0896},new double[]{119.303,26.09},new double[]{119.302,26.0936},new double[]{119.311,26.1007},new double[]{119.304,26.0878},new double[]{119.302,26.0925},new double[]{119.307,26.1067},new double[]{119.312,26.0838},new double[]{119.303,26.0912},new double[]{119.302,26.0958},new double[]{119.313,26.0905},new double[]{119.303,26.0899},new double[]{119.302,26.0935},new double[]{119.31,26.101},new double[]{119.304,26.0873},new double[]{119.302,26.0924},new double[]{119.305,26.1062},new double[]{119.314,26.084},new double[]{119.303,26.091},new double[]{119.302,26.0955},new double[]{119.312,26.091},new double[]{119.303,26.0898},new double[]{119.302,26.0934},new double[]{119.31,26.1012},new double[]{119.304,26.0866},new double[]{119.302,26.0924},new double[]{119.304,26.1061},new double[]{119.315,26.084},new double[]{119.303,26.0909},new double[]{119.302,26.0952},new double[]{119.312,26.091},new double[]{119.303,26.0897},new double[]{119.302,26.0933},new double[]{119.31,26.1025},new double[]{119.305,26.0858},new double[]{119.302,26.0922},new double[]{119.304,26.106},new double[]{119.316,26.0841},new double[]{119.303,26.0908},new double[]{119.302,26.0949}};

    //static Point[] group = new Point[data.length];

    static Scope scope;

    public CoordinateFrame() {
        setSize(800, 600);
        setTitle("座标分析");

        Point[] group = new Point[data.length];
        double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE, maxX = Double.MIN_VALUE, maxY = Double.MIN_VALUE;

        for (int i = 0; i < data.length; i++) {
            double[] point = data[i];
            Point _point = new Point();
            _point.setIdx(i);
            _point.setLocation(point[0], point[1]);
            group[i] = _point;
            if (point[0] < minX) {
                minX = point[0];
            }
            if (point[1] < minY) {
                minY = point[1];
            }
            if (point[0] > maxX) {
                maxX = point[0];
            }
            if (point[1] > maxY) {
                maxY = point[1];
            }
        }

        Point minPoint = new Point();
        minPoint.setLocation(minX, minY);

        Point maxPoint = new Point();
        maxPoint.setLocation(maxX, maxY);

        Scope scope = new Scope();
        scope.setMin(minPoint);
        scope.setMax(maxPoint);

        System.out.println(scope);


        int widthOffset = 50;
        int heightOffset = 50;

        MapPanel mapPanel = new MapPanel(group, scope, widthOffset, heightOffset);
        add(mapPanel);
    }


    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new CoordinateFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }


    static class MapPanel extends JPanel{
        private final Point[] points;

        private final Scope scope;

        private final int widthOffset;

        private final int heightOffset;


        public MapPanel(Point[] points, Scope scope, int widthOffset, int heightOffset ){
            this.points = points;
            this.scope = scope;
            this.widthOffset = widthOffset;
            this.heightOffset = heightOffset;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            if(points!=null && points.length > 0){

                //int widthDistance = (int) (scope.getMax().x * 10000 - scope.getMin().x * 10000);
                //int heightDistance = (int) (scope.getMax().y * 10000 - scope.getMin().y * 10000);

                for (int i=0;i<points.length;i++) {
                    g2d.setColor(Color.RED);
                    g2d.drawOval((int) (points[i].x * 10000 - scope.getMin().x * 10000)*3 + widthOffset,
                            (int) (points[i].y * 10000 - scope.getMin().y * 10000)*3 + heightOffset, 1, 1);
                    g2d.setColor(Color.BLACK);
                    g2d.drawString(i + "", (int) (points[i].x * 10000 - scope.getMin().x * 10000)*3 + widthOffset + 10,
                            (int) (points[i].y * 10000 - scope.getMin().y * 10000)*3 + heightOffset);
                }
            }
        }



    }


}
