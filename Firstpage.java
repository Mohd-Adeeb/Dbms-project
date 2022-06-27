import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import java.net.URI;

//import javax.swing.plaf.ColorUIResource;



 class Firstpage extends JFrame implements ActionListener{
    private Container c;
    private JLabel title;
    private JButton sub;


    public  Firstpage() {
        setTitle("Animal DataBase");
        setBounds(500,190,900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Color r1 = new Color(142, 183, 230);
        c = getContentPane();
        c.setBackground(r1);
        c.setLayout(null);


         title = new JLabel("Welcome to Animal DataBase");
         title.setFont(new Font("Arial",Font.BOLD,24));
         title.setSize(500,30);
         title.setLocation(300, 100);
         title.setForeground(Color.DARK_GRAY);
         c.add(title);

         sub = new JButton("Click to enter");
         sub.setFont(new Font("Arial",Font.PLAIN,20));
         sub.setSize(200,50);
         sub.setLocation(330,250);
         sub.setForeground(Color.DARK_GRAY);
         sub.addActionListener(this);
         c.add(sub);
    }

    public void actionPerformed(ActionEvent e)
    {
        try{
            
            
            Secondpage s = new Secondpage();
            s.setVisible(true);
            dispose();

        }
        catch(Exception exception)
        {
            System.out.println("Exception");
        }
    }

    public static void main(String[] args) {
        Firstpage f = new Firstpage();
        f.setVisible(true);
    }
    
}
    


    

