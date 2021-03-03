package penjualan.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {
    private static Connection conn;
    public static Connection getConnection(){
        if (conn==null) {
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn=DriverManager.getConnection("jdbc:mysql://localhost/db_mvc","root","");
                
            }catch (SQLException ex){
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }  
}

