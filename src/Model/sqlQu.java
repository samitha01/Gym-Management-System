/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import view.UpdateDeleteMember;

/**
 *
 * @author Acer
 */
public class sqlQu {
//    public static void CreateAcc(String email, String password) {
//        Connection conn = DBConnection.connect();
//        PreparedStatement pst;
//        String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
//
//        try {
//            pst = conn.prepareStatement(query);
//            pst.setString(1, name);
//            pst.setString(2, email);
//            pst.setString(3, password);
//            pst.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//           JOptionPane.showMessageDialog(null, "Some thing went wrong", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//    
    

    public static boolean checkuser(String username, String password) {
        Connection conn = DBConnection.connect();
    
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "SELECT username, password FROM user WHERE username = ? AND password = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;
    
    }

  
    
     public static void addMember(String id, String name, String age, String mobilenumber, String gender, String email, String nicnumber, String gymtime, String currentaddress, String category, String amountpay) {
        Connection conn = DBConnection.connect();
        

        String query = "INSERT INTO new_member_table( Name, Age,Mobile_Number,Gender,Email, NIC_Number,Gym_Time, Current_Address,Category,Amount) VALUES (?,?,?,?,?,?,?,?,?,?)";
         System.out.println();
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, age);
           pst.setString(3, mobilenumber);
            pst.setString(4, gender);
            pst.setString(5, email);
            pst.setString(6, nicnumber);
           pst.setString(7, gymtime);
            pst.setString(8, currentaddress);
            pst.setString(9, category);
           pst.setString(10, amountpay);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "IMember added successfully!");
            System.out.println("Member added successfully!");
        } catch (SQLException e) {
            System.out.println("An error occurred while inserting the data.");
            e.printStackTrace();
        }
}
     
        public static ResultSet getMembers(String tdnname) {
            System.out.println("fjkhdsjf");
        Connection conn = DBConnection.connect();
        String query = "SELECT * FROM "+tdnname;
            System.out.println(tdnname);
        ResultSet rs = null;

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            return rs;
             
        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving the data.");
            e.printStackTrace();
             return rs;
        }
        
       
    }

   public static void pay(int id, String date, String amount) {
       Connection conn = DBConnection.connect();
        

        String query = "INSERT INTO payment( id, date,amount) VALUES (?,?,?)";
         System.out.println();
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.setString(2, date);
           pst.setString(3, amount);
           

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "payment successfully!");
           
        } catch (SQLException e) {
            System.out.println("An error occurred while inserting the data.");
            e.printStackTrace();
        }
    }

    public static ResultSet get(int id) {
         ResultSet rs = null;
           try {
              Connection con=DBConnection.connect();
            Statement st=con.createStatement();
           rs =st.executeQuery("select * from new_member_table where Member_ID = '"+id+"'");
           
          

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return rs;
    

    }

    public static void update(String name, String age, String mobilenumber, String email, String nicnumber, String currentaddress, String amountpay, int id) {
        try
        {
            Connection con=DBConnection.connect();

            PreparedStatement ps=con.prepareStatement("update new_member_table set name=?,age=?,Mobile_Number=?,email=?,NIC_Number=?,Current_Address=?,amount=? where Member_ID=?");
            ps.setString(1,name);
            ps.setString(2,age);
            ps.setString(3,mobilenumber);
            ps.setString(4,email);
            ps.setString(5,nicnumber);
            ps.setString(6,currentaddress);
            ps.setString(7,amountpay);
            ps.setInt(8,id);
            
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,"Successfully Updated");
            
            new UpdateDeleteMember().setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void delete(int id) {
         try
            {
                Connection con=DBConnection.connect();

                Statement st=con.createStatement();
                st.executeUpdate("delete from new_member_table where Member_ID= "+id+"");
                JOptionPane.showMessageDialog(null,"Successfully Deleted");
               
                new UpdateDeleteMember().setVisible(true);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
    }

    

}
