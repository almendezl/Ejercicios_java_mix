package potencian;

import javax.swing.JOptionPane;
/* pagina 141 del libro*/
/**
 *
 * @author Angie Mendez
 */
public class PotenciaN {
    public static void main(String[] args) {
        int numero;
        int potencia=0;
        numero = Integer.parseInt(JOptionPane.showInputDialog(
                "Ingrese un numero entre 1 y 10"));
        if(numero<=10){
            for (int i=1;i<=numero;i++){
                potencia += Math.pow(i,i);
            }
            JOptionPane.showMessageDialog(null, potencia);
        }
    }
}
