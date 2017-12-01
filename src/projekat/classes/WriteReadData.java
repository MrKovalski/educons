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
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteReadData {

    public boolean WriteDataInFile(String unetiArtikal) {
        if (unetiArtikal != null) {
            String[] tip = unetiArtikal.split("\\|");

            if (tip[4].equals("DVD film")) {
                String relacija2 = "artikli/dvd.dat";
                //privremena lista
                ArrayList<String> temp = new ArrayList();
                //lista artikala
                ArrayList<String> artikli = new ArrayList();
                //dodavanje svih elemenata u listu
                artikli.addAll(reading(relacija2));
                temp.addAll(reading(relacija2));
                return writing(unetiArtikal, temp, relacija2, artikli);
            }
        }
        return true;
    }

    public ArrayList<String> reading(String putanja) {
        //citanje putanje
        ArrayList<String> linijaIzFajla = new ArrayList();
        try {
            BufferedReader ucitano = new BufferedReader(new FileReader(putanja));

            String red = "";
            while ((red = ucitano.readLine()) != null) {
                linijaIzFajla.add(red);
            }
            ucitano.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linijaIzFajla;
    }

    public boolean writing(String unetiArtikal, ArrayList<String> sviArtikli, String putanja, ArrayList<String> artikliFajla) {
        try {
            String[] unetiSplit = unetiArtikal.split("\\|");
            String unetaSifra = unetiSplit[0];
            for (int i = 0; i < sviArtikli.size(); i++) {
                String[] artikliSplit = ((String) sviArtikli.get(i)).split("\\|");
                String sifra = artikliSplit[0];
                if (sifra.equals(unetaSifra)) {
                    return false;
                }
            }
            BufferedWriter writing = new BufferedWriter(new FileWriter(putanja));
            for (int i = 0; i < artikliFajla.size(); i++) {
                writing.write((String) artikliFajla.get(i) + "\n");
            }
            writing.write(unetiArtikal + "\n");
            writing.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean pisanjeIzmene(String unetiArtikal, String putanja, ArrayList<String> artikliFajla) {
        try {
            String[] unetiSplit = unetiArtikal.split("\\|");
            String unetaSifra = unetiSplit[0];
            for (int i = 0; i < artikliFajla.size(); i++) {
                String[] artikliSplit = ((String) artikliFajla.get(i)).split("\\|");
                String sifra = artikliSplit[0];
                if (sifra.equals(unetaSifra)) {
                    artikliFajla.remove(i);
                    artikliFajla.add(i, unetiArtikal);
                }
            }
            BufferedWriter writing = new BufferedWriter(new FileWriter(putanja));
            for (int i = 0; i < artikliFajla.size(); i++) {
                writing.write((String) artikliFajla.get(i) + "\n");
            }
            writing.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
