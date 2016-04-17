package Controller;

import Model.PelangganModel;
import View.signin;
import View.signup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tugasbesarpbo2016.Pelanggan;

public class signinController implements ActionListener{
    signin s;
    private PelangganModel pm;
    public signinController() throws SQLException {
        s = new signin();
        s.setVisible(true);
        s.addListener(this);
        pm = new PelangganModel();
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e == s.getLogin())
        {
            if ((s.getTxtusername().getText().isEmpty()) || s.getTxtPass().getText().isEmpty())
            {
                JOptionPane.showMessageDialog(s, "Data Pengguna tidak boleh kosong");
            }
            else
            {
                boolean log = false;
                try {
                    log = pm.cekPelanggan(s.getTxtusername().getText(), s.getTxtPass().getText());
                } catch (SQLException ex) {
                    System.err.println("Login gagal");
                }
                System.out.println(log);
                if(log){
                    System.out.println("Proses Pilih Menu");
                    JOptionPane.showMessageDialog(s,"Log In Berhasil Dilakukan");
                    try {
                        Pelanggan p = pm.getDataPelanggan(s.getTxtusername().getText(), s.getTxtPass().getText());
                        new MenuPelangganController(p);
                        s.dispose(); 
                    } catch (SQLException ex) {
                        System.err.println("Data error");             
                    } 
                }else{
                    JOptionPane.showMessageDialog(s,"Log In Gagal Dilakukan");
                }         
            }

        }
        else if (e == s.getSignupnow())
        {
            System.out.println("Proses Sign Up Pelanggan");
            try {
                new signupController();
            } catch (SQLException ex) {
                System.err.println("Database Error");   
            }
            s.dispose(); 
        }
    }
    
}
