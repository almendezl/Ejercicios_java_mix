package metodosestadisticos2;
public class MetodosEstadisticos2 {
    /*
    Este metodo devolvera datos de tipo entero, el nombre del metodo es generar y consta de dos datos de entrada de
    caracter entero cuyos nombres son 'min' y 'max' respectivamente. Dentro del arreglo directamente retorna a partir
    de la libreria Math.random un conjunto de numeros aleatorios decimales a partir de las variables 'min' y 'max';
    se compone por el escalamiento (max-min+1) el cual establece el tamaño del rango y el corrimeinto es el que se suma (+min) 
    que es el valor mas pequeño del rango para luego retornarlos por medio de (int) es el casting utilizado para obtener
    valores de caracter entero sin importar la perdida de informacion. Fin del metodo. 
    */
    public static int generar(int min, int max){
        return (int)(Math.random()*(max-min+1)+min);
    }
    /*
    Este es un metodo el cual no va a retornar ninguna informacion, su nombre es llenar y tomara como valor de entrada un
    arreglo de caracter entero llamado 'a'. El metodo contiene un ciclo 'for' con las condiciones: 'i' inicializado en 0,
    'i' menor al tamaño del arreglo 'a', e 'i' incrementando de uno en uno. Dentro del ciclo se invoca al metodo generar asignando 
    el valor 1 a la variable 'min' y 10 a la variable 'max' para luego asiganrlos en la posicion 'i' del arreglo 'a'. Fin del ciclo
    y fin del metodo.
    */
    public static void llenar(int a[]){
        for(int i=0; i<a.length; i++)
            a[i] = generar(1,10);
    }
    /*
    Este metodo devolvera un dato de tipo String (cadena de caracteres), el nombre del arreglo es imprimir y tiene un solo dato de 
    entrada que es un arreglo de tipo entero, dentro del metodo inicializa la variable local 'salida' de tipo String en "" (vacio),
    luego se compone de un ciclo 'for' con las condiciones: 'i' inicializado en 0, 'i' menor al tamaño del arreglo 'a', e 'i' incrementando 
    de uno en uno. Dentro del ciclo toma la variable 'salida' concatenando su dato actual y el dato del arreglo 'a' segun su posicion junto con \t 
    (que proporciona unos espacios para tabular).
    Luego se aplica un condicional en donde segun su posicion mas uno cuyo modulo 20 sea 0 se le concatene a la variable 'salida', en su valor actual un \n (el cual da un salto de linea),
    es decir cada 20 datos se realizará un salto en linea, para una mejor visualizacion de los mismos,
    Fin del ciclo, retorna la variable salida y da fin al metodo.
    */
    public static String imprimir(int a[]){
        String salida = "";
        for(int i=0; i<a.length; i++){
            salida += a[i] + "\t";
            if((i+1)%20 == 0)
                salida += "\n";
        }
        return salida;
    }
    /*
    EsEste metodo devolvera un dato de tipo Double (decimal), el nombre del metodo es media y consta de un dato de entrada de
    cacaracter entero el cual es un arreglo llamado 'a' respectivamente. Dentro del metodo se inicializa la variable suma de tipo Double
    (decimal) en 0, y luego se compone de un ciclo 'for' con las condiciones: 'i' inicializado en 0, 'i' menor al tamaño del arreglo 'a', e
    'i' incrementando de uno en uno. Dentro del ciclo la variable suma se le concatena su valor actual y el valor del arreglo 'a' partiendo de la posicion
    'i'. Fin del ciclo, y luego el metodo retorna la variable 'suma' dividido en la longitud del arreglo 'a'. Fin del metodo.
    Es decir este metodo realiza un proedio de todos los datos contenidos en el arreglo 'a' y lo retorna.
    */
    public static double media(int a[]){
        double suma=0;
        for(int i=0; i<a.length; i++)
            suma += a[i];
        return suma/a.length;
    }
    /*
    Este metodo devolvera un dato de tipo entero, el nombre del metodo es moda y consta de un datos de entrada de
    caracter entero el cual es un arreglo llamado 'a' respectivamente. Dentro del metodo se invoca el metodo 'frecuencias' partiendo
    del arreglo 'a' y se almacenará en el arreglo 'aux' de caracter entero. Luego el metodo retorna la invocacion  del metodo 'max'  partiendo del
    arreglo 'aux' y sumandolo a 1 debido a que este le proporciona el dato que se repite mas veces en el arreglo. Fin del ciclo
    */
    public static int moda(int a[]){
        int aux[] = frecuencias(a);
        return max(aux)+1;
    }
    /*
    Este metodo devolvera un arreglo de tipo entero, el nombre del metodo es frecuencias y consta de un dato de entrada de
    caracter entero el cual es un arreglo llamado 'a' respectivamente. Dentro del metodo se crea el areglo de tipo entero
    llamado 'aux' cuyo tamaño es de 10 y su contenido es de caracter entero. Luego se compone de un ciclo 'for' con las
    condiciones: 'i' inicializado en 0, 'i' menor al tamaño del arreglo 'aux', incrementando de uno en uno. Este ciclo recorrera 
    al arreglo 'aux' en la posicion 'i', e inicializara en 0. Fin del ciclo 'for', luego se inicia otro ciclo for' con las
    condiciones: 'i' inicializado en 0, 'i' menor al tamaño del arreglo 'a', e 'i' incrementando de uno en uno. Dentro del ciclo 
    el arreglo 'aux' en la poscion (a[i]-1) el arreglo 'a' en la poscion 'i' -1 se declara la poscion del arreglo 'aux' la cual se
    incrementara de uno en uno. Fin del ciclo, el metodo retorna el arreglo aux. Fin del metodo.
    Este metodo almacenará la frecuencia en que se repite un dato del arreglo 'a' en el arreglo 'aux'.
    */
    public static int[] frecuencias(int a[]){
        int aux[] = new int [10];
        for(int i=0; i<aux.length; i++)
            aux[i]=0;
        for(int i=0; i<a.length; i++)
            aux[a[i]-1]++;
        return aux;
    }
    /*
    Este es un metodo el cual no va a retornar ninguna informacion, su nombre es histograma y tomara como
    valor de entrada un arreglo de caracter entero llamado 'a'. Dentro del metodo se invoca el metodo 
    'frecuencias' partiendo del arreglo 'a' y se almacenara en el arreglo 'aux' de caracter entero.Luego
    se compone de un ciclo 'for' con las condiciones: 'i' inicializado en 0, 'i' menor al tamaño del arreglo 
    'aux', incrementando de uno en uno. Dentro del ciclo se imprimira la variable 'i' mas uno que representa el dato 
    contenido en el arreglo junto con ":\t" que efectua un doble punto y una tabulacion concatenada a el arreglo 'aux'
    de posicion 'i' el cual nos da el dato de dicha posicion junto con "->\t" un flecha y una tabulacion. Luego cita a un 
    ciclo anidado que se compone de un ciclo 'for' con las condiciones: 'j' inicializado en 0, 'j' menor al arreglo 'aux'
    en la posicion 'i', incrementando de uno en uno. EL cual imprime un asterisco que representa el dato del arreglo 'aux'.
    Fin del segundo ciclo, luwgo imprime un salto de linea. Fin del primer ciclo, fin del metodo.
    Este metodo permite realizar de manera grafica la visualizacion de los datos obtenidos en el arreglo 'aux' que representa
    la frecuencia con la que se repiten datos en el arreglo 'a'.
    */
    public static void histograma(int a[]){
        int aux[] = frecuencias(a);
        for(int i=0; i<aux.length; i++){
                System.out.print((i+1) + ":\t" + aux[i] + "->\t" );
            for(int j=0; j<aux[i]; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    /*
    Este metodo devolvera un dato de tipo Double (decimal), el nombre del metodo es mediana y consta de un dato de entrada de
    caracter entero el cual es un arreglo llamado 'a' respectivamente. Dentro del metodo se encuentra un condicional el cual 
    evalua si el arreglo es par o impar, a partir del modulo 2 del tamaño del arreglo, siendo diferente de 0. Es decir si es impar
    el metodo retornara el arreglo 'a' en la posicion de la longitud del arreglo dividido en 2. Sino retornara el arreglo 'a' en 
    en la posicion de la longitud del arreglo dividido en 2 mas en la posicion de la longitud del arreglo dividido en 2 menos uno y todo
    dividido en 2. Es decir, si es par tomara el valor de las dos posiciones intermedias y las promediara. Fin del condicional y fin del 
    metodo.
    Este metodo retorna el valor de la posicion intermedia de un arreglo.
    */
    public static double mediana(int a[]){
        if(a.length % 2 != 0)
            return a[a.length/2];
        else
            return (a[a.length/2] + a[a.length/2-1])/2;
    }
    /*
     Este metodo devolvera un dato de tipo entero, el nombre del metodo es max y consta de un dato de entrada de
    caracter entero el cual es un arreglo llamado 'a' respectivamente. Dentro del metodo inicializa la variable 
    'mayor' de caracter entero en 0. Luego citara un ciclo 'for' con las condiciones: 'i' inicializado en 0, 'i'
    menor al tamaño del arreglo 'a', y incrementando de uno en uno. Dentro del ciclo se evaluara la condicion del
    arreglo 'a' en posicion 'i' mayor al arreglo 'a' en la posicion del valor de la variable 'mayor', si cumple la
    condicion la variable 'mayor' tomara el tomara el valor de 'i'. Fin del condicional, retorna 'menor' y fin del metodo.
    Es decir, con el ciclo y el condicional se recorre el arreglo 'a' para determinar el mayor de los datos contenidos.
    */
    public static int max(int a[]){
        int mayor = 0;
        for(int i=0; i<a.length; i++)
            if(a[i]>a[mayor])
                mayor = i;
        return mayor;
    }
    /*
    Este metodo devolvera un dato de tipo entero, el nombre del metodo es min y consta de un dato de entrada de
    caracter entero el cual es un arreglo llamado 'a' respectivamente. Dentro del metodo inicializa la variable 'menor'
    de caracter entero en 0. Luego citara un ciclo 'for' con las condiciones: 'i' inicializado en 0, 'i' menor al tamaño
    del arreglo 'a', y incrementando de uno en uno. Dentro del ciclo se evaluara la condicion del arreglo 'a' en posicion
    'i' menor al arreglo 'a' en la posicion del valor de la variable 'menor', si cumple la condicion la variable 'menor' 
    tomara el valor de 'i'. Fin del condicional, retorna 'menor' y fin del metodo. Es decir, con el ciclo y el condicional
    se recorre el arreglo 'a' para determinar el menor de los datos contenidos.
    */
    public static int min(int a[]){
        int menor = 0;
        for(int i=0; i<a.length; i++)
            if(a[i]<a[menor])
                menor = i;
        return menor;
    }
    /*
    En el metodo principal (el primero que se ejecuta) se crea un arreglo llamadao 'datos' de caracter entero el cual contiene 
    400 datos de tipo entero. Luego se invoca el metodo 'llenar' con el dato de entrada del arreglo 'datos'. 
    A continuacion se imprime el retorno del metodo 'imprimir' con dato de entrada el arreglo 'datos'.
    A continuacion se imprime  "La media de los datos es: " junto con el retorno del metodo 'media' con dato de entrada el arreglo 'datos',
    A continuacion se imprime  "La moda de los datos es: " junto con el retorno del metodo 'moda' con dato de entrada el arreglo 'datos', 
    A continuacion se imprime  "La mediana de los datos es: " junto con el retorno del metodo 'mediana' con dato de entrada el arreglo 'datos', 
    A continuacion se imprime  "El máximo de los datos es:" junto con el el arreglo 'datos' con posicion dada por el retorno del metodo 'max' con dato de entrada del arreglo 'datos', 
    A continuacion se imprime "El minimo de los datos es:" junto con el el arreglo 'datos' con posicion dada por el retorno del metodo 'min' con dato de entrada del arreglo 'datos',
    A continuacion se imprime  "El histograma de los datos es: " junto con el retorno del metodo 'histograma' con dato de entrada el arreglo 'datos'
    Fin del programa.
    */
    
    public static void main(String[] args) {
        int datos[] = new int [400];
        
        llenar(datos);
        System.out.println(imprimir(datos));
        System.out.println("La media de los datos es: " + media(datos));
        System.out.println("La moda de los datos es: " + moda(datos));
        System.out.println("La mediana de los datos es: " + mediana(datos));
        System.out.println("El máximo de los datos es: " + datos[max(datos)]);
        System.out.println("El mínimo de los datos es: " + datos[min(datos)]);
        System.out.println("El histograma de los datos es: ");
        histograma(datos);
    }
    
}
