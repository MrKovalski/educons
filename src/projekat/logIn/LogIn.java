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
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import projekat.frejm.MainFrame;
import projekat.frejm.Office;
//log in klasa 

public class LogIn
        extends JDialog {

    private MainFrame parent;
    private JLabel lblUsername;
    private JTextField txtFldUsername;
    private JLabel lblPassword;
    private JPasswordField passFldPassword;
    private JButton buttonLogIn;
    private ArrayList<User> allUsers;
    String separatorPutanje = System.getProperty("file.separator");

    

    
    //Konstruktor sa parametrima 
    public LogIn(MainFrame parent, boolean modal) {
        super(parent, "Prijava radnika na sistem", modal);
        this.parent = parent;
        this.allUsers = UserData.getUserData().getAllUsers();
        // pravljenje putanje za ikonicu i setovanje ikonice
        String logInJPGPutanja = "." + this.separatorPutanje + "resource" + this.separatorPutanje + "images" + this.separatorPutanje + "logIn.jpg";
        setIconImage(Toolkit.getDefaultToolkit().getImage(logInJPGPutanja));
        
        //podesavanje grid layaouta
        GridBagConstraints gbc = new GridBagConstraints();
        getContentPane().setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.anchor = 22;
        gbc.weightx = 0.0D;
        gbc.weighty = 0.0D;

        this.lblUsername = new JLabel("Korisničko ime:");
        getContentPane().add(this.lblUsername, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = 2;
        gbc.anchor = 10;
        gbc.weightx = 1.0D;
        this.txtFldUsername = new JTextField();
        getContentPane().add(this.txtFldUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0D;
        gbc.fill = 0;
        gbc.anchor = 22;
        this.lblPassword = new JLabel("Šifra: ");
        getContentPane().add(this.lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = 2;
        gbc.anchor = 10;
        gbc.weightx = 1.0D;
        this.passFldPassword = new JPasswordField();
        getContentPane().add(this.passFldPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.0D;
        gbc.fill = 0;
        gbc.anchor = 22;
        this.buttonLogIn = new JButton("Uloguj se");
        this.buttonLogIn.addActionListener((ActionEvent e) -> {
            LogIn.this.loggin();
        });
        getContentPane().add(this.buttonLogIn, gbc);
        setPreferredSize(new Dimension(300, 150));
        setModalityType(DEFAULT_MODALITY_TYPE);

        pack();
        Toolkit kit = Toolkit.getDefaultToolkit();
        int screenWidth = kit.getScreenSize().width;
        int screenHeight = kit.getScreenSize().height;
        setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
        // x dugme za exit
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //funkcija za ulogovanje na sistem
    void loggin() {
        User logged = null;
        if (this.txtFldUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Niste uneli korisničko ime.", "Greška pri unosu vrednosti",
                    0);
        } else if ((this.passFldPassword.getPassword() == null) || (this.passFldPassword.getPassword().length <= 1)) {
            JOptionPane.showMessageDialog(this, "Niste uneli šifru.", "Greška pri unosu vrednosti.",
                    0);
        } else {
            //poredi privremenog usera sa originalnim userima dok ne pronadje onog koji odgovara
            for (User u : this.allUsers) {
                String pass = "";
                for (char ch : this.passFldPassword.getPassword()) {
                    pass = pass + ch;
                }
                if ((u.username.equals(this.txtFldUsername.getText())) && (u.password.equals(pass))) {
                    logged = u;
                    break;
                }
            }
            if (logged == null || logged.getAddmin() == 2) {
                JOptionPane.showMessageDialog(this, "Korisnik sa datim informacijama ne postoji u sistemu!", "User not found",
                        2);
            } else {
                this.parent.setUlogovaniKorisnik(logged);

                this.parent.setVisible(false);

                if (this.parent.ulogovaniKorisnik != null) {
                    Office fo = new Office(this.parent.getMainFrame());

                    fo.setVisible(true);
                } else {
                    this.parent.pozoviLogInProzor();
                }

                dispose();

            }
        }
    }

}
