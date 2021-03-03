package penjualan.interfc;

import java.util.ArrayList;
import penjualan.entity.Barang;

public interface barangInterface {
    ArrayList<Barang> getAll();
    void insert(Barang barang);
    void update(String id, Barang barang);
    void delete(String id);
    
}
