/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.sqlQu;

/**
 *
 * @author Acer
 */
public class paymenT {

    public void pay(int id, String date, String amount) {
        sqlQu.pay(id,date,amount);
      // sqlQu.pay(id,date,amount);
       
    }
    
}
