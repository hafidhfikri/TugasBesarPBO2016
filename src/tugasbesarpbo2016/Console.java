/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesarpbo2016;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Hafidh Fikri Rasyid
 */
public class Console {
    
    private List<Pelanggan> daftarPelanggan = new ArrayList<Pelanggan>();
    private List<Pengemudi> daftarPengemudi = new ArrayList<Pengemudi>();
    private List<Pesanan> daftarPesanan = new ArrayList<Pesanan>();
    private Scanner scan = new Scanner(System.in);
    final String baru = "Baru";
    final String process = "Sedang Diproses";
    final String finish = "Selesai";
    final String kembali = "Tidak Ditemukan";
    final String file_pelanggan = "data_pelanggan.dat";
    final String file_pengemudi = "data_pengemudi.dat";
    Serial serial;
       
    public void addPelanggan(String nama, long no_telp, String alamat_pelanggan, long id_pelanggan,String username,String password) throws IOException{
        Pelanggan tmp_pelanggan = new Pelanggan(nama,no_telp,alamat_pelanggan,id_pelanggan,username,password);
        daftarPelanggan.add(tmp_pelanggan);
    }
    
    public void addPengemudi(String nama, long no_telp, long id_pengemudi,String username,String password) throws IOException{
        Pengemudi tmp_pengemudi = new Pengemudi(nama,no_telp,id_pengemudi,username,password);
        daftarPengemudi.add(tmp_pengemudi);
    }
    
    public Pengemudi getPengemudi(long idPengemudi){
        int panjang = daftarPengemudi.size();
        for (int i = 0; i < panjang; i++) {
            if(daftarPengemudi.get(i).getId_pengemudi() == idPengemudi){
                return daftarPengemudi.get(i);
            }
        }
        return null;
    }
    
    public Pesanan getPesanan(long idPesanan){
        int panjang = daftarPesanan.size();
        for (int i = 0; i < panjang; i++) {
            if(daftarPesanan.get(i).getId_pesanan()== idPesanan){
                return daftarPesanan.get(i);
            }
        }
        return null;
    }
    
    public Pengemudi getPengemudi(String username,String password){
        int panjang = daftarPengemudi.size();
        for (int i = 0; i < panjang; i++) {
            if((username.equals(daftarPengemudi.get(i).getUsername()))&&(password.equals(daftarPengemudi.get(i).getPassword()))){
                return daftarPengemudi.get(i);
            }
        }
        return null;
    }
    
    public void deletePengemudi(long idPengemudi){
        int panjang = daftarPengemudi.size();
        for (int i = 0; i < panjang; i++) {
            if(daftarPengemudi.get(i).getId_pengemudi() == idPengemudi){
                daftarPengemudi.remove(i);
            }
        }
    }
    
    public Pelanggan getPelanggan(long idPelanggan){
        int panjang = daftarPelanggan.size();
        for (int i = 0; i < panjang; i++) {
            if(daftarPelanggan.get(i).getId_pelanggan() == idPelanggan){
                return daftarPelanggan.get(i);
            }
        }
        return null;
    }
    
    public Pelanggan getPelanggan(String username,String password){
        int panjang = daftarPelanggan.size();
        for (int i = 0; i < panjang; i++) {
            if((username.equals(daftarPelanggan.get(i).getUsername()))&&(password.equals(daftarPelanggan.get(i).getPassword()))){
                return daftarPelanggan.get(i);
            }
        }
        return null;
    }
    
    public void deletePelanggan(long idPelanggan){
        int panjang = daftarPelanggan.size();
        for (int i = 0; i < panjang; i++) {
            if(daftarPelanggan.get(i).getId_pelanggan() == idPelanggan){
                daftarPelanggan.remove(i);
            }
        }
    }
    
    public boolean cekPelanggan(String username,String password){
        if(getPelanggan(username, password) != null){
            return true;
        }
        return false;   
    }
    
    public boolean cekPengemudi(String username,String password){
        if(getPengemudi(username, password) != null){
            return true;
        }
        return false;
    }
   
    
    public void MenuLayananOjek(Pelanggan p){
        long id_pesanan;
        String status, alamat_tujuan;
        Pesanan tmpPesanan;
        int indPengemudi = -1;
        
        System.out.print("ID Pesanan : ");
        id_pesanan = scan.nextLong();
        System.out.print("Alamat Tujuan : ");
        alamat_tujuan = scan.next();
        
        tmpPesanan = new Pesanan(alamat_tujuan, baru, id_pesanan);
        p.createPesanan(tmpPesanan);
        
        daftarPesanan.add(tmpPesanan);
    }
    
