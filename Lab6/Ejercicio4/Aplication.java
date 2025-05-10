package Ejercicio4;

import java.util.Stack;

public class Aplication {
    public static boolean symbolBalancing(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Si es un corchete de apertura, lo ponemos en la pila
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Si es un corchete de cierre, verificamos que haya un par correcto
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] pruebas = {
            "()[]{}",        // ✅ Correcto
            "([{}])",        // ✅ Correcto
            "(]",            // ❌ Incorrecto
            "([)]",          // ❌ Incorrecto
            "{[()]}",        // ✅ Correcto
            "",              // ✅ Correcto (vacío)
            "[(])",          // ❌ Incorrecto
            "(((())))",      // ✅ Correcto
            "[({})]",        // ✅ Correcto
            "(()"            // ❌ Incorrecto
        };

        for (String prueba : pruebas) {
            System.out.println(prueba + " -> " + symbolBalancing(prueba));
        }
    }
}
