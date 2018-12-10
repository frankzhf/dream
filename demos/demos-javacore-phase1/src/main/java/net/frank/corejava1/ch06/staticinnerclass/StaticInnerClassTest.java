package net.frank.corejava1.ch06.staticinnerclass;

public class StaticInnerClassTest {

	public static void main(String[] args) {
		double [] d = new double[20];
		for(int i=0;i< d.length;i++) {
			d[i] = 100 * Math.random();
		}
		
		ArrayAlg.Pair p = ArrayAlg.minmax(d);
		System.out.println("min=" + p.getFirst());
		System.out.println("max=" + p.getSecord());
	}

}


class ArrayAlg{
	public static class Pair{
		private double first;
		private double secord;
		
		public Pair(double f, double s) {
			first = f;
			secord = s;
		}
		
		public double getFirst() {
			return first;
		}
		
		public double getSecord() {
			return secord;
		}	
	}
	
	public static Pair minmax(double[] values) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		
		for(double v : values) {
			if(min > v) {
				min = v;
			}
			if(max < v) {
				max = v;
			}
		}
		return new Pair(min,max);
	}
	
}
