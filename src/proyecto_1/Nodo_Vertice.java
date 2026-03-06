/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

/**
 * esta clase es el vertice del grafo osea cada proteina individual 
 * tiene su propia lista de aristas para saber con quien interactua
 * @author coco
 */
public class Nodo_Vertice {

    private String pDato;
    private Nodo_Vertice pNext;
    private Lista_Arista lista_Aristas;
    public boolean visitado;
    public double distancia;
    public Nodo_Vertice anterior;

    /**
     * crea un vertice nuevo con el nombre de la proteina y su lista vacia
     * @param pDato el nombre o id de la proteina
     */
    public Nodo_Vertice(String pDato) {
        this.pDato = pDato;
        this.pNext = null;
        this.lista_Aristas = new Lista_Arista();
        this.visitado = false;
    }

    /**
     * @return el nombre de la proteina guardada
     */
    public String getpDato() {
        return pDato;
    }

    /**
     * @param pDato cambia el nombre de la proteina en este nodo
     */
    public void setpDato(String pDato) {
        this.pDato = pDato;
    }

    /**
     * @return el siguiente vertice en la lista de vertices del grafo
     */
    public Nodo_Vertice getpNext() {
        return pNext;
    }

    /**
     * @param pNext pone cual es el siguiente vertice en la secuencia
     */
    public void setpNext(Nodo_Vertice pNext) {
        this.pNext = pNext;
    }

    /**
     * @return la lista de todas las aristas que salen de este nodo
     */
    public Lista_Arista getLista_Aristas() {
        return lista_Aristas;
    }

    /**
     * @param lista_Aristas setea una lista completa de conexiones
     */
    public void setLista_Aristas(Lista_Arista lista_Aristas) {
        this.lista_Aristas = lista_Aristas;
    }
}