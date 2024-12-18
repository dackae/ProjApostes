/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mvm.daw.ur.projecteapostes.model;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class serveisApostes {

    public serveisApostes() {
    }

    public void afegirAposta(int contadorIDs, List<Aposta> listaApostes, HttpServletRequest request) {
        int ID = contadorIDs;
        String nombre = request.getParameter("nombre");
        String partido = request.getParameter("partido");
        int monto = Integer.parseInt(request.getParameter("monto"));
        String fecha = request.getParameter("fecha");
        String resultado = request.getParameter("resultado");
        String competicion = request.getParameter("competicion");
        Aposta apuesta = new Aposta(ID, nombre, partido, monto, fecha, resultado, competicion);
        listaApostes.add(apuesta);
    }

    public void borrarAposta(List<Aposta> listaApostes, HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("ID"));
        for (Aposta apuesta : listaApostes) {
            int identificador = apuesta.getID();
            if (identificador == ID) {
                listaApostes.remove(apuesta);
                break;
            }
        }
    }

    public void editarAposta(List<Aposta> listaApostes, HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("ID"));
        String nombre = request.getParameter("nombre");
        String partido = request.getParameter("partido");
        int monto = Integer.parseInt(request.getParameter("monto"));
        String fecha = request.getParameter("fecha");
        String resultado = request.getParameter("resultado");
        String competicion = request.getParameter("competicion");
        for (Aposta aposta : listaApostes) {
            int identificador = aposta.getID();
            if (identificador == ID) {
                aposta.setNombre(nombre);
                aposta.setPartido(partido);
                aposta.setMonto(monto);
                aposta.setData(fecha);
                aposta.setResultado(resultado);
                aposta.setCompeticion(competicion);
            }
        }
    }

    public List<Aposta> filtrarAposta(List<Aposta> listaApostes, HttpServletRequest request) {
        String filtro = request.getParameter("Filtro");
        filtro = filtro.toLowerCase();
        List<Aposta> listaFiltrada = new ArrayList<>();
        for (Aposta apuesta : listaApostes) {
            String nombre = apuesta.getNombre();
            nombre = nombre.toLowerCase();
            if (nombre.equals(filtro)) {
                listaFiltrada.add(apuesta);
            }
        }
        return listaFiltrada;
    }

    public List<Aposta> filtraMontoUsuario(List<Aposta> listaApostes, HttpServletRequest request) {
        String filtro = request.getParameter("filtroUsuarioCompuesto");
        int montoMax = Integer.parseInt(request.getParameter("filtroMontoMax"));
        int montoMin = Integer.parseInt(request.getParameter("filtroMontoMin"));
        int aux;
        if (montoMax < montoMin) {
            aux = montoMax;
            montoMax = montoMin;
            montoMin = aux;
        }
        filtro = filtro.toLowerCase();
        List<Aposta> listaFiltrada = new ArrayList<>();
        for (Aposta apuesta : listaApostes) {
            String nombre = apuesta.getNombre();
            int monto = apuesta.getMonto();
            nombre = nombre.toLowerCase();
            if (nombre.equals(filtro) && (montoMax > monto) && (monto > montoMin)) {
                listaFiltrada.add(apuesta);
            }
        }
        return listaFiltrada;
    }

    public void verificarGanadores(List<Aposta> listaApostes, Map<String, String> resultadosPartidos) {
        for (Aposta apuesta : listaApostes) {
            String resultado = apuesta.getPartido();
            String partido = apuesta.getPartido();
            if (resultado.equals(resultadosPartidos.get(partido))) {
                apuesta.setGanador(Boolean.TRUE);
            } else {
                apuesta.setGanador(Boolean.FALSE);
            }
        }
    }

    public List<Aposta> listaGanadores(List<Aposta> listaApostes) {
        List<Aposta> listaGanadores = new ArrayList<>();
        for (Aposta apuesta : listaApostes) {
            Boolean ganador = apuesta.getGanador();
            if (ganador.equals(Boolean.TRUE)) {
                listaGanadores.add(apuesta);
            }
        }
        return listaGanadores;
    }

    public List<Aposta> listaApostesPartido(List<Aposta> listaApostes, HttpServletRequest request) {
        List<Aposta> listaApostesPartido = new ArrayList<>();
        for (Aposta apuesta : listaApostes){
            String partido = apuesta.getPartido();
            String fecha = apuesta.getData();
            if (partido.equals(request.getParameter("partidoFiltro")) && fecha.equals(request.getParameter("fechaFiltro"))){
                listaApostesPartido.add(apuesta);
            }
        }
        return listaApostesPartido;
    }
}
