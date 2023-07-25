package controlador;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persona.Persona;
import personaDAO.PersonaDAO;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    int id;
    
    Persona p = new Persona(); 
    PersonaDAO dao = new PersonaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String dni = request.getParameter("txtDNI");
            String nombre = request.getParameter("txtNom");
            p.setDni(Integer.parseInt(dni));
            p.setNombre(nombre);
            dao.add(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("actualizar")){
            id = Integer.parseInt(request.getParameter("txtID"));
            String dni = request.getParameter("txtDNI");
            String nombre = request.getParameter("txtNom");
            
            p.setID(id);
            p.setDni(Integer.parseInt(dni));
            p.setNombre(nombre);
            dao.edit(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            p.setID(id);
            dao.eliminar(id);
            acceso = listar;
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        processRequest(request, response);
    }
    
    
}
