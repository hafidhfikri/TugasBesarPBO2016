package Controller;

import Model.PesananModel;
import View.Order_Transportasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tugasbesarpbo2016.Pelanggan;

public class Order_TransportasiController implements ActionListener{
    Order_Transportasi ot;
    private PesananModel pm;
    private Pelanggan p;

    public Order_TransportasiController(Pelanggan p) {
        ot = new Order_Transportasi();
        ot.setVisible(true);
        ot.addListener(this);
        this.p = p;
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e  = ae.getSource();
        if (e == ot.getBtnNext())
        {
            if (ot.getTxtFrom().getText().isEmpty() || ot.getTxtTo().getText().isEmpty())
            {
                JOptionPane.showMessageDialog(ot,"Asal dan tempat tujuan tidak boleh kosong");
            }
            else {
            System.out.println("Loading...");
            if (ot.getTxtFrom().getText().equals("Dago") && ot.getTxtTo().getText().equals("Riau"))
            {
                new price_transportController(ot.getTxtFrom().getText(),ot.getTxtTo().getText(),15,this.p);
                
            }
            ot.dispose();
            }
        }
        else if(e == ot.getBtnBack())
        {
            System.out.println("Back");
            new MenuPelangganController(p);
            ot.dispose();
        }
    }
    
    
}
