
package Electricity_billing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class loginpage extends JFrame implements ActionListener
{     
  JLabel l1,l2,l3;
  JTextField t1;
  JButton b1,b2;
  JPanel p1,p2,p3,p4;
  JPasswordField t2;
  loginpage()
   {
	super("Admin Login");
	setSize(400,250);
	setResizable(false);
	setLocation(500,250);
       /* ImageIcon img1=new ImageIcon("Electricity_billing/image/screen2.jpg");
        setIconImage(img1.getImage());*/
        
	l1=new JLabel("username");
	l2=new JLabel("password");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Electricity_billing/image/login.png"));
        Image img=i1.getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
	l3=new JLabel(i2);
	t1=new JTextField(14);
	t2=new JPasswordField(14);
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("Electricity_billing/image/logo7.png"));
        Image img2=i3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        b1=new JButton("Login",new ImageIcon(img2));
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Electricity_billing/image/logo8.png"));
        Image img3=i4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2=new JButton("Cancle",new ImageIcon(img3));
        
					 
	Font f;
        f =new Font("Arial",Font.BOLD,16);
	l1.setFont(f);
	l2.setFont(f);
	b1.setFont(f);
	b2.setFont(f);
	t1.setFont(f);
	t2.setFont(f);
					 
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	setLayout(new BorderLayout());
	p2.add(l1);
	p2.add(t1);
	p2.add(l2);
	p2.add(t2);
	add(p2,BorderLayout.CENTER);
	p1.add(l3);
	add(p1,BorderLayout.WEST);
	p3.add(b1);
        p3.add(b2);
	add(p3,BorderLayout.SOUTH);
					 
	b1.addActionListener(this);
	b2.addActionListener(this);
      }
				
	public void actionPerformed(ActionEvent ev) 
	{
	  try {
						
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","");
						
		if(ev.getSource()==b1)
		{
		  String name=t1.getText();
		  String pass = t2.getText();
		  String q="select * from login_info where usr='"+name+"' and passwd='"+pass+"'";
		  Statement stm=cn.createStatement();
		  ResultSet set=stm.executeQuery(q);
		  if(set.next())
		    {
			new homepage().setVisible(true);
			this.setVisible(false);
		    }
		   else
		    {
		      JOptionPane.showMessageDialog(null,"invalid login");
		      setVisible(false);
		    }
		}	
		else
		{
			this.setVisible(false);
			new mainPage().setVisible(true);
		}
	      }
				
		catch(Exception e)
		{
		 e.printStackTrace();
		 System.out.println("Error.........");
		}
	}
				
	public static void main(String s[])
	{
	  new loginpage().setVisible(true);
	}    
}
