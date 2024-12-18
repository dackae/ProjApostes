<%-- 
    Document   : listaApostasPartido
    Created on : 18 de des. 2024, 20:18:38
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
        <title>listaApostasPartido</title>
        <%
        String filtro = request.getParameter("partidoFiltro");
        String fecha = request.getParameter("fechaFiltro");
        %>
    </head>
    <body>
        <h1>Apostes filtrades per <%=filtro%> y <%=fecha%></h1>
        <ul>
            <%
                List<Aposta> listaApostasPartido = (ArrayList<Aposta>) request.getAttribute("listaApostasPartido");
                if (listaApostasPartido.size() == 0) {
                    out.println("<p>No existeix ninguna aposta a nom de <strong>" + filtro + "</strong> y en la fecha <strong>" + fecha + "</strong>.</p>");
                }
                if (listaApostasPartido != null) {
                    for (Aposta aposta : listaApostasPartido) {
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
                }

            %>
        </ul>
        <button onclick="location.href = './listaApostas.jsp'">Tornar</button>
    </body>
</html>
