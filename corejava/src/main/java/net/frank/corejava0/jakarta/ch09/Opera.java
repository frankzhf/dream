package net.frank.corejava0.jakarta.ch09;

import java.io.Serializable;
import java.util.List;

public class Opera implements Serializable {
	private String name;
	private String composer;
	private int year;
	private List<String> acts;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<String> getActs() {
		return acts;
	}
	public void setActs(List<String> acts) {
		this.acts = acts;
	}
	@Override
	public String toString() {
		return "Opera [name=" + name + ", composer=" + composer + ", year=" + year + ", acts=" + acts + "]";
	}
	
	
}
