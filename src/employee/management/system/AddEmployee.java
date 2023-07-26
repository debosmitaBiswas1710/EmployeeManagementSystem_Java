package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran =new Random();
    int number = ran.nextInt(9999999);//To generate Unique Employee Id

    JTextField  tfname,tffname,tfdob,tfsalary,tfaddress;
    JTextField  tfphone,tfemail,tfdesignation,tfaadhar;
    JDateChooser dcdob;
    JComboBox cbedu;
    JLabel lblempId;
    JButton add,back;

    AddEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //-------Heading--------//
        
        JLabel heading = new JLabel("ADD DETAILS OF EMPLYOEE");
        heading.setBounds(230,10,1200,80);
        heading.setFont(new Font("SAN_SARIF",Font.BOLD,30));
        heading.setForeground(Color.DARK_GRAY);
        add(heading);
        
        //---------------------//

        //------LABELING-------//
       
        //------Name-------//
        JLabel lbname = new JLabel("Employee's Name :");
        lbname.setBounds(80,50,250,200);
        lbname.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(320,140,400,30);
        add(tfname);
        //---------------------//

        //------Father's Name-------//
        JLabel lbfname = new JLabel("Father's Name :");
        lbfname.setBounds(80,100,250,200);
        lbfname.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbfname);
        
        tffname = new JTextField();
        tffname.setBounds(320,190,400,30);
        add(tffname);
        //---------------------//
        
        //------D.O.B-------//
        JLabel lbdob = new JLabel("Enter D.O.B:");
        lbdob.setBounds(80,150,250,200);
        lbdob.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbdob);
        
        /*tfdob = new JTextField();
        tfdob.setBounds(300,240,400,30);
        add(tfdob);*/

        dcdob = new JDateChooser();
        dcdob.setBounds(270,240,100,30);
        add(dcdob);
        //------------------------------------------------//

         //-----------AadharNo-----------//
        JLabel labelaadhar = new JLabel("Aadhar Number:");
        labelaadhar.setBounds(390,150,280,200);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 30));
        add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,240,200,30);
        add(tfaadhar);
        //--------------------------------//

        //-----------Designation----------//
        JLabel labeldesignation = new JLabel("Designation:");
        labeldesignation.setBounds(80,200,250,200);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 30));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(250,290,250,30);
        add(tfdesignation);
        //------------------------------//    
        
        //------Salary-------//
        JLabel lbsalary = new JLabel("Salary:");
        lbsalary.setBounds(520,200,250,200);
        lbsalary.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(615,290,200,30);
        add(tfsalary);
        //---------------------//

        //------Phone_No.-------//
        JLabel lbphone = new JLabel("Enter Phone No.:");
        lbphone.setBounds(80,250,250,200);
        lbphone.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(320,340,400,30);
        add(tfphone);
        //---------------------//

        //------Email-------//
        JLabel lbemail = new JLabel("Enter Email:");
        lbemail.setBounds(80,300,250,200);
        lbemail.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(320,390,400,30);
        add(tfemail);
        //---------------------//

        //------Address-------//
        JLabel lbaddress = new JLabel("Adderess:");
        lbaddress.setBounds(80,350,200,200);
        lbaddress.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbaddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,440,250,30);
        add(tfaddress);
        
        //---------------------//

        //------Highest Education-------//
        JLabel lbedu = new JLabel("Highest Education:");
        lbedu.setBounds(460,350,290,200);
        lbedu.setFont(new Font("SERIF",Font.PLAIN,30));
        add(lbedu);
        
        String courses[] ={"None","B.Tech","BSC","BBA","BCA","MSC","M.TECH"};
        cbedu = new JComboBox(courses);
        cbedu.setBounds(695,440,120,30);
        cbedu.setBackground(Color.WHITE);
        add(cbedu);
        //---------------------//
        

        //-----------Employee Id---------//
        JLabel labelempId = new JLabel("Employee id:");
        labelempId.setBounds(80, 490, 250, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 30));
        add(labelempId);
        // empID should be unique so we are taking Jlabel type
        lblempId = new JLabel("" + number);//""+ before number type cast number into string
        lblempId.setBounds(250, 490, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 30));
        lblempId.setForeground(Color.DARK_GRAY);
        add(lblempId);
        
        //-----------------------------//

        //--------------------------------------------------------------//


        
        //--------------------- Button Creation--------------------------------//
        
        add = new JButton("Done");
        add.setFont(new Font("italics", Font.PLAIN , 20));
        add.setBounds(350,550,100,50);
        add.addActionListener(this);
        add(add); 

        back = new JButton("Back");
        back.setFont(new Font("italics", Font.PLAIN , 20));
        back.setBounds(480,550,100,50);
        back.addActionListener(this); 
        add(back); 

        //--------------------------------------------------------------------//


        //------------ Add Image --------------//
         
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i1 = i.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
        // T0 scale image , getImage is a function in image class , we are doing default scaling
        ImageIcon i2 = new ImageIcon(i1); // we are converting image to imageIcon
        JLabel image = new JLabel(i2); 
        // we cannot add imageIcon so we need to convert it to Jable
        image.setBounds(650, 0, 150, 150);
        add(image);

        ImageIcon newi = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image newi1 = newi.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
        // T0 scale image , getImage is a function in image class , we are doing default scaling
        ImageIcon newi2 = new ImageIcon(newi1); // we are converting image to imageIcon
        JLabel newimage = new JLabel(newi2); 
        // we cannot add imageIcon so we need to convert it to Jable
        newimage.setBounds(80, 0, 150, 140);
        add(newimage);
        //------------------------------------//
        
        //-------Frame----------//

        setSize(900,700);
        setLocation(600,100);
        setVisible(true);

        //---------------------//


    }

    public static void main(String[] args){
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add){

            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText(); // Important
            String aadhar = tfaadhar.getText();
            String designation = tfdesignation.getText();
            String salary = tfsalary.getText();
            String phn= tfphone.getText();
            String email = tfemail.getText();
            String edu = (String) cbedu.getSelectedItem();//cbedu needed to be typecasted
            String add = tfaddress.getText();
            String empId = lblempId.getText();

            try {
                
                Conn c = new Conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+aadhar+"','"+designation+"','"+salary+"','"+phn+"','"+email+"','"+edu+"','"+add+"','"+empId+"')";
                c.s.executeUpdate(query); //Command for DML Query
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
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
