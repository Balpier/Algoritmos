package Ejercicios;

public interface Operable<N extends Number> {
    N suma(N operando1, N operando2);
    N resta(N operando1, N operando2);
    N producto(N operando1, N operando2);
    N division(N operando1, N operando2);
}