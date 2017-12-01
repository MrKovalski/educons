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
import java.util.HashMap;
import projekat.logIn.User;
import projekat.logIn.UserData;

public class RacuniDB {

    private static RacuniDB singltonKlasaDBRacuni = null;
    public ArrayList<Racuni> sviRacuni;
    public Racuni selektovanRacun;
    public String[] columnNames = {"Šifra", "Ukupna Cena", "Šifra radnika"};
    public String[] columnNamesStavke = {"RedniBroj", "Sifra Artikla", "Naziv Artikla", "Kolicina", "Jedinicna Cena", "UkupnaCena"};
    String separatorPutanje = System.getProperty("file.separator");
    private HashMap<String, User> allUsers = new HashMap();

    public static RacuniDB getDBRacuni() {
        if (singltonKlasaDBRacuni == null) {
            singltonKlasaDBRacuni = new RacuniDB();
            singltonKlasaDBRacuni.initData();
        }
        return singltonKlasaDBRacuni;
    }

    public void initData() {
        citajIzFajla();
        this.allUsers.clear();
        for (User ur : UserData.getUserData().getAllUsers()) {
            this.allUsers.put(ur.getSifra(), ur);
        }
    }

    public int getRowCount() {
        return this.sviRacuni.size();
    }

    public int getColumnCount() {
        return this.columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retVal = "";
        if ((this.sviRacuni.size() > rowIndex) && (3 > columnIndex)) {
            Racuni t = (Racuni) this.sviRacuni.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return t.getSifra();
                case 1:
                    return Double.valueOf(t.getUkupnaCena());
                case 2:
                    return t.getSifraRadnika() + " " + ((User) this.allUsers.get(t.getSifraRadnika())).getIme() + " " + ((User) this.allUsers.get(t.getSifraRadnika())).getPrezime();
            }
        }
        return retVal;
    }

    public Object getStavkaValueAt(int rowIndex, int columnIndex) {
        Object retVal = "";
        if ((this.selektovanRacun != null) && (6 > columnIndex)) {
            StavkeRacuna stavka = (StavkeRacuna) this.selektovanRacun.stavke.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    retVal = Integer.valueOf(stavka.getRedniBroj());
                    break;
                case 1:
                    retVal = stavka.getSifraArtikla();
                    break;
                case 2:
                    retVal = stavka.getNazivArtikla();
                    break;
                case 3:
                    retVal = Integer.valueOf(stavka.getKolicina());
                    break;
                case 4:
                    retVal = Double.valueOf(stavka.getJedinicnaCena());
                    break;
                case 5:
                    retVal = Double.valueOf(stavka.getJedinicnaCena() * stavka.getKolicina());
            }
        }
        return retVal;
    }

    public ArrayList<Racuni> getRacuni() {
        return this.sviRacuni;
    }

    public void citajIzFajla() {
        this.sviRacuni = new ArrayList();
        String putanja = "." + this.separatorPutanje + "artikli" + this.separatorPutanje + "racuni.dat";
        try {
            BufferedReader ucitano = new BufferedReader(new FileReader(putanja));
            String text = "";
            while ((text = ucitano.readLine()) != null) {
                this.sviRacuni.add(new Racuni(text));
            }
            ucitano.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!this.sviRacuni.isEmpty()) {
            this.selektovanRacun = ((Racuni) this.sviRacuni.get(0));
        }
    }

    public void pisiUFajl() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("." + this.separatorPutanje + "artikli" + this.separatorPutanje + "racuni.dat"));
            for (Racuni racun : this.sviRacuni) {
                out.println(racun.toFile());
            }
            out.flush();
            out.close();
        } catch (Exception localException) {
        }
    }

    public void dodajRacun(Racuni racun) {
        this.sviRacuni.add(racun);
    }

    public Racuni getSelektovanRacun() {
        return this.selektovanRacun;
    }

    public void setSelektovanRacun(Racuni selektovanRacun) {
        this.selektovanRacun = selektovanRacun;
    }
}
