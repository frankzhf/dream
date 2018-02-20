package net.frank.corejava0.desginpattern.mediator;

import javax.swing.JButton;

public class ColleagueButton extends JButton implements Colleague {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1315146773392870727L;
	
	@SuppressWarnings("unused")
	private Mediator mediator;
	
	public ColleagueButton(String caption) {
		super(caption);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		//mediator.colleagueChanged();
	}

}
