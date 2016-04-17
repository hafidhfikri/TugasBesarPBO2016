package Controller;

import Model.PengemudiModel;
import View.signin_pengemudi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import tugasbesarpbo2016.Pengemudi;

public class sign_pengemudiController implements ActionListener{
    signin_pengemudi sp;
    private PengemudiModel pm;

    public sign_pengemudiController()
    {
        sp = new signin_pengemudi();
        pm = new PengemudiModel();
        sp.setVisible(true);
        sp.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e == sp.getBtnlogin())
        {
            if (sp.getTxtusername().getText().isEmpty() || sp.getTxtPass().getText().isEmpty())
            {
                JOptionPane.showMessageDialog(sp,"Data Pengemudi Tidak Boleh Kosong");
            }else 
            {
                boolean log = false;
                 try {
                    log = pm.cekPengemudi(sp.getTxtusername().getText(), sp.getTxtPass().getText());
                } catch (SQLException ex) {
                     System.err.println(ex);                
                }
                if(log){
                    System.out.println("Proses Pilih Menu");
                    JOptionPane.showMessageDialog(sp,"Log In Pengemudi Berhasil Dilakukan");
                    try {
                        Pengemudi p = pm.getDataPengemudi(sp.getTxtusername().getText(), sp.getTxtPass().getText());
                        new MenuPengemudiController(p);
                        sp.dispose(); 
                    } catch (SQLException ex) {
                        System.err.println("Data error");      
                        System.out.println(ex);
                    } 
                }else{
                    JOptionPane.showMessageDialog(sp,"Log In Pengemudi Gagal Dilakukan");
                }       
            }
        }
        else if (e == sp.getBtnBack())
        {
            new Menu1Controller();
            sp.dispose();
        }
    }
    
    
    
}
