
import java.awt.*;  
import javax.swing.*;
import java.awt.event.*;  
import java.sql.*;

public class Secondpage extends JFrame implements ActionListener
{  
	Connection con;
    Statement stmt;
	private TextField tf,t1;  
    private Container c;
	private JButton b1,b2,b3,b4,b5;
	private JLabel l,l2,l3;
	public JComboBox<String> combo1;

	public Secondpage()
	{  	  
		connect();
	    c = getContentPane();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,190,900,600);
		setLocationRelativeTo(null);
		
		
		l = new JLabel("Animal Name :");
		l.setBounds(0,50,170,20);
		l.setFont(new Font("Serif",Font.BOLD,18));
		l.setForeground(Color.black);
		
		
		tf=new TextField();
		tf.setEditable(false);
		tf.setBounds(140,50,170,20);
		
		l2=new JLabel("Features Des.:");
		l2.setBounds(0,100,170,20);
		l2.setFont(new Font("Serif",Font.BOLD,20));

		t1=new TextField();
		t1.setEditable(false);
		t1.setBounds(140,105,250,20);

		l3=new JLabel("Features names :");
		l3.setBounds(0,160,220,20);
		l3.setFont(new Font("Serif",Font.BOLD,20));

		
		String features[]={"physical","eat","height","ear","skin"}; 
		combo1 = new JComboBox<>(features);
		combo1.setEditable(true);
		combo1.setBounds(150,160,170,20);

	
		b1=new JButton("Display");  
		b1.setBounds(200,250,100,20);  
		b1.addActionListener(this);	
		
		b2=new JButton("Insertion page");  
		b2.setBounds(550,100,130,20); 
		b2.addActionListener(this); 
		
		b3=new JButton("Updation page");  
		b3.setBounds(550,130,130,20);  
		b3.addActionListener(this);

		
		b4=new JButton("Deletion page");  
		b4.setBounds(550,160,130,20); 
		b4.addActionListener(this);


		b5 = new JButton("Go Back");
		b5.setSize(130,20); 
		b5.setLocation(550,190);
		b5.addActionListener(this);	
		
		Color r1 = new Color(142, 183, 230);
		
		
		c.add(b1); c.add(l3); 
        c.add(tf); c.add(t1); 
		c.add(l); c.add(combo1);
		c.add(l2);
		c.add(b2); 
		c.add(b3); c.add(b4);
		c.add(b5);
		c.setBackground(r1); 
		c.setSize(1000,1000);  
		c.setLayout(null);  
		c.setVisible(true); 
		setTitle("Animal Database");
		
	} 

	public void  connect() 
    {
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/animaldb","root","vasavi" );
            stmt  = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
        }
        catch(SQLException e)
        {
            System.out.println("Exception2");
        }
    }


	public void actionPerformed(ActionEvent e)
    {
        try{
            
            	if(e.getSource() == b5)
				{
            		Firstpage f = new Firstpage();
					f.setVisible(true);
					dispose();
				}
				if(e.getSource() == b2)
				{
					Insertpage i = new Insertpage();
					i.setVisible(true);
					dispose();
				}
				if(e.getSource() == b4)
				{
					Deletepage d = new Deletepage();
					d.setVisible(true);
					dispose();
				}
				if(e.getSource() == b3)
				{
					Updatepage u = new Updatepage();
					u.setVisible(true);
					dispose();
				}
				if(e.getSource() == b1)
				{
					try{


						//String q1 = combo1.getSelectedItem().toString();
						String sql2 ="SELECT hid FROM has where fname='"+combo1.getSelectedItem().toString()+"'";
						ResultSet rs1 = stmt.executeQuery(sql2);
						String jml="";
						while(rs1.next())
							jml = rs1.getString(1);
						String sql1 ="SELECT  aname FROM has where hid="+jml;
						ResultSet rs = stmt.executeQuery(sql1);
						if(rs.next())
						{
							tf.setText(rs.getString(1));
						}
					}
						catch(Exception expe)
						{
							System.out.println(expe);
						}

							try{

								//String q1 = combo1.getSelectedItem().toString();
								String sql3 ="SELECT hid FROM has where fname='"+combo1.getSelectedItem().toString()+"'";
								ResultSet rs2 = stmt.executeQuery(sql3);
								String jml1="";
								while(rs2.next())
									jml1 = rs2.getString(1);
								String sql4 ="SELECT  fdes FROM has where hid="+jml1;
								ResultSet rs3 = stmt.executeQuery(sql4);
								if(rs3.next())
								{
									t1.setText(rs3.getString(1));
								}
							}
							catch(Exception expe)
							{
								System.out.println(expe);
							}

					}
				}
				catch(Exception expe)
							{
								System.out.println(expe);
							}
	
        	}
       
    

    public static void main(String args[])
	{  
		
		Secondpage s = new Secondpage();
		s.setVisible(true); 
	} 
}

 