<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="persona.Persona"%>
<%@page import="personaDAO.PersonaDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>Listar</title>
    </head>
    
    <body>
        <div class="container">
            <h1>Personas</h1>
            <a class="btn btn-success mb-3" href="Controlador?accion=add">Agregar Nuevo</a>
            <table class="table table-bordered">
                <thead>
                  <tr>
                    <td class="text-center">ID</td>
                    <td class="text-center">Nombre</td>
                    <td class="text-center">DNI</td>
                    <td class="text-center">Acciones</td>
                  </tr>
                </thead>
                <%
                    PersonaDAO dao = new PersonaDAO();
                    List<Persona> list = dao.listar();
                    Iterator<Persona> iter = list.iterator();
                    Persona per = null;

                    while (iter.hasNext()) {
                        per = iter.next();
                %>
                <tbody>
                  <tr>
                    <td class="text-center"><%=per.getID()%></td>
                    <td class="text-center"><%=per.getNombre()%></td>
                    <td class="text-center"><%=per.getDNI()%></td>
                    <td class="text-center">
                        <a class="btn btn-warning" href="Controlador?accion=editar&id=<%=per.getID()%>">Editar</a>
                        <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%=per.getID()%>">Eliminar</a>
                    </td>
                  </tr>
                </tbody>
                <%}%> 
            </table>
        </div>
    </body>
</html>
