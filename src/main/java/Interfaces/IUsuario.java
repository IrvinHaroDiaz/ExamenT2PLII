package Interfaces;

import java.util.List;
import model.TblUsuariocl2;

public interface IUsuario {
	void registrar(TblUsuariocl2 usuario);
    TblUsuariocl2 buscarPorId(int id);
    List<TblUsuariocl2> listarTodos();
    void actualizar(TblUsuariocl2 usuario);
    void eliminar(int id);
	TblUsuariocl2 buscarPorId(String usuario);
}
