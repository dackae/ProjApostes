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
        <p>Nombre y apellido: <input type="text"></p>
        <p>Elige el partido: <select name="partido" id="partido">
            <%
                List<String> partidos = (List<String>) request.getAttribute("partidos");
                for (String partido : partidos) {
                    out.println("<option value=\"" + partido + "\">" + partido + "</option>");
                }
            %>
            </select>
        </p>
        <p>Indica el monto: <input type="number"></p>
        <p>Indica el resultado. Equipo 1:<!-- %out.println(partidos.get())--><input type="number" name="equipo2"> Equipo 2:<<input type="number" name="equipo1"></p>
    </body>
</html>
