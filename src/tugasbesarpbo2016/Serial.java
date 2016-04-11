/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesarpbo2016;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Hafidh Fikri Rasyid
 */
public class Serial implements Serializable{
    private String nama_file;

    public Serial(String nama_file) {
        this.nama_file = nama_file;
    }

    public String getNama_file() {
        return nama_file;
    }
    
    public void setNama_file(String nama_file) {
        this.nama_file = nama_file;
    }
    
    public void writeObject(Object obj) throws IOException{
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(nama_file));
        writer.writeObject(obj);
        writer.close();
    }
    
    public Object readObject() throws Exception{
        Object obj = new Object();
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(nama_file));
        obj = reader.readObject();
        return obj;
    }
}
