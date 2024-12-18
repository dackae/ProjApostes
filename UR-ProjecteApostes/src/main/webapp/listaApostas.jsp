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
        %>
    </head>
    <body>
        <h1>Llista d'apostes</h1>
        <ul>
            <%
                for (Aposta aposta : listaApostes) {
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
        <form action="controladorApostes" method="post">
            Filtra apostes per nom sencer:<input type="text" name="Filtro"><button type="submit" name="submit" value="Filtra" required>Filtra</button></br>
        </form>
        <form action="controladorApostes" method="post">
            Filtra apostes per nom sencer y per un rang d'aposta (no inclosos):<input type="text" name="filtroUsuarioCompuesto" required> Num1:<input type="number" name="filtroMontoMax" min="1" required> Num2:<input type="number" name="filtroMontoMin" min="1" required> <button type="submit" name="submit" value="filtraMontoUsuario">Filtra</button></br>
        </form>
        <form action="controladorApostes" method="post">
            Lista las apuestas ganadoras <button type="submit" name="submit" value="ListarGanadores">Listar Ganadores</button>
        </form>
        <button onclick="location.href = 'apuestas.jsp'">Tornar</button>
    </body>
</html>
