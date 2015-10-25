<%-- 
    Document   : index
    Created on : Oct 3, 2015, 9:28:46 PM
    Author     : jorge
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Probando...</title>
    </head>
    <body>
        <h1>Listar</h1>

        <form  action="app/personas/listar">
            <input type="submit" value="Listar Personas">
        </form>




        <h1>Buscar</h1>

        <form  action="app/personas/buscar">
            <input type="text" name="nom">
            <input type="submit" value="Buscar...">
        </form>


        <h1>Actualizar</h1>

        <form  action="app/personas/actualizar"  >
            <input type="text" name="nom">
            <input type="text" name="ape">
            <input type="submit" value="Actualizar">
        </form>



        <h1>Insertar</h1>

        <form  method="post" action="app/revistas/articulo/agregar"  >
         
            <input type="text" name="resumen">
            <input type="text" name="nombre_resumen">
            <input type="text" name="estado">
            <input type="text" name="id_revista">
    
            <input type="submit" value="Insertar">
        </form>


        <h1>Eliminar</h1>

        <form  action="app/personas/eliminar"  >
            <input type="text" name="nom">
            <input type="submit" value="Eliminado...">
        </form>



    </body>
</html>
