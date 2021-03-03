package penjualan.interfc;

import java.sql.SQLException;
import java.util.List;
import penjualan.entity.Pelanggan;

public interface pelangganInterface {
    Pelanggan insert (Pelanggan o) throws SQLException;
    void update (Pelanggan o) throws SQLException;
    void delete (String id_pelanggan) throws SQLException;
    List getAll() throws SQLException;
    
}
