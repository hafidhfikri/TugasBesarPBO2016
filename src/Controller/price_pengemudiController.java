package Controller;

import Model.PengemudiModel;
import View.price_pengemudi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tugasbesarpbo2016.Pengemudi;
import tugasbesarpbo2016.Pesanan;

public class price_pengemudiController implements ActionListener{
    price_pengemudi pp;
    private Pengemudi pe;
    private PengemudiModel pm;
    private Pesanan pes;
    
    public price_pengemudiController(Pengemudi p, String idp) throws SQLException {
        pp = new price_pengemudi();
        pm = new PengemudiModel();
        pp.setVisible(true);
        pp.addListener(this);
        pe = p;
        
        pes = new Pesanan();
        pes = pm.getDetilPesanan(idp);
        
        pp.getTxtAsal().setText(pes.getAlamat_asal());
        pp.getTxtTujuan().setText(pes.getAlamat_tujuan());
        pp.getTxtTarif().setText(String.valueOf(pes.getTarif()));
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if(e == pp.getBtnOrder())
        {
            JOptionPane.showMessageDialog(pp,"Order telah sukses diambil");
            try {
                pm.takePesanan((int) pes.getId_pesanan(), pe.getId_pengemudi());
                new MenuPengemudiController(pe);
            } catch (SQLException ex) {
                System.err.println("Data error");   
            }
            pp.dispose();
        }
        else if(e == pp.getBtnCancel())
        {
            try {  
                new MenuPengemudiController(pe);
                pp.dispose();
            } catch (SQLException ex) {
                System.err.println("Data error");   
            } 
        }
        
    }
    
}
