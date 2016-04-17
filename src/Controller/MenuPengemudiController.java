/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PengemudiModel;
import View.MenuPengemudi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import tugasbesarpbo2016.Pengemudi;

/**
 *
 * @author Hafidh Fikri Rasyid
 */
public class MenuPengemudiController extends JTable implements ActionListener {
    MenuPengemudi viMenPe;
    private Pengemudi pe;
    JTable tabel;

    public MenuPengemudiController(Pengemudi p) throws SQLException {
        PengemudiModel pm = new PengemudiModel();
        viMenPe = new MenuPengemudi(pm.getPesanan());
        viMenPe.setVisible(true);
        viMenPe.addListener(this);
        
        pe = p;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e == viMenPe.getBtnTakeOrder())
        {   
            if (viMenPe.getTxtinputid().getText().isEmpty())
            {
                JOptionPane.showMessageDialog(viMenPe,"Masukan ID pesanan !!!");
            }
            else{
                String id_pesanan = viMenPe.getTxtinputid().getText();
                try {
                    new price_pengemudiController(pe,id_pesanan);
                } catch (SQLException ex) {
                    System.err.println("Data Error");       
                }
                viMenPe.dispose();
            }

        }
        else if (e == viMenPe.getBtnLogout())
        {
            new Menu1Controller();
            viMenPe.dispose();
        }
    }
    
}
