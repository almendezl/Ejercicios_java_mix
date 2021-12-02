package mundo;

public class Nodo {

	private final String padre;
	private final int valor;
	
	public Nodo(String padre, int valor) {
		this.padre = padre;
		this.valor = valor;
	}

	public String getKey() {
		return padre;
	}

	public int getpNode() {
		return valor;
	}

	@Override
	public String toString() {
		return " [Padre = " + padre + ", Valor = " + valor + "]";
	}
}
