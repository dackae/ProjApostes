<%-- 
    Document   : listaGanadores
    Created on : 18 de des. 2024, 19:14:19
    Author     : isard
--%>

<%@page import="com.mvm.daw.ur.projecteapostes.model.Aposta"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listaGanadores</title>
    </head>
    <body>
        <h1>Llista de guanyadors</h1>
        <ul>
            <%
                List<Aposta> listaGanadores = (ArrayList<Aposta>) request.getAttribute("listaGanadores");
                if (listaGanadores.size() == 0) {
                    out.println("<p>No existeix ninguna aposta guanyadora.</p>");
                }

                for (Aposta aposta : listaGanadores) {
                    out.println("<li><form action=\"controladorApostes\" method=\"post\">"
                            + aposta.getID() + " "
                            + aposta.getNombre() + " "
                            + aposta.getPartido() + " "
                            + aposta.getMonto() + "€ "
                            + aposta.getData() + " "
                            + aposta.getCompeticion() + " "
                            + "<input type=\"hidden\" name=\"ID\" value=\"" + aposta.getID() + "\">" + " "
                            + "<input type=\"submit\" name=\"submit\" value=\"Detalls\">" + " "
                            + "<input type=\"submit\" name=\"submit\" value=\"Borrar\">" + " "
                            + "<input type=\"submit\" name=\"submit\" value=\"Editar\"></form></li>");
                }
            %>
        </ul>
        <button onclick="location.href = 'apuestas.jsp'">Tornar</button>
    </body>
</html>
