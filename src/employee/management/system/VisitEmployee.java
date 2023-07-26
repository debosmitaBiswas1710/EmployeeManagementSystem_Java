package employee.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils; // To insert data in table without Separately Creating it
import java.sql.*;

public class VisitEmployee extends JFrame implements ActionListener {
    
     JTable table;
     Choice search_employeeId; //Here we are using Choice instead of ComboBox for drop down menu

     // For Button Creation
     JButton search ,print ,update,back ,add, delete;

    /**
     * 
     */
    VisitEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel headinglb = new JLabel("EMPLOYEE DATA");
        headinglb.setBounds(350,0,300,30);
        headinglb.setFont(new Font("SERIF",Font.BOLD,25));
        headinglb.setForeground(Color.BLUE);
        add(headinglb);
          

        //-------------Table-----------------//
           
        table = new JTable(); //object creation
        try {
            Conn connect = new Conn();
            ResultSet rs = connect.s.executeQuery("SELECT * FROM EMPLOYEE");
            //To create table with built in library files
            table.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (Exception eh) {
            // handle exception
            eh.printStackTrace();
        }

        //-- Adding Scroll Bar ---//

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,150,900,600);
        add(jsp);


        //----------------------------------//


        //-----------For Searching----------//

        JLabel searchlb = new JLabel("Search Using Employee ID:");
        searchlb.setBounds(30,30,300,40);
        searchlb.setFont(new Font("SERIF",Font.BOLD,25));
        searchlb.setForeground(Color.DARK_GRAY);
        add(searchlb);
          
        // To Create Drop Down
        search_employeeId = new Choice();
        search_employeeId.setBounds(330,38,160,40);
        add(search_employeeId);

        try {
            Conn connect = new Conn();
            ResultSet rs = connect.s.executeQuery("SELECT * FROM EMPLOYEE");
           // To add employee id inside Drop down 
           while(rs.next()){
               search_employeeId.add(rs.getString("empID"));
           }

        } catch (Exception eh) {
            // TODO: handle exception
            eh.printStackTrace();
        }

        //----------------------------------//

        //------------Button------------//
          
          /***** Search Button *******/
           search = new JButton("Search");
           search.setBounds(50, 70, 90, 30);
           search.addActionListener(this);
           add(search);
          /**************************/
          
          /***** Print Button *******/
           print = new JButton("Print");
           print.setBounds(160, 70, 90, 30);
           print.addActionListener(this);
           add(print);
          /**************************/

           /***** Add Button *******/
           add = new JButton("Add");
           add.setBounds(270, 70, 90, 30);
           add.addActionListener(this);
           add(add);

          /**************************/

          /***** Update Button *******/
           update = new JButton("Update");
           update.setBounds(50, 110, 90, 30);
           update.addActionListener(this);
           add(update);
          /**************************/

          /***** back Button *******/
           back= new JButton("Back");
           back.setBounds(160, 110, 90, 30);
           back.addActionListener(this);
           add(back);
          /**************************/

          /***** Delete Button *******/
           delete= new JButton("Delete");
           delete.setBounds(270, 110, 90, 30);
           delete.addActionListener(this);
           add(delete);
          /**************************/



        //-------------------------------//

        //------------ Add Image --------------//
         
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon/employees.jpg"));
        Image i1 = i.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
        // T0 scale image , getImage is a function in image class , we are doing default scaling
        ImageIcon i2 = new ImageIcon(i1); // we are converting image to imageIcon
        JLabel image = new JLabel(i2); 
        // we cannot add imageIcon so we need to convert it to Jable
        image.setBounds(450, 0, 200, 200);
        add(image);

        ImageIcon ni = new ImageIcon(ClassLoader.getSystemResource("icon/employees.jpg"));
        Image ni1 = ni.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
        // T0 scale image , getImage is a function in image class , we are doing default scaling
        ImageIcon ni2 = new ImageIcon(ni1); // we are converting image to imageIcon
        JLabel nimage = new JLabel(ni2); 
        // we cannot add imageIcon so we need to convert it to Jable
        nimage.setBounds(710, 0, 200, 200);
        add(nimage);

        ImageIcon newi = new ImageIcon(ClassLoader.getSystemResource("icon/employee_search.jpg"));
        Image newi1 = newi.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
        // T0 scale image , getImage is a function in image class , we are doing default scaling
        ImageIcon newi2 = new ImageIcon(newi1); // we are converting image to imageIcon
        JLabel newimage = new JLabel(newi2); 
        // we cannot add imageIcon so we need to convert it to Jable
        newimage.setBounds(610,10, 150, 150);
        add(newimage);


        //------------------------------------//
        //------------Frame---------------//

        setSize(900,700);
        setLocation(600,100);
        setVisible(true);

       //---------------------------------//

    }
      public static void main(String[] args){
        new VisitEmployee();
      }
    @Override
    public void actionPerformed(ActionEvent act) {
        
        if(act.getSource()== search){

            String query = "select * from employee where empID = '"+search_employeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs= c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ehand) {
        
                ehand.printStackTrace();
            }

        }else if(act.getSource()== print){
            try {
                table.print();  // In built Print function in Java

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(act.getSource()== update){
            
            setVisible(false);
            new UpdateEmployee(search_employeeId.getSelectedItem());

        }else if(act.getSource()==add)
        {
            setVisible(false);
            new AddEmployee();
        }
        else if(act.getSource()==delete)
        {
            setVisible(false);
            new DeleteEmployee();
        }
        else if(act.getSource()==back)
        {
            setVisible(false);
            new Home();
        }

        
    }
}
