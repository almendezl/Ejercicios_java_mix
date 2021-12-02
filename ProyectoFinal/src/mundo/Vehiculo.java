package mundo;

public class Vehiculo implements Comparable<Vehiculo> {
	private final String placa;
    private final String marca;
    private final String color;
    private final String modelo; 
    
    public Vehiculo(String pl, String ma, String co, String modelo) {
        this.placa = pl;
        this.marca = ma;
        this.color = co;
        this.modelo = modelo; 

    }
    

    @Override
    public int compareTo(Vehiculo that) {
    	 if(this.getPlaca().compareToIgnoreCase(that.getPlaca()) > 0){
             return 1;
         }
    	 if(this.getPlaca().compareToIgnoreCase(that.getPlaca()) < 0){
             return -1;
         }
         return 0;
    }

    @Override
    public String toString() {
        return "vehiculo{" + " Placa: " + getPlaca() + ", Marca: " + getMarca() + ", Color: " + getColor() + ", Modelo: " + getModelo() + '}';
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the amo
     */
    public String getModelo() {
        return modelo;
    }
 
}
