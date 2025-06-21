package test;

import btree.BTree;
import excepciones.ItemNotFound;

public class TestBuildingBTree {
    public static void main(String[] args) {
        try {
            // Intenta construir el árbol B desde el archivo
            BTree<Integer> arbol = BTree.building_Btree("src/test/arbolB.txt");
            System.out.println("Árbol B cargado correctamente desde el archivo.\n");

            // Imprimir el árbol en formato de tabla
            arbol.printTable();

        } catch (ItemNotFound e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Excepción inesperada: " + ex);
        }
    }
}
