package btree;

import excepciones.ItemNotFound;
import java.io.*;
import java.util.*;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;
    private int idCounter = 0;

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
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, this.root);
            pnew.childs.set(1, nDes);
            pnew.idNode = idCounter++;
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
            mediana = push(current.childs.get(pos[0]), cl);
            if (up) {
                if (current.nodeFull(this.orden - 1))
                    mediana = dividedNode(current, mediana, pos[0]);
                else {
                    up = false;
                    putNode(current, mediana, nDes, pos[0]);
                }
            }
            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        int i;
        for (i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int i, posMdna;
        posMdna = (k <= this.orden / 2) ? this.orden / 2 : this.orden / 2 + 1;
        nDes = new BNode<E>(this.orden);
        nDes.idNode = idCounter++;
        for (i = posMdna; i < this.orden - 1; i++) {
            nDes.keys.set(i - posMdna, current.keys.get(i));
            nDes.childs.set(i - posMdna + 1, current.childs.get(i + 1));
        }
        nDes.count = (this.orden - 1) - posMdna;
        current.count = posMdna;
        if (k <= this.orden / 2)
            putNode(current, cl, rd, k);
        else
            putNode(nDes, cl, rd, k - posMdna);
        E median = current.keys.get(current.count - 1);
        nDes.childs.set(0, current.childs.get(current.count));
        current.count--;
        return median;
    }

    // Ejercicio 3: Cargar árbol B desde archivo
    public static BTree<Integer> building_Btree(String fileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        if (line == null) throw new ItemNotFound("Archivo vacío o inválido");

        int orden = Integer.parseInt(line.trim());
        BTree<Integer> tree = new BTree<>(orden);
        Map<Integer, BNode<Integer>> nodos = new HashMap<>();
        Map<Integer, Integer> niveles = new HashMap<>();
        Map<Integer, List<Integer>> hijosMap = new HashMap<>();
        List<Integer> nivelesList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.trim().split(",");
            int nivel = Integer.parseInt(parts[0].trim());
            int id = Integer.parseInt(parts[1].trim());
            List<Integer> claves = new ArrayList<>();
            for (int i = 2; i < parts.length; i++) {
                claves.add(Integer.parseInt(parts[i].trim()));
            }
            BNode<Integer> nodo = new BNode<>(orden);
            nodo.count = claves.size();
            nodo.idNode = id;
            for (int i = 0; i < claves.size(); i++) {
                nodo.keys.set(i, claves.get(i));
            }
            nodos.put(id, nodo);
            niveles.put(id, nivel);
            nivelesList.add(id);
            hijosMap.put(id, new ArrayList<>());
        }

        // Enlazar los nodos segun niveles (reconstrucción top-down)
        for (int idPadre : nivelesList) {
            int nivelPadre = niveles.get(idPadre);
            for (int idHijo : nivelesList) {
                if (niveles.get(idHijo) == nivelPadre + 1) {
                    hijosMap.get(idPadre).add(idHijo);
                }
            }
        }

        // Enlazar hijos en cada nodo
        for (int idPadre : hijosMap.keySet()) {
            BNode<Integer> padre = nodos.get(idPadre);
            List<Integer> hijos = hijosMap.get(idPadre);
            for (int i = 0; i < hijos.size() && i < padre.childs.size(); i++) {
                padre.childs.set(i, nodos.get(hijos.get(i)));
            }
        }

        // Determinar raíz
        int rootId = nivelesList.stream().min(Comparator.comparingInt(niveles::get)).orElse(-1);
        tree.root = nodos.get(rootId);

        if (tree.root == null) throw new ItemNotFound("No se pudo reconstruir el árbol");

        reader.close();
        return tree;
    }

    // Método para imprimir la tabla de nodos del árbol B
    public void printTable() {
        System.out.printf("%-10s%-20s%-15s%-15s\n", "id_nodo", "claves nodo", "id_padre", "id_hijos");
        recorrerTabla(root, null);
    }

    private void recorrerTabla(BNode<E> actual, BNode<E> padre) {
        if (actual == null) return;

        // Construir claves
        StringBuilder claves = new StringBuilder();
        for (int i = 0; i < actual.count; i++) {
            claves.append(actual.keys.get(i));
            if (i < actual.count - 1) claves.append(" , ");
        }

        // Obtener id del padre
        String idPadre = (padre == null) ? "----" : String.valueOf(padre.idNode);

        // Obtener hijos
        StringBuilder hijos = new StringBuilder();
        for (int i = 0; i <= actual.count; i++) {
            if (actual.childs.get(i) != null) {
                hijos.append(actual.childs.get(i).idNode);
                if (i < actual.count) hijos.append(" , ");
            }
        }
        if (hijos.length() == 0) hijos.append("----");

        // Imprimir nodo
        System.out.printf("%-10d%-20s%-15s%-15s\n",
                actual.idNode,
                claves.toString(),
                idPadre,
                hijos.toString());

        // Recorrer hijos
        for (int i = 0; i <= actual.count; i++) {
            recorrerTabla(actual.childs.get(i), actual);
        }
    }
}
