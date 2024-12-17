<%-- 
    Document   : listaApostas
    Created on : 15 de des. 2024, 14:58:19
    Author     : isard
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mvm.daw.ur.projecteapostes.model.Aposta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listaApostas</title>
        <%List<Aposta> listaApostes = (ArrayList<Aposta>) getServletContext().getAttribute("listaApostes");
            List<Aposta> listaFiltrada = (ArrayList<Aposta>) getServletContext().getAttribute("listaFiltrada");
            String filtro = request.getParameter("filtro");
        %>
    </head>
    <body>
        <h1>Llista d'apostes</h1>
        <ul>
            <%
                if (listaFiltrada != null){
                    listaApostes = listaFiltrada;
                    out.println("<h1>ayuda</h1>");
                    if (listaApostes.size() == 0) {
                        out.println("<p>No existeix ninguna aposta a nom de" + filtro + "</p>");
                    }
                }
                for (Aposta aposta : listaApostes) {
                    out.println("<li><form action=\"controladorApostes\" method=\"post\">"
                            + aposta.getID() + " "
                            + aposta.getNombre() + " "
                            + aposta.getPartido() + " "
                            + aposta.getMonto() + " "
                            + aposta.getData() + " "
                            + "<input type=\"hidden\" name=\"ID\" value=\"" + aposta.getID() + "\">" + " "
                            + "<input type=\"submit\" name=\"submit\" value=\"Detalls\">" + " "
                            + "<input type=\"submit\" name=\"submit\" value=\"Borrar\">" + " "
                            + "<input type=\"submit\" name=\"submit\" value=\"Editar\"></form></li>");
                }
            %>
        </ul>
        <form action="controladorApostes" method="post">Filtra apostes per nom sencer:<input type="text" name="Filtro"><button type="submit" name="submit" value="Filtra">Filtra</button></form>
        <button onclick="location.href = 'apuestas.jsp'">Tornar</button>
    </body>
</html>
