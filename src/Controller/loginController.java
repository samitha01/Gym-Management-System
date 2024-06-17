/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.sqlQu;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import view.home;
import view.login;

/**
 *
 * @author Acer
 */
public class loginController {


    public void checkuser(String uname, String Password) {
         boolean a =  sqlQu.checkuser(uname, Password);
         
         if(a){
               home h = new home();
           h.setVisible(true);
         }else{
     JOptionPane.showMessageDialog(null, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);



             login l=new  login();
              l.setVisible(true);    
             

         }
    }
    
    
    
}
