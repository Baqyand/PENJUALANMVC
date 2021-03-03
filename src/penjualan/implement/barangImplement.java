package penjualan.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import penjualan.entity.Barang;
import penjualan.interfc.barangInterface;
import penjualan.koneksi.Koneksi;


public class barangImplement implements barangInterface{
    ArrayList<Barang> listBarang;
    
    //Siapkan object untuk melakukan manipulasi database/CRUD
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    //String untuk menjalankan sql
    String query;

    //Constructor untuk inisialisasi
    public barangImplement() {
        try {
            conn = Koneksi.getConnection();
            stmt = conn.createStatement();
            listBarang = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    @Override
    public ArrayList<Barang> getAll() {
        try {
            query = "SELECT * FROM barang";
            rs = stmt.executeQuery(query);
            listBarang.clear();
            while(rs.next()){
                Barang barang = new Barang();
                
                //Sesuaikan dengan tabel di DB kalian
                barang.setKodeBarang(rs.getString("kode_barang"));
                barang.setNamaBarang(rs.getString("nama_barang"));
                barang.setJumlahBarang(rs.getInt("stok"));
                barang.setHargaBarang(rs.getInt("harga"));
                
                listBarang.add(barang);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBarang;  
    }

    @Override
    public void insert(Barang barang) {
        //Melakukan insert ke database
        try {
            query = "INSERT INTO barang VALUES ('"
                    +barang.getKodeBarang()+"','"
                    +barang.getNamaBarang()+"',"
                    +barang.getJumlahBarang()+","
                    +barang.getHargaBarang()+")";
            
            int berhasil = stmt.executeUpdate(query);
            if (berhasil == 1) {
                System.out.println("Berhasil Insert Data!");
            }else if(berhasil == 0){
                System.out.println("Gagal Insert Data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, Barang barang) {
        //Melakukan update ke database tergantung id
        try {
            query = "UPDATE barang SET "
                    +"kode_barang = '"+barang.getKodeBarang()
                    +"',nama_barang = '"+barang.getNamaBarang()
                    +"',harga = "+barang.getHargaBarang()
                    +",stok = "+barang.getJumlahBarang()                   
                    +" WHERE kode_barang = '"+id+"'";
            
            int berhasil = stmt.executeUpdate(query);
                    
            if (berhasil == 1) {
                System.out.println("Berhasil Update Data!");
            }else if(berhasil == 0){
                System.out.println("Gagal Update Data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        //Menghapus dari database tergantung id
        try {
            query = "DELETE FROM barang WHERE kode_barang = '"+id+"'";
            int berhasil = stmt.executeUpdate(query);
                    
            if (berhasil == 1) {
                System.out.println("Berhasil Menghapus Data!");
            }else if(berhasil == 0){
                System.out.println("Gagal Menghapus Data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}