 package Controller;

import View.MenuPengemudi;
import View.menu1;
import View.signin;
import View.signup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu1Controller implements ActionListener {
    menu1 m1;

    public Menu1Controller(){
        m1 = new menu1();
        m1.setVisible(true);
        m1.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e == m1.getLogin())
        {
            System.out.println("Proses Login Pelanggan");
            try {
                new signinController();
            } catch (SQLException ex) {
                System.err.println("Database Error");
            }
            m1.dispose();
        }
        else if (e == m1.getSignup())
        {
            System.out.println("Proses Sign Up Pelanggan");
            try {
                new signupController();
            } catch (SQLException ex) {
                System.err.println("Database Error");     
            }
            m1.dispose();
        }
        else if (e == m1.getLogin_driver())
        {
            System.out.println("Proses Log In Pengemudi");
            new sign_pengemudiController();
            m1.dispose();
        }
        
    }
    
}
