/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesarpbo2016;

/**
 *
 * @author Hafidh Fikri Rasyid
 */
public class Pesanan {
    private long id_pesanan;
    private int tarif;
    private String alamat_tujuan;
    private String alamat_asal;
    private String Status;
    private int jarak;
    private int jenis;
    private int berat;
    
    public Pesanan(String alamat_tujuan, String Status, long id_pesanan){
        this.alamat_tujuan = alamat_tujuan;
        this.Status = Status;
        this.id_pesanan = id_pesanan;
    }
    
     public Pesanan(String alamat_tujuan,String alamat_asal, String Status, int jarak){
        this.alamat_tujuan = alamat_tujuan;
        this.alamat_asal = alamat_asal;
        this.Status = Status;
        this.jarak = jarak;
    }

    public Pesanan() {
    }
        
    public void createTarif(int jenis) {
        this.jenis = jenis;
    }
    
    public void createTariff(int jenis, int berat) {
        this.jenis = jenis;
        this.berat = berat;
    }
    
    public void ubahStatus(String Status) {
        this.Status = Status;
    }

    public long getId_pesanan() {
        return id_pesanan;
    }

    public void setId_pesanan(long id_pesanan) {
        this.id_pesanan = id_pesanan;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public String getAlamat_tujuan() {
        return alamat_tujuan;
    }

    public void setAlamat_tujuan(String alamat_tujuan) {
        this.alamat_tujuan = alamat_tujuan;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getJarak() {
        return jarak;
    }

    public void setJarak(int jarak) {
        this.jarak = jarak;
    }

    public void setAlamat_asal(String alamat_asal) {
        this.alamat_asal = alamat_asal;
    }

    public String getAlamat_asal() {
        return alamat_asal;
    }
    
    public String toString(){
        String x = "\nID Pesanan : "+this.getId_pesanan()+
                "\nAlamat Tujuan : "+this.getAlamat_tujuan()+
                "\nStatus : "+this.getStatus()+
                "\nJarak : "+this.getJarak()+
                "\nTarif :"+ this.getTarif();
        return x;
    }
}
