package net.frank.corejava0.desginpattern.mediator;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginFrame extends JFrame implements ActionListener, Mediator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2403194970899083039L;
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	
	public LoginFrame(String title) {
		super();
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setLayout(new GridLayout(4,2));
		createColleagues();
		add(checkGuest);
		add(checkLogin);
		add(new JLabel("Username:"));
		add(textUser);
		add(new JLabel("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		colleagueChanged();
	}
	
	@Override
	public void createColleagues() {
		ButtonGroup loginType = new ButtonGroup();
		checkGuest = new ColleagueCheckbox("Guest",loginType,true);
		checkLogin = new ColleagueCheckbox("Login",loginType,false);
		textUser = new ColleagueTextField("",10);
		textPass = new ColleagueTextField("",10);
		//textPass.set
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
		
	}

	@Override
	public void colleagueChanged() {
		if(checkGuest.isSelected()) {
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		}else {
			textUser.setColleagueEnabled(true);
			userpassChange();
		}
	}

	private void userpassChange() {
		if(textUser.getText().length()>0) {
			textPass.setColleagueEnabled(true);
			if(textPass.getText().length()>0) {
				buttonOk.setColleagueEnabled(true);
			}else {
				buttonOk.setColleagueEnabled(false);
			}
		}else {
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f = new LoginFrame("Login for Mediator");
				f.setVisible(true);
			}
			
		});
		
		
		
	}

}
