package employee.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// It is the Central Class of this project
public class Home extends JFrame implements ActionListener{
    
    JButton add,visit,update,delete ,back;
    Home(){

        setLayout(null);

        
           
       //------------- ADD IMAGE AT FONT -----------//
           
        // 1st image on the front page //
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/home1.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1200, 750, Image.SCALE_DEFAULT); 
        // T0 scale image , getImage is a function in image class , we are doing default scaling
        ImageIcon i6 = new ImageIcon(i5); // we are converting image to imageIcon
        JLabel image1 = new JLabel(i6); 
        // we cannot add imageIcon so we need to convert it to Jable
        image1.setBounds(0 , 0, 1200 , 750);
        add(image1);
            
        //------------------------------------------------------------------------------------//
            
         //-------------- HEADING ----------------// 
         JLabel heading = new JLabel("Employee  Management  System "); 
         // heading = new JLabel("Employee Management System "); --> is called Component
         heading.setBounds(180,20 /*To place the lable from left and top */, 1200, 70/* levels length and width */);
         // setBounds is a method to form own layout
         heading.setForeground(Color.WHITE); // To set Font Color
         heading.setFont(new Font("TAPOMA", Font.PLAIN , 60));// To set the font
         image1.add(heading);// to make component visible in the frame;

         //------------------------------------------------------------------------------------//

         //--------- ADD BUTTON ----------//
        add = new JButton("Add Here");
        add.setFont(new Font("italics", Font.PLAIN , 32));
        add.setBounds(180,120,250,50);
        add.addActionListener(this); //used to point where ActionListener should work
        image1.add(add); // image. is used to add button over image w.r.t. image

        visit = new JButton("Visit Here");
        visit.setFont(new Font("italics", Font.PLAIN , 32));
        visit.setBounds(800,120,250,50);
        visit.addActionListener(this); //used to point where ActionListener should work
        image1.add(visit); // image. is used to add button over image w.r.t. image

        update = new JButton("Update Here");
        update.setFont(new Font("italics", Font.PLAIN , 32));
        update.setBounds(180,200,250,50);
        update.addActionListener(this); //used to point where ActionListener should work
        image1.add(update); // image. is used to add button over image w.r.t. image

        delete = new JButton("Delete Here");
        delete.setFont(new Font("italics", Font.PLAIN , 32));
        delete.setBounds(800,200,250,50);
        delete.addActionListener(this); //used to point where ActionListener should work
        image1.add(delete); // image. is used to add button over image w.r.t. image

        back = new JButton("Back");
        back.setFont(new Font("italics", Font.PLAIN , 20));
        back.setBounds(470,500,250,30);
        back.addActionListener(this); 
        image1.add(back); 


         //------------------------------------------------------------------------------------//

         //------------ FRAME ------------//
         setSize(1200,750); //Used to set the size of the frame 
         setLocation(400,50);// 1st arg--> distance from left , 2nd arg--> distance from to
         setVisible(true); // By default frame is not visible so we need to use this function

         //------------------------------------------------------------------------------------//


    }
   
    public static void main(String[] args){

        new Home();
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
      
        setVisible(false);
        if(ae.getSource() == add){
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource() == visit){
            setVisible(false);
            new VisitEmployee();            
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new VisitEmployee();            
        }
        else if(ae.getSource() == delete){
            setVisible(false);
            new DeleteEmployee();
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
}
