package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entity.*;
import repository.*;

public class Movie extends JFrame implements ActionListener
{
	private JLabel wl,nameLabel, passL, backImgLabel;
	private JTextField nameTF;
	private JPasswordField passPF;
	private JButton contact,loginBtn, signupBtn;
    private Color color;
	private Font myFont,m2;
	private ImageIcon backImg;
	private JPanel panel;
	
	public Movie()
	{
		super("Movie Theater");
		this.setSize(1300,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		color = new Color(0,0,0);
		myFont = new Font("Consolas", Font.ITALIC | Font.BOLD, 130);
		m2 = new Font("Consolas", Font.ITALIC | Font.BOLD, 20);
		
		panel = new JPanel();
		panel.setLayout(null); 
		
		
		wl = new JLabel("WELCOME TO MOVIES");
		wl.setBounds(30,80,1250,110);
		wl.setFont(myFont);
	    wl.setForeground(Color.WHITE);
		wl.setBackground(color);
		wl.setOpaque(true);
		panel.add(wl);
		
		
		nameLabel = new JLabel("User ID:");
		nameLabel.setBounds(270,260, 120, 30);
		nameLabel.setFont(m2);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBackground(color);
		nameLabel.setOpaque(true);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(410,260,120,30);
		panel.add(nameTF);
		
		
		passL = new JLabel("Password:");
		passL.setBounds(700, 260, 120, 30);
		passL.setFont(m2);
		passL.setForeground(Color.WHITE);
		passL.setBackground(color);
		passL.setOpaque(true);
		panel.add(passL);
		
		passPF = new JPasswordField();
		passPF.setBounds(835,260,120,30);
		panel.add(passPF);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(570, 340, 120, 30);
		loginBtn.setBackground(color);
		loginBtn.setForeground(Color.WHITE);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		signupBtn = new JButton("Sign UP");
		signupBtn.setBounds(570, 400, 120,30);
		signupBtn.setBackground(color);
		signupBtn.setForeground(Color.WHITE);
		signupBtn.addActionListener(this);
		panel.add(signupBtn);
		
		contact = new JButton("Contact");
		contact.setBounds(611, 900,78,15);
		contact.setBackground(color);
		contact.setForeground(Color.WHITE);
		contact.addActionListener(this);
		panel.add(contact);
		
		
		backImg = new ImageIcon("org.jpg");
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
		
		if(command.equals(contact.getText()))
		{
            Contact c = new Contact();
			c.setVisible(true);
			this.setVisible(false);
			
		}
		else if (command.equals(loginBtn.getText()))
		{   UserRepo ur = new UserRepo();
	User user = ur.getUser(nameTF.getText(), passPF.getText());
	if(user != null)
	{
		if(user.getStatus() == 0)
			{
					EmployeeHome eh = new EmployeeHome();
					eh.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 1)
				{
					SelectMovie sm = new SelectMovie();
					sm.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 2)
				{
					ManagerHome ue = new ManagerHome();
			          ue.setVisible(true);
			         this.setVisible(false);
				}
			else{}
			
		}
		else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
		}
		else if (command.equals(signupBtn.getText()))
		{
			CreateCustomer cc= new CreateCustomer();
			cc.setVisible(true);
			this.setVisible(false);
		}
		else{}
	
	}

	
}






