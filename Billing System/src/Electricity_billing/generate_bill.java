package Electricity_billing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class generate_bill extends JFrame implements ActionListener{
 JLabel l1,l2;
 JButton b1,b2;
 JTextArea t1;
 Choice c1,c2;
 JPanel p,p1;
 Font f;
 generate_bill()
 {
     super("Generate Bill");
     setSize(450,700);
     setResizable(false);
     setLocation(20,20);
     p=new JPanel();
     f=new Font("senserif",Font.BOLD,16);
     p1=new JPanel();
     l1=new JLabel("meter_no");
     l2=new JLabel("month");
     l2.setFont(f);
     l1.setFont(f);
     
     c1=new Choice();
     connectionclass ob=new connectionclass();
	 String q="SELECT `meterno` FROM `customer_info`";
	 try {
		 ResultSet set = ob.stm.executeQuery(q);
		 //Dynamic data adding on choice button....
		 while(set.next()) {
			 c1.add(set.getString(1));
//			 System.out.print(set.getString(1));
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
     c1.setFont(f);
		
	c2=new Choice();
	c2.add("january");
	c2.add("febuary");
	c2.add("march");
	c2.add("april");
	c2.add("may");
	c2.add("june");
	c2.add("july");
	c2.add("august");
	c2.add("september");
	c2.add("october");
	c2.add("november");
	c2.add("december");
		
	c2.setFont(f);
                
               t1=new JTextArea(50,15);
               t1.setFont(f);
               ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Electricity_billing/image/logo7.png"));
		Image img1=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(img1);
                b1=new JButton("PRINT",i2);
                
                ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("Electricity_billing/image/logo2.png"));
		Image img2=i3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
		ImageIcon i4=new ImageIcon(img2);
                b2=new JButton("SHOW",i4);
                b1.setFont(f);
                b2.setFont(f);
                setLayout(new BorderLayout());
                p.add(l1);
                p.add(c1);
                p.add(l2);
                p.add(c2);
                
                add(p,"North");
                p1.add(b1);
                p1.add(b2);
                add(p1,"South");
                add(t1);
                JScrollPane sp=new JScrollPane(t1);
                add(sp);
                b1.addActionListener(this);
                b2.addActionListener(this);
 }
 public void actionPerformed(ActionEvent ev)
 {
     if(ev.getSource()==b2)
     {
         String meterno=c1.getSelectedItem();
         String month=c2.getSelectedItem();
         t1.setText("\tNoida Power Company Limited\nELECTRICITY BILL FOR THE MONTH OF "+month+",2020\n\n");
         try
         {
             connectionclass con=new connectionclass();
             String q1="select * from customer_info where meterno ='"+meterno+"'";
             ResultSet rset2=con.stm.executeQuery(q1);
             while(rset2.next())
             {
                 t1.append("\nName :"+rset2.getString("name"));
                 t1.append("\nMeter_number :"+rset2.getString("meterno"));
                 t1.append("\nAddress :"+rset2.getString("address"));
                 t1.append("\nState :"+rset2.getString("state"));
                 t1.append("\nCity :"+rset2.getString("city"));
                 t1.append("\nEmail :"+rset2.getString("email"));
                 t1.append("\nPhone :"+rset2.getString("phone"));
             }
             t1.append("\n------------------------------------------------------------------------");
             String q2="select * from tax";
             ResultSet rset3=con.stm.executeQuery(q2);
             while(rset3.next())
             {
                 t1.append("\nMeter location :"+rset3.getString("meter_location"));
                 t1.append("\nMeter type :"+rset3.getString("meter_type"));
                 t1.append("\nPhase code :"+rset3.getString("phase_code"));
                 t1.append("\nBill type :"+rset3.getString("bill_type"));
                 t1.append("\nMonth :"+rset3.getString("month"));
                 t1.append("\nDivision name :"+rset3.getString("division_name"));
                 
                 t1.append("\n\n--------------------------------------------------------------------");
                 t1.append("\nMeter rent :"+rset3.getString("meter_rent"));
                 t1.append("\nService rent :"+rset3.getString("service_rent"));
                 t1.append("\nGST :"+rset3.getString("gst"));
                 t1.append("\nMCB rent :"+rset3.getString("mcb_rent"));
             }
             t1.append("\n");
             String q="select * from bill where meterno ='"+meterno+"' and month='"+month+"'";
             ResultSet rset4=con.stm.executeQuery(q);
             
             if(rset4.next()) {
            	 ResultSet rset41=con.stm.executeQuery(q);
            	 while(rset41.next())
            	 {
            		 t1.append("\nMeter no : "+rset41.getString("meterno"));
            		 t1.append("\nCurrent Month : "+rset41.getString("month"));
            		 t1.append("\nUnits Consumed : "+rset41.getString("units"));
            		 t1.append("\ncharges : "+rset41.getString("amount"));
            		 t1.append("\n\n--------------------------------------------------------------------------");
            		 t1.append("\nTotal PAYBILL : "+rset41.getString("amount"));
            		 t1.append("\n\n\n Please Update Your Mobile Number You Can Pay \nyour Bill Online at Nearest JAN SUVIDHA KENDRA");
            		 t1.setForeground(Color.black);
            	 }
             }else {
            	 t1.append(" \n Please pay your due bill ! \n There are no any record found !"+"\n+-----------------------------------------------------------------------+");
                 t1.setForeground(Color.red);
             }
         }
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
     }
     if(ev.getSource()==b1)
     {
         try
         {
             t1.print();
         }
         catch(Exception exc)
         {
             exc.printStackTrace();
         }
     }
 }
   public static void main(String args[])
   {
    new generate_bill().setVisible(true);
   }
             
 }


