package mundo;
/**
*
* @author shirleycamargo
*/

public class Vehiculo implements Comparable<Vehiculo>
{
   private String placa;
   private String marca;
   private String color;
   private String modelo;
   
   public Vehiculo (String pla, String marca, String color, String modelo){
       this.placa = pla;
       this.marca = marca;
       this.color = color;
       this.modelo = modelo;
       
   }
   
   public String placa (){
       return getPlaca();
   }


   @Override
public String toString() {
	return "Vehiculo [placa=" + placa + ", marca=" + marca + ", color=" + color + ", modelo=" + modelo + "]";
}

public String getPlaca() {
       return placa;
   }

   public void setPlaca(String placa) {
       this.placa = placa;
   }

   public String getMarca() {
       return marca;
   }

   public void setMarca(String marca) {
       this.marca = marca;
   }

   public String getColor() {
       return color;
   }

   public void setColor(String color) {
       this.color = color;
   }

   public String getModelo() {
       return modelo;
   }

   public void setModelo(String modelo) {
       this.modelo = modelo;
   }

@Override
public int compareTo(Vehiculo that) {
	 if(this.getPlaca().compareToIgnoreCase(that.getPlaca()) > 0){
         return +1;
     }
	 if(this.getPlaca().compareToIgnoreCase(that.getPlaca()) < 0){
         return -1;
     }
     return 0;
}
   
   
   
}
