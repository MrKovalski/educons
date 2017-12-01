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
import javax.swing.JOptionPane;

public class Racuni {

    String sifra;
    String datum;
    double ukupnaCena;
    String sifraRadnika;
    ArrayList<StavkeRacuna> stavke = new ArrayList();

    public Racuni(String sifra, String datum, double ukupnaCena, String sifraRadnika) {
        this.sifra = sifra;
        this.datum = datum;
        this.ukupnaCena = ukupnaCena;
        this.sifraRadnika = sifraRadnika;
    }

    public Racuni(String text) {
        String[] split = text.split("\\|");
        if (split.length < 5) {
            JOptionPane.showMessageDialog(null, "Tekst \"" + text + "\" nije dobro formatiran", "Greska parsiranja podataka iz datoteke", 0);
            System.exit(0);
        }
        this.sifra = split[0];
        this.datum = split[1];
        this.ukupnaCena = Double.parseDouble(split[2]);
        this.sifraRadnika = split[3];
        for (int i = 4; i < split.length; i++) {
            String[] splitStavke = split[i].split(";");

            this.stavke.add(new StavkeRacuna(Integer.parseInt(splitStavke[0]), splitStavke[1], splitStavke[2],
                    Integer.parseInt(splitStavke[3]), Double.parseDouble(splitStavke[4])));
        }
    }

    public String getSifra() {
        return this.sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getDatum() {
        return this.datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getUkupnaCena() {
        return this.ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public String getSifraRadnika() {
        return this.sifraRadnika;
    }

    public void setSifraRadnika(String sifraRadnika) {
        this.sifraRadnika = sifraRadnika;
    }

    public ArrayList<StavkeRacuna> getStavke() {
        return this.stavke;
    }

    public void setStavke(ArrayList<StavkeRacuna> stavke) {
        this.stavke = stavke;
    }

    public void addStavke(StavkeRacuna st) {
        this.stavke.add(st);
    }

    public void removeStavke(int index) {
        this.stavke.remove(index);
    }

    public void removeAllStavke() {
        this.stavke.clear();
    }

    public String toFile() {
        String retVal = this.sifra + "|" + this.datum + "|" + this.ukupnaCena + "|" + this.sifraRadnika + "|";
        for (StavkeRacuna st : this.stavke) {
            retVal = retVal + st.toFile() + "|";
        }
        return retVal;
    }
}
