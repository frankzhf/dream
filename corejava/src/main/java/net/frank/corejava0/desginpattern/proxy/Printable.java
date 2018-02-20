package net.frank.corejava0.desginpattern.proxy;

public interface Printable {
	public abstract void setPrinterName(String name);
	public abstract String getPrinterName();
	public abstract void print(String string);
}
