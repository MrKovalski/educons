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
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import projekat.logIn.UserData;

public class TableModelStatusi
        extends AbstractTableModel {

    public int getColumnCount() {
        return UserData.getUserData().columnNamesStatusi.length;
    }

    public String getColumnName(int col) {
        return UserData.getUserData().columnNamesStatusi[col];
    }

    public int getRowCount() {
        if (UserData.getUserData().selektovanUser != null) {
            return UserData.getUserData().selektovanUser.getStavke().size();
        }
        return 0;
    }

    public Object getValueAt(int arg0, int arg1) {
        Object retVal = "";
        if (UserData.getUserData().selektovanUser != null) {
            retVal = UserData.getUserData().getStatusiValueAt(arg0, arg1);
        }
        return retVal;
    }
}
