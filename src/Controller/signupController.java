
package Controller;

import Model.PelangganModel;
import View.signup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tugasbesarpbo2016.Pelanggan;
public class signupController implements ActionListener{
    signup su;
    private PelangganModel pelModel;
    
    public signupController() throws SQLException
    {
        pelModel = new PelangganModel();
        su = new signup();
        su.setVisible(true);
        su.addListener(this);
    }
    
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e == su.getBtnsignup()) {
            if ((su.getTxtname().getText().isEmpty()) || (su.getTxtPass().getText().isEmpty()) || (su.getTxtusername().getText().isEmpty()) || (su.getTxtphone().getText().isEmpty()))
            {
                JOptionPane.showMessageDialog(su, "Data Pengguna tidak boleh kosong");
            }
            else
            {   long telp = Long.parseLong(su.getTxtphone().getText());
                long id = 0;
                Pelanggan p = new Pelanggan(su.getTxtname().getText(), telp , su.getTxtAddress().getText(), id, su.getTxtusername().getText(), su.getTxtPass().getText());
                
                pelModel.tambahPelanggan(p);
                JOptionPane.showMessageDialog(su, "Sign Up berhasil dilakukan");
                new MenuPelangganController(p);
                su.setVisible(false);
                su.dispose();                 
            }

        }
        else if (e == su.getBtnloginnow()) {
            System.out.println("Loading.....");
            try {
                new signinController();
            } catch (SQLException ex) {
                System.err.println("Database Error");       
            }
            su.dispose();   
        }
    }
}