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

public class TableModelRacuni
        extends AbstractTableModel {

    public int getColumnCount() {
        return RacuniDB.getDBRacuni().getColumnCount();
    }

    public int getRowCount() {
        return RacuniDB.getDBRacuni().getRowCount();
    }

    public String getColumnName(int col) {
        return RacuniDB.getDBRacuni().columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return RacuniDB.getDBRacuni().getValueAt(row, col);
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
