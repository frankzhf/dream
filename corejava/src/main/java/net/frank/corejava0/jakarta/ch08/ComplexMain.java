package net.frank.corejava0.jakarta.ch08;

import java.text.NumberFormat;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexFormat;

public class ComplexMain {
	public static void main(String[] args) {
		Complex a = new Complex(2,3);
		Complex b = new Complex(4,5);
		Complex c = new Complex(0.3,2);
		Complex e = new Complex(4,4);
		
		Complex sum =a.add(b);
		Complex d = c.divide(sum);
		Complex f = e.multiply(d.conjugate());
		
		System.out.println("D is : " + ComplexFormat.getInstance().format(d));
		System.out.println("F is : " + ComplexFormat.getInstance().format(f));
		
		double realF = f.getReal();
		double imD = d.getImaginary();
		double answer = realF/imD;
		
		System.out.println("Answer Re(F)/Im(D):" +NumberFormat.getInstance().format(answer));
		
		//复数的格式化显示
		ComplexFormat format = new ComplexFormat("j");
		System.out.println("Impedance:" + format.format(a));
		
	}
}
