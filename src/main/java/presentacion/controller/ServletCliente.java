package presentacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import entidad.Cliente;
import negocio.ClienteNeg;
import negocioImpl.ClienteNegImpl;
import javax.servlet.RequestDispatcher;


@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteNeg clienteNeg = new ClienteNegImpl();
		
		try {
			List<Cliente> clientes = clienteNeg.obtenerTodos();
			request.setAttribute("clientes", clientes);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ListadoClientes.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnGuardar") != null) {
			Cliente cliente = new Cliente();
			cliente.setDni(request.getParameter("txtDni"));
			cliente.setCuil(request.getParameter("txtCuil"));
			cliente.setNombre(request.getParameter("txtNombre"));
			cliente.setApellido(request.getParameter("txtApellido"));
			cliente.setSexo(request.getParameter("txtSexo"));
			cliente.setFechaNacimiento(request.getParameter("txtFechaNacimiento"));
			cliente.setDireccion(request.getParameter("txtDireccion"));
			cliente.setNacionalidad(request.getParameter("txtNacionalidad"));
			cliente.setLocalidad(request.getParameter("txtLocalidad"));
			cliente.setProvincia(request.getParameter("txtProvincia"));
			cliente.setCorreoElectronico(request.getParameter("txtCorreoElectronico"));
			cliente.setTelefono(request.getParameter("txtTelefono"));
			
			ClienteNeg clienteNeg = new ClienteNegImpl();
			
			try {
				clienteNeg.insertar(cliente);
				response.sendRedirect("ServletCliente");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
