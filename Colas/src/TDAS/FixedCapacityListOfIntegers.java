package TDAS;

public class FixedCapacityListOfIntegers {

	private Integer[] lista; //tipo de dato primitivo para no dejar con errores 
    private int contador;

    //contador 
    public FixedCapacityListOfIntegers(int tamanio) {
        lista = new Integer[tamanio];
        contador = 0;  //cuenta el numero de elementos guardado en el arreglo 
    }

    //revisar que los datos no sean iguales 
   /* public boolean igualdades(Integer p) {
        if (p.getId().equals(p)) { //si la id de la persona es igual a la otra retorne verdadero de lo contrario false 
            return true;
        }
        return false;
    }*/

    //insertar, void no retorna  ningun valor 
    public boolean insertar(Integer p) {
        if (contador < lista.length) { //si es menor que el tamaño del arreglo inserta, de lo contrario no 
            if (buscar(p) == -1) {
                lista[contador++] = p; //en la posicion contador ++ que arranca en la posicion cero incrementa, la paso la persona p que me indica  
                return true;
            }
        }
        return false; //no hay espacio para insertar 

    }

    //antes de insertar debo revisar que el metodo no exista 
    //Buscar 
    public int buscar(Integer p) {
        int pos = 0;
        if (!listaVacia()) {
            do {
               if (lista[pos] != null) 
                    if (lista[pos]==(p)) //compara el objeto de la posicion pos, de esa persona se pide la id, si esa identificacion es igual al de la persona que pasa por parametro si la encuentra retorna la posicion si no la encuentra incrementa 
                    {
                        return pos;
                    }
                

                pos++; //si no se encontro se incrementa la posicion para seguir buscando 
            } while (pos < contador);//mientras sea menor que el contador, ya uqe apenas encuentre un null se muere, solo lo hace para las posiciones donde hay datos insertados  
        }
        return -1; //el -1 significa que no se encontro    

    }
    //actualizar, con dos parametros actualio posicion 

    public boolean actualizar(Integer p, int pos) {
        //sobreescribe una posicion 
        if (pos >= 0 && pos < lista.length) {
            if (lista[pos] != null) { //si la posicion no es valida hay que insertar
                lista[pos] = p;
                return true;
            }
        }
        return false; //si la posicion no existe 

    }

    // actualizar una persona 
    public boolean actualizar(Integer p) {
        if (!listaVacia()) {
            int pos = buscar(p);
            if (pos != -1) {
                lista[pos] = p ; 
                return true;
            }
        }
        return false; //no encontro o no existe la ersona 

    }

    //Eliminar si pasa parametro escrITURA 
    public boolean eliminar(Integer p) {
        if (!listaVacia()) {
            int pos = buscar(p);
            if (pos != -1) { //diferente a -1 por que se encontro 
                lista[pos] = null;
                moverIzq(pos);
                contador--;
                return true;
            }
        }
        return false;

    }

    //Eliminar un campo completo o posicion, si paso parametro entero 
    public boolean eliminar(int pos) { //Sigue siendo int por que es una posicion 
        if (!listaVacia()) {
            if (pos >= 0 && pos < lista.length) { //si la posicion existe 
                lista[pos] = null;
                moverIzq(pos);
                contador--; //si puede eliminar resta la posicion 
                return true;
            }
        }
        return false;//si no la encuentra 

    }

    //se deben invocar en los metodos de eliminacion 
    public void moverIzq(int pos) {
        while (pos < contador - 1) {
            lista[pos] = lista[pos + 1];
            lista[pos + 1] = null;
        }
    }

    //cuantos elementos hay, el tamanio de la lista es diferente al arreglo, es solo los elementos que hay 
    public int tamanioLista() {
        return contador;
    }

    //Determina si la lista esta vacia 
    public boolean listaVacia() {
        return contador == 0;
    }//no es necesario colocar true o false ya que es redundante 

    public String mostrar() {
        String salida = "Tamanio actual  " + contador + "\n";
        for (Integer p : lista) {
            salida += p + "\n";
        }
        return salida;
    }
}
