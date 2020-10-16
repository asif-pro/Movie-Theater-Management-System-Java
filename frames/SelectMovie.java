package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entity.*;
import frames.*;
import repository.*;


public class SelectMovie extends JFrame implements ActionListener {
	private JLabel movienameLabel,showtimeLabel,tickeLabel,backImgLabel;
	private JButton  proceedBtn, logoutBtn, accountBtn;
	private JComboBox combo;
	private JPanel panel;
	private ImageIcon backImg;
	private Color color;
	private ButtonGroup bg;
	private JRadioButton r1, r2, r3;
	String items[];
	
	public SelectMovie()
	{
		super("Select Movie");
		this.setSize(1300,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.setResizable(false);
		
		
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
		movienameLabel = new JLabel("MOVIE NAME:");
		movienameLabel.setBounds(400,200, 100, 40);
		movienameLabel.setBackground(Color.BLACK);
		movienameLabel.setForeground(Color.WHITE);
		panel.add(movienameLabel);
		
		
		showtimeLabel = new JLabel("SHOW-TIME:");
		showtimeLabel.setBounds(400,250, 100, 40);
		showtimeLabel.setBackground(Color.BLACK);
		showtimeLabel.setForeground(Color.WHITE);
		panel.add(showtimeLabel);
		
		tickeLabel = new JLabel("TICKET:");
        tickeLabel.setBounds(400,350, 100, 40);
		tickeLabel.setBackground(Color.BLACK);
		tickeLabel.setForeground(Color.WHITE);
		panel.add(tickeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(1180, 0, 100, 50);
		logoutBtn.setBackground(Color.GRAY);
		logoutBtn.setForeground(Color.BLACK);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
	
		proceedBtn = new JButton("Proceed");
		proceedBtn.setBounds(550, 500, 100, 30);
		proceedBtn.setBackground(Color.BLACK);
		proceedBtn.setForeground(Color.WHITE);
		proceedBtn.addActionListener(this);
		panel.add(proceedBtn);
		
		accountBtn = new JButton("Account");
		accountBtn.setBounds(20, 0, 100, 50);
		accountBtn.setBackground(Color.GRAY);
		accountBtn.setForeground(Color.BLACK);
		accountBtn.addActionListener(this);
		panel.add(accountBtn);
		
		r1 = new JRadioButton("one");
		r1.setBounds(550, 350, 80, 30);
		panel.add(r1);
		
		
		r2 = new JRadioButton("two");
		r2.setBounds(550, 390, 80, 30);
		panel.add(r2);
		
		r3 = new JRadioButton("three");
		r3.setBounds(550, 430, 80, 30);
		panel.add(r3);
		
		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		
		
		String items[] = {"DEADPOOL", "AVATOR", "LOGAN", "BEAUTY AND THE BEAST"};
		
		
		combo = new JComboBox(items);
		combo.setBounds(550,200, 130, 40);
		panel.add(combo);
		
        backImg = new ImageIcon("sm.jpg");
		Image rawImage = backImg.getImage();
		Image resizedImage = rawImage.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
		
		backImg = new ImageIcon(resizedImage);
		backImgLabel = new JLabel(backImg);
		backImgLabel.setBounds(0,0, 1300, 1000);
		panel.add(backImgLabel);

		
		this.add(panel);
		
		}
		
    public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
	  if(command.equals(proceedBtn.getText()))
		{
		//JOptionPane.showMessageDialog(this, "procedure Complete");
		 ShowDetails sdg= new ShowDetails();
		sdg.setVisible(true);
		this.setVisible(false);
		}
		else if(command.equals(logoutBtn.getText()))
		{
			Movie mv = new Movie();
	     mv.setVisible(true);
		this.setVisible(false);
		}
		else if(command.equals(accountBtn.getText()))
			{

		 Changepassword cp = new Changepassword();
	     cp.setVisible(true);
		this.setVisible(false);
			
		}
		else{}
	
	
}
}

