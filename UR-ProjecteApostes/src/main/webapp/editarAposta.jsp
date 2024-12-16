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
        <% List<String> partidos = (List<String>) request.getAttribute("listaPartidos");
           List<Aposta> listaApostes = (List<Aposta>) request.getAttribute("listaApostes");
           int ID;
           Aposta apostaAEditar = null;
           for (Aposta aposta : listaApostes){
              ID = aposta.getID();
              if (ID == Integer.parseInt(request.getParameter("identificador"))){
                apostaAEditar = aposta;
            }
            }
           String nombre = apostaAEditar.getNombre();
           String partidoDefault = apostaAEditar.getPartido();
           int monto = apostaAEditar.getMonto();
           String fecha = apostaAEditar.getData();
           String resultado = apostaAEditar.getResultado();            
        %>
    </head>
    <body>
        <h1>Crea tu apuesta</h1>
        <form action="controladorAposta" method="post">
            <input type="hidden" name="ID" value="<%=Integer.parseInt(request.getParameter("identificador"))%>">
            Nombre y apellido: <input type="text" name="nombre" required placeholder="<%=nombre%>"></br>
            Elige el partido: <select name="partido" id="partido" placeholder="<%=partidoDefault%>">
                <%
                    for (String partido : partidos) {
                        out.println("<option value=\"" + partido + "\">" + partido + "</option>");
                    }
                %>
            </select></br>
            Indica el monto: <input type="number" name="monto" required placeholder="<%=monto%>">€</br>
            Indica la fecha: <input type="date" name="fecha" required placeholder="<%=fecha%>"></br>
            Indica el resultado: <input type="string" name="resultado" required placeholder=""<%=resultado%>><!-- %out.println(partidos.get())<input type="number" name="equipo2"> Equipo 2:<<input type="number" name="equipo1"> -->
            <input type="submit" name="submit" value="confirmar">
        </form>
</body>
</html>
