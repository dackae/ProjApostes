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
    
    public void borrarAposta(List<Aposta> listaApostes, HttpServletRequest request){
        int ID = Integer.parseInt(request.getParameter("ID"));
        for (Aposta apuesta : listaApostes){
            int identificador = apuesta.getID();
            if (identificador == ID){
                listaApostes.remove(apuesta);
                break;
            }
        }
    }
    
    public void editarAposta(List<Aposta> listaApostes, HttpServletRequest request){
        int ID = Integer.parseInt(request.getParameter("ID"));
        String nombre = request.getParameter("nombre");
        String partido = request.getParameter("partido");
        int monto = Integer.parseInt(request.getParameter("monto"));
        String fecha = request.getParameter("fecha");
        String resultado = request.getParameter("resultado");        
        for (Aposta aposta : listaApostes){
            int identificador = aposta.getID();
            if (identificador == ID){
                aposta.setNombre(nombre);
                aposta.setPartido(partido);
                aposta.setMonto(monto);
                aposta.setData(fecha);
                aposta.setResultado(resultado);
            }
        }
    }
    
    public List<Aposta> filtrarAposta(List<Aposta> listaApostes, HttpServletRequest request){
        String filtro = request.getParameter("Filtro");
        List<Aposta> listaFiltrada = new ArrayList<>();
        for (Aposta apuesta : listaApostes){
            if ((apuesta.getNombre()).equals(filtro)){
                listaFiltrada.add(apuesta);
            }
        }
        return listaFiltrada;
    }
}
