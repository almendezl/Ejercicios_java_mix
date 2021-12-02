package mundo;

public class Triangulo extends Figura{

	public Triangulo(double base, double altura) {
		super(base, altura);
	}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return super.getBase()*super.getAltura();
	}

	@Override
	public double perimetro() {
		return super.getAltura()+
				Math.sqrt(Math.pow(super.getBase(), 2)-Math.pow(super.getAltura(), 2))
		+ super.getBase();
	}
	@Override
	public String toString() {
		return "Triangulo ["+ super.toString()+"]";
	}
}
