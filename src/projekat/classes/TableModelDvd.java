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

public class TableModelDvd
        extends AbstractTableModel {

    public String traziSifra = null;
    public String traziNaziv = null;
    public String traziZanr = null;
    public String traziReziser = null;
    public String traziGodinaIzdanja = null;
    public ArrayList<DvdFilmovi> allPretrazeniDvd = new ArrayList();
    public String traziKolicina = null;

    public int getColumnCount() {
        return DvdFilmoviDB.getDBDvd().getColumnCount();
    }

    public int getRowCount() {
        int retVal = -1;
        if ((this.traziSifra != null) || (this.traziNaziv != null) || (this.traziZanr != null) || (traziKolicina != null) || (this.traziReziser != null) || (this.traziGodinaIzdanja != null)) {
            retVal = this.allPretrazeniDvd.size();
        } else {
            retVal = DvdFilmoviDB.getDBDvd().getRowCount();
        }
        return retVal;
    }

    public String getColumnName(int col) {
        return DvdFilmoviDB.getDBDvd().columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Object retVal = "";
        if ((this.traziSifra != null) || (this.traziNaziv != null) || (this.traziZanr != null) || (traziKolicina != null) || (this.traziReziser != null) || (this.traziGodinaIzdanja != null)) {
            if (!this.allPretrazeniDvd.isEmpty()) {
                retVal = DvdFilmoviDB.getDBDvd().getValueAt(row, col, this.allPretrazeniDvd);
            }
        } else {
            retVal = DvdFilmoviDB.getDBDvd().getValueAt(row, col);
        }
        return retVal;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void setTraziDvd(String sifra, String naslov, String zanr, String kolicina, String reziser, String godinaIzdanja) {
        this.traziSifra = sifra;
        this.traziNaziv = naslov;
        this.traziZanr = zanr;
        this.traziKolicina = kolicina;
        this.traziReziser = reziser;
        this.traziGodinaIzdanja = godinaIzdanja;

        this.allPretrazeniDvd.clear();
        //dok ne prodje kroz sve artikle traje for
        for (DvdFilmovi dt : DvdFilmoviDB.getDBDvd().dvdFilmovi) {
            boolean pripada = true;
            //proverava da li je trazena sifra
            if ((this.traziSifra != null) && (!this.traziSifra.trim().equalsIgnoreCase(""))
                    && (!dt.getSifra().equalsIgnoreCase(this.traziSifra.trim()))) {
                pripada = false;
            }
            if ((this.traziNaziv != null) && (!this.traziNaziv.trim().equalsIgnoreCase(""))
                    && (!dt.getNaslov().equalsIgnoreCase(this.traziNaziv.trim()))) {
                pripada = false;
            }
            if ((this.traziZanr != null) && (!this.traziZanr.trim().equalsIgnoreCase(""))
                    && (!dt.getZanr().equalsIgnoreCase(this.traziZanr.trim()))) {
                pripada = false;
            }
            //------------
            if ((this.traziKolicina != null) && (!this.traziKolicina.trim().equalsIgnoreCase(""))
                    && (!Integer.toString(dt.getKolicina()).equalsIgnoreCase(this.traziKolicina.trim()))) {
                pripada = false;
            }

            //------------
            if ((this.traziReziser != null) && (!this.traziReziser.trim().equalsIgnoreCase(""))
                    && (!dt.getReziser().equalsIgnoreCase(this.traziReziser.trim()))) {
                pripada = false;
            }
            if ((this.traziGodinaIzdanja != null) && (!this.traziGodinaIzdanja.trim().equalsIgnoreCase(""))
                    && (!dt.getGodinaIzdanja().equalsIgnoreCase(this.traziGodinaIzdanja.trim()))) {
                pripada = false;
            }
            if (pripada) {
                this.allPretrazeniDvd.add(dt);
            }
        }
    }

    public void setPonistiDvd() {
        this.traziSifra = null;
        this.traziNaziv = null;
        this.traziZanr = null;
        this.traziKolicina = null;
        this.traziReziser = null;
        this.traziGodinaIzdanja = null;
        this.allPretrazeniDvd.clear();
    }

//    public void setTraziDvd(String text, String text0, String text1, String text2, String text3) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
