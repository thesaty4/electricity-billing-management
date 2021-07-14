
package Electricity_billing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class pay_bill extends JFrame implements ActionListener{
 JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	JTextArea t1;
	Choice c1,c2;
	JPanel p,p1;
	Font f,f1;
	pay_bill()
	{
		super("Pay bill");
		setSize(1000,400);
		setLocation(200,200);
		setResizable(false);
		f=new Font("rockwell",Font.BOLD,17);
                f1=new Font("rockwell",Font.ITALIC,30);
		l1=new JLabel("Meter Number");
		l2=new JLabel("Month");
		l3=new JLabel("Units Consumed");
		l5=new JLabel("Calculates Electricity Bill");
		l5.setHorizontalAlignment(JLabel.CENTER);
		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		l5.setFont(f1);
		
		c1=new Choice();
		
		try {
			connectionclass ob = new connectionclass();
			ResultSet data = ob.stm.executeQuery("select `meterno` from `customer_info`");
			while(data.next()) {
				c1.add(data.getString(1));
			}
		}catch(Exception e) {
			System.out.print("Connection problem");
		}               
		
		c1.setFont(f);
		
		c2=new Choice();
		c2.add("January");
		c2.add("Febuary");
		c2.add("March");
		c2.add("April");
		c2.add("May");
		c2.add("June");
		c2.add("July");
		c2.add("August");
		c2.add("September");
		c2.add("October");
		c2.add("November");
		c2.add("December");
		
		c2.setFont(f);
		t1=new JTextArea();
		t1.setFont(f);
		
		b1=new JButton("Submit");
		b2=new JButton("Cancle");
		
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		b1.setFont(f);
		b2.setFont(f);
		
		b1.setSize(50,50);
		p=new JPanel();
		p.setLayout(new GridLayout(4,2,30,30));

		p.add(l1);
		p.add(c1);
		p.add(l2);
		p.add(c2);
		p.add(l3);
		p.add(t1);
		p.add(b1);
		p.add(b2);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,1));
		ImageIcon ig=new ImageIcon(ClassLoader.getSystemResource("Electricity_billing/image/logo3.jpeg"));
		Image img=ig.getImage().getScaledInstance(270,270,Image.SCALE_DEFAULT);
		ImageIcon ig2=new ImageIcon(img);
		l4=new JLabel(ig2);
		p1.add(l4);
		
		setLayout(new BorderLayout(30,30));
		
		add(l5,"North");
		add(p1,"West");
		add(p,"Center");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource()==b1)
		{
			try
			{
				connectionclass obj=new connectionclass();
				String meterno=c1.getSelectedItem();
				String month=c2.getSelectedItem();
				// This query for checking data already available of not...........
				ResultSet billingData = obj.stm.executeQuery("select * from `bill` where `meterno`="+meterno+" and `month` = '"+month+"'");
				if(billingData.next()) {
					JOptionPane.showMessageDialog(null, "This data already exists..", "Warning", JOptionPane.WARNING_MESSAGE);
				}else {
					int units=Integer.parseInt(t1.getText());
					int amount=(units*7)+98+42+112+48;
					String q="insert into bill value('"+month+"','"+units+"','"+amount+"','"+meterno+"')";
					obj.stm.executeUpdate(q);
					JOptionPane.showMessageDialog(null,"Data succesfull inserted\n --------------------------------"+"\n Meter Number = "+meterno+"\n Units = "+units+"\n Amount = "+amount);
					setVisible(false);
				}
				
			}
			catch(Exception ex)
			{
				// if field is empty then exception occured..................
				JOptionPane.showMessageDialog(null, "All Field Required", "Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(ev.getSource()==b2)
		{
			JOptionPane.showMessageDialog(null,"You pressed cancel......");
			setVisible(false);
		}
	}
	public static void main(String args[])
	{
		new pay_bill().setVisible(true);
	}   
}
