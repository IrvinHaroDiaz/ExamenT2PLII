package TestEntidades;

import DaoImp.UsuarioImp;
import model.TblUsuariocl2;

public class TestEntidadesProveedor {

	public static void main(String[] args) {
		TblUsuariocl2 usuario = new TblUsuariocl2();
        UsuarioImp usuarioImp = new UsuarioImp();

        usuario.setUsuariocl2("Carlos");
        usuario.setPasswordcl2("12345");

        usuarioImp.registrar(usuario);
        System.out.println("Usuario registrado correctamente.");
    }
}