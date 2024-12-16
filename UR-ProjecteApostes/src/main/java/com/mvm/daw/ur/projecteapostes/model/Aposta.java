/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mvm.daw.ur.projecteapostes.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isard
 */
public class Aposta {
    int ID;
    String nombre;
    String partido;
    int monto;
    String data;
    String resultado;

    public Aposta(int ID, String nombre, String partido, int monto, String data, String resultado) {
        this.ID = ID;
        this.nombre = nombre;
        this.partido = partido;
        this.monto = monto;
        this.data = data;
        this.resultado = resultado;
    }

    public int getID() {
        return ID;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public String getPartido() {
        return this.partido;
    }

    public int getMonto() {
        return this.monto;
    }

    public String getData() {
        return this.data;
    }

    public String getResultado() {
        return this.resultado;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}