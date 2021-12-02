/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosas;

/**
 *
 * @author Nicole D Torres
 */
public class Persona {

    private String nombre;
    private int edad;
    private final String id; //es string ya que no se hace operaciones y no cabe en un int
    private final boolean genero; //verdadero = hombre, falso = mujer. Se almacena cmo un booleano pero se muestra como cadena de caracteres

    //Constructor 
    public Persona(String nombre, int edad, String id, String genero) {
        this.nombre = nombre;
        this.edad = edad >= 0 ? edad : 0;
        this.id = id;
        if (genero != null) {
            this.genero = genero.equalsIgnoreCase("Hombre"); //no es necesario colocar los condicionales ya que o toma especifico 
        }else 
            this.genero = true; // si es null por defecto me coloca hombre
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
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad >= 0 ? edad : 0; //Si es negativa la edad deje cero 
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    /*public void setId(String id) {
        this.id = id;
    }*/
    /**
     * @return the genero
     */
    public String getGenero() {
        return genero ? "Hombre" : "Mujer";
    }

    //hereda de la clase objet
    @Override
    public String toString() {
        return "Persona " + "nombre = " + nombre + ", edad = " + edad + ", id = " + id + ", genero = " + (genero ? "Hombre" : "Mujer");
    }

}

