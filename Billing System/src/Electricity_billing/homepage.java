package Electricity_billing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;

    public class homepage extends JFrame implements ActionListener {
        JLabel l1;
	homepage()
	{
		setTitle("Electricity billing system");
		setSize(1600,690);
		ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("Electricity_billing/image/npcl.png"));
		Image i3=i2.getImage().getScaledInstance(1600,690,Image.SCALE_DEFAULT);
        ImageIcon icc=new ImageIcon(i3);
		l1=new JLabel(icc);
		add(l1);
		JMenuBar mb=new JMenuBar();
		JMenu master=new JMenu("Master");
		JMenuItem mi1=new JMenuItem("New Customer");
		JMenuItem mi2=new JMenuItem("Customer Details");
		
		master.setForeground(Color.BLUE);
		Font f=new Font("monospaced",Font.PLAIN,16);
		mi1.setFont(f);
                ImageIcon img_mi1=new ImageIcon(ClassLoader.getSystemResource("Electricity_billing/image/logo1.png"));
                Image image_mi1=img_mi1.getImage().getScaledInstance(16,20,Image.SCALE_DEFAULT);
                mi1.setIcon(new ImageIcon(image_mi1));
		mi1.setBackground(Color.WHITE);
		
		mi2.setFont(f);
                ImageIcon img_mi2=new ImageIcon(ClassLoader.getSystemResource("Electricity_billing/image/logo7.png"));
                Image image_mi2=img_mi2.getImage().getScaledInstance(16,20,Image.SCALE_DEFAULT);
                mi2.setIcon(new ImageIcon(image_mi2));
                mi2.setBackground(Color.WHITE);
		
                mi1.addActionListener(this);
		mi2.addActionListener(this);
		//second column
		JMenu user=new JMenu("user");
		JMenuItem ui1=new JMenuItem("Pay bill");
		ui1.setFont(f);
		ui1.setBackground(Color.WHITE);
		ui1.addActionListener(this);
		
		JMenu report=new JMenu("Report");
		JMenuItem r1=new JMenuItem("Generate Bill");
		r1.setFont(f);
		r1.addActionListener(this);
		
		
		JMenu exit=new JMenu("Exit");
		JMenuItem ex=new JMenuItem("Exit");
		ex.setFont(f);
		ex.setBackground(Color.WHITE);
		ex.addActionListener(this);
		
		master.add(mi1);
		master.add(mi2);
		
		user.add(ui1);
		
		report.add(r1);
		
		exit.add(ex);
		mb.add(master);
		mb.add(user);
		mb.add(report);
		mb.add(exit);
		
		setJMenuBar(mb);
		
		setFont(new Font("Senserif",Font.BOLD,16));
		setLayout(new FlowLayout());
		setVisible(false);
	}
	public void actionPerformed(ActionEvent ev)
	{
		String msg=ev.getActionCommand();
		if(msg.equals("New Customer"))
		{
			new new_customer().setVisible(true);
		}
                else if(msg.equals("Customer Details"))
                {
                    new customer_details().setVisible(true);
                }
		else if(msg.equals("Pay bill"))
		{
			new pay_bill().setVisible(true);
		}
		else if(msg.equals("Generate Bill"))
		{
			new generate_bill().setVisible(true);
		}
		else if(msg.equals("Exit"))
		{
			System.exit(0);
		}
		else
		{
			System.out.println("Wrong");
		}
	}
	public static void main(String args[])
	{
		new homepage().setVisible(true);
	}    
}
