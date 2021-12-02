package mundo;

public class BusquedaLineal {

	public static void main(String[] args) {
		
		String arr[] = {"A", "B", "C", "D", "E"};
		String datoString = "D";
		int posicion = busquedaLineal(arr, datoString);
		int posicionBLR = busquedaLRecur(arr, datoString, 0);
		
		
		System.out.println("---BUSQUEDA LINEAL---");
		System.out.println(posicion ==-1?"El dato no se encuentra":"El dato se encuentra en la posicion "+posicion);
		
		
		System.out.println("---BUSQUEDA LINEAL RECURSIVA---");
		System.out.println(posicionBLR ==-1?"El dato no se encuentra":"El dato se encuentra en la posicion "+posicion);

	}
	public static int busquedaLineal(Comparable arr[], Comparable dato){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(dato) == 0){
                return i;
            }
        }
        return -1;
    }
      public static int busquedaLRecur(Comparable arr[], Comparable dato, int pos){
        if(pos <arr.length){
            if(arr[pos].compareTo( dato) == 0)
                return pos;
            else
                return busquedaLRecur(arr, dato, pos+1);
        }
        return -1;
    }

}
