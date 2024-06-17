/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.sqlQu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.UpdateDeleteMember;

/**
 *
 * @author Acer
 */
public class UD {

    public void get(JTextField jTextField2, JTextField jTextField3, JTextField jTextField30, JTextField jTextField4, JTextField jTextField5, JTextField jTextField6, JTextField jTextField7, JTextField jTextField8, JTextField jTextField9, JTextField jTextField10, JTextField jTextField11,int id) {
      
          ResultSet rs =  sqlQu.get(id);
        try
        {
    while(rs.next())
            {
              
                jTextField2.setText(rs.getString(2));
                jTextField3.setText(rs.getString(3));
                jTextField4.setText(rs.getString(4));
                jTextField5.setText(rs.getString(5));
                jTextField5.setEditable(false);
                jTextField6.setText(rs.getString(6));
                jTextField7.setText(rs.getString(7));
                jTextField8.setText(rs.getString(8));
                jTextField8.setEditable(false);
                jTextField9.setText(rs.getString(9));
                jTextField10.setText(rs.getString(10));
                jTextField10.setEditable(false);
                jTextField11.setText(rs.getString(11));
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void update(String name, String age, String mobilenumber, String email, String nicnumber, String currentaddress, String amountpay,int id) {
      
  sqlQu.update(name,age,mobilenumber,email,nicnumber,currentaddress,amountpay,id);
    }    

    public void delete(int id) {
        System.out.println(id);
        sqlQu.delete(id);
       
        
    }
}
