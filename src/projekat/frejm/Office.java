/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat.frejm;

/**
 *
 * @author User
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import projekat.logIn.User;

import projekat.classes.DvdFilmovi;
import projekat.classes.DvdFilmoviDB;

import projekat.classes.Racuni;
import projekat.classes.RacuniDB;
import projekat.classes.StavkeRacuna;
import projekat.classes.TableModelArtikli;

import projekat.classes.TableModelDvd;
import projekat.classes.TableModelRacuni;
import projekat.classes.TableModelRadnici;
import projekat.classes.TableModelStatusi;
import projekat.classes.TableModelStavkeRacuna;

import projekat.dialogs.Dialog;
import projekat.dialogs.DialogUser;
import projekat.logIn.UserData;

public class Office
        extends JFrame {

    Dimension velicinaEkrana = Toolkit.getDefaultToolkit().getScreenSize();
    private MainFrame parent;
    JTextField textArtikliSifra;
    JTextField textArtikliNaziv;
    JButton dugmeArtikliPonistiPretragu;
    JButton dugmeArtikliPretrazi;
    TableModelArtikli modelArtikli;
    JTable tabelaArtikala;
    JTextField textAudioSifra;
    JTextField textAudioNaziv;
    JTextField textAudioAutor;
    JTextField textAudioGodinaIzdanja;
    JButton dugmeAudioPonistiPretragu;
    JButton dugmeAudioPretrazi;

    JTable tabelaAudio;
    JButton dugmeAudioDetalji;
    JTextField textAudioSelektovanaSifra;
    JTextField textAudioSelektovanaKolicina;
    JButton dugmeAudioDodajUKorpu;
    JTextField textKnjigeSifra;
    JTextField textKnjigeNaziv;
    JTextField textKnjigeAutor;
    JTextField textKnjigeGodinaIzdanja;
    JTextField textKnjigeISBN;
    JButton dugmeKnjigePonistiPretragu;
    JButton dugmeKnjigePretrazi;

    JTable tabelaKnjige;
    JButton dugmeKnjigeDetalji;
    JTextField textKnjigeSelektovanaSifra;
    JTextField textKnjigeSelektovanaKolicina;
    JButton dugmeKnjigeDodajUKorpu;
    JTextField textDvdSifra;
    JTextField textDvdNaziv;
    JTextField textDvdReziser;
    JTextField textDvdKolicina;
    JTextField textDvdZanr;
    JTextField textDvdGodinaIzdanja;
    JButton dugmeDvdPonistiPretragu;
    JButton dugmeDvdPretrazi;
    TableModelDvd modelDvd;
    DvdFilmovi selektovanDvd;
    JTable tabelaDvd;
    JButton dugmeDvdDetalji;
    JButton dugmeDvdDetalji2;
    JButton dugmeDvdDetalji3;
    JTextField textDvdSelektovanaSifra;
    JTextField textDvdSelektovanaKolicina;
    JButton dugmeDvdDodajUKorpu;
    ArrayList<StavkeRacuna> listaStavki = new ArrayList();
    JTable tabelaStavki;
    DefaultTableModel modelZaTabeluStavki;
    JScrollPane scrollPaneStavke;
    JPanel korpaPanelJug;
    JButton dugmeUkloniStavkuRacuna;
    JButton dugmeFormirajRacun;
    JButton dugmeOdustaniOdKupovine;
    String separatorPutanje = System.getProperty("file.separator");
    JTable tabelaRacuni;
    TableModelRacuni modelRacuni;
    Racuni selektovanRacun;
    TableModelStavkeRacuna modelStavkeRacuna;
    JButton dugmeIzmenaDvd;
    JButton dugmeUnosDvd;
    JTable tabelaRadnici;
    TableModelRadnici modelRadnici;
    User selektovanUser;
    TableModelStatusi modelStatusi;
    JPanel panelUser2;
    //TableModelRadnici modelUser;
    JButton dugmeIzmenaUser;

    /**
     *
     * @param parent
     */
    //ogroman konstruktor (iscrtava sve)
    public Office(final MainFrame parent) {

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                dispose();
                parent.login();
            }
        });

        String storeJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "store.png";
        String dvdFilmJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "dvdfilm.png";
        String pregledRacunaJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "pregledRacuna.png";
        String pregledKorpaJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "korpazaprodaju.png";
        String pregledRadnikaJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "osoba.png";
        String searchJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "search.jpg";
        String korpicaJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "addkorpa.jpg";
        
        
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(storeJPGPutanja));
        this.parent = parent;
        setSize(this.velicinaEkrana.width / 2, this.velicinaEkrana.height / 2);
        setTitle("ProjekatKodStojica™ - M3ntalniAt3ntat®");
        setDefaultCloseOperation(2);
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Color.white);
        getContentPane().add(tabbedPane, "Center");

        JPanel panelDvd = new JPanel(false);
        panelDvd.setLayout(new BorderLayout());
        tabbedPane.addTab("Dvd", new ImageIcon(dvdFilmJPGPutanja), panelDvd, "Dvd");

        JPanel panelKorpa = new JPanel(false);
        panelKorpa.setLayout(new BorderLayout());
        tabbedPane.addTab("Korpa", new ImageIcon(pregledKorpaJPGPutanja), panelKorpa, "Korpa");

        JPanel panelDvdPretraga = new JPanel(false);
        panelDvdPretraga.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Pretraga", 2, 2, null, new Color(0, 0, 139)));
        panelDvdPretraga.setLayout(new GridBagLayout());
        panelDvdPretraga.setBackground(new Color(198, 214, 133));
        panelDvd.add(panelDvdPretraga, "North");

        JLabel labelaDvdSifra = new JLabel("Šifra Dvd-a-->");
        this.textDvdSifra = new JTextField(10);

        JLabel labelaDvdNaziv = new JLabel("Naziv-->");
        this.textDvdNaziv = new JTextField(10);

        JLabel labelaDvdZanr = new JLabel("Zanr-->");
        this.textDvdZanr = new JTextField(10);

        JLabel labelaDvdKolicina = new JLabel("Količina-->");
        this.textDvdKolicina = new JTextField(13);

        JLabel labelaDvdReziser = new JLabel("Režiser-->");
        this.textDvdReziser = new JTextField(10);

        JLabel labelaDvdGodinaIzdanja = new JLabel("Godina Izdanja-->");
        this.textDvdGodinaIzdanja = new JTextField(10);

        this.dugmeDvdPonistiPretragu = new JButton("Poništi pretragu");
        this.dugmeDvdPonistiPretragu.setMnemonic('t');
        
        this.dugmeDvdPonistiPretragu.setFont(
                new Font("Tahoma", 3, 11));

        this.dugmeDvdPonistiPretragu.setBackground(
                new Color(255, 255, 255));
        
        this.dugmeDvdPonistiPretragu.addActionListener((ActionEvent arg0) -> {
            Office.this.modelDvd.setPonistiDvd();
            // ugradjena funkciju u abstract table model klasi koja refreshuje tabelu
            Office.this.modelDvd.fireTableDataChanged();
        });
        this.dugmeDvdPretrazi = new JButton("Pretraži");
        this.dugmeDvdPretrazi.setMnemonic('p');
        this.dugmeDvdPretrazi.setIcon(new ImageIcon(searchJPGPutanja));
        
        this.dugmeDvdPretrazi.setFont(
                new Font("Tahoma", 3, 11));

        this.dugmeDvdPretrazi.setBackground(
                new Color(255, 255, 255));

        this.dugmeDvdPretrazi.addActionListener((ActionEvent arg0) -> {
            if ((!Office.this.textDvdSifra.getText().trim().equalsIgnoreCase("")) || (!Office.this.textDvdNaziv.getText().equalsIgnoreCase("")) || (!Office.this.textDvdZanr.getText().trim().equalsIgnoreCase(""))
                    || (!Office.this.textDvdKolicina.getText().trim().equalsIgnoreCase(""))
                    || (!Office.this.textDvdReziser.getText().trim().equalsIgnoreCase("")) || (!Office.this.textDvdGodinaIzdanja.getText().trim().equalsIgnoreCase(""))) {
                Office.this.modelDvd.setTraziDvd(Office.this.textDvdSifra.getText(), Office.this.textDvdNaziv.getText(), Office.this.textDvdZanr.getText(),
                        Office.this.textDvdKolicina.getText(),
                        Office.this.textDvdReziser.getText(), Office.this.textDvdGodinaIzdanja.getText());
            }
            Office.this.modelDvd.fireTableDataChanged();
        });
        GridBagConstraints gbcLabelaDvdSifra = new GridBagConstraints();
        gbcLabelaDvdSifra.gridx = 0;
        gbcLabelaDvdSifra.gridy = 0;
        gbcLabelaDvdSifra.gridwidth = 1;
        gbcLabelaDvdSifra.gridheight = 1;
        gbcLabelaDvdSifra.insets = new Insets(2, 2, 2, 2);
        gbcLabelaDvdSifra.fill = 0;
        gbcLabelaDvdSifra.anchor = 21;
        gbcLabelaDvdSifra.weightx = 0.0D;
        gbcLabelaDvdSifra.weighty = 0.0D;
        panelDvdPretraga.add(labelaDvdSifra, gbcLabelaDvdSifra);

        GridBagConstraints gbcTextDvdSifra = new GridBagConstraints();
        gbcTextDvdSifra.gridx = 1;
        gbcTextDvdSifra.gridy = 0;
        gbcTextDvdSifra.gridwidth = 1;
        gbcTextDvdSifra.gridheight = 1;
        gbcTextDvdSifra.insets = new Insets(2, 2, 2, 2);
        gbcTextDvdSifra.fill = 2;
        gbcTextDvdSifra.anchor = 10;
        gbcTextDvdSifra.weightx = 1.0D;
        gbcTextDvdSifra.weighty = 0.0D;
        panelDvdPretraga.add(this.textDvdSifra, gbcTextDvdSifra);

        GridBagConstraints gbcLabelaDvdNaziv = new GridBagConstraints();
        gbcLabelaDvdNaziv.gridx = 2;
        gbcLabelaDvdNaziv.gridy = 0;
        gbcLabelaDvdNaziv.gridwidth = 1;
        gbcLabelaDvdNaziv.gridheight = 1;
        gbcLabelaDvdNaziv.insets = new Insets(2, 2, 2, 2);
        gbcLabelaDvdNaziv.fill = 0;
        gbcLabelaDvdNaziv.anchor = 21;
        gbcLabelaDvdNaziv.weightx = 0.0D;
        gbcLabelaDvdNaziv.weighty = 0.0D;
        panelDvdPretraga.add(labelaDvdNaziv, gbcLabelaDvdNaziv);

        GridBagConstraints gbcTextDvdNaziv = new GridBagConstraints();
        gbcTextDvdNaziv.gridx = 3;
        gbcTextDvdNaziv.gridy = 0;
        gbcTextDvdNaziv.gridwidth = 1;
        gbcTextDvdNaziv.gridheight = 1;
        gbcTextDvdNaziv.insets = new Insets(2, 2, 2, 2);
        gbcTextDvdNaziv.fill = 2;
        gbcTextDvdNaziv.anchor = 10;
        gbcTextDvdNaziv.weightx = 1.0D;
        gbcTextDvdNaziv.weighty = 0.0D;
        panelDvdPretraga.add(this.textDvdNaziv, gbcTextDvdNaziv);

        GridBagConstraints gbcLabelaDvdZanr = new GridBagConstraints();
        gbcLabelaDvdZanr.gridx = 0;
        gbcLabelaDvdZanr.gridy = 1;
        gbcLabelaDvdZanr.gridwidth = 1;
        gbcLabelaDvdZanr.gridheight = 1;
        gbcLabelaDvdZanr.insets = new Insets(2, 2, 2, 2);
        gbcLabelaDvdZanr.fill = 0;
        gbcLabelaDvdZanr.anchor = 21;
        gbcLabelaDvdZanr.weightx = 0.0D;
        gbcLabelaDvdZanr.weighty = 0.0D;
        panelDvdPretraga.add(labelaDvdZanr, gbcLabelaDvdZanr);

        GridBagConstraints gbcTextDvdZanr = new GridBagConstraints();
        gbcTextDvdZanr.gridx = 1;
        gbcTextDvdZanr.gridy = 1;
        gbcTextDvdZanr.gridwidth = 1;
        gbcTextDvdZanr.gridheight = 1;
        gbcTextDvdZanr.insets = new Insets(2, 2, 2, 2);
        gbcTextDvdZanr.fill = 2;
        gbcTextDvdZanr.anchor = 10;
        gbcTextDvdZanr.weightx = 1.0D;
        gbcTextDvdZanr.weighty = 0.0D;
        panelDvdPretraga.add(this.textDvdZanr, gbcTextDvdZanr);

        GridBagConstraints gbcLabelaDvdGlumci = new GridBagConstraints();
        gbcLabelaDvdGlumci.gridx = 2;
        gbcLabelaDvdGlumci.gridy = 1;
        gbcLabelaDvdGlumci.gridwidth = 1;
        gbcLabelaDvdGlumci.gridheight = 1;
        gbcLabelaDvdGlumci.insets = new Insets(2, 2, 2, 2);
        gbcLabelaDvdGlumci.fill = 0;
        gbcLabelaDvdGlumci.anchor = 21;
        gbcLabelaDvdGlumci.weightx = 0.0D;
        gbcLabelaDvdGlumci.weighty = 0.0D;
        panelDvdPretraga.add(labelaDvdKolicina,
                gbcLabelaDvdGlumci);

        GridBagConstraints gbcTextDvdGlumci = new GridBagConstraints();
        gbcTextDvdGlumci.gridx = 3;
        gbcTextDvdGlumci.gridy = 1;
        gbcTextDvdGlumci.gridwidth = 1;
        gbcTextDvdGlumci.gridheight = 1;
        gbcTextDvdGlumci.insets = new Insets(2, 2, 2, 2);
        gbcTextDvdGlumci.fill = 2;
        gbcTextDvdGlumci.anchor = 10;
        gbcTextDvdGlumci.weightx = 1.0D;
        gbcTextDvdGlumci.weighty = 0.0D;
        panelDvdPretraga.add(this.textDvdKolicina,
                gbcTextDvdGlumci);

        GridBagConstraints gbcLabelaDvdReziser = new GridBagConstraints();
        gbcLabelaDvdReziser.gridx = 0;
        gbcLabelaDvdReziser.gridy = 2;
        gbcLabelaDvdReziser.gridwidth = 1;
        gbcLabelaDvdReziser.gridheight = 1;
        gbcLabelaDvdReziser.insets = new Insets(2, 2, 2, 2);
        gbcLabelaDvdReziser.fill = 0;
        gbcLabelaDvdReziser.anchor = 21;
        gbcLabelaDvdReziser.weightx = 0.0D;
        gbcLabelaDvdReziser.weighty = 0.0D;
        panelDvdPretraga.add(labelaDvdReziser, gbcLabelaDvdReziser);

        GridBagConstraints gbcTextDvdReziser = new GridBagConstraints();
        gbcTextDvdReziser.gridx = 1;
        gbcTextDvdReziser.gridy = 2;
        gbcTextDvdReziser.gridwidth = 1;
        gbcTextDvdReziser.gridheight = 1;
        gbcTextDvdReziser.insets = new Insets(2, 2, 2, 2);
        gbcTextDvdReziser.fill = 2;
        gbcTextDvdReziser.anchor = 10;
        gbcTextDvdReziser.weightx = 1.0D;
        gbcTextDvdReziser.weighty = 0.0D;
        panelDvdPretraga.add(this.textDvdReziser, gbcTextDvdReziser);

        GridBagConstraints gbcLabelaDvdGodinaIzdanja = new GridBagConstraints();
        gbcLabelaDvdGodinaIzdanja.gridx = 2;
        gbcLabelaDvdGodinaIzdanja.gridy = 2;
        gbcLabelaDvdGodinaIzdanja.gridwidth = 1;
        gbcLabelaDvdGodinaIzdanja.gridheight = 1;
        gbcLabelaDvdGodinaIzdanja.insets = new Insets(2, 2, 2, 2);
        gbcLabelaDvdGodinaIzdanja.fill = 0;
        gbcLabelaDvdGodinaIzdanja.anchor = 21;
        gbcLabelaDvdGodinaIzdanja.weightx = 0.0D;
        gbcLabelaDvdGodinaIzdanja.weighty = 0.0D;
        panelDvdPretraga.add(labelaDvdGodinaIzdanja, gbcLabelaDvdGodinaIzdanja);

        GridBagConstraints gbcTextDvdGodinaIzdanja = new GridBagConstraints();
        gbcTextDvdGodinaIzdanja.gridx = 3;
        gbcTextDvdGodinaIzdanja.gridy = 2;
        gbcTextDvdGodinaIzdanja.gridwidth = 1;
        gbcTextDvdGodinaIzdanja.gridheight = 1;
        gbcTextDvdGodinaIzdanja.insets = new Insets(2, 2, 2, 2);
        gbcTextDvdGodinaIzdanja.fill = 2;
        gbcTextDvdGodinaIzdanja.anchor = 10;
        gbcTextDvdGodinaIzdanja.weightx = 1.0D;
        gbcTextDvdGodinaIzdanja.weighty = 0.0D;
        panelDvdPretraga.add(this.textDvdGodinaIzdanja, gbcTextDvdGodinaIzdanja);

        GridBagConstraints gbcDugmeDvdPretrazi = new GridBagConstraints();
        gbcDugmeDvdPretrazi.gridx = 0;
        gbcDugmeDvdPretrazi.gridy = 3;
        gbcDugmeDvdPretrazi.gridwidth = 2;
        gbcDugmeDvdPretrazi.gridheight = 1;
        gbcDugmeDvdPretrazi.fill = 0;
        gbcDugmeDvdPretrazi.anchor = 10;
        gbcDugmeDvdPretrazi.weightx = 0.0D;
        gbcDugmeDvdPretrazi.weighty = 0.0D;
        panelDvdPretraga.add(this.dugmeDvdPretrazi, gbcDugmeDvdPretrazi);

        GridBagConstraints gbcDugmeDvdPonisti = new GridBagConstraints();
        gbcDugmeDvdPonisti.gridx = 2;
        gbcDugmeDvdPonisti.gridy = 3;
        gbcDugmeDvdPonisti.gridwidth = 2;
        gbcDugmeDvdPonisti.gridheight = 1;
        gbcDugmeDvdPonisti.fill = 0;
        gbcDugmeDvdPonisti.anchor = 10;
        gbcDugmeDvdPonisti.weightx = 0.0D;
        gbcDugmeDvdPonisti.weighty = 0.0D;
        panelDvdPretraga.add(this.dugmeDvdPonistiPretragu, gbcDugmeDvdPonisti);

        this.selektovanDvd = ((DvdFilmovi) DvdFilmoviDB.getDBDvd().dvdFilmovi.get(0));
        this.modelDvd = new TableModelDvd();
        this.tabelaDvd = new JTable(this.modelDvd);
        this.tabelaDvd.setAutoCreateRowSorter(true);
        this.tabelaDvd.setSelectionMode(0);
        // implementuje selektovanje u tabeli
        ListSelectionModel lsmDvd = this.tabelaDvd.getSelectionModel();
        lsmDvd.addListSelectionListener((ListSelectionEvent e) -> {
            if ((!e.getValueIsAdjusting())
                    && ((e.getSource() instanceof ListSelectionModel))) {
                int row = Office.this.tabelaDvd.getSelectedRow();
                if (row == -1) {
                    return;
                }
                String sifraDvd = (String) Office.this.tabelaDvd.getValueAt(row, 0);
                for (DvdFilmovi temp2 : DvdFilmoviDB.getDBDvd().dvdFilmovi) {
                    if (temp2.getSifra().equalsIgnoreCase(sifraDvd)) {
                        Office.this.selektovanDvd = temp2;
                        Office.this.textDvdSelektovanaSifra.setText(Office.this.selektovanDvd.getSifra());
                        Office.this.textDvdSelektovanaKolicina.setText(Integer.toString(Office.this.selektovanDvd.getKolicina()));
                        break;
                    }
                }
                if (Office.this.selektovanDvd == null) {
                    System.out.println("Ne postoji DVD sa datom šifrom!");
                }
            }
        });
        JScrollPane scrollPaneDvd = new JScrollPane(this.tabelaDvd);
        scrollPaneDvd.setVerticalScrollBarPolicy(22);
        panelDvd.add(scrollPaneDvd, "Center");

        JPanel panelDvdKomande = new JPanel(false);
        panelDvdKomande.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dostupne komande", 2, 2, null, new Color(0, 0, 139)));
        panelDvdKomande.setLayout(new GridBagLayout());
        panelDvdKomande.setBackground(new Color(198, 214, 133));
        panelDvd.add(panelDvdKomande, "South");
        
        
        //-------------------------------------------------
        if (MainFrame.ulogovaniKorisnik.isAddmin()) {
            
            this.dugmeIzmenaDvd = new JButton("Izmena");
            this.dugmeIzmenaDvd.setFont(new Font("Tahoma", 3, 11));
            this.dugmeIzmenaDvd.setBackground(new Color(255, 115, 0));
            GridBagConstraints gbcDugmeIzmenaDvd = new GridBagConstraints();
            gbcDugmeIzmenaDvd.insets = new Insets(5, 5, 5, 5);
            panelDvdKomande.add(this.dugmeIzmenaDvd, gbcDugmeIzmenaDvd);
            this.dugmeIzmenaDvd.addActionListener((ActionEvent arg0) -> {
                Office.this.editDvd();
            });
            this.dugmeUnosDvd = new JButton("Unos");
            this.dugmeUnosDvd.setBackground(new Color(135, 200, 10));
            this.dugmeUnosDvd.setFont(new Font("Tahoma", 3, 11));
            GridBagConstraints gbcDugmeUnosDvd = new GridBagConstraints();
            gbcDugmeUnosDvd.insets = new Insets(5, 5, 5, 5);
            panelDvdKomande.add(this.dugmeUnosDvd, gbcDugmeUnosDvd);
            this.dugmeUnosDvd.addActionListener((ActionEvent arg0) -> {
                Office.this.addNewDvd();
            });
        }

        //--------------------------------------------------
        this.dugmeDvdDetalji = new JButton("Detaljan pregled");

        this.dugmeDvdDetalji.setFont(
                new Font("Tahoma", 3, 11));

        this.dugmeDvdDetalji.setBackground(
                new Color(255, 205, 0));

        GridBagConstraints gbc_dugmeDvdDetalji = new GridBagConstraints();
        gbc_dugmeDvdDetalji.insets = new Insets(5, 5, 5, 5);

        panelDvdKomande.add(this.dugmeDvdDetalji, gbc_dugmeDvdDetalji);

        this.dugmeDvdDetalji.addActionListener((ActionEvent arg0) -> {
            Office.this.browseDvd();
        });
        JLabel labelaDvdSelektovanSifra = new JLabel("Šifra DVD-a");
        labelaDvdSelektovanSifra.setFont(new Font("Tahoma", 1, 11));
        GridBagConstraints gbc_labelaDvdSelektovanSifra = new GridBagConstraints();
        gbc_labelaDvdSelektovanSifra.insets = new Insets(5, 5, 5, 5);
        panelDvdKomande.add(labelaDvdSelektovanSifra, gbc_labelaDvdSelektovanSifra);
        this.textDvdSelektovanaSifra = new JTextField(10);
        this.textDvdSelektovanaSifra.setToolTipText("\\u0161ifra selektovanog artikla");
        this.textDvdSelektovanaSifra.setEditable(false);
        GridBagConstraints gbc_textDvdSelektovanaSifra = new GridBagConstraints();
        gbc_textDvdSelektovanaSifra.insets = new Insets(5, 2, 5, 5);
        panelDvdKomande.add(this.textDvdSelektovanaSifra, gbc_textDvdSelektovanaSifra);
        JLabel labelaDvdSelektovanKolicina = new JLabel("Količina");
        labelaDvdSelektovanKolicina.setFont(new Font("Tahoma", 1, 11));
        GridBagConstraints gbc_labelaDvdSelektovanKolicina = new GridBagConstraints();
        gbc_labelaDvdSelektovanKolicina.insets = new Insets(5, 5, 5, 5);
        panelDvdKomande.add(labelaDvdSelektovanKolicina, gbc_labelaDvdSelektovanKolicina);
        this.textDvdSelektovanaKolicina = new JTextField(10);
        this.textDvdSelektovanaKolicina.setToolTipText("Raspoloživa količina selektovanog artikla. \r\nUnesite količinu koju želite da dodate u korpu.");
        GridBagConstraints gbc_textDvdSelektovanaKolicina = new GridBagConstraints();
        gbc_textDvdSelektovanaKolicina.insets = new Insets(5, 2, 5, 5);
        panelDvdKomande.add(this.textDvdSelektovanaKolicina, gbc_textDvdSelektovanaKolicina);
        this.dugmeDvdDodajUKorpu = new JButton("Dodaj u korpu");
        this.dugmeDvdDodajUKorpu.setForeground(new Color(255, 255, 224));
        this.dugmeDvdDodajUKorpu.setMnemonic('u');
        this.dugmeDvdDodajUKorpu.setFont(new Font("Tahoma", 3,
                11));
        this.dugmeDvdDodajUKorpu.setIcon(new ImageIcon(korpicaJPGPutanja));
        this.dugmeDvdDodajUKorpu.setBackground(new Color(140, 40, 140));
        GridBagConstraints gbc_dugmeDvdDodajUKorpu = new GridBagConstraints();
        gbc_dugmeDvdDodajUKorpu.insets = new Insets(5, 5, 5, 5);
        panelDvdKomande.add(this.dugmeDvdDodajUKorpu, gbc_dugmeDvdDodajUKorpu);
        this.dugmeDvdDodajUKorpu.addActionListener((ActionEvent arg0) -> {
            String unetaSifra = Office.this.textDvdSelektovanaSifra.getText();
            String unetaKolicina = Office.this.textDvdSelektovanaKolicina.getText();
            if ((unetaSifra == null) || (unetaKolicina == null)) {
                JOptionPane.showMessageDialog(null,
                        "Niste uneli vrednost šifre ili količine! ",
                        "Greška pri unosu u korpu",
                        0);
            } else if ((unetaSifra.trim().equalsIgnoreCase("")) || (unetaKolicina.trim().equalsIgnoreCase(""))) {
                JOptionPane.showMessageDialog(null,
                        "Niste uneli vrednost šifre ili količine! ",
                        "Greška pri unosu u korpu",
                        0);
            } else {
                DvdFilmoviDB tempDBDvd = DvdFilmoviDB.getDBDvd();
                for (DvdFilmovi DVDFilm : tempDBDvd.getdvdFilmovi()) {
                    if (DVDFilm.getSifra().equalsIgnoreCase(unetaSifra.trim())) {
                        if (DVDFilm.getKolicina() < Integer.parseInt(unetaKolicina)) {
                            JOptionPane.showMessageDialog(null,
                                    "Tražene Dvd nema dovoljno na stanju! ",
                                    "Greška pri unosu u korpu",
                                    0);
                            break;
                        }
                        int novaKolicina = DVDFilm.getKolicina() - Integer.parseInt(unetaKolicina.trim());
                        DVDFilm.setKolicina(novaKolicina);
                        
                        StavkeRacuna stavka = new StavkeRacuna(Office.this.listaStavki.size(), DVDFilm.getSifra(),
                                DVDFilm.getNaslov(), Integer.parseInt(unetaKolicina.trim()),
                                DVDFilm.getCena());
                        Office.this.listaStavki.add(stavka);
                        Office.this.modelZaTabeluStavki.addRow(new Object[]{Integer.valueOf(stavka.getRedniBroj()), stavka.getSifraArtikla(),
                            stavka.getNazivArtikla(), Integer.valueOf(stavka.getKolicina()),
                            Double.valueOf(stavka.getJedinicnaCena()), Double.valueOf(stavka.getUkupnaCena())});
                        DvdFilmoviDB.getDBDvd().pisiUFajl();
                        Office.this.modelDvd.fireTableDataChanged();
                        
                        break;
                    }
                }
            }
        });
        this.modelZaTabeluStavki = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.modelZaTabeluStavki.setColumnIdentifiers(new String[]{"Redni broj", "Šifra artikla",
            "Naziv", "Količina", "Jedinična cena", "Ukupna cena"});
        this.tabelaStavki = new JTable(this.modelZaTabeluStavki);
        this.tabelaStavki.setToolTipText("Tabela stavki računa. Da biste konacno formirali račun, potvrdite pritiskom na dugme FORMIRAJ RAČUN!");
        this.tabelaStavki.setColumnSelectionAllowed(false);
        this.scrollPaneStavke = new JScrollPane(this.tabelaStavki);
        this.scrollPaneStavke.setVerticalScrollBarPolicy(22);
        this.tabelaStavki.setFillsViewportHeight(true);
        this.tabelaStavki.setSelectionMode(0);

        panelKorpa.add(this.scrollPaneStavke, "Center");

        JPanel panelStavkeKomande = new JPanel(false);
        panelStavkeKomande.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dostupne komande", 2, 2, null, new Color(0, 0, 139)));
        panelStavkeKomande.setLayout(new GridBagLayout());
        panelStavkeKomande.setBackground(new Color(198, 214, 133));
        panelKorpa.add(panelStavkeKomande, "South");

        this.dugmeOdustaniOdKupovine = new JButton("Odustani od kupovine");
        this.dugmeOdustaniOdKupovine.setMnemonic('o');
        this.dugmeOdustaniOdKupovine.setMargin(new Insets(5, 14, 5, 14));
        this.dugmeOdustaniOdKupovine.setFont(new Font("Tahoma", 3, 11));
        this.dugmeOdustaniOdKupovine.setBackground(new Color(255, 115, 0));

        GridBagConstraints gbcDugmeOdustaniOdKupovine = new GridBagConstraints();
        gbcDugmeOdustaniOdKupovine.insets = new Insets(5, 5, 5, 5);
        panelStavkeKomande.add(this.dugmeOdustaniOdKupovine, gbcDugmeOdustaniOdKupovine);

        this.dugmeOdustaniOdKupovine.addActionListener((ActionEvent arg0) -> {
            while (Office.this.listaStavki.size() > 0) {
                StavkeRacuna selektovanaStavka = (StavkeRacuna) Office.this.listaStavki.get(0);
                for (DvdFilmovi dvd : DvdFilmoviDB.getDBDvd().getdvdFilmovi()) {
                    if (dvd.getSifra().equals(selektovanaStavka.getSifraArtikla())) {
                        dvd.setKolicina(dvd.getKolicina() + selektovanaStavka.getKolicina());
                        DvdFilmoviDB.getDBDvd().pisiUFajl();
                        Office.this.modelDvd.fireTableDataChanged();
                        break;
                    }
                }
                Office.this.listaStavki.remove(0);
                Office.this.modelZaTabeluStavki.removeRow(0);
            }
        });
        this.dugmeUkloniStavkuRacuna = new JButton("Ukloni stavku sa računa");
        this.dugmeUkloniStavkuRacuna.setMnemonic('u');
        this.dugmeUkloniStavkuRacuna.setMargin(new Insets(5, 14, 5, 14));
        this.dugmeUkloniStavkuRacuna.setFont(new Font("Tahoma", 3, 11));
        this.dugmeUkloniStavkuRacuna.setBackground(new Color(255, 205, 0));

        GridBagConstraints gbcDugmeUkloniStavku = new GridBagConstraints();
        gbcDugmeUkloniStavku.insets = new Insets(5, 5, 5, 5);
        panelStavkeKomande.add(this.dugmeUkloniStavkuRacuna, gbcDugmeUkloniStavku);

        this.dugmeUkloniStavkuRacuna.addActionListener((ActionEvent arg0) -> {
            int i = Office.this.tabelaStavki.getSelectedRow();
            if (i != -1) {
                StavkeRacuna selektovanaStavka = (StavkeRacuna) Office.this.listaStavki.get(i);
                
                for (DvdFilmovi dvd : DvdFilmoviDB.getDBDvd().getdvdFilmovi()) {
                    if (dvd.getSifra().equals(selektovanaStavka.getSifraArtikla())) {
                        dvd.setKolicina(dvd.getKolicina() + selektovanaStavka.getKolicina());
                        DvdFilmoviDB.getDBDvd().pisiUFajl();
                        Office.this.modelDvd.fireTableDataChanged();
                        break;
                    }
                }
                Office.this.listaStavki.remove(i);
                Office.this.modelZaTabeluStavki.removeRow(i);
            }
        });
        this.dugmeFormirajRacun = new JButton("Formiraj račun");
        this.dugmeFormirajRacun.setMnemonic('f');
        this.dugmeFormirajRacun.setMargin(new Insets(5, 14, 5, 14));
        this.dugmeFormirajRacun.setFont(new Font("Tahoma", 3, 11));
        this.dugmeFormirajRacun.setBackground(new Color(135, 200, 10));
        this.dugmeFormirajRacun.setIcon(new ImageIcon("resource/images/print.jpg"));

        GridBagConstraints gbcDugmeFormirajRacun = new GridBagConstraints();
        gbcDugmeFormirajRacun.insets = new Insets(5, 5, 5, 5);
        panelStavkeKomande.add(this.dugmeFormirajRacun, gbcDugmeFormirajRacun);

        this.dugmeFormirajRacun.addActionListener((ActionEvent arg0) -> {
            double ukupnaCena = 0.0D;
            for (StavkeRacuna stavka : Office.this.listaStavki) {
                ukupnaCena += stavka.getUkupnaCena();
            }
            if (Office.this.listaStavki.isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Niste dodali ni jedan artikal u korpu!", "Poruka o praznoj korpi", 2);
            } else {
                String sifraRacuna = Integer.toString(RacuniDB.getDBRacuni().getRacuni().size());
                Racuni racun = new Racuni(sifraRacuna, new Date().toString(), ukupnaCena, parent.ulogovaniKorisnik.getSifra());
                for (StavkeRacuna stavka : Office.this.listaStavki) {
                    racun.addStavke(stavka);
                }
                RacuniDB.getDBRacuni().dodajRacun(racun);
                RacuniDB.getDBRacuni().pisiUFajl();
                
                Office.this.listaStavki.clear();
                Office.this.modelZaTabeluStavki.setNumRows(0);
                
                JOptionPane.showMessageDialog(parent,
                        "Uspešno ste formirali račun!",
                        "Poruka o formiranom računu",
                        -1);
                Office.this.modelStavkeRacuna.fireTableDataChanged();
            }
            Office.this.modelStavkeRacuna.fireTableDataChanged();
        });
        panelStavkeKomande.add(this.dugmeFormirajRacun);
        panelStavkeKomande.add(this.dugmeUkloniStavkuRacuna);
        panelStavkeKomande.add(this.dugmeOdustaniOdKupovine);
        

        //--------------------------------------------------------------
        if (MainFrame.ulogovaniKorisnik.isAddmin()) {
            JPanel panelRacuni = new JPanel(false);
            panelRacuni.setLayout(new BorderLayout());
            tabbedPane.addTab("Racuni", new ImageIcon(pregledRacunaJPGPutanja), panelRacuni, "Racuni");
            this.modelRacuni = new TableModelRacuni();
            this.tabelaRacuni = new JTable(this.modelRacuni);
            this.tabelaRacuni.setToolTipText("Tabela izdatih računa!");
            this.tabelaRacuni.setAutoCreateRowSorter(true);
            this.tabelaRacuni.setSelectionMode(0);
            this.tabelaRacuni.setBackground(new Color(198, 214, 133));
            this.selektovanRacun = RacuniDB.getDBRacuni().getSelektovanRacun();
            
            ListSelectionModel lsmRacuni = this.tabelaRacuni.getSelectionModel();
            lsmRacuni.addListSelectionListener((ListSelectionEvent e) -> {
                Office.this.modelStavkeRacuna.fireTableDataChanged();
                if ((!e.getValueIsAdjusting()) && ((e.getSource() instanceof ListSelectionModel))) {
                    int row = Office.this.tabelaRacuni.getSelectedRow();
                    Office.this.modelStavkeRacuna.fireTableDataChanged();
                    if (row == -1) {
                        Office.this.modelStavkeRacuna.fireTableDataChanged();
                        return;
                    }
                    String sifraRacuna = (String) Office.this.tabelaRacuni.getValueAt(row, 0);
                    Office.this.modelStavkeRacuna.fireTableDataChanged();
                    for (Racuni temp : RacuniDB.getDBRacuni().sviRacuni) {
                        if (temp.getSifra().equalsIgnoreCase(sifraRacuna)) {
                            Office.this.selektovanRacun = temp;
                            RacuniDB.getDBRacuni().selektovanRacun = temp;
                            Office.this.modelStavkeRacuna.fireTableDataChanged();
                            break;
                        }
                    }
                }
            });
            this.modelStavkeRacuna = new TableModelStavkeRacuna();

            JTable tableStvakeRacuna = new JTable((TableModel) this.modelStavkeRacuna);

            JSplitPane splitPane = new JSplitPane(0,
                    new JScrollPane(this.tabelaRacuni, 22, 32),
                    new JScrollPane(tableStvakeRacuna, 22, 32));
            splitPane.setResizeWeight(0.5D);

            panelRacuni.add(splitPane, "Center");
        }
        //-------------------------------------------------------------

        if (MainFrame.ulogovaniKorisnik.isAddmin()) {
            JPanel panelRadnici = new JPanel(false);
            panelRadnici.setLayout(new BorderLayout());
            tabbedPane.addTab("Radnici", new ImageIcon(pregledRadnikaJPGPutanja), panelRadnici, "Radnici");
            this.modelRadnici = new TableModelRadnici();
            this.tabelaRadnici = new JTable(this.modelRadnici);
            this.tabelaRadnici.setToolTipText("Tabela radnika");
            this.tabelaRadnici.setAutoCreateRowSorter(true);
            this.tabelaRadnici.setSelectionMode(0);
            this.tabelaRadnici.setBackground(new Color(198, 214, 133));
            this.selektovanUser = UserData.getUserData().getSelektovanUser();
            ListSelectionModel lsmRadnici = this.tabelaRadnici.getSelectionModel();
            lsmRadnici.addListSelectionListener((ListSelectionEvent e1) -> {
                if ((!e1.getValueIsAdjusting()) && ((e1.getSource() instanceof ListSelectionModel))) {
                    int row1 = Office.this.tabelaRadnici.getSelectedRow();
                    if (row1 == -1) {
                        return;
                    }
                    String sifraRadnika1 = (String) Office.this.tabelaRadnici.getValueAt(row1, 0);
                    for (User temp1 : UserData.getUserData().allUsers) {
                        if (temp1.getSifra().equalsIgnoreCase(sifraRadnika1)) {
                            Office.this.selektovanUser = temp1;
                            UserData.getUserData().selektovanUser = temp1;
                            Office.this.modelStatusi.fireTableDataChanged();
                            break;
                        }
                    }
                }
            });
            this.modelStatusi = new TableModelStatusi();

            JTable tableStatusi = new JTable((TableModel) this.modelStatusi);

            JSplitPane splitPane1 = new JSplitPane(0,
                    new JScrollPane(this.tabelaRadnici, 22, 32),
                    new JScrollPane(tableStatusi, 22, 32));
            splitPane1.setResizeWeight(0.5D);

            panelRadnici.add(splitPane1, "Center");

            //--------------------------------------------------------------
            //----
            JPanel panelUser = new JPanel(false);
            panelUser.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dostupne komande", 2, 2, null, new Color(0, 0, 139)));
            panelUser.setLayout(new GridBagLayout());
            panelUser.setBackground(new Color(198, 214, 133));

            panelRadnici.add(panelUser, "South");

            //-------------------------------------------------
            this.dugmeIzmenaUser = new JButton("Izmena");
            this.dugmeIzmenaUser.setFont(new Font("Tahoma", 3, 11));
            this.dugmeIzmenaUser.setBackground(new Color(255, 115, 0));
            GridBagConstraints gbcDugmeIzmenaDvd = new GridBagConstraints();
            gbcDugmeIzmenaDvd.insets = new Insets(5, 5, 5, 5);
            panelUser.add(this.dugmeIzmenaUser, gbcDugmeIzmenaDvd);
            this.dugmeIzmenaUser.addActionListener((ActionEvent arg0) -> {
                Office.this.editUser();
            });
            this.dugmeUnosDvd = new JButton("Unos");
            this.dugmeUnosDvd.setBackground(new Color(135, 200, 10));
            this.dugmeUnosDvd.setFont(new Font("Tahoma", 3, 11));
            GridBagConstraints gbcDugmeUnosDvd = new GridBagConstraints();
            gbcDugmeUnosDvd.insets = new Insets(5, 5, 5, 5);
            panelUser.add(this.dugmeUnosDvd, gbcDugmeUnosDvd);
            this.dugmeUnosDvd.addActionListener((ActionEvent arg0) -> {
                Office.this.addNewUser();
            });

        }
        //--------------------------------------------------------------

    }

    void addNewDvd() {
        DvdFilmovi temp = new DvdFilmovi();
        Dialog Dialog = new Dialog(this, "Unos novog DVD-a", true);
        Dialog.setDvd(temp);
        Dialog.setMode(0);
        Dialog.setAllValues();
        Dialog.setVisible(true);
        if (Dialog.resultAction) {
            this.selektovanDvd = temp;
        }
    }

    void editDvd() {
        Dialog Dialog = new Dialog(this, "Izmena podataka DVD-a", true);
        Dialog.setDvd(this.selektovanDvd);
        Dialog.setMode(1);
        Dialog.setAllValues();
        Dialog.setVisible(true);
    }

    public void refreshTableDvd() {
        this.modelDvd.fireTableDataChanged();
    }

    public void refreshTableUser() {
        this.modelRadnici.fireTableDataChanged();
    }

    void browseDvd() {
        Dialog Dialog = new Dialog(this, "Pregled podataka DVD filma", true);
        Dialog.setDvd(this.selektovanDvd);
        Dialog.setMode(2);
        Dialog.setAllValues();
        Dialog.setVisible(true);
    }

    private void editUser() {
        DialogUser DialogUser = new DialogUser(this, "Izmena podataka DVD-a", true);
        DialogUser.setUser(this.selektovanUser);
        DialogUser.setMode(1);
        DialogUser.setAllValues();
        DialogUser.setVisible(true);
    }

    private void addNewUser() {
        User temp = new User();
        DialogUser DialogUser = new DialogUser(this, "Unos novog DVD-a", true);
        DialogUser.setUser(temp);
        DialogUser.setMode(0);
        DialogUser.setAllValues();
        DialogUser.setVisible(true);
        if (DialogUser.resultAction) {
            this.selektovanUser = temp;
        }
    }
}
