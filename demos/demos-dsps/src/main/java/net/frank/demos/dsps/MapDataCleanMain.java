package net.frank.demos.dsps;

public class MapDataCleanMain {
    
    
    static double[][] data = new double[][]{new double[]{119.312,26.0912},new double[]{119.304,26.0896},new double[]{119.302,26.0932},new double[]{119.309,26.1043},new double[]{119.305,26.0848},new double[]{119.302,26.0922},new double[]{119.303,26.1058},new double[]{119.316,26.0843},new double[]{119.303,26.0907},new double[]{119.302,26.0947},new double[]{119.312,26.0944},new double[]{119.304,26.0894},new double[]{119.302,26.0931},new double[]{119.308,26.1055},new double[]{119.305,26.0839},new double[]{119.302,26.0921},new double[]{119.302,26.1056},new double[]{119.315,26.0848},new double[]{119.303,26.0906},new double[]{119.302,26.0945},new double[]{119.311,26.0965},new double[]{119.304,26.0892},new double[]{119.302,26.093},new double[]{119.308,26.1062},new double[]{119.305,26.0836},new double[]{119.303,26.0919},new double[]{119.301,26.1054},new double[]{119.315,26.0855},new double[]{119.303,26.0904},new double[]{119.302,26.0943},new double[]{119.311,26.0976},new double[]{119.304,26.089},new double[]{119.302,26.0929},new double[]{119.305,26.0831},new double[]{119.303,26.0918},new double[]{119.302,26.1017},new double[]{119.314,26.0869},new double[]{119.303,26.0903},new double[]{119.302,26.0941},new double[]{119.311,26.1001},new double[]{119.304,26.0888},new double[]{119.302,26.0928},new double[]{119.308,26.1062},new double[]{119.306,26.0833},new double[]{119.303,26.0916},new double[]{119.302,26.0999},new double[]{119.313,26.0878},new double[]{119.303,26.0902},new double[]{119.302,26.0939},new double[]{119.311,26.1002},new double[]{119.304,26.0885},new double[]{119.302,26.0927},new double[]{119.308,26.1069},new double[]{119.307,26.0836},new double[]{119.303,26.0915},new double[]{119.302,26.0966},new double[]{119.313,26.0895},new double[]{119.303,26.0901},new double[]{119.302,26.0938},new double[]{119.311,26.1005},new double[]{119.304,26.0882},new double[]{119.302,26.0926},new double[]{119.307,26.1068},new double[]{119.309,26.0836},new double[]{119.303,26.0913},new double[]{119.302,26.096},new double[]{119.313,26.0896},new double[]{119.303,26.09},new double[]{119.302,26.0936},new double[]{119.311,26.1007},new double[]{119.304,26.0878},new double[]{119.302,26.0925},new double[]{119.307,26.1067},new double[]{119.312,26.0838},new double[]{119.303,26.0912},new double[]{119.302,26.0958},new double[]{119.313,26.0905},new double[]{119.303,26.0899},new double[]{119.302,26.0935},new double[]{119.31,26.101},new double[]{119.304,26.0873},new double[]{119.302,26.0924},new double[]{119.305,26.1062},new double[]{119.314,26.084},new double[]{119.303,26.091},new double[]{119.302,26.0955},new double[]{119.312,26.091},new double[]{119.303,26.0898},new double[]{119.302,26.0934},new double[]{119.31,26.1012},new double[]{119.304,26.0866},new double[]{119.302,26.0924},new double[]{119.304,26.1061},new double[]{119.315,26.084},new double[]{119.303,26.0909},new double[]{119.302,26.0952},new double[]{119.312,26.091},new double[]{119.303,26.0897},new double[]{119.302,26.0933},new double[]{119.31,26.1025},new double[]{119.305,26.0858},new double[]{119.302,26.0922},new double[]{119.304,26.106},new double[]{119.316,26.0841},new double[]{119.303,26.0908},new double[]{119.302,26.0949}};


    public static void main(String[] args){
        int length = data.length;
        System.out.println("Variable [length] -> " + length);
        double[][] distance = new double[length][length];

        Point[] group = new Point[length];

        for(int i=0;i<data.length;i++){
            double[] point = data[i];
            Point _point = new Point();
            _point.setIdx(i);
            _point.setX(point[0]);
            _point.setY(point[1]);
            group[i] = _point;
        }

        //依次算出各点的距离
        for(int i =0;i<length;i++){
            double[] onePoint = data[i];
            Point self = group[i];
            //Point left=null,right = null;
            for(int j=0;j<length;j++){
                if(i == j){
                    distance[i][j] = 0d;
                }else{
                    double[] other = data[j];
                    distance[i][j] = calculateDistance(onePoint,other);
                }
                fillPointLeftRight(self,group,i,j,distance[i],distance[i][j]);
            }
        }


        Point start = group[0];
        Point current = start;
        Point next;
        int i =0;
        do{
            next = current.getLeft();
            if(next.getRight().getIdx() != current.getIdx()){
                Point temp = next.getRight();
                next.setRight(next.getLeft());
                next.setLeft(temp);
            }
            current = next;
            i ++;
        }while(current.getIdx()!= start.getIdx());

        System.out.println("done "+ i);


    }


    private static double calculateDistance(double[] onePoint, double[] other){

        double x1 = onePoint[0];
        double y1 = onePoint[1];

        double x2 = other[0];
        double y2 = other[1];

        return Math.sqrt(Math.pow(Math.abs(x1-x2),2) + Math.pow(Math.abs(y1-y2),2));
    }

    private static void fillPointLeftRight(Point self,Point[] group,int row,int column,double[] rows,double distance){
        if(row == column){
            return;
        }
        if(self.getLeft()==null){
            self.setLeft(group[column]);
            return;
        }
        if(self.getRight()==null){
            self.setRight(group[column]);
            return;
        }

        double leftValue = rows[self.getLeft().getIdx()];
        double rightValue = rows[self.getRight().getIdx()];

        if(distance<leftValue && distance>rightValue){
            self.setLeft(group[column]);
            return;
        }
        if(distance<rightValue && distance>leftValue){
            self.setRight(group[column]);
            return;
        }

        if(distance<leftValue && distance<rightValue){
            if(leftValue<rightValue){
                self.setRight(group[column]);
            }else{
                self.setLeft(group[column]);
            }
        }
    }

    
}


class Point{
    private int idx = -1;
    private double x;
    private double y;

    private Point left;
    private Point right;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point getLeft() {
        return left;
    }

    public void setLeft(Point left) {
        this.left = left;
    }

    public Point getRight() {
        return right;
    }

    public void setRight(Point right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Point{" +
                "idx=" + idx +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
