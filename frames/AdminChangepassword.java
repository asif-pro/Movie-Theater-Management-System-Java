package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entity.*;
import frames.*;
import repository.*;


public class AdminChangepassword extends JFrame implements ActionListener
{
	private JLabel  oldpassLabel,newpassLabel , ConfirmpassLabel;
	private JPasswordField  oldpassPF ,  newpassPF , ConfirmpassPF ;
	private JButton ConfirmBtn, BackBtn, logoutBtn;
	private JPanel panel;
	
	public AdminChangepassword ()
	{
		super("Admin Change Password");
		this.setSize(1300,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
        panel.setLayout(null);
		

        oldpassLabel = new JLabel("Old password:");
		oldpassLabel.setBounds(150, 180, 100, 30);
		panel.add(oldpassLabel);
		
		oldpassPF = new JPasswordField("");
		oldpassPF.setBounds(280,180,100,30);
		panel.add(oldpassPF);


		
		newpassLabel = new JLabel("NEW Password:");
		newpassLabel.setBounds(150, 240, 100, 30);
		panel.add(newpassLabel);
		
		newpassPF = new JPasswordField("");
		newpassPF.setBounds(280,240,100,30);
		panel.add(newpassPF);
		
		ConfirmpassLabel = new JLabel("Confirm password:");
		ConfirmpassLabel.setBounds(150, 300, 150, 30);
		panel.add(ConfirmpassLabel);
		
		newpassPF = new JPasswordField();
		newpassPF.setBounds(280,300,100,30);
		panel.add(newpassPF);
		
		
		ConfirmBtn = new JButton("Confirm");
		ConfirmBtn.setBounds(400,400, 120, 50);
		ConfirmBtn.setBackground(Color.BLACK);
		ConfirmBtn.setForeground(Color.WHITE);
		ConfirmBtn.addActionListener(this);
		panel.add(ConfirmBtn);
		
		BackBtn = new JButton("Back");
		BackBtn.setBounds(200, 400, 120, 50);
		BackBtn.setBackground(Color.BLACK);
		BackBtn.setForeground(Color.WHITE);
		BackBtn.addActionListener(this);
		panel.add(BackBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(1180, 0,100 , 50);
        logoutBtn.setBackground(Color.GRAY);
		logoutBtn.setForeground(Color.BLACK);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
	
		this.add(panel);
	}
	   public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
           Movie m24 = new Movie();
	     m24.setVisible(true);
		this.setVisible(false);
			
		}
		else if (command.equals(BackBtn.getText()))
			{

		 ManagerHome mh1 = new ManagerHome();
	     mh1.setVisible(true);
		this.setVisible(false);
			
		}
		else if (command.equals(ConfirmBtn.getText()))
			{
            JOptionPane.showMessageDialog(this, "Password Changed Successfully");
		 ManagerHome mh2 = new ManagerHome();
	     mh2.setVisible(true);
		this.setVisible(false);
			
		}
		else {}
	
	}


	
	
	
	
	
	
}