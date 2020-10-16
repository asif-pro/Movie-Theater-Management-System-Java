package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import entity.*;
import frames.*;
import repository.*; 

public class ShowDetails extends JFrame implements ActionListener
{
	JLabel movnameLabel,timeLabel,noOfTicketLabel,bimgLabel,amountLabel,showLabel;
	JButton prevBtn, procedBtn, logoutBtn;
	private Color backColor;
	private ImageIcon bimg;
	JPanel panel; 
	
	public ShowDetails()
	{
		super("Show Details");
		
		this.setSize(1300, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
	    movnameLabel = new JLabel("Name :");
		movnameLabel.setBounds(300, 150, 250, 30);
		panel.add( movnameLabel);
		
	    showLabel= new JLabel("  ");
		showLabel.setBounds(600, 150, 250, 30);
		panel.add( showLabel);
		
		timeLabel= new JLabel("Time : ");
		timeLabel.setBounds(300, 200, 250, 30);
		panel.add(timeLabel);
		
		showLabel= new JLabel("  ");
		showLabel.setBounds(600, 200, 250, 30);
		panel.add( showLabel);
		
		noOfTicketLabel= new JLabel("No Of Ticket : ");
		noOfTicketLabel.setBounds(300, 250, 250, 30);
		panel.add(noOfTicketLabel); 
		
		showLabel= new JLabel("  ");
		showLabel.setBounds(600, 250, 250, 30);
		panel.add( showLabel);
		
		amountLabel = new JLabel("User Id:");
		amountLabel.setBounds(300, 300, 200, 30);
		panel.add( amountLabel);
		
		showLabel= new JLabel(" ");
		showLabel.setBounds(600, 300, 200, 30);
		panel.add( showLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(1180, 0, 100, 50);
		logoutBtn.addActionListener(this);
		logoutBtn.setBackground(Color.GRAY);
		logoutBtn.setForeground(Color.BLACK);
		panel.add(logoutBtn);
		
		prevBtn = new JButton("Previous");
		prevBtn.setBounds(500, 500, 100, 30);
		prevBtn.addActionListener(this);
		prevBtn.setBackground(Color.BLACK);
		prevBtn.setForeground(Color.WHITE);
		panel.add(prevBtn);
		
		procedBtn = new JButton("Procced");
		procedBtn.setBounds(700, 500, 100, 30);
		procedBtn.addActionListener(this);
		procedBtn.setBackground(Color.BLACK);
		procedBtn.setForeground(Color.WHITE);
		panel.add(procedBtn);
		
		
		bimg = new ImageIcon("contact.jpg");
		Image rawImage = bimg.getImage();
		Image resizedImage = rawImage.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
		
		bimg = new ImageIcon(resizedImage);
		bimgLabel = new JLabel(bimg);
		bimgLabel.setBounds(0,0, 1300, 1000);
		panel.add(bimgLabel);
		
		this.add(panel);
	}
	
    public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(ae.getSource()== prevBtn)
		{
		SelectMovie sm = new SelectMovie();
		sm.setVisible(true);
		this.setVisible(false);
		}
		
		else if(command.equals(logoutBtn.getText()))
		{
		Movie mv = new Movie();
		mv.setVisible(true);
		this.setVisible(false);
		} 
		
		else if(command.equals(procedBtn.getText()))
		{
			JOptionPane.showMessageDialog(this, "Make the Payment");
		}
		else{}
	}

}