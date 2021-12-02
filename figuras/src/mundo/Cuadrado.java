package mundo;

public class Cuadrado extends Figura{

	public Cuadrado(double base, double altura) {
		super(base, altura);
	}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return super.getBase()*super.getAltura();
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 4*super.getAltura();
	}

	@Override
	public String toString() {
		return "Cuadrado ["+ super.toString()+"]";
	}

}
