/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.sqlQu;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class NewMembers {

  
       

    public void add(String id, String name, String age, String mobilenumber, String gender, String email, String nicnumber, String gymtime, String currentaddress, String category, String amountpay) {
      
        sqlQu.addMember( id, name, age, mobilenumber, gender,email,nicnumber,gymtime,currentaddress,category,amountpay);
    }
 
    public void LoadTable(JTable emptable,String tablename) {
        ResultSet rs = sqlQu.getMembers(tablename);

        // Ensure rs is not null
        if (rs == null) {
            JOptionPane.showMessageDialog(null, "The result set is null.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            DefaultTableModel tableModel = new DefaultTableModel();
            Vector<String> columnNames = new Vector<>();

            // Get column names from the ResultSetMetaData
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }
            tableModel.setColumnIdentifiers(columnNames);

            // Clear the current rows
            tableModel.setRowCount(0);

            // Add rows from the ResultSet
            while (rs.next()) {
                Vector<Object> row = new Vector<>(columnCount);
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row.add(rs.getObject(columnIndex));
                }
                tableModel.addRow(row);
            }

            // Set the model to the table
            emptable.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong while retrieving data.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


}