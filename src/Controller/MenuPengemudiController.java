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
import tugasbesarpbo2016.Pesanan;

/**
 *
 * @author Hafidh Fikri Rasyid
 */
public class MenuPengemudiController extends JTable implements ActionListener {
    MenuPengemudi viMenPe;
    private Pengemudi pe;
    private Pesanan ps;
    private PengemudiModel pm;
    JTable tabel;

    public MenuPengemudiController(Pengemudi p) throws SQLException {
        pm = new PengemudiModel();
        ps = new Pesanan();
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
                    ps = pm.getDetilPesanan(id_pesanan);
                    if(ps != null){
                         new price_pengemudiController(pe,id_pesanan);
                        viMenPe.dispose();
                    }else{
                        JOptionPane.showMessageDialog(viMenPe,"ID yang anda masukkan salah !");
                    }  
                } catch (SQLException ex) {
                    System.err.println("Data Error");       
                }catch (java.lang.NullPointerException ea){
                    JOptionPane.showMessageDialog(viMenPe,"ID yang anda masukkan salah !");
                }
            }

        }
        else if (e == viMenPe.getBtnLogout())
        {
            new Menu1Controller();
            viMenPe.dispose();
        }
    }
    
}
