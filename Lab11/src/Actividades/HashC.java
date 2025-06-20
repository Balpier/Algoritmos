package Actividades;

public class HashC {
    private Register[] table;
    private int size;

    public HashC(int size) {
        this.size = size;
        this.table = new Register[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public boolean insert(int key, String name) {
        int index = hash(key);
        int originalIndex = index;

        do {
            if (table[index] == null || table[index].isDeleted) {
                table[index] = new Register(key, name);
                return true;
            } else if (table[index].key == key && !table[index].isDeleted) {
                System.out.println("Clave duplicada: " + key);
                return false;
            }

            index = (index + 1) % size;
        } while (index != originalIndex);

        System.out.println("Tabla llena, no se pudo insertar");
        return false;
    }

    public Register search(int key) {
        int index = hash(key);
        int originalIndex = index;

        do {
            Register reg = table[index];
            if (reg == null) return null;
            if (!reg.isDeleted && reg.key == key) return reg;

            index = (index + 1) % size;
        } while (index != originalIndex);

        return null;
    }

    public boolean delete(int key) {
        int index = hash(key);
        int originalIndex = index;

        do {
            Register reg = table[index];
            if (reg == null) return false;
            if (!reg.isDeleted && reg.key == key) {
                reg.isDeleted = true;
                return true;
            }

            index = (index + 1) % size;
        } while (index != originalIndex);

        return false;
    }

    public void display() {
        System.out.println("Estado actual de la tabla:");
        for (int i = 0; i < size; i++) {
            System.out.printf("[%d]: %s\n", i, (table[i] == null ? "Vacio" : table[i].toString()));
        }
    }
}
