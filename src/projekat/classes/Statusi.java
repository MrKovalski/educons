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
public class Statusi {

    String sifraUser;
    String vreme;
    String datum;
    int status;

    public Statusi(String sifraUser, String vreme, String datum, int status) {
        this.sifraUser = sifraUser;
        this.vreme = vreme;
        this.datum = datum;
        this.status = status;
    }

    public String getSifraUser() {
        return sifraUser;
    }

    public void setSifraUser(String sifraUser) {
        this.sifraUser = sifraUser;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toFile() {
        return this.sifraUser + ";" + this.vreme + ";" + this.datum + ";" + this.status;
    }
}
