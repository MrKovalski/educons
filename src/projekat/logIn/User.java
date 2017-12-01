/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat.logIn;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import projekat.classes.Statusi;

public class User {

    protected String sifra;
    protected String ime;
    protected String prezime;
    protected String username;
    protected String password;
    protected int addmin;
    protected String datumZaposlenja;
    protected String datumOtkaz;
    public ArrayList<Statusi> stavke = new ArrayList();

    // Konstruktor sa jednim parametrom; tokenizer se ponasa kao split i pita da li je datoteka dobro  napisana
    public User(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text, "\\|");
        if (tokenizer.countTokens() < 8) {
            JOptionPane.showMessageDialog(null, "Tekst \"" + text + "\" nije dobro formatiran", "Greska parsiranja podataka iz datoteke", 0);
            System.exit(0);
        }
        //inicijalizacija polja klase
        this.sifra = tokenizer.nextToken();
        this.ime = tokenizer.nextToken();
        this.prezime = tokenizer.nextToken();
        this.username = tokenizer.nextToken();
        this.password = tokenizer.nextToken();
        this.datumZaposlenja = tokenizer.nextToken();
        this.datumOtkaz = tokenizer.nextToken();
        this.addmin = Integer.parseInt(tokenizer.nextToken());
        while (tokenizer.hasMoreTokens()) {
            String[] splitStavke = tokenizer.nextToken().split(";");

            this.stavke.add(new Statusi(splitStavke[0], splitStavke[1], splitStavke[2], Integer.parseInt(splitStavke[3])));
        }

    }

    //konstruktor za logIn
    public User(String sifra, String ime, String prezime) {
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
    }

    //prazan konstruktor
    public User() {
    }

    // geteri i seteri i nacin pisanja u Fajl
    public String getSifra() {
        return this.sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return this.ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return this.prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAddmin() {
        return addmin;
    }

    public void setAddmin(int addmin) {
        this.addmin = addmin;
    }

    //provera da li je admin ili je obrisan ili je radnik
    public boolean isAddmin() {
        if (this.addmin == 1) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Statusi> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<Statusi> stavke) {
        this.stavke = stavke;
    }

    public String getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(String datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public String getDatumOtkaz() {
        return datumOtkaz;
    }

    public void setDatumOtkaz(String datumOtkaz) {
        this.datumOtkaz = datumOtkaz;
    }

    public void addStatusi(Statusi st) {
        this.stavke.add(st);
    }

    public void removeStatusi(int index) {
        this.stavke.remove(index);
    }

    public void removeAllStatusi() {
        this.stavke.clear();
    }

    //redefinisana toString metoda
    public String toString() {
        return this.ime + " " + this.prezime;
    }

    //upisivanje u fajl 
    public String toFile() {

        String retVal = this.sifra + "||" + this.ime + "||" + this.prezime + "||" + this.username + "||" + this.password + "||" 
                + this.datumZaposlenja + "||" + this.datumOtkaz + "||" + this.addmin + "||";
        for (Statusi st : this.stavke) {
            retVal = retVal + st.toFile() + "|";
        }
        return retVal;
    }

}
