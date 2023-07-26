package employee.management.system; // This is the name of our package

// We can also use  import javax.swing.*;
//import javax.swing.JFrame; //javax ---> the extended java package
//import javax.swing.JLabel;
import javax.swing.*;

// To develop a frame we need to extend class to JFrame i.e. also a class under swing package
import java.awt.*; //It contains acaolor class
import java.awt.event.*;// Needed for ActionListener interface

public class Splash extends JFrame implements ActionListener {
    // ActionListener is an interface i.e. used to make the botton functionable

    //Constructor
       Splash(){ 

           getContentPane().setBackground(Color.WHITE);
           //There are certain layouts to place component on the frame as required
           setLayout(null); // TO set the default layout as null

           //------------------------------------------------------------------------------------//
       
           //-------------- HEADING ----------------// 
           JLabel heading = new JLabel("Employee  Management  System "); 
           // heading = new JLabel("Employee Management System "); --> is called Component
           heading.setBounds(200,20 /*To place the lable from left and top */, 1200, 620/* levels length and width */);
           // setBounds is a method to form own layout
           heading.setForeground(Color.ORANGE); // To set Font Color
           heading.setFont(new Font("serif", Font.PLAIN , 60));// To set the font
           add(heading);// to make component visible in the frame;

           //------------------------------------------------------------------------------------//
            
           //------------- ADD IMAGE AT FONT -----------//
           
           // 1st image on the front page //
           ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg"));
           Image i5 = i4.getImage().getScaledInstance(1200, 1070, Image.SCALE_DEFAULT); 
           // T0 scale image , getImage is a function in image class , we are doing default scaling
           ImageIcon i6 = new ImageIcon(i5); // we are converting image to imageIcon
           JLabel image1 = new JLabel(i6); 
           // we cannot add imageIcon so we need to convert it to Jable
           image1.setBounds(50 , 5, 1080 , 300);
           add(image1);

           // 2nd image on the front page //

           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/frontnew3.jpg"));
           Image i2 = i1.getImage().getScaledInstance(1200, 1070, Image.SCALE_DEFAULT); 
           // T0 scale image , getImage is a function in image class , we are doing default scaling
           ImageIcon i3 = new ImageIcon(i2); // we are converting image to imageIcon
           JLabel image = new JLabel(i3); 
           // we cannot add imageIcon so we need to convert it to Jable
           image.setBounds(50 ,370 , 1080 , 300);
           add(image);
           //------------------------------------------------------------------------------------//


          //--------- ADD BUTTON ----------//
          JButton clickHere = new JButton("Continue Here");
          clickHere.setFont(new Font("italics", Font.PLAIN , 32));
          clickHere.setBounds(400,200,300,70);
          //clickHere.setBackground(Color.DARK_GRAY);
          clickHere.setForeground(Color.DARK_GRAY);
          clickHere.addActionListener(this); //used to point where ActionListener should work
          image.add(clickHere); // image. is used to add button over image w.r.t. image

          //------------------------------------------------------------------------------------//

           //------------ FRAME ------------//
           setSize(1200,750); //Used to set the size of the frame 
           setLocation(400,50);// 1st arg--> distance from left , 2nd arg--> distance from to
           setVisible(true); // By default frame is not visible so we need to use this function

           //------------------------------------------------------------------------------------//

              while(true){ // To create flikering effect

             heading.setVisible(false);

             // TO slow down use TRY and Catch
             try{
                Thread.sleep(500);
             }catch (Exception e){


             }

             heading.setVisible(true);

             try{
                Thread.sleep(500);
             }catch (Exception e){
                

             }

           }

           //------------------------------------------------------------------------------------//

       }
        public static void main (String args[]){
          new Splash();
        }
        //Override foe ActionListener
        public void actionPerformed(ActionEvent ae) {
            
            // To demonstrate the function of ActionListener
            setVisible(false);// to close the current tab
            new Login(); // make constructor of Login class to open login page
        }
}