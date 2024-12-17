<%-- 
    Document   : apostesFiltrades
    Created on : 17 de des. 2024, 17:40:32
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
        <title>apostesFiltraes</title>
        <%String filtro = request.getParameter("Filtro");%>
    </head>
    <body>
        <h1>Apostes filtrades per <%=filtro%></h1>
        <%
            List<Aposta> listaFiltrada = (ArrayList<Aposta>) request.getAttribute("listaFiltrada");
            if (listaFiltrada != null) {
                for (Aposta aposta : listaFiltrada) {
                    out.println("<li><form action=\"controladorApostes\" method=\"post\">"
                            + aposta.getID() + " "
                            + aposta.getNombre() + " "
                            + aposta.getPartido() + " "
                            + aposta.getMonto() + "€ "
                            + aposta.getData() + " "
                            + "<input type=\"hidden\" name=\"ID\" value=\"" + aposta.getID() + "\">" + " "
                            + "<input type=\"submit\" name=\"submit\" value=\"Detalls\">" + " "
                            + "<input type=\"submit\" name=\"submit\" value=\"Borrar\">" + " "
                            + "<input type=\"submit\" name=\"submit\" value=\"Editar\"></form></li>");
                }
            }

        %>
        <button onclick="location.href='./listaApostas.jsp'">Tornar</button>
    </body>
</html>
