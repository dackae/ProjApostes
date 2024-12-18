<%-- 
    Document   : listaMontoUsuario
    Created on : 18 de des. 2024, 19:24:11
    Author     : isard
--%>

<%@page import="com.mvm.daw.ur.projecteapostes.model.Aposta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String filtro = request.getParameter("filtroUsuarioCompuesto");%>
    </head>
    <body>
        <h1>Apostes filtrades per <%=filtro%></h1>
        <ul>
            <%
                List<Aposta> listaMontoUsuario = (ArrayList<Aposta>) request.getAttribute("listaMontoUsuario");
                if (listaMontoUsuario.size() == 0) {
                    out.println("<p>No existeix ninguna aposta a nom de <strong>" + filtro + "</strong> y en un rango de <strong>" + "</strong> a <strong>" + "</strong>.</p>");
                }
                if (listaMontoUsuario != null) {
                    for (Aposta aposta : listaMontoUsuario) {
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
