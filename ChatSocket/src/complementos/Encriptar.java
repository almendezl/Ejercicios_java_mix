package complementos;

public class Encriptar {
	public static String encriptaMensaje(String mensaje) {
		String encriptar = "";

		for (int i = 0; i < mensaje.length(); i++) {
			char val = mensaje.toLowerCase().charAt(i);
			switch (val) {
			case 120: // x
				encriptar += "0";
				break;
			case 121: // y = 1
				encriptar += "1";
				break;
			case 122: // z
				encriptar += "2";
				break;
			case 55: // 7
				encriptar += "-";
				break;
			case 56: // 8
				encriptar += "a";
				break;
			case 57: // 9
				encriptar += "b";
				break;
			case 45: // -
				encriptar += "c";
				break;
			case 32: // el espacio
				encriptar += " ";
				break;
			case 46: // el punto
				encriptar += ".";
				break;
			default:
				encriptar += Character.toString((char) (val + 3));
				break;
			}

			/**
			 * casos especiales x y z 7 8 9 -
			 * 
			 */

		}
		return encriptar;

	}

	public static String desencriptaMensaje(String mensaje) {
		String desencriptar = "";

		for (int i = 0; i < mensaje.length(); i++) {
			char val = mensaje.toLowerCase().charAt(i);
			switch (val) {
			case 48: // 0
				desencriptar += "x";
				break;
			case 49: // 1
				desencriptar += "y";
				break;
			case 50: // 2
				desencriptar += "z";
				break;
			case 45: // -
				desencriptar += "7";
				break;
			case 97: // a
				desencriptar += "8";
				break;
			case 98: // b
				desencriptar += "9";
				break;
			case 99: // c
				desencriptar += "-";
				break;
			case 32: // el espacio
				desencriptar += " ";
				break;
			case 46: // el punto
				desencriptar += ".";
				break;
			default:
				desencriptar += Character.toString((char) (val - 3));
				break;
			}

			/**
			 * casos especiales 0 1 2 - a b c
			 * 
			 */

		}
		return desencriptar;

	}
}
