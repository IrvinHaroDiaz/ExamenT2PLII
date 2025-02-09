package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImp.UsuarioImp;
import model.TblUsuariocl2;

/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UsuarioImp usuarioImp;

    public ControladorUsuario() {
        super();
        usuarioImp = new UsuarioImp();  // Instancia el DAO
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if (action == null) {
            // Listar todos los usuarios
            List<TblUsuariocl2> usuarios = usuarioImp.listarTodos();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } else if (action.equals("editar")) {
            // Editar usuario
            int id = Integer.parseInt(request.getParameter("id"));
            TblUsuariocl2 usuario = usuarioImp.buscarPorId(id);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("editarUsuario.jsp").forward(request, response);
        }
    }	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if (action.equals("registrar")) {
            // Registrar usuario
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            TblUsuariocl2 nuevoUsuario = new TblUsuariocl2();
            nuevoUsuario.setUsuariocl2(usuario);
            nuevoUsuario.setPasswordcl2(password);

            usuarioImp.registrar(nuevoUsuario);
            response.sendRedirect("ControladorUsuario");
        } else if (action.equals("actualizar")) {
            // Actualizar usuario
            int id = Integer.parseInt(request.getParameter("id"));
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            TblUsuariocl2 usuarioExistente = usuarioImp.buscarPorId(id);
            usuarioExistente.setUsuariocl2(usuario);
            usuarioExistente.setPasswordcl2(password);

            usuarioImp.actualizar(usuarioExistente);
            response.sendRedirect("ControladorUsuario");
        }
    }
}