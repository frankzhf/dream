package net.frank.corejava0.jakarta.ch01;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PoliticalCandidate {
	private String lastName;
	private String firstName;
	private Date dateOfBirth;
	private BigDecimal moneyRaised;
	private State homeState;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public BigDecimal getMoneyRaised() {
		return moneyRaised;
	}
	public void setMoneyRaised(BigDecimal moneyRaised) {
		this.moneyRaised = moneyRaised;
	}
	public State getHomeState() {
		return homeState;
	}
	public void setHomeState(State homeState) {
		this.homeState = homeState;
	}
	
	public int compareTo(Object obj) {
		/**
		 *  自定义方法如下
		 *  
		 *  int compare = -1;
		 *  if(obj!=null &&
				PoliticalCandidate.class.isAssignableFrom(obj.getClass())) {
				PoliticalCandidate ps = (PoliticalCandidate)obj;
				compare = (new CompareToBuilder()
						.append(firstName, ps.getFirstName())
						.append(lastName, ps.getLastName())).toComparison();
			}
			return compare;
		 *  
		 *  
		 *  
		 */
		
		return CompareToBuilder.reflectionCompare(this,obj);
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37)//必须是非零非偶的质数
				.append(firstName)
				.append(lastName).toHashCode();
	}
	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if(obj!=null &&
				PoliticalCandidate.class.isAssignableFrom(obj.getClass())) {
			PoliticalCandidate ps = (PoliticalCandidate)obj;
			equals = (new EqualsBuilder()
						.append(firstName, ps.getFirstName())
						.append(lastName, ps.getLastName())).isEquals();
		}
		return equals;
	}
	@Override
	public String toString() {
		/**
		 * ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		 * 		.append("lastName",lastName)
		 * 		.append("firstName",firstName)
		 * 		.toString();
		 * 
		 * ToStringBuilder 常用的方法
		 * append(int value)
		 * append(String n, int value)
		 * append(Object obj)
		 * append(String n, Object obj)
		 * append(int[] array)
		 * append(Object[] array)
		 * append(String n, int[] array);
		 * append(String n, Object[] array);
		 * append(String n, int[] array, boolean detail)
		 * 
		 * ToStringStyle.DEFAULT_STYLE
		 * ToStringStyle.MULTI_LINE_STYLE
		 * ToStringStyle.NO_FIELD_NAMES_STYLE
		 * ToStringStyle.SIMPLE_STYLE
		 * ToStringStyle.SHORT_PREFIX_STYLE
		 * 
		 */
		return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public static void main(String[] args) {
		State va = new State("va","Virginia");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,1743);
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		calendar.set(Calendar.DAY_OF_MONTH, 13);
		Date dob = calendar.getTime();
		BigDecimal moneyRaised = new BigDecimal(293829292.93);
		
		PoliticalCandidate candidate = new PoliticalCandidate();
		candidate.setFirstName("Thomas");
		candidate.setLastName("Jefferson");
		candidate.setDateOfBirth(dob);
		candidate.setMoneyRaised(moneyRaised);
		candidate.setHomeState(va);
		System.out.println(candidate);
		
	}
	
}


class State{
	
	private String abbreviation;
	private String name;
	
	public State(String abbreviation,String name) {
		this.abbreviation = abbreviation;
		this.name = name;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37)
				.append(abbreviation)
				.append(name).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if(obj!=null &&
			State.class.isAssignableFrom(obj.getClass())) {
			State ps = (State) obj;
			equals = (new EqualsBuilder()
						.append(abbreviation,ps.getAbbreviation())
						.append(name,ps.getName())).isEquals();
		}
		return equals;
	}

	
	
	
	
	
}