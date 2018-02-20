package net.frank.corejava0.desginpattern.memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
	int money;
	ArrayList<String> fruits;
	
	Memento(int money){
		this.money = money;
		fruits = new ArrayList<String>();
	}
	public int getMoney() {
		return money;
	}
	
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
	@SuppressWarnings("unchecked")
	List<String> getFruits(){
		return (List<String>)fruits.clone();
	}
}
