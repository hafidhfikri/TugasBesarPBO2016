package Controller;

import Model.PesananModel;
import View.price_transport;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tugasbesarpbo2016.Pelanggan;
import tugasbesarpbo2016.Pesanan;

public class price_transportController implements ActionListener{
    price_transport pt;
    private PesananModel pm;
    private Pelanggan p;
    private String asal;
    private String tujuan;
    private int jarak;
    
    public price_transportController(String asal, String tujuan,int km,Pelanggan p)
    {
        pt = new price_transport();
        pt.setVisible(true);
        pt.addListener(this);
        pt.getTxtOrigin().setText(asal);
        pt.getTxtDestination().setText(tujuan);
        pt.getTxtHarga().setText(""+km*4000);
        pm = new PesananModel();
        this.p = p;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jarak = km;
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if(e == pt.getBtnOrder())
        {
            Pesanan p = new Pesanan(tujuan,asal,"Pending", jarak);
            p.setTarif((int) Long.parseLong(pt.getTxtHarga().getText()));
            p.setJarak(jarak);
            pm.createPesanan(p, this.p.getId_pelanggan());
            JOptionPane.showMessageDialog(pt,"Order Pick Up Berhasil Dilakukan");
            new MenuPelangganController(this.p);
            pt.dispose();
        }
        else if(e == pt.getBtnCancel())
        {
            JOptionPane.showMessageDialog(pt,"Order Pick Up Dibatalkan");
            new MenuPelangganController(p);
            pt.dispose();
        }
    }
    
}
