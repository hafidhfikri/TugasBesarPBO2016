/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import tugasbesarpbo2016.Pelanggan;
import tugasbesarpbo2016.Pengemudi;
import tugasbesarpbo2016.Pesanan;

/**
 *
 * @author Hafidh Fikri Rasyid
 */
public class PengemudiModel {
    private Koneksi conn;
    private Statement stmt;
    
    
    public PengemudiModel(){
        this.conn = new Koneksi();
        conn.bikinKoneksi();
    }
    
    public boolean cekPengemudi(String username, String password) throws SQLException{
        stmt = conn.getConn().createStatement();
        String query = "select * from pengemudi where username='"+username+"' and password = '"+password+"'";
        ResultSet rs = stmt.executeQuery(query);
        if (rs != null && rs.next()) {
           return true;
        }else{
           return false;
        }
    }
    
    public Pengemudi getDataPengemudi(String username, String password) throws SQLException{        
        stmt = conn.getConn().createStatement();
        String query = "select * from pengemudi where username='"+username+"' and password = '"+password+"'";
        ResultSet rs = stmt.executeQuery(query);
        if (rs != null && rs.next()) {
           Pengemudi p = new Pengemudi(rs.getString("nama"),rs.getLong("no_telepon"),rs.getLong("id_pengemudi"),username,password);
           return p;
        }
        
        return null;
    }
    
    public Vector getPesanan() throws SQLException{
        stmt = conn.getConn().createStatement();
        Vector<Vector<String>> pesananVektor = new Vector<Vector<String>>();
        String query = "select pesanan.id_pesanan, pesanan.asal,pesanan.tujuan, pelanggan.no_telepon, pesanan.kategori, pesanan.status from pesanan inner join pelanggan on pesanan.id_pelanggan = pelanggan.id_pelanggan";
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            Vector<String> pesanan = new Vector<String>();
            pesanan.add(rs.getString(1));
            pesanan.add(rs.getString(5));
            pesanan.add(rs.getString(2));
            pesanan.add(rs.getString(3));
            pesanan.add(rs.getString(4));
            pesanan.add(rs.getString(6));
            pesananVektor.add(pesanan);
        }
        
        return pesananVektor;
    }
    
    public Pesanan getDetilPesanan(String id) throws SQLException{
        Pesanan p = new Pesanan();
        stmt = conn.getConn().createStatement();
        String query = "select * from pesanan where id_pesanan = "+id;
        ResultSet rs = stmt.executeQuery(query);
        if (rs != null && rs.next()) {
            p.setId_pesanan(rs.getInt(1));
            p.setAlamat_asal(rs.getString(3));
            p.setAlamat_tujuan(rs.getString(4));
            p.setTarif(rs.getInt(5));
           return p;
        }
        return null;
    }
    
    public void takePesanan(int idp, long idpe) throws SQLException{
        //update pesanan
        stmt = conn.getConn().createStatement();
        String query = "Update pesanan Set status = 'Taken' Where id_pesanan = "+idp;
        stmt.executeUpdate(query);
        //input ke order
        query = "Insert into orderpesanan values("+idp+","+idpe+");";
        stmt.executeUpdate(query);
    }
}
