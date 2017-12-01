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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import projekat.logIn.LogIn;
import projekat.logIn.User;
import projekat.logIn.UserData;

public class MainFrame
        extends JFrame {

    static public User ulogovaniKorisnik;
    private JPanel contentPane;
    JToolBar toolBar;
    private JButton btnEvidencija;
    private JButton btnProdavnica;
    private JLabel labelaUlogovanUser;
    private JButton btnLogIn;
    private JButton btnLogOut;
    String separatorPutanje = System.getProperty("file.separator");

    public MainFrame() {
        loadUsers();

        String documentJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "document.jpg";
        String storeJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "store.jpg";

        setTitle("Projekat kod Stojica");
        setDefaultCloseOperation(3);
        setBounds(200, 200, 800, 400);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(this.contentPane);

        this.toolBar = new JToolBar("Rad sa artiklima", 0);

        this.btnEvidencija = new JButton();
        this.btnEvidencija.setMnemonic('B');
        this.btnEvidencija.setText("BackOffice - Evidencija");
        this.btnEvidencija.setToolTipText("Evidencija");
        this.btnEvidencija.setIcon(new ImageIcon(documentJPGPutanja));

        this.btnEvidencija.addActionListener((ActionEvent fi) -> {
            if (MainFrame.this.ulogovaniKorisnik != null) {
                Office bf = new Office(MainFrame.this.getMainFrame());
                bf.setVisible(true);
            } else {
                MainFrame.this.pozoviLogInProzor();
            }
        });
        this.toolBar.add(this.btnEvidencija);

        this.toolBar.addSeparator();

        this.btnProdavnica = new JButton();
        this.btnProdavnica.setMnemonic('F');
        this.btnProdavnica.setText("FrontOffice - Prodavnica");
        this.btnProdavnica.setToolTipText("Prodavnica");
        this.btnProdavnica.setIcon(new ImageIcon(storeJPGPutanja));
        this.btnProdavnica.addActionListener((ActionEvent e) -> {
            if (MainFrame.this.ulogovaniKorisnik != null) {
                Office fo = new Office(MainFrame.this.getMainFrame());
                fo.setVisible(true);
            } else {
                MainFrame.this.pozoviLogInProzor();
            }
        });
        this.toolBar.add(this.btnProdavnica);

        JSeparator jSeparator = new JSeparator();
        jSeparator.setForeground(Color.ORANGE);
        this.toolBar.add(jSeparator);

        this.labelaUlogovanUser = new JLabel("Not logged");
        this.toolBar.add(this.labelaUlogovanUser);

        this.toolBar.addSeparator();

        this.btnLogIn = new JButton();
        this.btnLogIn.setMnemonic('L');
        this.btnLogIn.setText("Log In");
        this.btnLogIn.addActionListener((ActionEvent e) -> {
            MainFrame.this.login();
        });
        this.toolBar.add(this.btnLogIn);

        this.btnLogOut = new JButton();
        this.btnLogOut.setText("Log Out");
        this.btnLogOut.addActionListener((ActionEvent e) -> {
            MainFrame.this.logout();
        });
        this.toolBar.add(this.btnLogOut);

        this.toolBar.setFloatable(false);
        this.toolBar.setBackground(Color.ORANGE);
        this.contentPane.add(this.toolBar, "Center");
        if (this.ulogovaniKorisnik == null) {
            pozoviLogInProzor();
        }
    }

    public void pozoviLogInProzor() {
        this.ulogovaniKorisnik = null;
        LogIn logginScreen = new LogIn(this, true);
        logginScreen.setVisible(true);
    }

    void logout() {
        this.ulogovaniKorisnik = null;
        this.labelaUlogovanUser.setText("Niste ulogovani");
        this.btnLogIn.setVisible(true);
        this.btnLogOut.setVisible(false);
        this.btnEvidencija.setEnabled(true);
    }

    void login() {
        this.ulogovaniKorisnik = null;
        LogIn logginScreen = new LogIn(this, true);
        logginScreen.setVisible(true);
    }

    void loadUsers() {
        UserData.getUserData();
    }

    public User getUlogovaniKorisnik() {
        return this.ulogovaniKorisnik;
    }

    public void setUlogovaniKorisnik(User ulogovaniKorisnik) {
        this.ulogovaniKorisnik = ulogovaniKorisnik;
        if (ulogovaniKorisnik != null) {
            getLabelaUlogovanUser().setText("Ulogovani ste:  "
                    + ulogovaniKorisnik.getIme() + " "
                    + ulogovaniKorisnik.getPrezime());
            getBtnLogIn().setVisible(false);
            getBtnLogOut().setVisible(true);

            this.btnEvidencija.setEnabled(ulogovaniKorisnik.isAddmin());
        } else {
            logout();
        }
    }

    public JLabel getLabelaUlogovanUser() {
        return this.labelaUlogovanUser;
    }

    public void setLabelaUlogovanUser(JLabel labelaUlogovanUser) {
        this.labelaUlogovanUser = labelaUlogovanUser;
    }

    public JButton getBtnLogIn() {
        return this.btnLogIn;
    }

    public void setBtnLogIn(JButton btnLogIn) {
        this.btnLogIn = btnLogIn;
    }

    public JButton getBtnLogOut() {
        return this.btnLogOut;
    }

    public void setBtnLogOut(JButton btnLogOut) {
        this.btnLogOut = btnLogOut;
    }

    public MainFrame getMainFrame() {
        return this;
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(false);
    }
}
