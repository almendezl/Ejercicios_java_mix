/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import Persona.Persona;

/**
 *
 * @author ShirleyCamargo
 */
public class Lista {
    private Persona lista [];
    private int contador;

    public Lista(int tamanio) {
        lista = new Persona[tamanio];
        contador = 0;
    }
    
    public boolean insertar(Persona p){
        if (contador < lista.length){
            lista[contador ++] = p ;
            return true;
        }
        else return false;
    }
     
    
    
    public int buscar (Persona p){
        int pos = 0;
        if(!listaVacia()){
            do{
            	if (lista[pos] != null) {
            		if (lista[pos].getId().equalsIgnoreCase(p.getId())) 
                        return pos;
                        pos ++;	
            	}else {
					return -1;
				}
                
            }while(pos < lista.length);
        }
        return -1;
     }
    
    public boolean actualizar(Persona p, int pos){
        if (pos >=0 && pos <lista.length){
            if(lista[pos]!= null){
                lista[pos] =p;
           return true;
                }
            }
        return false; //posicion no existe
    }
    
    public boolean actualizar (Persona p){
        if(!listaVacia()){
            int pos = buscar(p);
            if(pos != -1){
                lista[pos].setNombre(p.getNombre());
                lista[pos].setEdad(p.getEdad());
                return true;
                }
            }
        return false;
    }
    
    public boolean eliminar(Persona p){
        if(!listaVacia()){
            int pos = buscar(p);
            if (pos!= -1){
                lista[pos] =null;
                contador --;
                moverIzq(pos);
                return true;
            }else {
            	return false;
            }
        }
        return false;
    }
    
    public boolean eliminar (int pos){
        if (!listaVacia()){
            if(pos >=0 && pos < lista.length){
                if (lista[pos] != null) {
                	contador --;
                    moverIzq(pos);
                    return true;
                }else {
                	return true;
                }
                    
            }else {
            	return false;
            }
            
          
        }
       return false;
    }
    
    public void moverIzq(int pos){
    	 // mover los datos
        for (int i = pos; i < lista.length-1; i++) {
        	if (lista[i+1] != null) {
        		Persona aux = lista[i+1];
				lista[i] = aux;	
				lista[i+1] = null;
        	}else {
        		
        		break;
        	}
		}
    }
    
    public int tamanioLista(){
        return contador;
    }
    
    public boolean listaVacia(){
        return contador ==0;
    }
    
    public String mostrar(){
        String salida ="Tamanio actual: " + contador + "\n";
        for (Persona p : lista)
            salida += p + "\n";
        return salida;
    }
}
