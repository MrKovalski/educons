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

public class DvdFilmovi
        extends Artikal {

    String zanr;
    //ArrayList<String> listaGlumaca;
    String reziser;
    String godinaIzdanja;
    double duzinaTrajanja;

    public DvdFilmovi() {
        this("", "", 0.0D, 0, "", 0.0D, "", "", "");
    }

    public DvdFilmovi(String sifra, String naslov, double cena, int kolicina, String tip, double duzinaTrajanja, String zanr, String reziser, String godinaIzdanja) {
        super(sifra, naslov, cena, kolicina, tip);
        this.duzinaTrajanja = duzinaTrajanja;
        this.zanr = zanr;
        this.reziser = reziser;
        this.godinaIzdanja = godinaIzdanja;
    }

    public DvdFilmovi(String text) {
        this();
        String[] split = text.split("\\|");
        if (split.length < 9) {
            JOptionPane.showMessageDialog(null, "Tekst \"" + text + "\" nije dobro formatiran", "Greska parsiranja podataka iz datoteke", 0);
            System.exit(0);
        }
        this.sifra = split[0];
        this.naslov = split[1];
        this.cena = Double.parseDouble(split[2]);
        this.kolicina = Integer.parseInt(split[3]);
        this.tip = split[4];
        this.duzinaTrajanja = Double.parseDouble(split[5]);
        this.zanr = split[6];

        this.reziser = split[7];
        this.godinaIzdanja = split[8];
    }

    public String getZanr() {
        return this.zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getReziser() {
        return this.reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public String getGodinaIzdanja() {
        return this.godinaIzdanja;
    }

    public void setGodinaIzdanja(String godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public double getDuzinaTrajanja() {
        return this.duzinaTrajanja;
    }

    public void setDuzinaTrajanja(double duzinaTrajanja) {
        this.duzinaTrajanja = duzinaTrajanja;
    }

    //pretvara ga u fajl i vraca nam film
    public String VratiDVDFilm() {
        String DVDFilm = toFile();
        return DVDFilm;
    }

    public String toFile() {
        String lista = super.toFile();

        lista = lista + "|" + this.duzinaTrajanja + "|" + this.zanr + "|"
                + this.reziser + "|" + this.godinaIzdanja;
        return lista;
    }
}
