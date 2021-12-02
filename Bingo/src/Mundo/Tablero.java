
package Mundo;


public class Tablero {
    private int tablero[][];
    private int tapado;

    public Tablero(String figura) {
        //constructor-> crea el tablero de 5x5, recibe la figura escogida por el usuario y lo llena segun corresponda
        this.tablero = new int [5][5];
        switch (figura){
            case "F":case "f": tableroF(); break;
            case "O":case "o": tableroO(); break;
            case "N":case "n": tableroN(); break;
            case "Z":case "z": tableroZ(); break;
        }
    }
public int[][] getTablero() {
        return tablero;
    }


    public int getTapado() {
        return tapado;
    }
    public void setTapadas(int tapado) {
        this.tapado = tapado;
    }
    
    private void tableroF(){
        //llena el tablero full
       boolean repetir;
        for(int i=0; i<tablero.length; i++)
            for(int j=0; j<tablero[i].length; j++)
                do{
                    repetir=false;
                    tablero[i][j]=(int)(Math.random()*51);
                    for(int k=0; k<i; k++)
                        //revisa las repetidas por columnas
                        if(tablero[k][j]==tablero[i][j])
                            repetir = true;
                }while(repetir);
        tapado = 0;
    }

    private void tableroO(){
        //llenar de forma o
        boolean repetir;
        for(int i=0; i<tablero.length; i++)
            for(int j=0; j<tablero[i].length; j++)
                //llena solo los bordes
                if(i==0 || i==tablero.length-1 || j==0 || j==tablero[i].length-1)
                    do{
                        repetir=false;
                        tablero[i][j]=(int)(Math.random()*51);
                        for(int k=0; k<i; k++)
                            if(tablero[k][j]==tablero[i][j])
                                repetir = true;
                    }while(repetir);
                else
                    tablero[i][j]=-1;
        tapado = 9;
    }
    
    private void tableroN(){
        boolean repetir;
        for(int i=0; i<tablero.length; i++){
           for(int j=0; j<tablero[i].length; j++){
               //llena los dos bordes verticales y la diagonal principal
               if(j==0 && i<=4 || j==4 && i<=4 || i==j)
                   do{
                        repetir=false;
                        tablero[i][j]=(int)(Math.random()*51);
                        for(int k=0; k<i; k++)
                            if(tablero[k][j]==tablero[i][j])
                                repetir = true;
                    }while(repetir);
                else
                    tablero[i][j]=-1;
           }
        }  
        tapado = 12;
    }
    
    private void tableroZ(){
        boolean repetir;
        for(int i=0; i<tablero.length; i++){
           for(int j=0; j<tablero[i].length; j++){
               //llena los dos bordes horizontales y la diagonal secundaria
               if(i==0 && j<=4 || i==4 && j<=4 || (i+j)==4)
                   do{
                        repetir=false;
                        tablero[i][j]=(int)(Math.random()*51);
                        for(int k=0; k<i; k++)
                            if(tablero[k][j]==tablero[i][j])
                                repetir = true;
                    }while(repetir);
                else
                    tablero[i][j]=-1;
        tapado = 12;
    }
        }
    }

    @Override
    public String toString() {
        String salida="B \tI \tN \tG \tO \n \n";
        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero[i].length; j++)
                salida += tablero[i][j] + "\t";   
            salida += "\n";
        }
        salida+="\nTapadas = " + tapado;
        return salida;
    }

    

public boolean buscarBalota(Balota balota){
        for(int fila = 0; fila<tablero.length; fila++)
            if(tablero[fila][balota.getLetra()] == balota.getNUMERO()){
                tablero[fila][balota.getLetra()] = -1;
                tapado++;
                
            }
                return tapado == 25;
    }   
    
}
