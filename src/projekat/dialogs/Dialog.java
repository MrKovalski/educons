/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat.dialogs;

/**
 *
 * @author User
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import projekat.frejm.Office;
import projekat.classes.DvdFilmovi;
import projekat.classes.DvdFilmoviDB;

public class Dialog
        extends JDialog {

    private Frame parent;
    public static final int UNOS = 0;
    public static final int IZMENA = 1;
    public static final int PREGLED = 2;
    public boolean resultAction = false;
    private int mode;
    private DvdFilmovi dvd;
    private JLabel labelaSifra;
    private JLabel labelaNaziv;
    private JLabel labelaZanr;
    private JLabel labelaReziser;
    private JLabel labelaGodinaIzdanja;
    private JLabel labelaDuzinaTrajanja;
    private JLabel labelaCena;
    private JLabel labelaKolicina;
    private JTextField textFieldSifra;
    private JTextField textFieldNaziv;
    private JTextField textFieldZanr;
    private JTextField textFieldReziser;
    private JTextField textFieldGodinaIzdanja;
    private JTextField textFieldDuzinaTrajanja;
    private JTextField textFieldCena;
    private JTextField textFieldKolicina;
    private JButton btnSave;
    private JButton btnCancel;
    String separatorPutanje = System.getProperty("file.separator");

    //konstruktor (postavlja pocetne vrednosti)
    public Dialog(Frame owner, String title, boolean modal) {
        super(owner, "Dvd Film", modal);
        this.parent = owner;
        String dvdFilmJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "dvdfilm.jpg";
        setIconImage(Toolkit.getDefaultToolkit().getImage(dvdFilmJPGPutanja));
        getContentPane().setForeground(SystemColor.info);
        getContentPane().setBackground(SystemColor.desktop);
        setDefaultCloseOperation(2);
        setComponentsInDialog();
        setLocationRelativeTo(owner);
        pack();
    }

    //iscrtavanje dijaloga
    void setComponentsInDialog() {
        getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbcLabelaSifra = new GridBagConstraints();
        gbcLabelaSifra.gridx = 0;
        gbcLabelaSifra.gridy = 0;
        gbcLabelaSifra.gridwidth = 1;
        gbcLabelaSifra.gridheight = 1;
        gbcLabelaSifra.fill = 0;
        gbcLabelaSifra.ipadx = 0;
        gbcLabelaSifra.ipady = 0;
        gbcLabelaSifra.insets = new Insets(5, 5, 5, 5);
        gbcLabelaSifra.weightx = 0.0D;
        gbcLabelaSifra.weighty = 0.0D;
        this.labelaSifra = new JLabel("Šifra*: ");
        this.labelaSifra.setForeground(SystemColor.info);
        this.labelaSifra.setBackground(SystemColor.info);
        this.labelaSifra.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaSifra, gbcLabelaSifra);

        GridBagConstraints gbcTextFieldSifra = new GridBagConstraints();
        gbcTextFieldSifra.gridx = 1;
        gbcTextFieldSifra.gridy = 0;
        gbcTextFieldSifra.gridwidth = 2;
        gbcTextFieldSifra.gridheight = 1;
        gbcTextFieldSifra.fill = 2;
        gbcTextFieldSifra.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldSifra.weightx = 1.0D;
        this.textFieldSifra = new JTextField(5);
        this.textFieldSifra.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldSifra, gbcTextFieldSifra);

        GridBagConstraints gbcLabelaNaziv = new GridBagConstraints();
        gbcLabelaNaziv.gridx = 0;
        gbcLabelaNaziv.gridy = 1;
        gbcLabelaNaziv.gridwidth = 1;
        gbcLabelaNaziv.gridheight = 1;
        gbcLabelaNaziv.fill = 0;
        gbcLabelaNaziv.insets = new Insets(5, 5, 5, 5);
        gbcLabelaNaziv.weightx = 0.0D;
        this.labelaNaziv = new JLabel("Naziv: ");
        this.labelaNaziv.setForeground(SystemColor.info);
        this.labelaNaziv.setBackground(SystemColor.info);
        this.labelaNaziv.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaNaziv, gbcLabelaNaziv);

        GridBagConstraints gbcTextFieldNaziv = new GridBagConstraints();
        gbcTextFieldNaziv.gridx = 1;
        gbcTextFieldNaziv.gridy = 1;
        gbcTextFieldNaziv.gridwidth = 2;
        gbcTextFieldNaziv.gridheight = 1;
        gbcTextFieldNaziv.fill = 2;
        gbcTextFieldNaziv.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldNaziv.weightx = 1.0D;
        this.textFieldNaziv = new JTextField(20);
        this.textFieldNaziv.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldNaziv, gbcTextFieldNaziv);

        GridBagConstraints gbcLabelaZanr = new GridBagConstraints();
        gbcLabelaZanr.gridx = 0;
        gbcLabelaZanr.gridy = 2;
        gbcLabelaZanr.gridwidth = 1;
        gbcLabelaZanr.gridheight = 1;
        gbcLabelaZanr.insets = new Insets(5, 5, 5, 5);
        gbcLabelaZanr.weightx = 0.0D;
        this.labelaZanr = new JLabel("Zanr: ");
        this.labelaZanr.setForeground(SystemColor.info);
        this.labelaZanr.setBackground(SystemColor.info);
        this.labelaZanr.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaZanr, gbcLabelaZanr);

        GridBagConstraints gbcTextFieldZanr = new GridBagConstraints();
        gbcTextFieldZanr.gridx = 1;
        gbcTextFieldZanr.gridy = 2;
        gbcTextFieldZanr.gridwidth = 2;
        gbcTextFieldZanr.gridheight = 1;
        gbcTextFieldZanr.fill = 2;
        gbcTextFieldZanr.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldZanr.weightx = 1.0D;
        this.textFieldZanr = new JTextField(20);
        this.textFieldZanr.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldZanr, gbcTextFieldZanr);

        GridBagConstraints gbcLabelaReziser = new GridBagConstraints();
        gbcLabelaReziser.gridx = 0;
        gbcLabelaReziser.gridy = 3;
        gbcLabelaReziser.gridwidth = 1;
        gbcLabelaReziser.gridheight = 1;
        gbcLabelaReziser.insets = new Insets(5, 5, 5, 5);
        gbcLabelaReziser.weightx = 0.0D;
        this.labelaReziser = new JLabel("Režiser: ");
        this.labelaReziser.setForeground(SystemColor.info);
        this.labelaReziser.setBackground(SystemColor.info);
        this.labelaReziser.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaReziser, gbcLabelaReziser);

        GridBagConstraints gbcTextFieldReziser = new GridBagConstraints();
        gbcTextFieldReziser.gridx = 1;
        gbcTextFieldReziser.gridy = 3;
        gbcTextFieldReziser.gridwidth = 2;
        gbcTextFieldReziser.gridheight = 1;
        gbcTextFieldReziser.fill = 2;
        gbcTextFieldReziser.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldReziser.weightx = 1.0D;
        this.textFieldReziser = new JTextField(20);
        this.textFieldReziser.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldReziser, gbcTextFieldReziser);

        GridBagConstraints gbcLabelaGodinaIzdanja = new GridBagConstraints();
        gbcLabelaGodinaIzdanja.gridx = 0;
        gbcLabelaGodinaIzdanja.gridy = 4;
        gbcLabelaGodinaIzdanja.gridwidth = 1;
        gbcLabelaGodinaIzdanja.gridheight = 1;
        gbcLabelaGodinaIzdanja.fill = 2;
        gbcLabelaGodinaIzdanja.insets = new Insets(5, 5, 5, 5);
        gbcLabelaGodinaIzdanja.weightx = 0.0D;
        this.labelaGodinaIzdanja = new JLabel("Godina Izdanja: ");
        this.labelaGodinaIzdanja.setForeground(SystemColor.info);
        this.labelaGodinaIzdanja.setBackground(SystemColor.info);
        this.labelaGodinaIzdanja.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaGodinaIzdanja, gbcLabelaGodinaIzdanja);

        GridBagConstraints gbcTextFieldGodinaIzdanja = new GridBagConstraints();
        gbcTextFieldGodinaIzdanja.gridx = 1;
        gbcTextFieldGodinaIzdanja.gridy = 4;
        gbcTextFieldGodinaIzdanja.gridwidth = 2;
        gbcTextFieldGodinaIzdanja.gridheight = 1;
        gbcTextFieldGodinaIzdanja.fill = 2;
        gbcTextFieldGodinaIzdanja.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldGodinaIzdanja.weightx = 1.0D;
        this.textFieldGodinaIzdanja = new JTextField(20);
        this.textFieldGodinaIzdanja.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldGodinaIzdanja, gbcTextFieldGodinaIzdanja);

        GridBagConstraints gbcLabelaDuzinaTrajanja = new GridBagConstraints();
        gbcLabelaDuzinaTrajanja.gridx = 0;
        gbcLabelaDuzinaTrajanja.gridy = 7;
        gbcLabelaDuzinaTrajanja.gridwidth = 1;
        gbcLabelaDuzinaTrajanja.gridheight = 1;
        gbcLabelaDuzinaTrajanja.insets = new Insets(5, 5, 5, 5);
        gbcLabelaDuzinaTrajanja.weightx = 0.0D;
        this.labelaDuzinaTrajanja = new JLabel("Dužina trajanja: ");
        this.labelaDuzinaTrajanja.setForeground(SystemColor.info);
        this.labelaDuzinaTrajanja.setBackground(SystemColor.info);
        this.labelaDuzinaTrajanja.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaDuzinaTrajanja, gbcLabelaDuzinaTrajanja);

        GridBagConstraints gbcTextFieldDuzinaTrajanja = new GridBagConstraints();
        gbcTextFieldDuzinaTrajanja.fill = 2;
        gbcTextFieldDuzinaTrajanja.gridx = 1;
        gbcTextFieldDuzinaTrajanja.gridy = 7;
        gbcTextFieldDuzinaTrajanja.gridwidth = 2;
        gbcTextFieldDuzinaTrajanja.gridheight = 1;
        gbcTextFieldDuzinaTrajanja.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldDuzinaTrajanja.weightx = 1.0D;
        this.textFieldDuzinaTrajanja = new JTextField(20);
        this.textFieldDuzinaTrajanja.setToolTipText("u minutima");
        this.textFieldDuzinaTrajanja.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldDuzinaTrajanja, gbcTextFieldDuzinaTrajanja);

        GridBagConstraints gbcLabelaCena = new GridBagConstraints();
        gbcLabelaCena.gridx = 0;
        gbcLabelaCena.gridy = 8;
        gbcLabelaCena.gridwidth = 1;
        gbcLabelaCena.gridheight = 1;
        gbcLabelaCena.insets = new Insets(5, 5, 5, 5);
        gbcLabelaCena.weightx = 0.0D;
        this.labelaCena = new JLabel("Cena: ");
        this.labelaCena.setForeground(SystemColor.info);
        this.labelaCena.setBackground(SystemColor.text);
        this.labelaCena.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaCena, gbcLabelaCena);

        GridBagConstraints gbcTextFieldCena = new GridBagConstraints();
        gbcTextFieldCena.fill = 2;
        gbcTextFieldCena.gridx = 1;
        gbcTextFieldCena.gridy = 8;
        gbcTextFieldCena.gridwidth = 2;
        gbcTextFieldCena.gridheight = 1;
        gbcTextFieldCena.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldCena.weightx = 1.0D;
        this.textFieldCena = new JTextField(20);
        this.textFieldCena.setToolTipText("u dinarima");
        this.textFieldCena.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldCena, gbcTextFieldCena);

        GridBagConstraints gbcLabelaKolicina = new GridBagConstraints();
        gbcLabelaKolicina.gridx = 0;
        gbcLabelaKolicina.gridy = 9;
        gbcLabelaKolicina.gridwidth = 1;
        gbcLabelaKolicina.gridheight = 1;
        gbcLabelaKolicina.insets = new Insets(5, 5, 5, 5);
        gbcLabelaKolicina.weightx = 0.0D;
        this.labelaKolicina = new JLabel("Količina: ");
        this.labelaKolicina.setForeground(SystemColor.info);
        this.labelaKolicina.setBackground(SystemColor.info);
        this.labelaKolicina.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaKolicina, gbcLabelaKolicina);

        GridBagConstraints gbcTextFieldKolicina = new GridBagConstraints();
        gbcTextFieldKolicina.fill = 2;
        gbcTextFieldKolicina.gridx = 1;
        gbcTextFieldKolicina.gridy = 9;
        gbcTextFieldKolicina.gridwidth = 2;
        gbcTextFieldKolicina.gridheight = 1;
        gbcTextFieldKolicina.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldKolicina.weightx = 1.0D;
        this.textFieldKolicina = new JTextField(20);
        this.textFieldKolicina.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldKolicina, gbcTextFieldKolicina);

        GridBagConstraints gbcDugmeSave = new GridBagConstraints();
        gbcDugmeSave.gridx = 0;
        gbcDugmeSave.gridy = 10;
        gbcDugmeSave.gridwidth = 1;
        gbcDugmeSave.gridheight = 1;
        gbcDugmeSave.insets = new Insets(5, 5, 5, 5);
        gbcDugmeSave.weightx = 0.0D;
        this.btnSave = new JButton("SAVE");
        this.btnSave.setFont(new Font("Tahoma", 3, 12));
        this.btnSave.setBackground(Color.BLUE);
        this.btnSave.setActionCommand("Save");
        //ocitava klik dugmeta i proverava da li je vrednost validna . ako jeste upusuje je u fajl
        this.btnSave.addActionListener((ActionEvent arg0) -> {
            if (Dialog.this.checkAndStore()) {
                Dialog.this.resultAction = true;
                Dialog.this.dispose();
            }
        });
        getContentPane().add(this.btnSave, gbcDugmeSave);

        GridBagConstraints gbcDugmeCancel = new GridBagConstraints();
        gbcDugmeCancel.gridx = 1;
        gbcDugmeCancel.gridy = 10;
        gbcDugmeCancel.gridwidth = 1;
        gbcDugmeCancel.gridheight = 1;
        gbcDugmeCancel.insets = new Insets(5, 5, 5, 5);
        gbcDugmeCancel.weightx = 0.0D;
        this.btnCancel = new JButton("CANCEL");
        this.btnCancel.setFont(new Font("Tahoma", 3, 12));
        this.btnCancel.setBackground(Color.RED);
        this.btnCancel.setActionCommand("Cancel");
        //ponistava sve promene i zatvara prozore
        this.btnCancel.addActionListener((ActionEvent arg0) -> {
            Dialog.this.resultAction = false;
            Dialog.this.dispose();
        });
        getContentPane().add(this.btnCancel, gbcDugmeCancel);
    }

    public DvdFilmovi getDvd() {
        return this.dvd;
    }

    public void setDvd(DvdFilmovi dvd) {
        this.dvd = dvd;
    }

    public int getMode() {
        return this.mode;
    }

    //pregled,unos,izmena
    public void setMode(int mode) {
        this.mode = mode;
        if (mode == 0) {
            this.textFieldSifra.setEditable(true);
            this.textFieldNaziv.setEditable(true);
            this.textFieldZanr.setEditable(true);
            this.textFieldReziser.setEditable(true);
            this.textFieldGodinaIzdanja.setEditable(true);
            this.textFieldDuzinaTrajanja.setEditable(true);
            this.textFieldCena.setEditable(true);
            this.textFieldKolicina.setEditable(true);
            this.btnSave.setEnabled(true);
            this.btnCancel.setEnabled(true);
        } else if (mode == 1) {
            this.textFieldSifra.setEditable(false);
            this.textFieldNaziv.setEditable(true);
            this.textFieldZanr.setEditable(true);
            this.textFieldReziser.setEditable(true);
            this.textFieldGodinaIzdanja.setEditable(true);
            this.textFieldDuzinaTrajanja.setEditable(true);
            this.textFieldCena.setEditable(true);
            this.textFieldKolicina.setEditable(true);
            this.btnSave.setEnabled(true);
            this.btnCancel.setEnabled(true);
        } else if (mode == 2) {
            this.textFieldSifra.setEditable(false);
            this.textFieldNaziv.setEditable(false);
            this.textFieldZanr.setEditable(false);
            this.textFieldReziser.setEditable(false);
            this.textFieldGodinaIzdanja.setEditable(false);
            this.textFieldDuzinaTrajanja.setEditable(false);
            this.textFieldCena.setEditable(false);
            this.textFieldKolicina.setEditable(false);
            this.btnSave.setEnabled(false);
            this.btnCancel.setEnabled(false);
        }
    }

    //nakon unetih podataka prosledjuje te podatke
    public void setAllValues() {
        this.textFieldSifra.setText(this.dvd.getSifra());
        this.textFieldNaziv.setText(this.dvd.getNaslov());
        this.textFieldZanr.setText(this.dvd.getZanr());
        this.textFieldReziser.setText(this.dvd.getReziser());
        this.textFieldDuzinaTrajanja.setText(Double.toString(this.dvd.getDuzinaTrajanja()));
        this.textFieldGodinaIzdanja.setText(this.dvd.getGodinaIzdanja());
        this.textFieldCena.setText(Double.toString(this.dvd.getCena()));
        this.textFieldKolicina.setText(Integer.toString(this.dvd.getKolicina()));
    }

    //da li je validno ako jeste menja se ako nije javlja odgovarajucu gresku
    boolean checkAndStore() {
        boolean RetVal = true;

        boolean greskaUnosa = false;
        String porukaUnosa = "Niste uneli sledeće vrednosti:\n";
        if (this.textFieldSifra.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- šifra\n";
        }
        if (this.textFieldNaziv.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- naziv\n";
        }
        if (this.textFieldZanr.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- žanr\n";
        }
        if (this.textFieldReziser.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- režiseri\n";
        }
        if (this.textFieldGodinaIzdanja.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- godinu izdanja\n";
        }
        if (this.textFieldDuzinaTrajanja.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t - dužinu trajanja\n";
        }
        if (this.textFieldCena.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- cenu\n";
        }
        if (this.textFieldKolicina.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t - količinu\n";
        }
        boolean greskaFormatiranja = false;
        String porukaFormatiranja = "Niste pravilno uneli sledeće vrednosti:\n";
        if (!this.textFieldCena.getText().equals("")) {
            try {
                Double.parseDouble(this.textFieldCena.getText());
            } catch (Exception e) {
                greskaFormatiranja = true;
                porukaFormatiranja = porukaFormatiranja + "\t- Cena je broj, koji morate uneti u formatu sa tačkom (npr: 200.00)\n";
            }
        }
        if (!this.textFieldDuzinaTrajanja.getText().equals("")) {
            try {
                Double.parseDouble(this.textFieldDuzinaTrajanja.getText());
            } catch (Exception e) {
                greskaFormatiranja = true;
                porukaFormatiranja = porukaFormatiranja + "\t- Duzina trajanja je izrazena u minutima, koji morate uneti u formatu sa tačkom (npr: 120.0)\n";
            }
        }
        if (!this.textFieldKolicina.getText().equals("")) {
            try {
                Integer.parseInt(this.textFieldKolicina.getText());
            } catch (Exception e) {
                greskaFormatiranja = true;
                porukaFormatiranja = porukaFormatiranja + "\t- Količina se unosi u brojkama. Niste uneli broj.";
            }
        }
        //ispisuje prozorcic na kom ispisuje greske
        if (greskaUnosa) {
            JOptionPane.showMessageDialog(this, porukaUnosa);
            RetVal = false;
        } else if (greskaFormatiranja) {
            JOptionPane.showMessageDialog(this, porukaFormatiranja);
            RetVal = false;
        } else {
            this.dvd.setSifra(this.textFieldSifra.getText());
            this.dvd.setNaslov(this.textFieldNaziv.getText());
            this.dvd.setZanr(this.textFieldZanr.getText());
            //this.dvd.listaGlumacaFromString(this.textFieldGlumci.getText());
            this.dvd.setReziser(this.textFieldReziser.getText());
            this.dvd.setDuzinaTrajanja(Double.parseDouble(this.textFieldDuzinaTrajanja.getText()));
            this.dvd.setGodinaIzdanja(this.textFieldGodinaIzdanja.getText());
            this.dvd.setCena(Double.parseDouble(this.textFieldCena.getText()));
            this.dvd.setKolicina(Integer.parseInt(this.textFieldKolicina.getText()));
            Office bOff;
            if ((this.parent instanceof Office)) {
                bOff = (Office) this.parent;
                bOff.refreshTableDvd();
            } else if ((this.parent instanceof Office)) {
                bOff = (Office) this.parent;
            }
            if (this.mode == 0) {
                DvdFilmoviDB.getDBDvd().dodajFilm(this.dvd);
            }
            DvdFilmoviDB.getDBDvd().pisiUFajl();
        }
        return RetVal;
    }

}
