<%-- 
    Document   : detallarAposta
    Created on : 16 de des. 2024, 12:25:34
    Author     : isard
--%>

<%@page import="com.mvm.daw.ur.projecteapostes.model.Aposta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>detallarAposta</title>
        <%  List<String> partidos = (List<String>) request.getAttribute("listaPartidos");
            List<Aposta> listaApostes = (List<Aposta>) request.getAttribute("listaApostes");
            int ID;
            Aposta apostaAMostrar = null;
            for (Aposta aposta : listaApostes){
                ID = aposta.getID();
                if (ID == Integer.parseInt(request.getParameter("identificador"))){
                    apostaAMostrar = aposta;
                }
            }
            ID = apostaAMostrar.getID();
            String nombre = apostaAMostrar.getNombre();
            String partido = apostaAMostrar.getPartido();
            int monto = apostaAMostrar.getMonto();
            String fecha = apostaAMostrar.getData();
            String resultado = apostaAMostrar.getResultado();
        %>
    </head>
    <body>
        <h1>Apuesta (<%=ID%>)</h1>
        <ul>
            <li><strong>Nombre y apellidos:</strong><%=nombre%></li>
            <li><strong>Partido:</strong><%=partido%></li>
            <li><strong>Monto:</strong><%=monto%>€</li>
            <li><strong>Fecha:</strong><%=fecha%></li>
            <li><strong>Resultado:</strong><%=resultado%></li>
        </ul>
        <button onclick="location.href='./listaApostas.jsp'">Volver</button>
    </body>
</html>
