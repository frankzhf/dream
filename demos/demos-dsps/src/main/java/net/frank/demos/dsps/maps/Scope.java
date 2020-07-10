package net.frank.demos.dsps.maps;

public class Scope {

    private Point min;

    private Point max;

    public Point getMin() {
        return min;
    }

    public void setMin(Point min) {
        this.min = min;
    }

    public Point getMax() {
        return max;
    }

    public void setMax(Point max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Scope{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
