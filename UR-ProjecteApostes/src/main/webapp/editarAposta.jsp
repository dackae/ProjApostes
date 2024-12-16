<%-- 
    Document   : editarAposta
    Created on : 14 de des. 2024, 19:48:26
    Author     : isard
--%>

<%@page import="com.mvm.daw.ur.projecteapostes.model.Aposta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>editarAposta</title>
        <% List<String> partidos = (List<String>) getServletContext().getAttribute("listaPartidos");
           List<Aposta> listaApostes = (List<Aposta>) getServletContext().getAttribute("listaApostes");
           int ID;
           Aposta apostaAEditar = null;
           for (Aposta aposta : listaApostes){
              ID = aposta.getID();
              if (ID == Integer.parseInt(request.getParameter("ID"))){
                apostaAEditar = aposta;
            }
            }
           ID = apostaAEditar.getID();
           String nombre = apostaAEditar.getNombre();
           String partidoDefault = apostaAEditar.getPartido();
           int monto = apostaAEditar.getMonto();
           String fecha = apostaAEditar.getData();
           String resultado = apostaAEditar.getResultado();  

        %>
    </head>
    <body>
        <h1>Crea tu apuesta</h1>
        <form action="controladorApostes" method="post">
            <input type="hidden" name="ID" value="<%=ID%>">
            Nombre y apellido: <input type="text" name="nombre" required value="<%=nombre%>"></br>
            Elige el partido: <select name="partido" id="partido" value="<%=partidoDefault%>">
                <%
                    for (String partido : partidos) {
                        out.println("<option value=\"" + partido + "\">" + partido + "</option>");
                    }
                %>
            </select></br>
            Indica el monto: <input type="number" name="monto" min="1" required value="<%=monto%>">€</br>
            Indica la fecha: <input type="date" name="fecha" required value="<%=fecha%>"></br>
            Indica el resultado: <input type="string" name="resultado" required value="<%=resultado%>">
            <input type="submit" name="submit" value="confirmar"> <button onclick="location.href='./listaApostas.jsp'">Tornar</button><!-- No se si quitar el location o no-->
        </form>
</body>
</html>
