package net.frank.corejava2.ch01;

public class Manager extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7972184913634929675L;
	private Employee secretary;
	
	public Manager(String n,double s,int year,int month,int day){
		super(n,s,year,month,day);
		secretary = null;
	}
	
	public void setSecretary(Employee s){
		secretary = s;
	}
	
	public String toString(){
		return super.toString() + "[secetary= " +secretary+ "]";
	}
}