package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImp.ProveedorImp;
import model.TblProveedorcl2;

/**
 * Servlet implementation class ControladorProveedor
 */
public class ControladorProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ProveedorImp proveedorImp;

    public ControladorProveedor() {
        super();
        proveedorImp = new ProveedorImp();  // Instancia el DAO
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            // Listar todos los proveedores
            List<TblProveedorcl2> proveedores = proveedorImp.listarTodos();
            request.setAttribute("proveedores", proveedores);
            request.getRequestDispatcher("proveedores.jsp").forward(request, response);
        } else if (action.equals("editar")) {
            // Editar proveedor
            int id = Integer.parseInt(request.getParameter("id"));
            TblProveedorcl2 proveedor = proveedorImp.buscarPorId(id);
            request.setAttribute("proveedor", proveedor);
            request.getRequestDispatcher("editarProveedor.jsp").forward(request, response);
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("registrar")) {
            // Registrar proveedor
            String nombre = request.getParameter("nombre");
            String ruc = request.getParameter("ruc");
            String email = request.getParameter("email");
            TblProveedorcl2 proveedor = new TblProveedorcl2();
            proveedor.setNomproveecl2(nombre);
            proveedor.setRucproveecl2(ruc);
            proveedor.setEmailproveecl2(email);

            proveedorImp.registrar(proveedor);
            response.sendRedirect("ControladorProveedor");
        } else if (action.equals("actualizar")) {
            // Actualizar proveedor
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String ruc = request.getParameter("ruc");
            String email = request.getParameter("email");
            TblProveedorcl2 proveedor = proveedorImp.buscarPorId(id);
            proveedor.setNomproveecl2(nombre);
            proveedor.setRucproveecl2(ruc);
            proveedor.setEmailproveecl2(email);

            proveedorImp.actualizar(proveedor);
            response.sendRedirect("ControladorProveedor");
        }
    }
}