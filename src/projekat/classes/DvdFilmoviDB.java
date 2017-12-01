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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DvdFilmoviDB {

    private static DvdFilmoviDB singltonKlasaDBDvd = null;
    public ArrayList<DvdFilmovi> dvdFilmovi;
    public String[] columnNames = {"Šifra", "Naziv", "Žanr", "Režiser", "Godina izdanja", "Cena", "Kolicina"};
    String separatorPutanje = System.getProperty("file.separator");

    public static DvdFilmoviDB getDBDvd() {
        if (singltonKlasaDBDvd == null) {
            singltonKlasaDBDvd = new DvdFilmoviDB();
            singltonKlasaDBDvd.InitData();
        }
        return singltonKlasaDBDvd;
    }

    public void InitData() {
        citajIzFajla();
    }

    public int getRowCount() {
        return this.dvdFilmovi.size();
    }

    public int getColumnCount() {
        return this.columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return getValueAt(rowIndex, columnIndex, this.dvdFilmovi);
    }

    public Object getValueAt(int rowIndex, int columnIndex, ArrayList<DvdFilmovi> listaDvdFilmova) {
        Object retVal = "";
        if ((listaDvdFilmova.size() > rowIndex) && (8 > columnIndex)) {
            DvdFilmovi dt = (DvdFilmovi) listaDvdFilmova.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    retVal = dt.getSifra();
                    break;
                case 1:
                    retVal = dt.getNaslov();
                    break;
                case 2:
                    retVal = dt.getZanr();
                    break;

                case 3:
                    retVal = dt.getReziser();
                    break;
                case 4:
                    retVal = dt.getGodinaIzdanja();
                    break;
                case 5:
                    retVal = Double.valueOf(dt.getCena());
                    break;
                case 6:
                    retVal = Integer.valueOf(dt.getKolicina());
            }
        }
        return retVal;
    }

    public ArrayList<DvdFilmovi> getdvdFilmovi() {
        return this.dvdFilmovi;
    }

    public void citajIzFajla() {
        this.dvdFilmovi = new ArrayList();
        String putanja = "." + this.separatorPutanje + "artikli" + this.separatorPutanje + "dvd.dat";
        try {
            BufferedReader ucitano = new BufferedReader(new FileReader(putanja));
            String text = "";
            while ((text = ucitano.readLine()) != null) {
                this.dvdFilmovi.add(new DvdFilmovi(text));
            }
            ucitano.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pisiUFajl() {
        String putanja = "." + this.separatorPutanje + "artikli" + this.separatorPutanje + "dvd.dat";
        try {
            PrintWriter out = new PrintWriter(new FileWriter(putanja));
            for (DvdFilmovi dvd : this.dvdFilmovi) {
                out.println(dvd.toFile());
            }
            out.flush();
            out.close();
        } catch (IOException localException) {
        }
    }

    public void dodajFilm(DvdFilmovi film) {
        this.dvdFilmovi.add(film);
    }
}
