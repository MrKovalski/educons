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
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import projekat.frejm.Office;
import projekat.classes.DvdFilmovi;
import projekat.classes.DvdFilmoviDB;
import projekat.classes.Statusi;
import projekat.logIn.User;
import projekat.logIn.UserData;

public class DialogUser
        extends JDialog {

    private Frame parent;
    public static final int UNOS = 0;
    public static final int IZMENA = 1;
    public static final int PREGLED = 2;
    public boolean resultAction = false;
    private int mode;
    private User user;
    private JLabel labelaSifra;
    private JLabel labelaIme;
    private JLabel labelaPrezime;

    private JLabel labelaUsername;
    private JLabel labelaGodinaPass;
    private JLabel labelaDatumZap;
    private JLabel labelaDatumOtkaz;
    private JLabel labelaStatus;
    private JTextField textFieldSifra;
    private JTextField textFieldIme;
    private JTextField textFieldPrezime;

    private JTextField textFieldUsername;
    private JTextField textFieldGodinaPass;
    private JTextField textFieldDatumZap;
    private JTextField textFieldDatumOtkaz;
    private JTextField textFieldStatus;

    private JButton btnSave;
    private JButton btnCancel;
    String separatorPutanje = System.getProperty("file.separator");

    public DialogUser(Frame owner, String title, boolean modal) {
        super(owner, "Radnik", modal);
        this.parent = owner;
        String dvdFilmJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "osoba.jpg";
        setIconImage(Toolkit.getDefaultToolkit().getImage(dvdFilmJPGPutanja));
        getContentPane().setForeground(SystemColor.info);
        getContentPane().setBackground(SystemColor.desktop);
        setDefaultCloseOperation(2);
        setComponentsInDialogUser();
        setLocationRelativeTo(owner);
        pack();
    }

    void setComponentsInDialogUser() {
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

        GridBagConstraints gbcLabelaIme = new GridBagConstraints();
        gbcLabelaIme.gridx = 0;
        gbcLabelaIme.gridy = 1;
        gbcLabelaIme.gridwidth = 1;
        gbcLabelaIme.gridheight = 1;
        gbcLabelaIme.fill = 0;
        gbcLabelaIme.insets = new Insets(5, 5, 5, 5);
        gbcLabelaIme.weightx = 0.0D;
        this.labelaIme = new JLabel("Ime: ");
        this.labelaIme.setForeground(SystemColor.info);
        this.labelaIme.setBackground(SystemColor.info);
        this.labelaIme.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaIme, gbcLabelaIme);

        GridBagConstraints gbcTextFieldIme = new GridBagConstraints();
        gbcTextFieldIme.gridx = 1;
        gbcTextFieldIme.gridy = 1;
        gbcTextFieldIme.gridwidth = 2;
        gbcTextFieldIme.gridheight = 1;
        gbcTextFieldIme.fill = 2;
        gbcTextFieldIme.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldIme.weightx = 1.0D;
        this.textFieldIme = new JTextField(20);
        this.textFieldIme.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldIme, gbcTextFieldIme);

        GridBagConstraints gbcLabelaPrezime = new GridBagConstraints();
        gbcLabelaPrezime.gridx = 0;
        gbcLabelaPrezime.gridy = 2;
        gbcLabelaPrezime.gridwidth = 1;
        gbcLabelaPrezime.gridheight = 1;
        gbcLabelaPrezime.insets = new Insets(5, 5, 5, 5);
        gbcLabelaPrezime.weightx = 0.0D;
        this.labelaPrezime = new JLabel("Prezime: ");
        this.labelaPrezime.setForeground(SystemColor.info);
        this.labelaPrezime.setBackground(SystemColor.info);
        this.labelaPrezime.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaPrezime, gbcLabelaPrezime);

        GridBagConstraints gbcTextFieldPrezime = new GridBagConstraints();
        gbcTextFieldPrezime.gridx = 1;
        gbcTextFieldPrezime.gridy = 2;
        gbcTextFieldPrezime.gridwidth = 2;
        gbcTextFieldPrezime.gridheight = 1;
        gbcTextFieldPrezime.fill = 2;
        gbcTextFieldPrezime.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldPrezime.weightx = 1.0D;
        this.textFieldPrezime = new JTextField(20);
        this.textFieldPrezime.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldPrezime, gbcTextFieldPrezime);

        GridBagConstraints gbcLabelaUsername = new GridBagConstraints();
        gbcLabelaUsername.gridx = 0;
        gbcLabelaUsername.gridy = 3;
        gbcLabelaUsername.gridwidth = 1;
        gbcLabelaUsername.gridheight = 1;
        gbcLabelaUsername.insets = new Insets(5, 5, 5, 5);
        gbcLabelaUsername.weightx = 0.0D;
        this.labelaUsername = new JLabel("Username: ");
        this.labelaUsername.setForeground(SystemColor.info);
        this.labelaUsername.setBackground(SystemColor.info);
        this.labelaUsername.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaUsername, gbcLabelaUsername);

        GridBagConstraints gbcTextFieldUsername = new GridBagConstraints();
        gbcTextFieldUsername.gridx = 1;
        gbcTextFieldUsername.gridy = 3;
        gbcTextFieldUsername.gridwidth = 2;
        gbcTextFieldUsername.gridheight = 1;
        gbcTextFieldUsername.fill = 2;
        gbcTextFieldUsername.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldUsername.weightx = 1.0D;
        this.textFieldUsername = new JTextField(20);
        this.textFieldUsername.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldUsername, gbcTextFieldUsername);

        GridBagConstraints gbcLabelaGodinaPass = new GridBagConstraints();
        gbcLabelaGodinaPass.gridx = 0;
        gbcLabelaGodinaPass.gridy = 4;
        gbcLabelaGodinaPass.gridwidth = 1;
        gbcLabelaGodinaPass.gridheight = 1;
        gbcLabelaGodinaPass.fill = 2;
        gbcLabelaGodinaPass.insets = new Insets(5, 5, 5, 5);
        gbcLabelaGodinaPass.weightx = 0.0D;
        this.labelaGodinaPass = new JLabel("Password: ");
        this.labelaGodinaPass.setForeground(SystemColor.info);
        this.labelaGodinaPass.setBackground(SystemColor.info);
        this.labelaGodinaPass.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaGodinaPass, gbcLabelaGodinaPass);

        GridBagConstraints gbcTextFieldGodinaPass = new GridBagConstraints();
        gbcTextFieldGodinaPass.gridx = 1;
        gbcTextFieldGodinaPass.gridy = 4;
        gbcTextFieldGodinaPass.gridwidth = 2;
        gbcTextFieldGodinaPass.gridheight = 1;
        gbcTextFieldGodinaPass.fill = 2;
        gbcTextFieldGodinaPass.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldGodinaPass.weightx = 1.0D;
        this.textFieldGodinaPass = new JTextField(20);
        this.textFieldGodinaPass.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldGodinaPass, gbcTextFieldGodinaPass);

        GridBagConstraints gbcLabelaDatumZap = new GridBagConstraints();
        gbcLabelaDatumZap.gridx = 0;
        gbcLabelaDatumZap.gridy = 7;
        gbcLabelaDatumZap.gridwidth = 1;
        gbcLabelaDatumZap.gridheight = 1;
        gbcLabelaDatumZap.insets = new Insets(5, 5, 5, 5);
        gbcLabelaDatumZap.weightx = 0.0D;
        this.labelaDatumZap = new JLabel("Datum zaposljavanja: ");
        this.labelaDatumZap.setForeground(SystemColor.info);
        this.labelaDatumZap.setBackground(SystemColor.info);
        this.labelaDatumZap.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaDatumZap, gbcLabelaDatumZap);

        GridBagConstraints gbcTextFieldDatumZap = new GridBagConstraints();
        gbcTextFieldDatumZap.fill = 2;
        gbcTextFieldDatumZap.gridx = 1;
        gbcTextFieldDatumZap.gridy = 7;
        gbcTextFieldDatumZap.gridwidth = 2;
        gbcTextFieldDatumZap.gridheight = 1;
        gbcTextFieldDatumZap.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldDatumZap.weightx = 1.0D;
        this.textFieldDatumZap = new JTextField(20);
        this.textFieldDatumZap.setToolTipText("Datum zaposljavanja");
        this.textFieldDatumZap.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldDatumZap, gbcTextFieldDatumZap);

        GridBagConstraints gbcLabelaDatumOtkaz = new GridBagConstraints();
        gbcLabelaDatumOtkaz.gridx = 0;
        gbcLabelaDatumOtkaz.gridy = 8;
        gbcLabelaDatumOtkaz.gridwidth = 1;
        gbcLabelaDatumOtkaz.gridheight = 1;
        gbcLabelaDatumOtkaz.insets = new Insets(5, 5, 5, 5);
        gbcLabelaDatumOtkaz.weightx = 0.0D;
        this.labelaDatumOtkaz = new JLabel("Datum otkaza: ");
        this.labelaDatumOtkaz.setForeground(SystemColor.info);
        this.labelaDatumOtkaz.setBackground(SystemColor.text);
        this.labelaDatumOtkaz.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaDatumOtkaz, gbcLabelaDatumOtkaz);

        GridBagConstraints gbcTextFieldDatumOtkaz = new GridBagConstraints();
        gbcTextFieldDatumOtkaz.fill = 2;
        gbcTextFieldDatumOtkaz.gridx = 1;
        gbcTextFieldDatumOtkaz.gridy = 8;
        gbcTextFieldDatumOtkaz.gridwidth = 2;
        gbcTextFieldDatumOtkaz.gridheight = 1;
        gbcTextFieldDatumOtkaz.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldDatumOtkaz.weightx = 1.0D;
        this.textFieldDatumOtkaz = new JTextField(20);
        this.textFieldDatumOtkaz.setToolTipText("Datum otkaza");
        this.textFieldDatumOtkaz.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldDatumOtkaz, gbcTextFieldDatumOtkaz);

        GridBagConstraints gbcLabelaStatus = new GridBagConstraints();
        gbcLabelaStatus.gridx = 0;
        gbcLabelaStatus.gridy = 9;
        gbcLabelaStatus.gridwidth = 1;
        gbcLabelaStatus.gridheight = 1;
        gbcLabelaStatus.insets = new Insets(5, 5, 5, 5);
        gbcLabelaStatus.weightx = 0.0D;
        this.labelaStatus = new JLabel("Satus: ");
        this.labelaStatus.setForeground(SystemColor.info);
        this.labelaStatus.setBackground(SystemColor.info);
        this.labelaStatus.setFont(new Font("Tahoma", 1, 12));
        getContentPane().add(this.labelaStatus, gbcLabelaStatus);

        GridBagConstraints gbcTextFieldStatus = new GridBagConstraints();
        gbcTextFieldStatus.fill = 2;
        gbcTextFieldStatus.gridx = 1;
        gbcTextFieldStatus.gridy = 9;
        gbcTextFieldStatus.gridwidth = 2;
        gbcTextFieldStatus.gridheight = 1;
        gbcTextFieldStatus.insets = new Insets(5, 5, 5, 5);
        gbcTextFieldStatus.weightx = 1.0D;
        this.textFieldStatus = new JTextField(20);
        this.textFieldStatus.setFont(new Font("Tahoma", 0, 12));
        getContentPane().add(this.textFieldStatus, gbcTextFieldStatus);

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
        this.btnSave.addActionListener((ActionEvent arg0) -> {
            if (DialogUser.this.checkAndStore()) {
                DialogUser.this.resultAction = true;
                DialogUser.this.dispose();
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
        this.btnCancel.addActionListener((ActionEvent arg0) -> {
            DialogUser.this.resultAction = false;
            DialogUser.this.dispose();
        });
        getContentPane().add(this.btnCancel, gbcDugmeCancel);
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
        if (mode == 0) {
            this.textFieldSifra.setEditable(true);
            this.textFieldIme.setEditable(true);
            this.textFieldPrezime.setEditable(true);
            this.textFieldUsername.setEditable(true);
            this.textFieldGodinaPass.setEditable(true);
            this.textFieldDatumZap.setEditable(false);
            this.textFieldDatumOtkaz.setEditable(false);
            this.textFieldStatus.setEditable(true);
            this.btnSave.setEnabled(true);
            this.btnCancel.setEnabled(true);
        } else if (mode == 1) {
            this.textFieldSifra.setEditable(false);
            this.textFieldIme.setEditable(true);
            this.textFieldPrezime.setEditable(true);
            this.textFieldUsername.setEditable(true);
            this.textFieldGodinaPass.setEditable(true);
            this.textFieldDatumZap.setEditable(false);
            this.textFieldDatumOtkaz.setEditable(true);
            this.textFieldStatus.setEditable(true);
            this.btnSave.setEnabled(true);
            this.btnCancel.setEnabled(true);
        } else if (mode == 2) {
            this.textFieldSifra.setEditable(false);
            this.textFieldIme.setEditable(false);
            this.textFieldPrezime.setEditable(false);
            this.textFieldUsername.setEditable(false);
            this.textFieldGodinaPass.setEditable(false);
            this.textFieldDatumZap.setEditable(false);
            this.textFieldDatumOtkaz.setEditable(false);
            this.textFieldStatus.setEditable(true);
            this.btnSave.setEnabled(true);
            this.btnCancel.setEnabled(true);

        }
    }

    public void setAllValues() {
        if (this.mode == 1) {
            this.textFieldSifra.setText(this.user.getSifra());
            this.textFieldIme.setText(this.user.getIme());
            this.textFieldPrezime.setText(this.user.getPrezime());
            this.textFieldUsername.setText(this.user.getUsername());
            this.textFieldDatumZap.setText(this.user.getDatumZaposlenja());
            this.textFieldGodinaPass.setText(this.user.getPassword());
            this.textFieldDatumOtkaz.setText(this.user.getDatumOtkaz());
            this.textFieldStatus.setText(Integer.toString(this.user.getAddmin()));
        } else if (this.mode == 0) {
            this.textFieldDatumZap.setText(new Date().toString());
            this.textFieldDatumOtkaz.setText("--");
            this.textFieldSifra.setText(this.user.getSifra());
            this.textFieldIme.setText(this.user.getIme());
            this.textFieldPrezime.setText(this.user.getPrezime());
            this.textFieldUsername.setText(this.user.getUsername());
            this.textFieldGodinaPass.setText(this.user.getPassword());
            this.textFieldStatus.setText(Integer.toString(this.user.getAddmin()));
        } else {
            this.textFieldSifra.setText(this.user.getSifra());
            this.textFieldIme.setText(this.user.getIme());
            this.textFieldPrezime.setText(this.user.getPrezime());
            this.textFieldUsername.setText(this.user.getUsername());
            this.textFieldDatumZap.setText(this.user.getDatumZaposlenja());
            this.textFieldGodinaPass.setText(this.user.getPassword());
            this.textFieldDatumOtkaz.setText(this.user.getDatumOtkaz());
            this.textFieldStatus.setText(Integer.toString(this.user.getAddmin()));

        }
    }

    boolean checkAndStore() {
        boolean RetVal = true;

        boolean greskaUnosa = false;
        String porukaUnosa = "Niste uneli sledeće vrednosti:\n";
        if (this.textFieldSifra.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- šifra\n";
        }
        if (this.textFieldIme.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- ime\n";
        }
        if (this.textFieldPrezime.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- prezime\n";
        }

        if (this.textFieldUsername.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- username\n";
        }
        if (this.textFieldGodinaPass.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- password\n";
        }
        if (this.textFieldDatumZap.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t - datum zaposlenja\n";
        }
        if (this.textFieldDatumOtkaz.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t- datum otkaza\n";
        }
        if (this.textFieldStatus.getText().equals("")) {
            greskaUnosa = true;
            porukaUnosa = porukaUnosa + "\t - status\n";
        }
        boolean greskaFormatiranja = false;
        String porukaFormatiranja = "Niste pravilno uneli sledeće vrednosti:\n";

        if (greskaUnosa) {
            JOptionPane.showMessageDialog(this, porukaUnosa);
            RetVal = false;
        } else if (greskaFormatiranja) {
            JOptionPane.showMessageDialog(this, porukaFormatiranja);
            RetVal = false;
        } else {
            String datum, vreme;
            Date date = new Date();
            datum = date.toString().split(" ")[1] + " " + date.toString().split(" ")[2] + " " + date.toString().split(" ")[5];
            vreme = date.toString().split(" ")[3];
            this.user.setSifra(this.textFieldSifra.getText());
            this.user.setIme(this.textFieldIme.getText());
            this.user.setPrezime(this.textFieldPrezime.getText());
            this.user.setUsername(this.textFieldUsername.getText());
            this.user.setDatumZaposlenja(this.textFieldDatumZap.getText());
            this.user.setPassword(this.textFieldGodinaPass.getText());
            this.user.setAddmin(Integer.parseInt(this.textFieldStatus.getText()));
            if (this.user.getAddmin() != 2) {
                this.user.setDatumOtkaz(this.textFieldDatumOtkaz.getText());
            } else {
                this.user.setDatumOtkaz(datum);
            }

            Statusi status = new Statusi(this.user.getSifra(), vreme, datum, this.user.getAddmin());
            this.user.addStatusi(status);
            Office bOff;
            if ((this.parent instanceof Office)) {
                bOff = (Office) this.parent;
                bOff.refreshTableUser();
            } else if ((this.parent instanceof Office)) {
                bOff = (Office) this.parent;
            }
            if (this.mode == 0) {
                UserData.getUserData().dodajUser(this.user);
            }
            UserData.getUserData().pisiUFajl();
        }
        return RetVal;
    }

}
