package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame implements ActionListener{
    
    JTextField  tfusername , tfpassword ;
    JButton login ;//,back;-->not working
    // Constructor
    Login(){
        
        // Set Frame Color
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);
       
        // UserName 
        JLabel lblusername = new JLabel("UserName :");
        lblusername.setBounds(120, 45, 100, 30);
        lblusername.setForeground(Color.WHITE); // To set Font Color
        add(lblusername);
    
        tfusername = new JTextField(); //TextField is The Box which will take input
        tfusername.setBounds(190, 45, 300, 30);
        add(tfusername);


        //Password
        JLabel lblpassword = new JLabel("Password :");
        lblpassword.setBounds(120, 95, 100, 30);
        lblpassword.setForeground(Color.WHITE); // To set Font Color
        add(lblpassword);
        
        tfpassword = new JTextField(); //TextField is The Box which will take input
        tfpassword.setBounds(190, 95, 300, 30);
        add(tfpassword);
        
        //------------------------------------------------------------------------------------//

         //------------- ADD IMAGE AT FONT -----------//
           
        // 1st image on the front page //
        ImageIcon newi1 = new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg"));
        Image newi2 = newi1.getImage().getScaledInstance(600, 350, Image.SCALE_DEFAULT); 
        // T0 scale image , getImage is a function in image class , we are doing default scaling
        ImageIcon newi3 = new ImageIcon(newi2); // we are converting image to imageIcon
        JLabel newimage1 = new JLabel(newi3); 
        // we cannot add imageIcon so we need to convert it to Jable
        newimage1.setBounds(0 , 0, 600 , 350);
        add(newimage1);

        //------------------------------------------------------------------------------------//

        //--------- ADD BUTTON ----------//
        login = new JButton("Login Here");
        login.setFont(new Font("italics", Font.PLAIN , 20));
        login.setBounds(230,240,160,30);
        /*login.setBackground(Color.GRAY);
        login.setForeground(Color.WHITE);*/
        login.addActionListener(this);
        newimage1.add(login); // image. is used to add button over image w.r.t. image

        /*back = new JButton("Back");
        back.setFont(new Font("italics", Font.PLAIN , 20));
        back.setBounds(320,240,160,30);
        back.addActionListener(this); 
        newimage1.add(back); */

        //------------------------------------------------------------------------------------//


        //------------ FRAME ------------//
        setSize(600,350); //Used to set the size of the frame 
        setLocation(650,350);// 1st arg--> distance from left , 2nd arg--> distance from to
        setVisible(true); // By default frame is not visible so we need to use this function

        //------------------------------------------------------------------------------------//

       
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username  = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            //Creation of MYsQL query
            String query ="select * from login where username = '"+username+"'and password = '"+password+"'";
            
            //Execution of the query
            ResultSet rs = c.s.executeQuery(query); //Statement from conn class is needed for that

            if(rs.next()){
                setVisible(false);
                //next class
                new Home();

            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Usename or Password");
                setVisible(false);
                
            }
            

        } catch (Exception em) {
           
            em.printStackTrace(); }
       
     }
        
    

     public static void main(String[] args){
       
        new Login();
    }
}
