package test;

import btree.BTree;
import btree.BNode;
import java.util.*;

public class TestBTree {

	private static Map<Integer, Integer> mapaPadres = new HashMap<>();

	public static void main(String[] args) {
	    BTree<Integer> arbol = new BTree<>(4);

	    int[] datos = {
	        31, 12, 19, 3, 10, 13
	    };

	    for (int dato : datos) {
	        arbol.insert(dato);
	    }

	    System.out.printf("%-10s %-20s %-10s %-20s%n", "id_nodo", "claves nodo", "id_padre", "id_hijos");
	    System.out.println("--------------------------------------------------------------------------");

	    imprimirTabla(arbol.getRaiz(), null);
	}

	private static void imprimirTabla(BNode<Integer> nodo, Integer idPadre) {
	    if (nodo == null) return;

	    int idActual = nodo.getIdNode();
	    mapaPadres.put(idActual, (idPadre != null) ? idPadre : -1);

	    String claves = getClaves(nodo);
	    String hijosTexto = getHijos(nodo);

	    String padreTexto = (idPadre == null) ? "----" : String.valueOf(idPadre);
	    if (hijosTexto.isEmpty()) hijosTexto = "---";

	    System.out.printf("%-10d %-20s %-10s %-20s%n",
	            idActual, claves, padreTexto, hijosTexto);

	    for (int i = 0; i <= nodo.getCount(); i++) {
	        BNode<Integer> hijo = nodo.getChilds().get(i);
	        if (hijo != null) {
	            imprimirTabla(hijo, idActual);
	        }
	    }
	}

	private static String getClaves(BNode<Integer> nodo) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < nodo.getCount(); i++) {
	        sb.append(nodo.getKeys().get(i));
	        if (i < nodo.getCount() - 1) sb.append(" , ");
	    }
	    return sb.toString();
	}

	private static String getHijos(BNode<Integer> nodo) {
	    List<Integer> hijosIds = new ArrayList<>();
	    for (int i = 0; i <= nodo.getCount(); i++) {
	        BNode<Integer> hijo = nodo.getChilds().get(i);
	        if (hijo != null) hijosIds.add(hijo.getIdNode());
	    }
	    return hijosIds.isEmpty() ? "" : hijosIds.toString().replace("[", "").replace("]", "").replace(",", " ,");
	}
}