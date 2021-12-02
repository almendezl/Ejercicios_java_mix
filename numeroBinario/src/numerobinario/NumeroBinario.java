/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerobinario;

import javax.swing.JOptionPane;

/**
 *
 * @author Angie Mendez
 */
public class NumeroBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        int b;
        int i;
        b=0;
        i=0;
        n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero no negativo (base 10)"));    
        if(n<1023){
            do{
            b=(int)(n%2*Math.pow(10, i)+b);
            n=n/2;
            i++;    
            }while(n>0);
            JOptionPane.showMessageDialog(null, "El numero binario es: "+b);}
        else
            JOptionPane.showMessageDialog(null,"ERROR, numero no valido");
            System.exit(0);
    }
    
}
