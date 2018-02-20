package net.frank.corejava0.desginpattern.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class ColleagueCheckbox extends JCheckBox implements ActionListener, Colleague {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7929042565393907899L;
	private Mediator mediator;
	
	public ColleagueCheckbox(String caption,ButtonGroup group,boolean state) {
		super(caption,state);
		group.add(this);
		addActionListener(this);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Call actionPerformed(e)");
		mediator.colleagueChanged();
	}

}
