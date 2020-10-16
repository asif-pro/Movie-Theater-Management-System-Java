package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import repository.*;
import entity.*;


public class Updateemployee extends JFrame implements ActionListener
{
	private JLabel empIdLabel, empNameLabel, empDesignationLabel, empSalaryLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF, empSalaryTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, backBtn,logoutBtn;
	private JPanel panel;
	private JTable empTable;
	
	private User user;
	private EmployeeRepo er;
	private UserRepo ur;

	
	
	public Updateemployee(User user)
	{
		super("Updateemployee");
		this.setSize(1300,1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		er = new EmployeeRepo();
		ur = new UserRepo();
		
	
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
		
	
		empIdLabel = new JLabel("Employee ID :");
		empIdLabel.setBounds(100,100,100,30);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(220,100,100,30);
		panel.add(empIdTF);
		
		empNameLabel = new JLabel("Employee Name :");
		empNameLabel.setBounds(100,150,100,30);
		panel.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(220,150,100,30);
		panel.add(empNameTF);
		
		empDesignationLabel = new JLabel("Employee Designation: ");
		empDesignationLabel.setBounds(100,200,200,30);
		panel.add(empDesignationLabel);
		
		empDesignationTF = new JTextField();
		empDesignationTF.setBounds(220,200,100,30);
		panel.add(empDesignationTF);
		
		empSalaryLabel = new JLabel("Employee Salary: ");
		empSalaryLabel.setBounds(100,250,100,30);
		panel.add(empSalaryLabel);
		
		empSalaryTF = new JTextField();
		empSalaryTF.setBounds(220,250,100,30);
		panel.add(empSalaryTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,500,80,30);
		loadBtn.addActionListener(this);
	    loadBtn.setBackground(Color.BLACK);
		loadBtn.setForeground(Color.WHITE);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,500,80,30);
		insertBtn.addActionListener(this);
		insertBtn.setBackground(Color.BLACK);
		insertBtn.setForeground(Color.WHITE);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,500,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		updateBtn.setBackground(Color.BLACK);
		updateBtn.setForeground(Color.WHITE);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,500,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		deleteBtn.setBackground(Color.BLACK);
		deleteBtn.setForeground(Color.WHITE);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,500,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setBackground(Color.BLACK);
		refreshBtn.setForeground(Color.WHITE);
		panel.add(refreshBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600,600,100,50); 
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.WHITE);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
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
         Movie m23 = new Movie();
	     m23.setVisible(true);
		this.setVisible(false);
			
		}
		else if (command.equals(backBtn.getText()))
			{
        ManagerHome mh = new ManagerHome();
	     mh.setVisible(true);
		this.setVisible(false);
		}
		
		else if(command.equals(loadBtn.getText()))
		{
			if(!empIdTF.getText().equals("") || !empIdTF.getText().equals(null))
			{
				Employee e = er.searchEmployee(empIdTF.getText());
				if(e!= null)
				{
					empNameTF.setText(e.getName());
					empDesignationTF.setText(e.getDesignation());
					empSalaryTF.setText(e.getSalary()+"");
					
					empIdTF.setEnabled(false);
					empNameTF.setEnabled(true);
					empDesignationTF.setEnabled(true);
					empSalaryTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Employee e = new Employee();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			e.setEmpId(empIdTF.getText());
			e.setName(empNameTF.getText());
			e.setDesignation(empDesignationTF.getText());
			e.setSalary(Double.parseDouble(empSalaryTF.getText()));
			
			u.setUserId(empIdTF.getText());
			u.setPassword(x+"");
			
		    u.setStatus(0);
			
			
			er.insertInDB(e);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+empIdTF.getText()+"and Password: "+x);
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			empIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
			else if(command.equals(updateBtn.getText()))
		{
			Employee e = new Employee();
			
			e.setEmpId(empIdTF.getText());
			e.setName(empNameTF.getText());
			e.setDesignation(empDesignationTF.getText());
			e.setSalary(Double.parseDouble(empSalaryTF.getText()));
			
			er.updateInDB(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
			empSalaryTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			er.deleteFromDB(empIdTF.getText());
			ur.deleteUser(empIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
			empSalaryTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		
		else {}
	
	}
	
}

		