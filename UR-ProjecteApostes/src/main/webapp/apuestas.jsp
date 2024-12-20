<%-- 
    Document   : apuestas
    Created on : 27 de nov. 2024, 20:14:21
    Author     : isard
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creación de apuestas</title>
        <%
        List<String> listaPartidos = new ArrayList<>();
        listaPartidos.add("Barcelona - Madrid (J2)");
        listaPartidos.add("Barcelona - Madrid (J1)");
        listaPartidos.add("Osasuna - Villareal");
        listaPartidos.add("A. Bilbao - A. Madrid");
        listaPartidos.add("Las Palmas - Rayo Vallecano");
        listaPartidos.add("Real Sociedad - Girona");
        getServletContext().setAttribute("listaPartidos", listaPartidos);
        List<String> listaCompeticiones = new ArrayList<>();
        listaCompeticiones.add("LaLiga");
        listaCompeticiones.add("Premier League");
        listaCompeticiones.add("Bundesliga");
        listaCompeticiones.add("Serie A");
        listaCompeticiones.add("League 1");
        getServletContext().setAttribute("listaCompeticiones", listaCompeticiones);
        %>
    </head>
    <body>
        <h1>Crea tu apuesta</h1>
        <form action="controladorApostes" method="post">
            Nombre y apellido: <input type="text" name="nombre" required></br>
            Elige el partido: <select name="partido" id="partido">
                <%
                    List<String> partidos = (List<String>) getServletContext().getAttribute("listaPartidos");
                    for (String partido : partidos) {
                        out.println("<option value=\"" + partido + "\">" + partido + "</option>");
                    }
                %>
            </select></br>
            Indica el monto: <input type="number" name="monto" min="1" required>€</br>
            Indica la fecha: <input type="date" name="fecha" required></br>
            Indica el resultado: <input type="string" name="resultado" required></br><!-- %out.println(partidos.get())<input type="number" name="equipo2"> Equipo 2:<<input type="number" name="equipo1"> -->
            Indica la competicion: <select name="competicion" required>
                <%
                    List<String> competiciones = (List<String>) getServletContext().getAttribute("listaCompeticiones");
                    for (String competicion : competiciones) {
                        out.println("<option value=\"" + competicion + "\">" + competicion + "</option>");
                    }
                %>
            </select></br>
            <input type="submit" name="submit" value="afegir">
        </form>
</body>
</html>
