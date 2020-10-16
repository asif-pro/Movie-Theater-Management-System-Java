package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entity.*;
import frames.*;
import repository.*;
public class ManagerHome extends JFrame implements ActionListener
{
	private JButton account,logout,emp;
	private JPanel panel;
	
	public ManagerHome()
	{
		
		super("Manager Home");
		this.setSize(1300,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null); 

		logout = new JButton("Logout");
		logout.setBounds(1180,0,100,50);
		logout.setBackground(Color.GRAY);
		logout.setForeground(Color.BLACK);
		logout.addActionListener(this);
		panel.add(logout);
		
		account = new JButton("Account");
		account.setBounds(590,390,120,50);
		account.setBackground(Color.BLACK);
		account.setForeground(Color.WHITE);
		account.addActionListener(this);
		panel.add(account);
		
		emp = new JButton("Employee");
		emp.setBounds(590,490,120,50);
		emp.setBackground(Color.BLACK);
		emp.setForeground(Color.WHITE);
		emp.addActionListener(this);
		panel.add(emp);

	
	this.add(panel);
}
    public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logout.getText()))
		{

		 Movie m2 = new Movie();
	     m2.setVisible(true);
		this.setVisible(false);
			
		}
		else if (command.equals(emp.getText()))
			{

		 Updateemployee ue = new Updateemployee((new User()));
	     ue.setVisible(true);
		this.setVisible(false);
			
		}
		else if (command.equals(account.getText()))
			{

		 AdminChangepassword acp = new AdminChangepassword();
	     acp.setVisible(true);
		this.setVisible(false);
			
		}
		else {}
	
	}

}