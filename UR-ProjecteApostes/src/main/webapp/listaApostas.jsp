<%-- 
    Document   : listaApostas
    Created on : 15 de des. 2024, 14:58:19
    Author     : isard
--%>

<%@page import="com.mvm.daw.ur.projecteapostes.model.Aposta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listaApostas</title>
        <%List<Aposta> listaApostes = (List<Aposta>) request.getAttribute("listaApostes");
          for (Aposta aposta : listaApostes){
          %>
    </head>
    <body>
        <h1>Llista d'apostes</h1>
        <ul>
            <%
            out.println("<li><form action=\"controladorAposta\" method=\"post\">" +
                    aposta.getID() +
                    aposta.getNombre() +
                    aposta.getPartido() +
                    aposta.getResultado() +
                    aposta.getMonto() +
                    aposta.getData() +
                    "<input type=\"hidden\" name=\"ID\" value=\"" + aposta.getID() + "\">" +
                    "<input type=\"button\" name=\"submit\" value=\"Detalls\"" + 
                    "<input type=\"button\" name=\"submit\" value=\"Borrar\"" + 
                    "<input type=\"button\" name=\"submit\">" +
                    "</form></li>");
            }
            %>
        </ul>
        <button onclick="href=apuestas.jsp">
    </body>
</html>
