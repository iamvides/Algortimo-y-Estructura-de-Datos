package avltree;

import exceptions.ItemDuplicated;

// Clase del AVLTree que hereda de BSTree
public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

	public AVLTree() {
	    raiz = null;
	}

	public void insertar(E x) throws ItemDuplicated {
	    Height h = new Height();
	    raiz = insertarAVL((NodeAVL<E>) raiz, x, h);
	}

	private NodeAVL<E> insertarAVL(NodeAVL<E> nodo, E x, Height h) throws ItemDuplicated {
	    if (nodo == null) {
	        h.h = true;
	        return new NodeAVL<>(x);
	    }

	    if (x.compareTo(nodo.dato) < 0) {
	        nodo.izq = insertarAVL((NodeAVL<E>) nodo.izq, x, h);
	        if (h.h) {
	            switch (nodo.bf) {
	                case 1 -> { nodo.bf = 0; h.h = false; }
	                case 0 -> nodo.bf = -1;
	                case -1 -> { nodo = balanceToRight(nodo); h.h = false; }
	            }
	        }
	    } else if (x.compareTo(nodo.dato) > 0) {
	        nodo.der = insertarAVL((NodeAVL<E>) nodo.der, x, h);
	        if (h.h) {
	            switch (nodo.bf) {
	                case -1 -> { nodo.bf = 0; h.h = false; }
	                case 0 -> nodo.bf = 1;
	                case 1 -> { nodo = balanceToLeft(nodo); h.h = false; }
	            }
	        }
	    } else {
	        throw new ItemDuplicated("Ya existe");
	    }

	    return nodo;
	}

	private NodeAVL<E> balanceToLeft(NodeAVL<E> nodo) {
	    NodeAVL<E> hijo = (NodeAVL<E>) nodo.der;

	    if (hijo.bf == 1) {
	        nodo.bf = 0;
	        hijo.bf = 0;
	        nodo = rotateSL(nodo);
	    } else {
	        NodeAVL<E> nieto = (NodeAVL<E>) hijo.izq;
	        switch (nieto.bf) {
	            case -1 -> { nodo.bf = 0; hijo.bf = 1; }
	            case 0 -> { nodo.bf = 0; hijo.bf = 0; }
	            case 1 -> { nodo.bf = 1; hijo.bf = 0; }
	        }
	        nieto.bf = 0;
	        nodo.der = rotateSR(hijo);
	        nodo = rotateSL(nodo);
	    }
	    return nodo;
	}

	private NodeAVL<E> balanceToRight(NodeAVL<E> nodo) {
	    NodeAVL<E> hijo = (NodeAVL<E>) nodo.izq;

	    if (hijo.bf == -1) {
	        nodo.bf = 0;
	        hijo.bf = 0;
	        nodo = rotateSR(nodo);
	    } else {
	        NodeAVL<E> nieto = (NodeAVL<E>) hijo.der;
	        switch (nieto.bf) {
	            case 1 -> { nodo.bf = 0; hijo.bf = -1; }
	            case 0 -> { nodo.bf = 0; hijo.bf = 0; }
	            case -1 -> { nodo.bf = -1; hijo.bf = 0; }
	        }
	        nieto.bf = 0;
	        nodo.izq = rotateSL(hijo);
	        nodo = rotateSR(nodo);
	    }
	    return nodo;
	}

	private NodeAVL<E> rotateSL(NodeAVL<E> nodo) {
	    NodeAVL<E> hijo = (NodeAVL<E>) nodo.der;
	    nodo.der = hijo.izq;
	    hijo.izq = nodo;
	    return hijo;
	}

	private NodeAVL<E> rotateSR(NodeAVL<E> nodo) {
	    NodeAVL<E> hijo = (NodeAVL<E>) nodo.izq;
	    nodo.izq = hijo.der;
	    hijo.der = nodo;
	    return hijo;
	}

	private static class Height {
	    boolean h;
	}

	// método de impresión inorden con bf
	public void imprimir() {
	    imprimir((NodeAVL<E>) raiz);
	    System.out.println();
	}

	private void imprimir(NodeAVL<E> nodo) {
	    if (nodo != null) {
	        imprimir((NodeAVL<E>) nodo.izq);
	        System.out.print(nodo + " ");
	        imprimir((NodeAVL<E>) nodo.der);
	    }
	}

	// EJERCICIO 1: contar nodos con bf = 0
	public int contarBalanceados() {
	    return contarBalanceados((NodeAVL<E>) raiz);
	}

	private int contarBalanceados(NodeAVL<E> nodo) {
	    if (nodo == null) return 0;

	    int contador = 0;
	    if (nodo.bf == 0) contador++;

	    contador += contarBalanceados((NodeAVL<E>) nodo.izq);
	    contador += contarBalanceados((NodeAVL<E>) nodo.der);

	    return contador;
	}

	// EJERCICIO 2: suma de nodos con bf ≠ 0
	public int sumarNoBalanceados() {
	    return sumarNoBalanceados((NodeAVL<E>) raiz);
	}

	private int sumarNoBalanceados(NodeAVL<E> nodo) {
	    if (nodo == null) return 0;

	    int suma = 0;
	    if (nodo.bf != 0)
	        suma += (Integer) nodo.dato;

	    suma += sumarNoBalanceados((NodeAVL<E>) nodo.izq);
	    suma += sumarNoBalanceados((NodeAVL<E>) nodo.der);

	    return suma;
	}

	// EJERCICIO 3: verificar si existe hoja con bf = 0
	public boolean existeHojaBalanceada() {
	    return existeHojaBalanceada((NodeAVL<E>) raiz);
	}

	private boolean existeHojaBalanceada(NodeAVL<E> nodo) {
	    if (nodo == null) return false;

	    if (nodo.izq == null && nodo.der == null && nodo.bf == 0)
	        return true;

	    return existeHojaBalanceada((NodeAVL<E>) nodo.izq) || existeHojaBalanceada((NodeAVL<E>) nodo.der);
	}

	// EJERCICIO 4: contar nodos con dos hijos
	public int contarNodosConDosHijos() {
	    return contarNodosConDosHijos((NodeAVL<E>) raiz);
	}

	private int contarNodosConDosHijos(NodeAVL<E> nodo) {
	    if (nodo == null) return 0;

	    int cuenta = 0;
	    if (nodo.izq != null && nodo.der != null)
	        cuenta++;

	    cuenta += contarNodosConDosHijos((NodeAVL<E>) nodo.izq);
	    cuenta += contarNodosConDosHijos((NodeAVL<E>) nodo.der);

	    return cuenta;
	}

	// EJERCICIO 5: sumar nodos hoja
	public int sumarHojas() {
	    return sumarHojas((NodeAVL<E>) raiz);
	}

	private int sumarHojas(NodeAVL<E> nodo) {
	    if (nodo == null) return 0;

	    if (nodo.izq == null && nodo.der == null)
	        return (Integer) nodo.dato;

	    return sumarHojas((NodeAVL<E>) nodo.izq) + sumarHojas((NodeAVL<E>) nodo.der);
	}

	// EJERCICIO 6: contar nodos internos
	public int contarNodosInternos() {
	    return contarNodosInternos((NodeAVL<E>) raiz);
	}

	private int contarNodosInternos(NodeAVL<E> nodo) {
	    if (nodo == null) return 0;

	    if (nodo.izq == null && nodo.der == null)
	        return 0;

	    return 1 + contarNodosInternos((NodeAVL<E>) nodo.izq) + contarNodosInternos((NodeAVL<E>) nodo.der);
	}
}