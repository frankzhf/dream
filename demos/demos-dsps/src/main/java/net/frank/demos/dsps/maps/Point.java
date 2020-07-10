package net.frank.demos.dsps.maps;

import java.awt.geom.Point2D;

public class Point extends Point2D.Double {

    private int idx = -1;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
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
