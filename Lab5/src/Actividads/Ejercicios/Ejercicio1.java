package Ejercicios;

import java.util.List;

public class Ejercicio1 {
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        return lista.contains(valor);
    }

    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Luis", "Carlos, Maria");
        System.out.println(buscarElemento(nombres, "Luis")); 
        System.out.println(buscarElemento(nombres, "Fernando")); 
    }
}
