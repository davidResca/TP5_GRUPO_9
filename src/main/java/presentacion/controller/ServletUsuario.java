package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Usuario;
import negocio.UsuarioNeg;
import negocioImpl.UsuarioNegImpl;




@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioNeg usuNeg = new UsuarioNegImpl();
       
   
    public ServletUsuario() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnIngresar")!=null) {
			
			Usuario usu = new Usuario();
			
			String Usuario = request.getParameter("txtUsuario");
			String Contraseña = request.getParameter("txtContrasena");
			
			try {

			    usu = usuNeg.obtenerUno(Usuario, Contraseña);

			} catch (Exception e) {

			    e.printStackTrace();
			}
			
			
			if(usu!=null) {
				
				
				HttpSession session = request.getSession();

			    session.setAttribute("usuarioLogueado", usu);

			    response.sendRedirect("Admin.jsp");
				
				
			}else {
				
				
				request.setAttribute("mensajeError", "Usuario o contraseña incorrectos");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);

				
			}
			
		}
	}

}
