/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.arraylist;
/**
 *
 * @author Melody
 */


import java.util.ArrayList;

public class ControladorPersona {
    
    public static ArrayList<Persona> listadePersonas 
            = new ArrayList<Persona>();
    
    public ArrayList<Persona> mostrarPersonas(){
        return listadePersonas;
    }
    
    public void registrarPersona(Persona p){
        listadePersonas.add(p);
    }
    
    public Persona buscarPersona(int id){
        Persona encontrada = new Persona();
        for(Persona p : listadePersonas){
            if(id == p.getId()){
                encontrada = p;
            }
        }
        return encontrada;
    }
    
    public void actualizarPersona(Persona personaActualizada){
        Persona personaActualizar 
                = buscarPersona(personaActualizada.getId());
        listadePersonas.remove(personaActualizar);
        listadePersonas.add(personaActualizada);
    }
    
    public void eliminarPersona(Persona personaEliminar){
        listadePersonas.remove(personaEliminar);
    }
}
