/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

/**
 *
 * @author ShirleyCamargo
 */
public class Persona {
    private final String id;
    private String nombre;
    private final boolean genero; //true:hombre, falso:mujer
    private int edad;

    public Persona(String id, String nombre, String genero, int edad) {
        this.id = id;
        this.nombre = nombre;
        if(genero != null)
            this.genero = genero.equalsIgnoreCase("Hombre");
        else
            this.genero = true;
        this.edad = edad >=0?edad:0;
    }
    
    @Override
    public String toString() {
        return "Persona " + "id=  " + id + ", nombre=  " + nombre + ", genero=  " + (genero?"Hombre":"Mujer") + ", edad=  " + edad ;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero?"Hombre":"Mujer";
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad >=0?edad:0;
    }
    
    
}
