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

public class TableModelStavkeRacuna
        extends AbstractTableModel {

    public int getColumnCount() {
        return RacuniDB.getDBRacuni().columnNamesStavke.length;
    }

    public String getColumnName(int col) {
        return RacuniDB.getDBRacuni().columnNamesStavke[col];
    }

    public int getRowCount() {
        if (RacuniDB.getDBRacuni().selektovanRacun != null) {
            return RacuniDB.getDBRacuni().selektovanRacun.stavke.size();
        }
        return 0;
    }

    public Object getValueAt(int arg0, int arg1) {
        Object retVal = "";
        if (RacuniDB.getDBRacuni().selektovanRacun != null) {
            retVal = RacuniDB.getDBRacuni().getStavkaValueAt(arg0, arg1);
        }
        return retVal;
    }
}
