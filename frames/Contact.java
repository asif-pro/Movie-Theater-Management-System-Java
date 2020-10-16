package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entity.*;
import frames.*;
import repository.*;

public class Contact extends JFrame implements ActionListener
{
	private JLabel display,r,e,b,p,bimgLabel;
	private JButton home;
	private Color color;
	private ImageIcon bimg;
	private JPanel panel;

	public Contact()
	{
		super("Contact");
		this.setSize(1300,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null); 

		color = new Color(192,192,192);
		
		
		home = new JButton("<Home");
	    home.setBounds(0,0,80,50);
		home.setBackground(color);
		home.setForeground(Color.BLACK);
		home.addActionListener(this);
		panel.add(home);

		display = new JLabel("         MOVIE THEATER");
		display.setBounds(560,350,140,30);
	    display.setForeground(Color.BLACK);
	    display.setBackground(color);
		display.setOpaque(true);
		panel.add(display);
		
		r = new JLabel(" 333-A,XYZ Road,Dhaka");
		r.setBounds(560,380,140,30);
	    r.setForeground(Color.BLACK);
		r.setBackground(color);
		r.setOpaque(true);
		panel.add(r);
		
		b = new JLabel("            Bangladesh");
		b.setBounds(560,410,140,30);
	    b.setForeground(Color.BLACK);
		b.setBackground(color);
		b.setOpaque(true);
		panel.add(b);
		
		 p= new JLabel(" Phone: +88013 333 333");
		p.setBounds(560,440,140,30);
	    p.setForeground(Color.BLACK);
		p.setBackground(color);
		p.setOpaque(true);
		panel.add(p);
		
		
		e = new JLabel("  Email: mvtr@mv.com");
		e.setBounds(560,470,140,30);
	    e.setForeground(Color.BLACK);
		e.setBackground(color);
		e.setOpaque(true);
		panel.add(e);
		
		
	
		
		
		
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
		
		if(command.equals(home.getText()))
		{   Movie mv = new Movie ();
			mv.setVisible(true);
			this.setVisible(false);
		}
else {}
		
	}

}