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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import projekat.classes.Racuni;
import projekat.classes.Statusi;

public class UserData {

    /*
    singltonKlasa sluzi za inicijalno popunjavanje liste u koliko ona ne postoji
    allUsers lista svih zaposlenih
    separator putanje generise putanju u odnosu na operativni sistem
     */
    private static UserData singltonKlasaUserData = null;
    public ArrayList<User> allUsers;
    
    public User selektovanUser;
    public String[] columnNamesUser = {"Šifra", "Ime", "Prezime", "Datum zaposlenja", "Datum prestanka rada", "Status"};
    public String[] columnNamesStatusi = {"Šifra", "Datum promene statusa", "Vreme promene statusa", "Status"};
    String separatorPutanje = System.getProperty("file.separator");
    //mapira usere i statuse    
    public HashMap<String, User> allUsersHash = new HashMap();

    //inicijalizuje klasu pomocu User Data
    public static UserData getUserData() {
        if (singltonKlasaUserData == null) {
            singltonKlasaUserData = new UserData();
            singltonKlasaUserData.initData();
        }
        return singltonKlasaUserData;
    }

    //inicijalizacija
    public void initData() {
        citajIzFajla();
        this.allUsersHash.clear();
        for (User ur : UserData.getUserData().getAllUsers()) {
            this.allUsersHash.put(ur.getSifra(), ur);
        }
    }

    // geter za listu zaposlenih
    public ArrayList<User> getAllUsers() {
        return this.allUsers;
    }

    //seter za listu zaposlenih
    public void setAllUsers(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }

    public static UserData getSingltonKlasaUserData() {
        return singltonKlasaUserData;
    }

    public static void setSingltonKlasaUserData(UserData singltonKlasaUserData) {
        UserData.singltonKlasaUserData = singltonKlasaUserData;
    }

    public String getSeparatorPutanje() {
        return separatorPutanje;
    }

    public void setSeparatorPutanje(String separatorPutanje) {
        this.separatorPutanje = separatorPutanje;
    }

    public String[] getColumnNamesUser() {
        return columnNamesUser;
    }

    public void setColumnNamesUser(String[] columnNamesUser) {
        this.columnNamesUser = columnNamesUser;
    }

    public String[] getColumnNamesStatusi() {
        return this.columnNamesStatusi;
    }

    public void setColumnNamesStatusi(String[] columnNamesStatusi) {
        this.columnNamesStatusi = columnNamesStatusi;
    }

    public int getRowCount() {
        return this.allUsers.size();
    }

    public int getColumnCount() {
        return this.columnNamesUser.length;
    }

    public User getSelektovanUser() {
        return this.selektovanUser;
    }

    public void setSelektovanUser(User selektovanUser) {
        this.selektovanUser = selektovanUser;
    }

    public HashMap<String, User> getAllUsersHash() {
        return allUsersHash;
    }

    public void setAllUsersHash(HashMap<String, User> allUsersHash) {
        this.allUsersHash = allUsersHash;
    }

    //citanje podatak iz tekstualnog fajla
    public void citajIzFajla() {
        this.allUsers = new ArrayList();
        String putanja = "." + this.separatorPutanje + "usersPodaci.dat";
        try {
            BufferedReader in = new BufferedReader(new FileReader(putanja));
            String s;
            while ((s = in.readLine()) != null) {
                //String s , smesta sve tokene od jednog usera u jednu listu ;
                User tempUser = new User(s);
                this.allUsers.add(tempUser);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Greska pri očitavanju");
        }
        if (!this.allUsers.isEmpty()) {
            this.selektovanUser = ((User) this.allUsers.get(0));
        }
    }

    //upisuje u fajl ,otvara ga i koristi toFile za upisivanje u fajl
    public void pisiUFajl() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("." + this.separatorPutanje + "usersPodaci.dat"));
            for (User us : this.allUsers) {
                out.println(us.toFile());
            }
            out.flush();
            out.close();
        } catch (Exception localException) {
        }
    }

    //vraca nam vrednost objekta u zavisnosti od unosa iz tabela ne direktno iz fajla
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retVal = "";
        if ((this.allUsers.size() > rowIndex) && (6 > columnIndex)) {
            //privremeni user
            User t = (User) this.allUsers.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return t.getSifra();
                case 1:
                    return t.getIme();
                case 2:
                    return t.getPrezime();
                case 3:
                    return t.getDatumZaposlenja();
                case 4:
                    return t.getDatumOtkaz();
                case 5:
                    //jos jedan switch koji proverava status radnika 
                    switch (t.getAddmin()) {
                        case 0:
                            return "radnik";
                        case 1:
                            return "sef";
                        case 2:
                            return "obrisan";
                        default:
                            return "Postoji greska u fajlu";
                    }
            }
        }
        return retVal;
    }

    //---------------------------------------
    //vraca nam vrednost objekta u zavisnosti od unosa iz tabela ne direktno iz fajla
    public Object getStatusiValueAt(int rowIndex, int columnIndex) {
        Object retVal = "";
        if ((this.selektovanUser != null) && (4 > columnIndex)) {
            Statusi stavka = (Statusi) this.selektovanUser.stavke.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    retVal = stavka.getSifraUser();
                    break;
                case 1:
                    retVal = stavka.getDatum();
                    break;
                case 2:
                    retVal = stavka.getVreme();
                    break;
                case 3:
                    retVal = String.valueOf(stavka.getStatus());

            }
        }
        return retVal;
    }

    //----------------------------------------------------------------------
    //metoda za dodavanje novog usera 
    public void dodajUser(User user) {
        this.allUsers.add(user);
    }
}
