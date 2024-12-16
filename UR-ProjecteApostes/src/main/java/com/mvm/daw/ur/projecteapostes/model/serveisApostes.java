/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mvm.daw.ur.projecteapostes.model;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class serveisApostes{
    
    public serveisApostes(){
    }
    
    public void afegirAposta(int contadorIDs, List<Aposta> listaApostes, HttpServletRequest request){
        int ID = contadorIDs;
        String nombre = request.getParameter("nombre");
        String partido = request.getParameter("partido");
        int monto = Integer.parseInt(request.getParameter("monto"));
        String fecha = request.getParameter("fecha");
        String resultado = request.getParameter("resultado");
        Aposta apuesta = new Aposta(ID, nombre, partido, monto, fecha, resultado);
        listaApostes.add(apuesta);
    }
    
    public void borrarAposta(int contadorIDs, List<Aposta> listaApostes, HttpServletRequest request){
        int ID = contadorIDs;
        for (Aposta apuesta : listaApostes){
            int identificador = apuesta.getID();
            if (identificador == ID){
                listaApostes.remove(apuesta);
            }
        }
    }
    
    public void editarAposta(List<Aposta> listaApostes, HttpServletRequest request){
        int ID = Integer.parseInt(request.getParameter("ID"))-1;
        Aposta apostaEditar = listaApostes.get(ID);
        // no se si debo llamar a un jsp ahora
        // supongo que haria algo en plan enviar apostaEditar al jsp, quizas ponerlo como context
        getServletContext().setAttribute("apostaEditar", apostaEditar);
        // pero se que luego hago esto:
        String nombre = request.getParameter("nombre");
        String partido = request.getParameter("partido");
        int monto = Integer.parseInt(request.getParameter("monto"));
        String fecha = request.getParameter("fecha");
        String resultado = request.getParameter("resultado");
        Aposta apuesta = new Aposta(ID, nombre, partido, monto, fecha, resultado);
        listaApostes.set(ID, apuesta);
    }
}
