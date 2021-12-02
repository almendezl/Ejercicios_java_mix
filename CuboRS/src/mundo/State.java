package mundo;

public class State {

	private String padre;
	private String movimiento;
	private Rubik cuboRubik;

	public State(String padre, String movimiento, Rubik cubRubik) {
		this.padre = padre;
		this.movimiento = movimiento;
		this.cuboRubik = cubRubik;
	}

	public String getPadre() {
		return padre;
	}

	public String getmovimiento() {
		return movimiento;
	}

	public Rubik getCubo() {
		return cuboRubik;
	}

	@Override
	public String toString() {
		return "Nodo [padre=" + padre + ", movimiento=" + movimiento + ",  key de cuboRubik=" + cuboRubik.getKey() + "]";
	}
	
}
