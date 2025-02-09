package Interfaces;

import java.util.List;
import model.TblProveedorcl2;

public interface IProveedor {
	void registrar(TblProveedorcl2 proveedor);
    TblProveedorcl2 buscarPorId(int id);
    List<TblProveedorcl2> listarTodos();
    void actualizar(TblProveedorcl2 proveedor);
    void eliminar(int id);
}
