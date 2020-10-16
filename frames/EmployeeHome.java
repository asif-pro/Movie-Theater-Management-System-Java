package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import repository.*;
import entity.*;
import frames.*;

public class EmployeeHome extends JFrame implements ActionListener
{

	JButton logoutBtn,account,am;
	private Color backColor;
    JPanel panel;
	

	
	public EmployeeHome()
	{
		super(" Employee Home ");
		this.setSize(1300,1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
        am = new JButton("Assign Movie");
		am.setBounds(590,490,120,50);
		am.setBackground(Color.BLACK);
		am.setForeground(Color.WHITE);
		am.addActionListener(this);
		panel.add(am);

	
	
		

		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(1180, 0, 100, 50);
		logoutBtn.addActionListener(this);
		logoutBtn.setBackground(Color.GRAY);
		logoutBtn.setForeground(Color.BLACK);
		panel.add(logoutBtn);
		
		account = new JButton("Account");
		account.setBounds(590,390,120,50);
		account.setBackground(Color.BLACK);
		account.setForeground(Color.WHITE);
		account.addActionListener(this);
		panel.add(account);
		
		  

		
		

		
		
		 
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		
		if(ae.getSource()== account)
		{
			EmployeeDetails ed = new EmployeeDetails();
		    ed.setVisible(true);
		    this.setVisible(false);
		}
		
		
		else if(command.equals(logoutBtn.getText()))
		{
			Movie mv = new Movie();
		mv.setVisible(true);
		this.setVisible(false);
		} 
		else if(command.equals(am.getText()))
		{
			SetMovie smv = new SetMovie();
		smv.setVisible(true);
		this.setVisible(false);
		} 
		
		
		else{}
		
	}
}