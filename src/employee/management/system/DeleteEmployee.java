
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class DeleteEmployee extends JFrame implements ActionListener{
    
    Choice cempId;
    JButton delete,back;
    

    DeleteEmployee(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //-------Heading--------//
        
        JLabel heading = new JLabel("DELETE DETAILS OF EMPLYOEE");
        heading.setBounds(210,10,1200,30);
        heading.setFont(new Font("SAN_SARIF",Font.BOLD,30));
        heading.setForeground(Color.DARK_GRAY);
        add(heading);
        
        //---------------------//

        //------LABELING-------//

        
        //-----------Employee Id---------//
        JLabel labelempId = new JLabel("Employee id:");
        labelempId.setBounds(80, 90, 170, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 30));
        add(labelempId);

        // empID should be unique so we are taking Jlabel type
        cempId = new Choice();//""+ before number type cast number into string
        cempId.setBounds(290, 85, 170, 20);
        cempId.setFont(new Font("serif", Font.BOLD, 27));
        cempId.setForeground(Color.DARK_GRAY);
        add(cempId);

        try {
            Conn c = new Conn();
            String query ="select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cempId.add(rs.getString("empId"));
            }
            
        } catch (Exception eh1) {
            //  handle exception
            eh1.printStackTrace();
        }
        
        //-----------------------------//
       
        //------Name-------//
        JLabel lbname = new JLabel("Employee's Name :");
        lbname.setBounds(80,50,250,200);
        lbname.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbname);
        
        JLabel lbvisname = new JLabel();
        lbvisname.setBounds(320,140,400,30);
        lbvisname.setFont(new Font("serif", Font.BOLD, 30));
        add(lbvisname);
        //---------------------//

        //------Father's Name-------//
        JLabel lbfname = new JLabel("Father's Name :");
        lbfname.setBounds(80,100,250,200);
        lbfname.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbfname);
        
        JLabel lbvisfname = new JLabel();
        lbvisfname.setBounds(320,190,400,30);
        lbvisfname.setFont(new Font("serif", Font.BOLD, 30));
        add(lbvisfname);
        //---------------------//
        
        //------D.O.B-------//
        JLabel lbdob = new JLabel("Enter D.O.B:");
        lbdob.setBounds(80,150,250,200);
        lbdob.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbdob);
        
        JLabel lbvisdob = new JLabel();
        lbvisdob.setBounds(250,237,200,30);
        lbvisdob.setFont(new Font("serif", Font.BOLD, 25));
        add(lbvisdob);
        //------------------------------------------------//

         //-----------AadharNo-----------//
        JLabel labelaadhar = new JLabel("Aadhar Number:");
        labelaadhar.setBounds(400,150,280,200);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 30));
        add(labelaadhar);
        
        JLabel labelvisaadhar = new JLabel();
        labelvisaadhar.setBounds(610,230,250,40);
        labelvisaadhar.setFont(new Font("serif", Font.BOLD, 30));
        add(labelvisaadhar);
        //--------------------------------//

        //-----------Designation----------//
        JLabel labeldesignation = new JLabel("Designation:");
        labeldesignation.setBounds(80,200,250,200);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 30));
        add(labeldesignation);
        
        JLabel lbvisdesignation = new JLabel();
        lbvisdesignation.setBounds(250,290,250,30);
        lbvisdesignation.setFont(new Font("SERIF",Font.BOLD,25));
        add(lbvisdesignation);
        //------------------------------//    
        
        //------Salary-------//
        JLabel lbsalary = new JLabel("Salary:");
        lbsalary.setBounds(520,200,250,200);
        lbsalary.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbsalary);
        
        JLabel lbvissalary = new JLabel();
        lbvissalary.setBounds(615,290,200,30);
        lbvissalary.setFont(new Font("SERIF",Font.BOLD,25));
        add(lbvissalary);
        //---------------------//

        //------Phone_No.-------//
        JLabel lbphone = new JLabel("Enter Phone No.:");
        lbphone.setBounds(80,250,250,200);
        lbphone.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbphone);
        
        JLabel lbvisphone = new JLabel();
        lbvisphone.setBounds(320,340,400,30);
        lbvisphone.setFont(new Font("SERIF",Font.BOLD,25));
        add(lbvisphone);
        //---------------------//

        //------Email-------//
        JLabel lbemail = new JLabel("Enter Email:");
        lbemail.setBounds(80,300,250,200);
        lbemail.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbemail);
        
        JLabel lbvisemail = new JLabel();
        lbvisemail.setBounds(320,390,400,30);
        lbvisemail.setFont(new Font("SERIF",Font.BOLD,25));
        add(lbvisemail);
        //---------------------//

        //------Address-------//
        JLabel lbaddress = new JLabel("Adderess:");
        lbaddress.setBounds(80,350,200,200);
        lbaddress.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbaddress);
        
        JLabel lbvisaddress = new JLabel();
        lbvisaddress.setBounds(200,440,250,30);
        lbvisaddress.setFont(new Font("SERIF",Font.BOLD,25));
        add(lbvisaddress);
        
        //---------------------//

        //------Highest Education-------//
        JLabel lbedu = new JLabel("Highest Education:");
        lbedu.setBounds(460,350,290,200);
        lbedu.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbedu);

        JLabel lbvisedu = new  JLabel();
        lbvisedu.setBounds(695,440,120,30);
        lbvisedu.setFont(new Font("SERIF",Font.BOLD,25));
        add(lbvisedu);
        //---------------------//
        

        //--------------Adding Previous Values in the table -----------------------//

        try {
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '"+cempId.getSelectedItem()+"' ";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        lbvisname.setText(rs.getString("name"));
                        lbvisfname.setText(rs.getString("fname"));
                        lbvisdob.setText(rs.getString("dob"));
                        labelvisaadhar.setText(rs.getString("aadhar"));
                        // lblempId.setText(rs.getString("empId"));
                        lbvisdesignation.setText(rs.getString("designation"));
                        lbvisaddress.setText(rs.getString("address"));
                        lbvisphone.setText(rs.getString("phn"));
                        lbvisemail.setText(rs.getString("email"));
                        lbvissalary.setText(rs.getString("salary"));
                        lbvisedu.setText(rs.getString("education"));
            }
            
        } 
        catch (Exception ahe) {
            // handle exception
            ahe.printStackTrace();
        }
        //To Check From the DropBox
        cempId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '"+cempId.getSelectedItem()+"' ";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        lbvisname.setText(rs.getString("name"));
                        lbvisfname.setText(rs.getString("fname"));
                        lbvisdob.setText(rs.getString("dob"));
                        labelvisaadhar.setText(rs.getString("aadhar"));
                        // lblempId.setText(rs.getString("empId"));
                        lbvisdesignation.setText(rs.getString("designation"));
                        lbvisaddress.setText(rs.getString("address"));
                        lbvisphone.setText(rs.getString("phn"));
                        lbvisemail.setText(rs.getString("email"));
                        lbvissalary.setText(rs.getString("salary"));
                        lbvisedu.setText(rs.getString("education"));
            }
            
        } 
        catch (Exception ahe) {
            // handle exception
            ahe.printStackTrace();}
        }
        });
       

        //--------------------------------------------------------------//


        
        //--------------------- Button Creation--------------------------------//
        
        delete = new JButton("Delete");
        delete.setFont(new Font("italics", Font.PLAIN , 20));
        delete.setBounds(350,550,100,50);
        delete.addActionListener(this);
        add(delete); 

        back = new JButton("Back");
        back.setFont(new Font("italics", Font.PLAIN , 20));
        back.setBounds(480,550,100,50);
        back.addActionListener(this); 
        add(back); 

        //--------------------------------------------------------------------//


        //------------ Add Image --------------//
         
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon/delete.png"));
        Image i1 = i.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT); 
        // T0 scale image , getImage is a function in image class , we are doing default scaling
        ImageIcon i2 = new ImageIcon(i1); // we are converting image to imageIcon
        JLabel image = new JLabel(i2); 
        // we cannot add imageIcon so we need to convert it to Jable
        image.setBounds(550, 0, 250, 250);
        add(image);

        
        //-------Frame----------//

        setSize(900,700);
        setLocation(600,100);
        setVisible(true);

        //---------------------//


    }

    public static void main(String[] args){
        new DeleteEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == delete){

            try {
                
                Conn c = new Conn();
                String query = "delete from employee where empId = '"+cempId.getSelectedItem()+"' ";
                c.s.executeUpdate(query); //Command for DML Query
                JOptionPane.showMessageDialog(null,"Deleted Successfully"); // Pop up
                setVisible(false);
                new Home();

            } catch (Exception eh) {
                // handle exception

                eh.printStackTrace();
            }

        } else if (ae.getSource() == back){
               setVisible(false);
               new Home();
        }
        
    }
}
