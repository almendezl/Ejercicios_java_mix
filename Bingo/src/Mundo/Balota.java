package Mundo;

/**
 *
 * @author Angie Mendez
 */
public class Balota {
   
    private final int BALOTA[] = new int[2];

    public Balota() {
        Balotera balotera = new Balotera();
        BALOTA[0] = balotera.generarBalota()[0];// aqui se gusra la letra
        BALOTA[1] = balotera.generarBalota()[1]; //aqui se guarda el numero de la balota
        //balotera.taparBalotera(BALOTA);
    }

    public int getLetra() {
        return BALOTA[0];
    }

    public int getNUMERO() {
        return BALOTA[1];
    }

    @Override
    public String toString() {
        String letra ="";
        switch(BALOTA[0]){
            case 0: letra = "B"; break;
            case 1: letra = "I"; break;
            case 2: letra = "N"; break;
            case 3: letra = "G"; break;
            case 4: letra = "O"; break;
        }
        return "Balota -->" + letra +" "+ BALOTA[1];
    }
}
