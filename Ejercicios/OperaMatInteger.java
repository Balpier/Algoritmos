package Ejercicios;

public class OperaMatInteger <T extends Integer> {
	public Integer sumar(T a, T b) {
		return a + b;
	}
	public Integer restar( T a, T b) {
		return a - b; 
	}
	public Integer multiplicar( T a, T b) {
		return a * b;
	}
	public Integer dividir(T a, T b) {

		if (b == 0) {
			System.out.println("ERROR: No permite división por cero");
			return null;
		}
		return a / b;
	}
	public Integer potencia(T a ) {
		return a *a;
	}
	public Double raizCuadrada(T a) {
		return Math.sqrt(a);
	}
	public Double raizCubica(T a) {
		return Math.cbrt(a);
	}
	
}