    public void MenuLayananAntarBarang(Pelanggan p){
        long id_pesanan;
        String status, alamat_tujuan,nama_barang;
        Kurir tmpKurir;
        int indPengemudi = -1;
        
        System.out.print("ID Pesanan : ");
        id_pesanan = scan.nextLong();
        System.out.print("Alamat Tujuan : ");
        alamat_tujuan = scan.next();
        System.out.print("Nama Barang : ");
        nama_barang = scan.next();
        
        tmpKurir = new Kurir(alamat_tujuan, baru, nama_barang, id_pesanan);
        p.createPesananKurir(tmpKurir);
         
        daftarPesanan.add(tmpKurir);
    }
    
    public void tambahPelanggan() throws Exception{
        String nama,alamat_pelanggan, username,password;
        long no_telp,id_pelanggan;
        
        System.out.print("Id Pelanggan : ");
        id_pelanggan = scan.nextLong();
        System.out.print("Nama : ");
        nama = scan.next();
        System.out.print("Username : ");
        username = scan.next();
        System.out.print("Password : ");
        password = scan.next();
        System.out.print("No Telepon : ");
        no_telp = scan.nextLong();
        System.out.print("Alamat Pelanggan : ");
        alamat_pelanggan = scan.next();
        
        
        addPelanggan(nama, no_telp, alamat_pelanggan, id_pelanggan, username, password);
    }
    
    public void tambahPengemudi() throws Exception{
        String nama,username,password;
        long no_telp,id_pengemudi;
        
        System.out.print("Id Pengemudi : ");
        id_pengemudi = scan.nextLong();
        System.out.print("Nama : ");
        nama = scan.next();
        System.out.print("Username : ");
        username = scan.next();
        System.out.print("Password : ");
        password = scan.next();
        System.out.print("No Telepon : ");
        no_telp = scan.nextLong();
        
        addPengemudi(nama, no_telp, id_pengemudi, username, password);
    }
    
    public void lihatStatusPesanan(Pelanggan p){
        int banyakPesanan;
        banyakPesanan = p.getJml_pesanan();
        
        System.out.println("Status Pesanan anda");
        
        for (int i = 0; i < banyakPesanan; i++) {
            System.out.println("Pesanan ber-id "+p.getPesanan(i).getId_pesanan()+" memiliki status "+p.getPesanan(i).getStatus());
        }
    }
    
    public void pilihPengemudi(int dri){
        System.out.println("Silahkan pilih pengemudi : ");
        for (int i = 0; i < 10; i++) {
            System.out.println((i+1)+". "+daftarPengemudi.get(i).getNama());
        }
        System.out.print("Pilih driver : ");
        dri = scan.nextInt();
        dri--;
    }
    
    public void ubahStatusPesanan(Pengemudi p,Pesanan an){
        String stat;
        
        System.out.println("Anda sedang membawa pesanan "+an.getId_pesanan());
        System.out.println("Silahkan pilih status yang ingin diubah : ");
        System.out.println("1. Selesai");
        System.out.println("2. Dikembalikan");
        System.out.print("Pilih status : ");
        stat = scan.next();
        
        if (new String("1").contains(stat)) {
            an.setStatus(finish);
            an = null;
        }else if(new String("2").contains(stat)){
            an.setStatus(kembali);
            an = null;
        }else{
            System.out.println("inputan salah");
        }
    }
    
    public void pilihPesanan(Pengemudi p){
        long tempID;
        int tmpPes = daftarPesanan.size();
        System.out.println("Silahkan pilih pesanan : ");
        for (int i = 0; i < tmpPes; i++) {
            if(new String(baru).equals(daftarPesanan.get(i).getStatus())){
                 System.out.println("ID Pesanan : "+daftarPesanan.get(i).getId_pesanan());
                 System.out.println("Alamat Tujuan"+daftarPesanan.get(i).getAlamat_tujuan());
                 System.out.println("");
            }
        }
    }
    
