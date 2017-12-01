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
public abstract class Artikal {

    String sifra;
    String naslov;
    double cena;
    int kolicina;
    String tip;

    public Artikal(String sifra, String naslov, double cena, int kolicina, String tip) {
        this.sifra = sifra;
        this.naslov = naslov;
        this.cena = cena;
        this.kolicina = kolicina;
        this.tip = tip;
    }

    public String getSifra() {
        return this.sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaslov() {
        return this.naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public double getCena() {
        return this.cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return this.kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getTip() {
        return this.tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String toFile() {
        return this.sifra + "|" + this.naslov + "|" + this.cena + "|" + this.kolicina + "|" + this.tip;
    }
}
