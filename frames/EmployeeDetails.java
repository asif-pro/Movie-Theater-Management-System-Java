package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entity.*;
import frames.*;
import repository.*;
public class EmployeeDetails extends JFrame implements ActionListener{
	private JLabel empidLabel, empnameLabel, changepassLabel, designationLabel, salaryLabel,confirmpassLabel;
	private JTextField empidTF;
	private JTextField empnameTF;
	private JTextField designationTF;
	private JPasswordField changepassPF;
	private JPasswordField confirmpassPF;
	private JTextField salaryTF;
	private JButton backBtn,logoutBtn,confirm;
	private JComboBox combo;
	private Color color;
	private JPanel panel;
	public EmployeeDetails()
	{
		super("EmployeeDetails");
		this.setSize(1300,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
		empidLabel = new JLabel("Emp Id:");
		empidLabel.setBounds(400,100, 100, 40);
		empidLabel.setBackground(Color.GRAY);
		empidLabel.setOpaque(true);
		panel.add(empidLabel);
		
		empidLabel = new JLabel(" ");
		empidLabel.setBounds(550,100,130,40);
		empidLabel.setBackground(Color.GRAY);
		empidLabel.setOpaque(true);
		panel.add(empidLabel);
		
		
		empnameLabel = new JLabel("Emp Name:");
		empnameLabel.setBounds(400,170, 100, 40);
		empnameLabel.setBackground(Color.GRAY);
		empnameLabel.setOpaque(true);
		panel.add(empnameLabel);
		
		empnameLabel = new JLabel(" ");
		empnameLabel.setBounds(550,170,130,40);
		empnameLabel.setBackground(Color.GRAY);
		empnameLabel.setOpaque(true);
		panel.add(empnameLabel);
		
		
		changepassLabel = new JLabel("Change Password:");
		changepassLabel.setBounds(400,240, 140, 40);
		changepassLabel.setBackground(Color.GRAY);
		changepassLabel.setOpaque(true);
		panel.add(changepassLabel);
		
		changepassPF = new JPasswordField();
		changepassPF.setBounds(560,240,130,40);
		panel.add(changepassPF);
		
		
		confirmpassLabel = new JLabel("Confirm Password:");
		confirmpassLabel.setBounds(400,310, 140, 40);
		confirmpassLabel.setBackground(Color.GRAY);
		confirmpassLabel.setOpaque(true);
		panel.add(confirmpassLabel);
		
		confirmpassPF = new JPasswordField();
		confirmpassPF.setBounds(560,310,130,40);
		panel.add(confirmpassPF);
		
		
		designationLabel = new JLabel("Designation:");
		designationLabel .setBounds(400,380, 150, 40);
		designationLabel.setBackground(Color.GRAY);
		panel.add(designationLabel );
		
		
		
		salaryLabel = new JLabel("Emp Salary:");
	    salaryLabel.setBounds(400, 450, 150, 40);
		salaryLabel.setBackground(Color.GRAY);
		panel.add(salaryLabel);
		
		salaryLabel = new JLabel(" ");
		salaryLabel.setBounds(500,450,130,40);
		salaryLabel.setBackground(Color.GRAY);
		panel.add(salaryLabel);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(0, 0, 100, 50);
		backBtn.setBackground(Color.GRAY);
		backBtn.setForeground(Color.BLACK);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		confirm = new JButton("Confirm");
		confirm.setBounds(600, 490, 100, 50);
		confirm.setBackground(Color.BLACK);
		confirm.setForeground(Color.WHITE);
		confirm.addActionListener(this);
		panel.add(confirm);
		
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(1180, 0, 100, 50);
		logoutBtn.setBackground(Color.GRAY);
		logoutBtn.setForeground(Color.BLACK);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		String items[] = {"Manager", "Engineer", "Customer", "Assistant"};
		
		combo = new JComboBox(items);
		combo.setBounds(560,380, 130, 40);
		panel.add(combo);
		
		
		
		this.add(panel);
	}
		 public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
         Movie mv = new Movie();
	     mv.setVisible(true);
		this.setVisible(false);
			
		}
		else if (command.equals(backBtn.getText()))
			{
       EmployeeHome eh = new EmployeeHome();
		eh.setVisible(true);
		this.setVisible(false);
			}
			else if (command.equals(confirm.getText()))
			{JOptionPane.showMessageDialog(this, "Password Changed Successfully");
       EmployeeHome eh = new EmployeeHome();
		eh.setVisible(true);
		this.setVisible(false);
			}
			else{}
	}	
}
