/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

/**
 *
 * @author coco
 */
public class Nodo_Vertice {

    private String pDato;
    private Nodo_Vertice pNext;
    private Lista_Arista lista_Aristas;
    public boolean visitado;
    public double distancia;
    public Nodo_Vertice anterior;

    public Nodo_Vertice(String pDato) {
        this.pDato = pDato;
        this.pNext = null;
        this.lista_Aristas = new Lista_Arista();
        this.visitado = false;
    }

    /**
     * @return the pDato
     */
    public String getpDato() {
        return pDato;
    }

    /**
     * @param pDato the pDato to set
     */
    public void setpDato(String pDato) {
        this.pDato = pDato;
    }

    /**
     * @return the pNext
     */
    public Nodo_Vertice getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodo_Vertice pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the lista_Aristas
     */
    public Lista_Arista getLista_Aristas() {
        return lista_Aristas;
    }

    /**
     * @param lista_Aristas the lista_Aristas to set
     */
    public void setLista_Aristas(Lista_Arista lista_Aristas) {
        this.lista_Aristas = lista_Aristas;
    }

}
