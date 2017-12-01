/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat.classes;

/**
 *
 * @author User
 */
import javax.swing.table.AbstractTableModel;
import projekat.logIn.UserData;

public class TableModelRadnici
        extends AbstractTableModel {

    public TableModelRadnici() {

    }

    public int getColumnCount() {
        return UserData.getUserData().getColumnCount();
    }

    public int getRowCount() {
        return UserData.getUserData().getRowCount();
    }

    public String getColumnName(int col) {
        return UserData.getUserData().getColumnNamesUser()[col];
    }

    public Object getValueAt(int row, int col) {
        return UserData.getUserData().getValueAt(row, col);
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