    public Pesanan pilihPesanan(Pengemudi p,long tempID){
        if(getPesanan(tempID)!= null){
            p.createPesanan(getPesanan(tempID));
            getPesanan(tempID).setStatus(process);
            return getPesanan(tempID);
        }else{
            System.out.println("inputan id pesanan salah");
            return null;
        }
    }
    /*
    public void refreshListPengemudi() throws Exception{
        serial = new Serial(file_pengemudi);
        
        daftarPengemudi = (List<Pengemudi>)serial.readObject();
    }
    
    public void refreshListPelanggan() throws Exception{
        serial = new Serial(file_pelanggan);
        
        daftarPelanggan = (List<Pelanggan>)serial.readObject();
    }
    */
    public void MainMenu() throws Exception{
        boolean jalan = true;
        boolean jl = true;
        boolean pengemudi,pelanggan;
        String username,password;
        String menu;
        Pelanggan tmpPelanggan;
        Pengemudi tmpPengemudi;
        Pesanan tmpPesanan = null;
        long jon;
        
        while(jalan){
            
           System.out.println("Selamat datang di aplikasi transportasi online");
           System.out.println("1. Login");
           System.out.println("2. Daftar");
           System.out.println("3. Keluar");
           System.out.print("Pilih menu :");
           menu = scan.next();
           
           if(new String("1").contains(menu)){
                System.out.println("1. Pelanggan");
                System.out.println("2. Pengemudi");
                System.out.print("Pilih menu :");
                menu = scan.next();
                
                if(new String("1").contains(menu)){
                    //BAGIAN PELANGGAN
                    System.out.println("Silahkan login");
                    System.out.print("Username : ");
                    username = scan.next();
                    System.out.print("Password : ");
                    password = scan.next();
                    
                    //cek di pelanggan
                    System.out.println(username +""+password);
                    pelanggan = cekPelanggan(username, password);
                    System.out.println(pelanggan);
                    
                    if(pelanggan){
                        while(jl){
                            //tampung pelanggan
                           tmpPelanggan = getPelanggan(username, password);

                           System.out.println("Silahkan pilih menu");
                           System.out.println("1. Pilih Layanan (Antar Barang/Ojek)");
                           System.out.println("2. Lihat Status");
                           System.out.println("3. Logout");
                           System.out.print("Pilih menu :");
                           menu = scan.next();

                           if(new String("1").contains(menu)){
                               System.out.println("Pilih layanan");
                               System.out.println("1. Ojek");
                               System.out.println("2. Antar Barang");
                               System.out.print("Pilih menu :");
                               menu = scan.next(); 

                               if(new String("1").contains(menu)){
                                   MenuLayananOjek(tmpPelanggan);
                               }else if(new String("2").contains(menu)){
                                   MenuLayananAntarBarang(tmpPelanggan);
                               }else{
                                    System.out.println("Menu yang anda inputkan salah");
                               }
                           }else if(new String("2").contains(menu)){
                               lihatStatusPesanan(tmpPelanggan);
                           }else if(new String("3").contains(menu)){
                               pelanggan = false;
                               jl = false;
                           }else{
                               System.out.println("Menu yang anda inputkan salah");
                           }
                        }
                    }
                }else if(new String("2").contains(menu)){
                    //BAGIAN PENGEMUDI
                    System.out.println("Silahkan login");
                    System.out.print("Username : ");
                    username = scan.next();
                    System.out.print("Password : ");
                    password = scan.next();
                    
                    //cek di pengemudi
                    pengemudi = cekPengemudi(username, password);
                    if(pengemudi){
                        while(jl){
                            //tampung pengemudi
                           tmpPengemudi = getPengemudi(username, password);

                           System.out.println("Silahkan pilih menu");
                           System.out.println("1. Pilih Pesanan");
                           System.out.println("2. Ubah Status Pesanan");
                           System.out.println("3. Logout");
                           System.out.print("Pilih menu :");
                           menu = scan.next();
                           if(new String("1").contains(menu)){
                               pilihPesanan(tmpPengemudi);
                               System.out.print("silahkan ketik ID pesanan : ");
                               jon = scan.nextLong();
                               tmpPesanan = pilihPesanan(tmpPengemudi, jon);
                               System.out.println(tmpPesanan.getAlamat_tujuan());
                           }else if(new String("2").contains(menu)){
                               ubahStatusPesanan(tmpPengemudi, tmpPesanan);
                           }else if(new String("3").contains(menu)){
                                pengemudi = false;
                                jl = false;
                           }else{
                               System.out.println("Menu yang anda inputkan salah");
                           }
                        }
                    }else{
                       System.out.println("Username dan Password salah");
                    }
                }else{
                    System.out.println("Menu yang anda inputkan salah");
                }
           }else if(new String("2").contains(menu)){
                //menu tambah user
                System.out.println("1. Pelanggan");
                System.out.println("2. Pengemudi");
                System.out.print("Pilih menu :");
                menu = scan.next();
                
                if(new String("1").contains(menu)){
                    tambahPelanggan();
                }else if(new String("2").contains(menu)){
                    tambahPengemudi();
                }else{
                    System.out.println("Menu yang anda inputkan salah");
                }
           }else if(new String("3").contains(menu)){
               jalan = false;
           }else{
               System.out.println("Menu yang anda inputkan salah");
           }   
           jl = true;
        }
    }
}