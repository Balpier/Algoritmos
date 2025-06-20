package Actividades;

public class TestHash {
    public static void main(String[] args) {
        HashC hashTable = new HashC(11);

        System.out.println("Insertando registros...");
        hashTable.insert(34, "Fernando");
        hashTable.insert(3, "Ana");
        hashTable.insert(7, "Luis");
        hashTable.insert(30, "Sofía");
        hashTable.insert(11, "Mario");
        hashTable.insert(8, "Lucía");
        hashTable.insert(7, "Repetido"); 
        hashTable.insert(23, "Pedro");
        hashTable.insert(41, "Carla");
        hashTable.insert(16, "Elena");
        hashTable.insert(34, "Fernando"); 

        hashTable.display();

        System.out.println("\nEliminando clave 30...");
        hashTable.delete(30);
        hashTable.display();

        System.out.println("\nBuscando clave 23...");
        Register r = hashTable.search(23);
        if (r != null) {
            System.out.println("Encontrado: " + r.name);
        } else {
            System.out.println("No se encontró la clave.");
        }
    }
}
