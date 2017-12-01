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

public class TableModelArtikli
        extends AbstractTableModel {

    public String traziSifra = null;
    public String traziNaziv = null;
    public ArrayList<Artikal> allPretrazeniArtikli = new ArrayList();

    public int getColumnCount() {
        return ArtikalDB.getDBArtikli().columnNames.length;
    }

    public int getRowCount() {
        int retVal = -1;
        if ((this.traziSifra != null) || (this.traziNaziv != null)) {
            retVal = this.allPretrazeniArtikli.size();
        } else {
            retVal = ArtikalDB.getDBArtikli().getRowCount();
        }
        return retVal;
    }

    public String getColumnName(int col) {
        return ArtikalDB.getDBArtikli().columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Object retVal = "";
        if ((this.traziSifra != null) || (this.traziNaziv != null)) {
            if (!this.allPretrazeniArtikli.isEmpty()) {
                retVal = ArtikalDB.getDBArtikli().getValueAt(row, col, this.allPretrazeniArtikli);
            }
        } else {
            retVal = ArtikalDB.getDBArtikli().getValueAt(row, col);
        }
        return retVal;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void setTrazi(String sifra, String naziv) {
        this.traziSifra = sifra;
        this.traziNaziv = naziv;

        this.allPretrazeniArtikli.clear();
        for (Artikal ar : ArtikalDB.getDBArtikli().allArtikli) {
            boolean pripada = true;
            if ((this.traziSifra != null) && (!this.traziSifra.trim().equalsIgnoreCase(""))
                    && (!ar.getSifra().equalsIgnoreCase(this.traziSifra.trim()))) {
                pripada = false;
            }
            if ((this.traziNaziv != null) && (!this.traziNaziv.trim().equalsIgnoreCase(""))
                    && (!ar.getNaslov().startsWith(this.traziNaziv.trim()))) {
                pripada = false;
            }
            if (pripada) {
                this.allPretrazeniArtikli.add(ar);
            }
        }
    }

    public void setPonisti() {
        this.traziSifra = null;
        this.traziNaziv = null;
        this.allPretrazeniArtikli.clear();
    }
}
