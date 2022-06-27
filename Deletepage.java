import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Deletepage extends JFrame implements ActionListener
{
    private Container c;
    private JLabel l1;//l2;
    private JTextField t1;
    JTextArea resultText ;
   // private JComboBox combo1;
    private JButton b1,b2;
    Connection con;
    Statement stmt;


    public  Deletepage() 
    {
        connect();
        setTitle("Animal DataBase");
        setBounds(500,190,900,600);
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
         t1.setLocation(130, 70);
         t1.setForeground(Color.DARK_GRAY);
         c.add(t1);

        /* l2 = new JLabel("Feature name :");
         l2.setFont(new Font("Serif",Font.BOLD,18));
         l2.setSize(500,30);
         l2.setLocation(0, 110);
         l2.setForeground(Color.DARK_GRAY);
         c.add(l2);*/

        /*combo1 = new JComboBox();
        combo1.addItem("physical");
		combo1.addItem("size");
		combo1.addItem("eat");
		combo1.addItem("color");
		combo1.addItem("height");
		combo1.addItem("speed");
		combo1.addItem("ear");
		combo1.addItem("eyes");
		combo1.addItem("skin");
		combo1.addItem("teeth");
        combo1.setEditable(false);
        combo1.setSize(200,30);
        combo1.setLocation(130, 110);
        c.add(combo1);*/

          b1 = new JButton("Delete  From table");
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

         JLabel l6 = new JLabel("Deletion page:");
         l6.setFont(new Font("Serif",Font.ITALIC,25));
         l6.setSize(500,30);
         l6.setLocation(250, 0);
         l6.setForeground(Color.DARK_GRAY);
         c.add(l6);

         resultText = new JTextArea();
         resultText.setFont(new Font("Serif",Font.ITALIC,25));
         resultText.setSize(550,30);
         resultText.setLocation(100, 200);
         resultText.setForeground(Color.DARK_GRAY);
         c.add(resultText);


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
            if(e.getSource() == b2){
            
                Secondpage s = new Secondpage();
                s.setVisible(true);
                dispose();
            }
            if(e.getSource() == b1){

                int jml = Integer.parseInt(t1.getText());
                String sql1 = "DELETE FROM Animals WHERE aid = " + jml;
                stmt.executeUpdate(sql1);  
                String sql2 = "DELETE FROM Features WHERE aid = " + jml;
                stmt.executeUpdate(sql2);
                String sql3 = "DELETE FROM has WHERE hid = " + jml;
                stmt.executeUpdate(sql3);

                resultText.setText("Row Deleted Successfully");

                t1.setText(" ");
                
                con.close();
            }




        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }




    public static void main(String[] args) 
    {
            Deletepage d = new Deletepage();
            d.setVisible(true);
    }
}
