package btree;

import java.util.ArrayList;

// Clase nodo del árbol B
public class BNode<E extends Comparable<E>> {

    protected ArrayList<E> keys;           // lista de claves
    protected ArrayList<BNode<E>> childs;  // lista de hijos
    protected int count;                   // cuántas claves tiene
    protected int idNode;                  // identificador del nodo
    private static int contadorNodos = 0;  // para contar nodos únicos

    public BNode(int n) {
        keys = new ArrayList<>(n);          // máximo n claves
        childs = new ArrayList<>(n + 1);    // máximo n+1 hijos
        count = 0;
        idNode = contadorNodos++;

        for (int i = 0; i < n; i++) {
            keys.add(null);         // claves vacías
            childs.add(null);       // hijos vacíos
        }
        childs.add(null);           // último hijo
    }

    // retorna true si el nodo está lleno
    public boolean nodeFull(int ordenMaxima) {
        return count == ordenMaxima;
    }

    // retorna true si el nodo está vacío
    public boolean nodeEmpty() {
        return count == 0;
    }

    // busca una clave en el nodo y devuelve la posición
    public boolean searchNode(E clave, int[] pos) {
        pos[0] = 0;
        while (pos[0] < count && clave.compareTo(keys.get(pos[0])) > 0) {
            pos[0]++;
        }
        return pos[0] < count && clave.compareTo(keys.get(pos[0])) == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nodo ").append(idNode).append(": ");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i)).append(" ");
        }
        return sb.toString();
    }
    public int getIdNode() {
    	return this.idNode;
    	}

    	public int getCount() {
    	return this.count;
    	}

    	public ArrayList<E> getKeys() {
    	return this.keys;
    	}

    	public ArrayList<BNode<E>> getChilds() {
    	return this.childs;
    	}
}