package mundo;

public abstract class Figura {

	private double base;
	private double altura;
	
	public Figura(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	public abstract double area();
	public abstract double perimetro();
	
	public void setBase(double base) {
		this.base = base;
	}
	public double getBase() {
		return base;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getAltura() {
		return altura;
	}

	@Override
	public String toString() {
		return "Figura [base=" + base + ", altura=" + altura + "]";
	}
	
}
