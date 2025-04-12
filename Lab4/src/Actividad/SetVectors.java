package Actividad;

import java.util.ArrayList;

public class SetVectors {
    ArrayList<Limits> list = new ArrayList<>();

    public void insertar(Limits l) {
        list.add(l);
    }

    public Limits mayor() {
        return list.get(0); 
    }

    public boolean esVacio() {
        return list.isEmpty();
    }

    public void eliminar(Limits l) {
        list.remove(l);
    }

    public int size() {
        return list.size();
    }
}