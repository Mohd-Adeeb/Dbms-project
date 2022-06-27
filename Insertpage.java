import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class Insertpage extends JFrame implements ActionListener{
    private Container c;
    private JButton b1,b2;
    private JTextField t1,t2,t3,t4,t5;
    private JLabel l1,l2,l3,l4,l5,l6;
    JTextArea resultText ;
    Statement st;
    Connection con;
    //Secondpage s = new Secondpage();
            /*s.combo1.addItem(t4.getText());
            s.setVisible(true);*/

    public Insertpage()
    {
        connect();
        setTitle("Animal DataBase");
        setBounds(500,500,900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Color r1 = new Color(142, 183, 230);
        c = getContentPane();
        c.setBackground(r1);
        c.setLayout(null);

         l1 = new JLabel("Animal id :");
         l1.setFont(new Font("Serif",Font.BOLD,18));
         l1.setSize(500,30);
         l1.setLocation(0, 70);
         l1.setForeground(Color.DARK_GRAY);
         c.add(l1);

         t1 = new JTextField();
         t1.setFont(new Font("Serif",Font.BOLD,18));
         t1.setSize(200,30);
         t1.setLocation(170, 70);
         t1.setForeground(Color.DARK_GRAY);
         c.add(t1);

         l2 = new JLabel("Animal name :");
         l2.setFont(new Font("Serif",Font.BOLD,18));
         l2.setSize(500,30);
         l2.setLocation(0, 110);
         l2.setForeground(Color.DARK_GRAY);
         c.add(l2);

         t2 = new JTextField();
         t2.setFont(new Font("Serif",Font.BOLD,18));
         t2.setSize(200,30);
         t2.setLocation(170, 110);
         t2.setForeground(Color.DARK_GRAY);
         c.add(t2);

         l3 = new JLabel("Animal Type :");
         l3.setFont(new Font("Serif",Font.BOLD,18));
         l3.setSize(500,30);
         l3.setLocation(0, 150);
         l3.setForeground(Color.DARK_GRAY);
         c.add(l3);

         t3 = new JTextField();
         t3.setFont(new Font("Serif",Font.BOLD,18));
         t3.setSize(200,30);
         t3.setLocation(170, 150);
         t3.setForeground(Color.DARK_GRAY);
         c.add(t3);

         l4 = new JLabel("Feature name :");
         l4.setFont(new Font("Serif",Font.BOLD,18));
         l4.setSize(500,30);
         l4.setLocation(0, 190);
         l4.setForeground(Color.DARK_GRAY);
         c.add(l4);

         t4 = new JTextField();
         t4.setFont(new Font("Serif",Font.BOLD,18));
         t4.setSize(200,30);
         t4.setLocation(170, 190);
         t4.setForeground(Color.DARK_GRAY);
         c.add(t4);

         l5 = new JLabel("Feature Description :");
         l5.setFont(new Font("Serif",Font.BOLD,18));
         l5.setSize(500,30);
         l5.setLocation(0, 230);
         l5.setForeground(Color.DARK_GRAY);
         c.add(l5);

         t5 = new JTextField();
         t5.setFont(new Font("Serif",Font.BOLD,18));
         t5.setSize(200,30);
         t5.setLocation(170, 230);
         t5.setForeground(Color.DARK_GRAY);
         c.add(t5);

         b1 = new JButton("Insert into table");
		 b1.setSize(200,20); 
		 b1.setLocation(50,300);
         b1.setForeground(Color.DARK_GRAY);
         b1.addActionListener(this);	
         c.add(b1);

         b2 = new JButton("Go Back");
		 b2.setSize(200,20); 
		 b2.setLocation(300,300);
         b2.setForeground(Color.DARK_GRAY);
         b2.addActionListener(this);	
         c.add(b2);

         l6 = new JLabel("Insertion page:");
         l6.setFont(new Font("Serif",Font.ITALIC,25));
         l6.setSize(500,30);
         l6.setLocation(250, 0);
         l6.setForeground(Color.DARK_GRAY);
         c.add(l6);

         resultText = new JTextArea();
         resultText.setFont(new Font("Serif",Font.ITALIC,25));
         resultText.setSize(550,30);
         resultText.setLocation(200, 350);
         resultText.setForeground(Color.DARK_GRAY);
         c.add(resultText);
        

    }
    
    

    public void  connect() 
    {
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/animaldb","root","vasavi" );
            st  = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
        }
        catch(SQLException e)
        {
            System.out.println("Exception2");
        }
    }


    public void actionPerformed(ActionEvent e)
    {
        try{
            if(e.getSource() == b2){
            
                Secondpage s = new Secondpage();
                s.setVisible(true);
                dispose();
            }
            if(e.getSource() == b1){

                try{

                    int jml = Integer.parseInt(t1.getText());
                    String q1 = t2.getText();
                    String q2 = t3.getText();
                    String q3 = t4.getText();
                    String q4 = t5.getText();
                    String sql = "Insert into Animals values(' "+jml + "','" + q1 + "','" + q2 +"')"; 
                    st.executeUpdate(sql);
                    String sql1 =  "INSERT INTO Features VALUES(' "+jml + "','" + q3 + "','" + q4 +"')";
                    st.executeUpdate(sql1);
                    String sql2 =  "INSERT INTO has VALUES(' "+jml + "','" + q1 + "','" + q3 +"','" + q4 +"')";
                    st.executeUpdate(sql2);

                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");

                    resultText.setText("Row Inserted Successfully");

                    Secondpage s = new Secondpage();
                    s.combo1.addItem(q3);
                    s.setVisible(false);


                


                    con.close();
                    st.close();
                    
      

                }
                catch(SQLException exp)
                {
                    System.out.println("Exception1");
                }
            }

        }
        catch(Exception exception)
        {
            System.out.println("Exception");
        }
    }


    public static void main(String args[]) throws Exception
	{  
        try{
		
            Insertpage i = new Insertpage();
            i.setVisible(true); 

            
        }
        catch(Exception e)
        {
            System.out.println("Exception 3");
        }
	} 
}
