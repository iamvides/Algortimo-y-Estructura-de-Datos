package hash;

// Clase que representa un registro con clave y nombre
public class Register {

    private int key;         // clave usada para el hash
    private String name;     // nombre asociado

    public Register(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + name + ")";
    }
}