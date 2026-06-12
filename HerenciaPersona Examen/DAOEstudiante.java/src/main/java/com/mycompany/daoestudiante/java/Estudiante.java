/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daoestudiante.java;

/**
 *
 * @author demon
 */
public class Estudiante extends Persona {
        
    private int numBoleta;
 
    
    public Estudiante(int numboleta, String nom, int edad, char gen){
         super(nom, edad, gen);
    this.numBoleta = numboleta;

        
    }

    public Estudiante(int numBoleta, String chillon, String nombre, int edad, char genero) {
        super(nombre, edad, genero);
        this.numBoleta = numBoleta;
        
    }

    public int getNumBoleta() {
        return numBoleta;
    }

    public void setNumBoleta(int numBoleta) {
        this.numBoleta = numBoleta;
    }

   
    
    
    
    
    
}
