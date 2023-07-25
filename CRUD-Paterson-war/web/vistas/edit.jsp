<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="persona.Persona"%>
<%@page import="personaDAO.PersonaDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>Editar</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <% 
                    PersonaDAO dao = new PersonaDAO();
                    int id  = Integer.parseInt((String) request.getAttribute("idper"));
                    Persona p = (Persona) dao.list(id);
                %>
                <h1>Modificar Persona</h1>
                <form action="Controlador">
                    DNI:<br>
                    <input class="form-control" type="text" name="txtDNI" value="<%= p.getDNI() %>"><br> 
                    Nombres:<br>
                    <input class="form-control" type="text" name="txtNom" value="<%= p.getNombre() %>"><br>
                    
                    <input class="form-control" type="hidden" name="txtID" value="<%= p.getID() %>"><br>
                    <input class="btn btn-success" type="submit" name="accion" value="Actualizar">
                    <br>
                    <a class="btn btn-light mt-5" href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>
        </div>    
    </body>
</html>