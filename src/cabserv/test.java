/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cabserv;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PavanS
 */
public class test {
 
    public static void main(String args[])
    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection con= DriverManager.getConnection("jdbc:odbc:testing","root", "");     //for connecting to database
            Statement s=con.createStatement();                           //for sql query
             
            ResultSet rs = s.executeQuery("select * from City ");        //for bringing result from database

while (rs.next()) {
String st = rs.getString(2);
System.out.println(st);
} //end while
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
