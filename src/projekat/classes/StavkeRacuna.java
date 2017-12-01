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
public class StavkeRacuna {

    int redniBroj;
    String sifraArtikla;
    String nazivArtikla;
    int kolicina;
    double jedinicnaCena;

    public StavkeRacuna(int redniBroj, String sifraArtikla, String nazivArtikla, int kolicina, double jedinicnaCena) {
        this.redniBroj = redniBroj;
        this.sifraArtikla = sifraArtikla;
        this.nazivArtikla = nazivArtikla;
        this.kolicina = kolicina;
        this.jedinicnaCena = jedinicnaCena;
    }

    public int getRedniBroj() {
        return this.redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getSifraArtikla() {
        return this.sifraArtikla;
    }

    public void setSifraArtikla(String sifraArtikla) {
        this.sifraArtikla = sifraArtikla;
    }

    public String getNazivArtikla() {
        return this.nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
    }

    public int getKolicina() {
        return this.kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getJedinicnaCena() {
        return this.jedinicnaCena;
    }

    public void setJedinicnaCena(double jedinicnaCena) {
        this.jedinicnaCena = jedinicnaCena;
    }

    public double getUkupnaCena() {
        return this.kolicina * this.jedinicnaCena;
    }

    public String toFile() {
        return this.redniBroj + ";" + this.sifraArtikla + ";" + this.nazivArtikla + ";" + this.kolicina + ";" + this.jedinicnaCena + ";" + getUkupnaCena();
    }
}
