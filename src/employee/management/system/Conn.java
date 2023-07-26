package employee.management.system;

// To connect JDBC
import java.sql.*;// for Connection Interface 



public class Conn  {

    Connection c; // Connection is a Interface used for Creating the Connecting String
    Statement s; // for creating statement
    
    //TO connect with MYSQL There are 5 Steps , written below
     
    public Conn(){
       try {
        //forNme is a static method present in java class
        Class.forName("com.mysql.cj.jdbc.Driver"); //inside () mention MYSQL driver
        c=DriverManager.getConnection("jdbc:mysql:///employee_management_system" , "root" ,"Debosmita@007");//please use own password for mysql
        //add name of database created in Mysql
        // i.e. "employee_management_system " here , then usename of MYsQL , password
        s=c.createStatement();

       } catch (Exception e) {
         e.printStackTrace();
       }
    }

    
}

/********************************
   ------------------------------
   Steps TO connect with MYSQL :-

   1.Register the driver class
   2.Creating the Connecting String
   3.Creating Statement
   4.Executing Mysql queries
   5.Closing Connections

   -------------------------------
*********************************/
