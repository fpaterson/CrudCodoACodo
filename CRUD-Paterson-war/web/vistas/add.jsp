<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>Agregar</title>
    </head>
    <body>
        <div class="container">
            <h1>Agregar Persona</h1>
            <form action="Controlador">
                DNI:<br>
                <input class="form-control" type="text" name="txtDNI"><br> 
                Nombres:<br>
                <input class="form-control" type="text" name="txtNom"><br>
                <input class="btn btn-success" type="submit" name="accion" value="Agregar">
                <br>
                <a class="btn btn-light mt-5" href="Controlador?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>
