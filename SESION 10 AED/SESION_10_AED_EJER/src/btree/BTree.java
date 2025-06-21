package btree;

import java.util.*;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up; 	
    private BNode<E> nDes;
    private boolean underflow;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;

        mediana = push(this.root, cl);

        if (up) {
            pnew = new BNode<E>(this.orden);
            pnew.count = 1;
            pnew.getKeys().set(0, mediana);
            pnew.getChilds().set(0, this.root);
            pnew.getChilds().set(1, nDes);
            this.root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        int pos[] = new int[1];
        E mediana;

        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean fl;
            fl = current.searchNode(cl, pos);

            if (fl) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }

            mediana = push(current.getChilds().get(pos[0]), cl);

            if (up) {
                if (current.nodeFull(this.orden - 1)) {
                    mediana = dividedNode(current, mediana, pos[0]);
                } else {
                    up = false;
                    putNode(current, mediana, nDes, pos[0]);
                }
            }

            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        int i;
        for (i = current.getCount() - 1; i >= k; i--) {
            current.getKeys().set(i + 1, current.getKeys().get(i));
            current.getChilds().set(i + 2, current.getChilds().get(i + 1));
        }
        current.getKeys().set(k, cl);
        current.getChilds().set(k + 1, rd);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int i, posMdna;
        posMdna = (k <= this.orden / 2) ? this.orden / 2 : this.orden / 2 + 1;

        nDes = new BNode<E>(this.orden);

        for (i = posMdna; i < this.orden - 1; i++) {
            nDes.getKeys().set(i - posMdna, current.getKeys().get(i));
            nDes.getChilds().set(i - posMdna + 1, current.getChilds().get(i + 1));
        }

        nDes.count = (this.orden - 1) - posMdna;
        current.count = posMdna;

        if (k <= this.orden / 2)
            putNode(current, cl, rd, k);
        else
            putNode(nDes, cl, rd, k - posMdna);

        E median = current.getKeys().get(current.count - 1);
        nDes.getChilds().set(0, current.getChilds().get(current.count));
        current.count--;

        return median;
    }

    public void mostrarRaiz() {
        if (root != null) {
            System.out.println("Raíz: " + root);
        } else {
            System.out.println("El árbol está vacío.");
        }
    }

    public BNode<E> getRaiz() {
        return root;
    }

    @Override
    public String toString() {
        String s = "";
        if (isEmpty())
            s += "BTree is empty...";
        else
            s = writeTree(this.root);
        return s;
    }

    private String writeTree(BNode<E> current) {
        StringBuilder sb = new StringBuilder();
        if (current != null) {
            sb.append("[ ");
            for (int i = 0; i < current.count; i++) {
                sb.append(current.getKeys().get(i)).append(" ");
            }
            sb.append("]\n");
            for (int i = 0; i <= current.count; i++) {
                sb.append(writeTree(current.getChilds().get(i)));
            }
        }
        return sb.toString();
    }
    
    // EJERCICIO 1: BUSCAR una clave del árbol B
    public boolean search(E cl) {
        return searchRec(this.root, cl);
    }

    private boolean searchRec(BNode<E> nodo, E cl) {
        if (nodo == null) return false;

        int[] pos = new int[1];
        boolean encontrado = nodo.searchNode(cl, pos);

        if (encontrado) {
            System.out.println(cl + " se encuentra en el nodo " + nodo.getIdNode() + " en la posición " + pos[0]);
            return true;
        } else {
            return searchRec(nodo.getChilds().get(pos[0]), cl);
        }
    }
    
    
 // Muestra los nodos del árbol como una tabla bien formateada
    public void printTable() {
        String formatoCabecera = "| %-8s | %-30s | %-10s | %-20s |%n";
        String linea = "+----------+--------------------------------+------------+----------------------+";

        System.out.println(linea);
        System.out.format(formatoCabecera, "id_nodo", "claves nodo", "id_padre", "id_hijos");
        System.out.println(linea);
        recorrerTablaFormateado(root, null, formatoCabecera, linea);
        System.out.println(linea);
    }

    private void recorrerTablaFormateado(BNode<E> actual, BNode<E> padre, String formato, String linea) {
        if (actual == null) return;

        // Construir claves del nodo
        StringBuilder claves = new StringBuilder();
        for (int i = 0; i < actual.count; i++) {
            claves.append(actual.keys.get(i));
            if (i < actual.count - 1) claves.append(" , ");
        }

        // Obtener ID del padre
        String idPadre = (padre == null) ? "----" : String.valueOf(padre.idNode);

        // Construir lista de hijos
        StringBuilder hijos = new StringBuilder();
        for (int i = 0; i <= actual.count; i++) {
            if (actual.childs.get(i) != null) {
                hijos.append(actual.childs.get(i).idNode);
                if (i < actual.count && actual.childs.get(i + 1) != null) hijos.append(" , ");
            }
        }
        if (hijos.length() == 0) hijos.append("----");

        // Imprimir fila formateada
        System.out.format(formato, actual.idNode, claves.toString(), idPadre, hijos.toString());

        // Llamada recursiva a los hijos
        for (int i = 0; i <= actual.count; i++) {
            recorrerTablaFormateado(actual.childs.get(i), actual, formato, linea);
        }
    }


    
    // BUSCAR NOMBRE
    public String buscarNombre(int codigo) {
        return buscarNombreRecursivo(root, codigo);
    }

    private String buscarNombreRecursivo(BNode<E> nodo, int codigo) {
        if (nodo == null) return "No encontrado";

        for (int i = 0; i < nodo.count; i++) {
            E elemento = nodo.keys.get(i);
            if (elemento instanceof modelo.RegistroEstudiante re) {
                if (re.getCodigo() == codigo) {
                    return re.getNombre();
                } else if (codigo < re.getCodigo()) {
                    return buscarNombreRecursivo(nodo.childs.get(i), codigo);
                }
            }
        }
        return buscarNombreRecursivo(nodo.childs.get(nodo.count), codigo);
    }

    // EJERCICIO 2: eliminar una clave del árbol B
    public void remove(E cl) {
        underflow = false;
        delete(root, cl);
        if (underflow && root.getCount() == 0) {
            root = root.getChilds().get(0); // propagación a la raíz
        }
    }

    private void delete(BNode<E> node, E key) {
        if (node == null) {
            System.out.println("Elemento no encontrado para eliminar: " + key);
            return;
        }

        int[] pos = new int[1];
        boolean found = node.searchNode(key, pos);

        if (found) {
            if (node.getChilds().get(0) == null) { // hoja
                for (int i = pos[0]; i < node.getCount() - 1; i++) {
                    node.getKeys().set(i, node.getKeys().get(i + 1));
                }
                node.getKeys().set(node.getCount() - 1, null);
                node.count--;
                underflow = (node.count < (orden - 1) / 2);
            } else {
                BNode<E> q = node.getChilds().get(pos[0]);
                while (q.getChilds().get(q.getCount()) != null)
                    q = q.getChilds().get(q.getCount());
                E pred = q.getKeys().get(q.getCount() - 1);
                node.getKeys().set(pos[0], pred);
                delete(node.getChilds().get(pos[0]), pred);
                if (underflow) fix(node, pos[0]);
            }
        } else {
            delete(node.getChilds().get(pos[0]), key);
            if (underflow) fix(node, pos[0]);
        }
    }

    private void fix(BNode<E> parent, int pos) {
        BNode<E> left = (pos > 0) ? parent.getChilds().get(pos - 1) : null;
        BNode<E> right = (pos < parent.getCount()) ? parent.getChilds().get(pos + 1) : null;
        BNode<E> current = parent.getChilds().get(pos);

        if (right != null && right.getCount() > (orden - 1) / 2) {
            current.getKeys().set(current.count++, parent.getKeys().get(pos));
            parent.getKeys().set(pos, right.getKeys().get(0));
            for (int i = 0; i < right.getCount() - 1; i++) {
                right.getKeys().set(i, right.getKeys().get(i + 1));
            }
            right.getKeys().set(right.getCount() - 1, null);
            right.count--;
            underflow = false;
        } else if (left != null && left.getCount() > (orden - 1) / 2) {
            for (int i = current.count; i > 0; i--) {
                current.getKeys().set(i, current.getKeys().get(i - 1));
            }
            current.getKeys().set(0, parent.getKeys().get(pos - 1));
            parent.getKeys().set(pos - 1, left.getKeys().get(left.getCount() - 1));
            left.getKeys().set(left.getCount() - 1, null);
            left.count--;
            current.count++;
            underflow = false;
        } else {
            if (left != null) {
                left.getKeys().set(left.count++, parent.getKeys().get(pos - 1));
                for (int i = 0; i < current.count; i++) {
                    left.getKeys().set(left.count++, current.getKeys().get(i));
                }
                for (int i = pos - 1; i < parent.count - 1; i++) {
                    parent.getKeys().set(i, parent.getKeys().get(i + 1));
                    parent.getChilds().set(i + 1, parent.getChilds().get(i + 2));
                }
                parent.getKeys().set(parent.count - 1, null);
                parent.getChilds().set(parent.count, null);
                parent.count--;
                underflow = (parent.count < (orden - 1) / 2);
            } else if (right != null) {
                current.getKeys().set(current.count++, parent.getKeys().get(pos));
                for (int i = 0; i < right.count; i++) {
                    current.getKeys().set(current.count++, right.getKeys().get(i));
                }
                for (int i = pos; i < parent.count - 1; i++) {
                    parent.getKeys().set(i, parent.getKeys().get(i + 1));
                    parent.getChilds().set(i + 1, parent.getChilds().get(i + 2));
                }
                parent.getKeys().set(parent.count - 1, null);
                parent.getChilds().set(parent.count, null);
                parent.count--;
                underflow = (parent.count < (orden - 1) / 2);
            }
        }
    }
}
