/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cabserv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author PavanS
 */
public class matrix {
  public int[][] mat(){  
    int [][] temp=new int[2][2];
try{
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection con = DriverManager.getConnection("jdbc:odbc:testing", "root", "");
    Statement s = con.createStatement();
    ResultSet rs = s.executeQuery("Select * from city where Name=ConnectedTo");
    int size=0;
    String str[]=new String[30];
    while(rs.next()){
        str[size]=rs.getString(1);                       //getting all the cities from database
        
        size++;
    }
     rs = s.executeQuery("Select * from city where Name<>ConnectedTo");        //getting all the roads from database
    int [][]cityarr=new int[size][size];                                       //adjacency matrix
    for(int j=0;j<size;j++){
        for(int k=0;k<size;k++){
            cityarr[j][k]=0;                                                   //initializing all the entries of matrix to zero
        }
        
    }
    String str1=new String();
    String str2=new String();
    int x1,y1,x2,y2,dis=0,l,m;
    /*
     all the entries in adjacency matrix are initialized to zero. if there is a road between two cities then that corresponding column
     * and row should be filled with distance between these cities in adjacency matrix.
     * this is done by following while loop 
     */
   while(rs.next()){                                                         //for getting distances between the road 
        str1=rs.getString(1);                                                 
        str2=rs.getString(4);
        x1=rs.getInt(2);
         y1=rs.getInt(3);
          x2=rs.getInt(5);
           y2=rs.getInt(6);
       for( l=0;l<size;l++){                                                   //getting row where the entry should be filled
           if(str1.equals(str[l])){
               break;
           }
       }
       for( m=0;m<size;m++){                                                  //getting column where entry should be filled
           if(str2.equals(str[m])){
               break;
           }
       }
       dis=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);                                    //calculating distance
       cityarr[l][m]=dis/20;                                                   //entering distance in matrix
   }
   
   temp=cityarr;
//   for(int j=0;j<size;j++){
//        for(int k=0;k<size;k++){
//            System.out.print(cityarr[j][k]+"    ");
//        }
//        System.out.println();
//    }
}   catch(Exception ex){
    System.out.println(ex.getMessage()+"first try catch");
}     
      //  return null;
    
return temp;                                     //get cityarr[][] somehow out of try-catch
  }
}
