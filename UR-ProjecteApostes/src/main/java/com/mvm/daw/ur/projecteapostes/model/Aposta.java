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
    String nombre;
    String partido;
    String monto;
    LocalDate data;
    int resultado1;
    int resultado2;

    
    
    public Aposta(String nombre, String partido, String monto, LocalDate data, int resultado1, int resultado2) {
        this.nombre = nombre;
        this.partido = partido;
        this.monto = monto;
        this.data = data;
        this.resultado1 = resultado1;
        this.resultado2 = resultado2;
    }
}
