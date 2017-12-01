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

public class ArtikalDB {

    private static ArtikalDB singltonKlasaDBArtikli = null;
    public ArrayList<Artikal> allArtikli;
    public String[] columnNames = {"Šifra", "Naziv", "Cena", "Kolicina"};

    public static ArtikalDB getDBArtikli() {
        if (singltonKlasaDBArtikli == null) {
            singltonKlasaDBArtikli = new ArtikalDB();
            singltonKlasaDBArtikli.initData();
        }
        return singltonKlasaDBArtikli;
    }

    public void initData() {
        this.allArtikli = new ArrayList();

        DvdFilmoviDB tempDBDvd = DvdFilmoviDB.getDBDvd();
        for (DvdFilmovi dvdFilmovi : tempDBDvd.getdvdFilmovi()) {
            this.allArtikli.add(dvdFilmovi);
        }

    }

    public int getRowCount() {
        return this.allArtikli.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return getValueAt(rowIndex, columnIndex, this.allArtikli);
    }

    public Object getValueAt(int rowIndex, int columnIndex, ArrayList<Artikal> listaArtikla) {
        Object retVal = "";
        if ((listaArtikla.size() > rowIndex) && (4 > columnIndex)) {
            Artikal item = (Artikal) listaArtikla.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    retVal = item.getSifra();
                    break;
                case 1:
                    retVal = item.getNaslov();
                    break;
                case 2:
                    retVal = Double.valueOf(item.getCena());
                    break;
                case 3:
                    retVal = Integer.valueOf(item.getKolicina());
            }
        }
        return retVal;
    }
}
