package Controller;

import Model.PesananModel;
import View.price_courier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tugasbesarpbo2016.Pelanggan;
import tugasbesarpbo2016.Pesanan;

public class price_courierController implements ActionListener{
    price_courier pc;
    private PesananModel pm;
    private Pelanggan p;
    private String asal;
    private String tujuan;
    private int jarak;
    private String deskripsi;

    public price_courierController(String asal, String tujuan, int km,Pelanggan p, String deskripsi) {
        pc = new price_courier();
        pc.setVisible(true);
        pc.addListener(this);
        pc.getTxtFrom().setText(asal);
        pc.getTxtTo().setText(tujuan);
        pc.getTxtPrice().setText(""+((km*4000)+5000));
        pm = new PesananModel();
        this.p = p;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jarak = km;
        this.deskripsi = deskripsi;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e == pc.getBtnOrder())
        {
            Pesanan p = new Pesanan(tujuan,asal,"Pending", jarak);
            p.setTarif((int) Long.parseLong(pc.getTxtPrice().getText()));
            pm.createPesananKurir(p, this.p.getId_pelanggan(),deskripsi);
            JOptionPane.showMessageDialog(pc,"Order Courier Berhasil Dilakukan");
            new MenuPelangganController(this.p);
            pc.dispose();
        }
        else if(e == pc.getBtnCancel())
        {
            JOptionPane.showMessageDialog(pc,"Order Courier Dibatalkan");
            new MenuPelangganController(p);
            pc.dispose();
        }
    }
    
}
