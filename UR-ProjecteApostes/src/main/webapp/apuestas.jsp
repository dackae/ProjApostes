<%-- 
    Document   : apuestas
    Created on : 27 de nov. 2024, 20:14:21
    Author     : isard
--%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creación de apuestas</title>
    </head>
    <body>
        <h1>Crea tu apuesta</h1>
        <form action="controladorAposta" method="post">
            Nombre y apellido: <input type="text" name="nombre" required></br>
            Elige el partido: <select name="partido" id="partido">
                <%
                    List<String> partidos = (List<String>) request.getAttribute("listaPartidos");
                    for (String partido : partidos) {
                        out.println("<option value=\"" + partido + "\">" + partido + "</option>");
                    }
                %>
            </select></br>
            Indica el monto: <input type="number" name="monto" required>€</br>
            Indica la fecha: <input type="date" name="fecha" required>€</br>
            Indica el resultado: <input type="string" name="resultado" required><!-- %out.println(partidos.get())<input type="number" name="equipo2"> Equipo 2:<<input type="number" name="equipo1"> -->
            <input type="submit" name="submit" value="afegir">
        </form>
</body>
</html>
