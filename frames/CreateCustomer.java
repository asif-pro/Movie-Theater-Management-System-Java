package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import entity.*;
import frames.*;
import repository.*;

public class CreateCustomer extends JFrame implements ActionListener
{     Scanner sc = new Scanner(System.in);
	JLabel nameLabel,phoneLabel,userIdLabel,passLabel,con_passLabel;
	JTextField nameTF,phoneTF,userIdTF;
	JPasswordField passPF,con_passPF;
	JButton prevBtn, procedBtn;
	private Color backColor;
	JPanel panel;
	
	private User user;
	private EmployeeRepo er;
	private CustomerRepo cr;
	private UserRepo ur;
	
	
	public CreateCustomer()
	{
		super("Create Customer");
		
		this.setSize(1300, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.user = user;
		
		cr = new CustomerRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
	    nameLabel = new JLabel("Name :");
		nameLabel.setBounds(300, 100, 250, 30);
		panel.add( nameLabel);
		
	    nameTF = new JTextField();
		nameTF.setBounds(600, 100, 250, 30);
		panel.add(nameTF);
		
		phoneLabel= new JLabel("Phone No : ");
		phoneLabel.setBounds(300,250, 250, 30);
		panel.add(phoneLabel);
		
		phoneTF= new JTextField();
		phoneTF.setBounds(600, 250, 250, 30);
		panel.add(phoneTF);
		
		userIdLabel = new JLabel("Customer Id:");
		userIdLabel.setBounds(300,150, 250, 30);
		panel.add( userIdLabel);
		
		userIdTF = new JTextField();
		userIdTF.setBounds(600, 150, 250, 30);
		panel.add(userIdTF);
		
		passLabel= new JLabel("Password : ");
		passLabel.setBounds(300, 350, 250, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(600, 350, 250, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		con_passLabel= new JLabel("Confirm Password : ");
		con_passLabel.setBounds(300, 400, 250, 30);
		panel.add(con_passLabel);
		
		con_passPF = new JPasswordField();
		con_passPF.setBounds(600, 400, 250, 30);
		con_passPF.setEchoChar('*');
		panel.add(con_passPF);
		
		
		prevBtn = new JButton("Previous");
		prevBtn.setBounds(500, 500, 100, 30);
		prevBtn.addActionListener(this);
		prevBtn.setBackground(Color.BLACK);
		prevBtn.setForeground(Color.WHITE);
		panel.add(prevBtn);
	
		procedBtn = new JButton("Proceed");
		procedBtn.setBounds(700, 500, 100, 30);
		procedBtn.addActionListener(this);
		procedBtn.setBackground(Color.BLACK);
		procedBtn.setForeground(Color.WHITE);
		panel.add(procedBtn);
		
		this.add(panel);
	}
	
    public void actionPerformed(ActionEvent ae)
	{   
		String command = ae.getActionCommand();
		
		if(ae.getSource()== prevBtn)
		{
	  Movie mv = new Movie();
		    mv.setVisible(true);
			this.setVisible(false);
			
		}
		
		
		else if(command.equals(procedBtn.getText()))
		{
			try 
			{
				Customer c = new Customer();
			User u = new User();
			
			c.setCustomerId(userIdTF.getText());
			c.setCustomerName(nameTF.getText());
			c.setPhone(phoneTF.getText());
			
			u.setUserId(userIdTF.getText());
			if((passPF.getText()).equals(con_passPF.getText())) 
			{u.setPassword(passPF.getText());
			u.setStatus(1);}
			else {JOptionPane.showMessageDialog(this, "Password Didn't Matched");}
			
				
			cr.insertCustomer(c);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+userIdTF.getText()+"and Password: "+(passPF.getText()));
			
			userIdTF.setText("");
			nameTF.setText("");
			phoneTF.setText("");
			}
			catch (NullPointerException ne){
			System.out.println("NullPointerException");
		}
		
		}
		else{}
	}
}