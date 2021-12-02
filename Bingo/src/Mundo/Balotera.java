
package Mundo;

/**
 *
 * @author Angie Mendez
 */
public class Balotera {
  //crea la balotera y el arreglo de las jugadas
    private int [][] balotera = new int[51][5];
    private final String [] balotasJugadas = new String[255];
    int jugadas;
    
    public Balotera() {
        //inicializa los arreglos 
        for(int i=0; i<balotera.length; i++)
            for(int j=0; j<balotera[i].length; j++)
                //lo llena por filas 
                balotera[i][j]=i;
        for(int i=0; i<balotasJugadas.length; i++)
            balotasJugadas[i]="no";
    }
    
    public int[][] getBalotera() {
        return balotera;
    }

    public int getJugadas() {
		return jugadas;
	}
    public int[] generarBalota(){
        //genera la balota en un arreglo y lo retorna
        int balota [] = new int [2];
        do{
            balota[0] = (int)(Math.random()*5); //aqui se guarda la letra
            balota[1] = (int)(Math.random()*51); // aqui se guarda el numero de la balota
            
        }while(balotera[balota[1]][balota[0]] == -1); //revisa que la balota aun no se haya sacado
        jugadas ++;
        
        return balota;        
    }
    public void taparBalotera(Balota balot){
        
        //recibe un objeto de tipo balota, segun la letra y el numero, la marca en la balotera para que no vuelva a jugar
        balotera[balot.getNUMERO()][balot.getLetra()]=-1;
     
        
    }
   
   @Override
    public String toString() {
        String salida="B A L O T E R A\n";
        for(int i=0; i<balotera.length; i++){
            for(int j=0; j<balotera[i].length; j++)
                salida+=balotera[i][j] + "\t";
            salida+="\n";
        }
        return salida;
    }
    }