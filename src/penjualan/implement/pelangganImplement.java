package penjualan.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import penjualan.interfc.pelangganInterface;
import penjualan.entity.Pelanggan;
import penjualan.koneksi.Koneksi;

public class pelangganImplement implements pelangganInterface{
    
    public Pelanggan insert(Pelanggan o) throws SQLException{
        PreparedStatement st=Koneksi.getConnection().prepareStatement("insert into pelanggan values(?,?,?,?,?)");
        st.setString(1,o.getIdPelanggan());
        st.setString(2,o.getNama());
        st.setString(3,o.getJeniskel());
        st.setString(4,o.getAlamat());
        st.setString(5,o.getNotlp());
        st.executeUpdate();
        return o;
    }
    
    public void update(Pelanggan o) throws SQLException{
        PreparedStatement st=Koneksi.getConnection().prepareStatement("update pelanggan set nama=?,jk=?,alamat=?,no_telepon=? where id_pelanggan=?");
        st.setString(1,o.getNama());
        st.setString(2,o.getJeniskel());
        st.setString(3,o.getAlamat());
        st.setString(4,o.getNotlp());
        st.setString(5,o.getIdPelanggan());
        st.executeUpdate();
    }
    
     public void delete(String id_pelanggan) throws SQLException{
        PreparedStatement st=Koneksi.getConnection().prepareStatement("delete from pelanggan where id_pelanggan=?");
        st.setString(1, id_pelanggan);
        st.executeUpdate();
    }
    
    public List<Pelanggan> getAll() throws SQLException{
        Statement st=Koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from pelanggan ");  
        List<Pelanggan>list=new ArrayList<Pelanggan>();
        while(rs.next()){
            Pelanggan plg=new Pelanggan();
            plg.setIdPelanggan(rs.getString("id_pelanggan"));
            plg.setNama(rs.getString("nama"));
            plg.setJeniskel(rs.getString("jk"));
            plg.setAlamat(rs.getString("alamat"));
            plg.setNotlp(rs.getString("no_telepon"));
            list.add(plg);
        }
        return list;
        
    }

}
