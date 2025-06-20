package Actividades;

public class Register {
    int key;
    String name;
    boolean isDeleted;

    public Register(int key, String name) {
        this.key = key;
        this.name = name;
        this.isDeleted = false;
    }

    @Override
    public String toString() {
        if (isDeleted) return "Null";
        return key + " - " + name;
    }
}
