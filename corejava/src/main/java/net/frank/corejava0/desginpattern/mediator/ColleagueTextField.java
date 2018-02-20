package net.frank.corejava0.desginpattern.mediator;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ColleagueTextField extends JTextField implements DocumentListener, Colleague {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5508053798508924974L;
	private Mediator mediator;
	
	public ColleagueTextField(String text,int columns) {
		super(text,columns);
		getDocument().addDocumentListener(this);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		setBackground(enabled? Color.WHITE : Color.LIGHT_GRAY);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		mediator.colleagueChanged();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		mediator.colleagueChanged();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		mediator.colleagueChanged();
	}

}
