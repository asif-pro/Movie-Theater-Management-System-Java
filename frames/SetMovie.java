package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import repository.*;
import entity.*;
import entity.*;
import repository.*;


public class SetMovie extends JFrame implements ActionListener
{
	private JLabel MNLabel, MovTimeLabel,TicketLabel;
	private JTextField MNTF,MovTimeTF,TicketTF;
	private JButton loadBtn,prevBtn,logoutBtn,insertBtn,updateBtn,deleteBtn,refreshBtn ;
	private Color backColor;
    private JPanel panel;
	private MovieRepo mr;
	
	public SetMovie()
	{
		super("Set movie");
		this.setSize(1300,1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mr = new MovieRepo();

		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
		MNLabel = new JLabel("Movie Name :");
		MNLabel.setBounds(300, 150, 250, 30);
		panel.add(MNLabel); 
		
		MNTF = new JTextField();
		MNTF.setBounds(600, 150, 250, 30);
		panel.add(MNTF);
		
		MovTimeLabel = new JLabel("Show Time :");
		MovTimeLabel.setBounds(300, 250, 250, 30);
		panel.add(MovTimeLabel); 
		
		MovTimeTF = new JTextField();
		MovTimeTF.setBounds(600, 250, 250, 30);
		panel.add(MovTimeTF); 
		
		TicketLabel = new JLabel("Tickets :");
		TicketLabel.setBounds(300, 350, 250, 30);
		panel.add(TicketLabel); 
		
		TicketTF= new JTextField();
		TicketTF.setBounds(600, 350, 250, 30);
		panel.add(TicketTF);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(1180, 0, 100, 50);
		logoutBtn.addActionListener(this);
		logoutBtn.setBackground(Color.GRAY);
		logoutBtn.setForeground(Color.BLACK);
		panel.add(logoutBtn);
		
		prevBtn = new JButton("Previous");
		prevBtn.setBounds(250, 600, 100, 30);
		prevBtn.addActionListener(this);
		prevBtn.setBackground(Color.BLACK);
		prevBtn.setForeground(Color.WHITE);
		panel.add(prevBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(400, 600, 100, 30);
		refreshBtn.addActionListener(this);
		refreshBtn.setBackground(Color.BLACK);
		refreshBtn.setForeground(Color.WHITE);
		panel.add(refreshBtn);
		  
		loadBtn = new JButton("Load");
		loadBtn.setBounds(550, 600, 100, 30);
		loadBtn.addActionListener(this);
		loadBtn.setBackground(Color.BLACK);
		loadBtn.setForeground(Color.WHITE);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(700,600,100,30);
		insertBtn.addActionListener(this);
		insertBtn.setBackground(Color.BLACK);
		insertBtn.setForeground(Color.WHITE);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(850,600,100,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		updateBtn.setBackground(Color.BLACK);
		updateBtn.setForeground(Color.WHITE);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(1000,600,100,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		deleteBtn.setBackground(Color.BLACK);
		deleteBtn.setForeground(Color.WHITE);
		panel.add(deleteBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(ae.getSource()== prevBtn)
		{
		EmployeeHome mh1 = new EmployeeHome();
	     mh1.setVisible(true);
		this.setVisible(false);
		}
		
		
		else if(command.equals(logoutBtn.getText()))
		{
		Movie mv = new Movie();
		mv.setVisible(true);
		this.setVisible(false);
		} 
		else if(command.equals(loadBtn.getText()))
		{
			if(!MNTF.getText().equals("") || !MNTF.getText().equals(null))
			{
				MovieE m = mr.getMovie(MNTF.getText());
				if(m!= null)
				{
					MovTimeTF.setText(m.getShowtime());
					TicketTF.setText(m.getTicket()+"");
					
					
					MNTF.setEnabled(false);
					MovTimeTF.setEnabled(true);
					TicketTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Movie");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			MovieE m = new MovieE();
			
			m.setMovieName(MNTF.getText());
			m.setShowtime(MovTimeTF.getText());
			m.setTicket(Integer.parseInt(TicketTF.getText()));
			
			
			mr.insertMovie(m);
			
			JOptionPane.showMessageDialog(this, "Inserted, Movie: "+MNTF.getText());
			
			MNTF.setText("");
			MovTimeTF.setText("");
			TicketTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			MNTF.setText("");
			MovTimeTF.setText("");
			TicketTF.setText("");
			
			MNTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			MovieE e = new MovieE();
			
			e.setMovieName(MNTF.getText());
			e.setShowtime(MovTimeTF.getText());
			e.setTicket(Integer.parseInt(TicketTF.getText()));
			
			mr.updateMovie(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			MNTF.setText("");
			MovTimeTF.setText("");
			TicketTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			MNTF.setEnabled(true);
			MovTimeTF.setEnabled(true);
			TicketTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			mr.deleteMovie(MNTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			MNTF.setText("");
			MovTimeTF.setText("");
			TicketTF.setText("");
			
			MNTF.setEnabled(true);
			MovTimeTF.setEnabled(true);
			TicketTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else{}
		
	}
}