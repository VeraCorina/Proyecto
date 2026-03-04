/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

/**
 *
 * @author coco
 */
public class Grafo_Vertices {

    private Nodo_Vertice pFirst;
    private Nodo_Vertice pLast;
    private int pSize;

    public Grafo_Vertices() {
        this.pFirst = null;
        this.pLast = null;
        this.pSize = 0;
    }

    /**
     * @return the pFirst
     */
    public Nodo_Vertice getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo_Vertice pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo_Vertice getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo_Vertice pLast) {
        this.pLast = pLast;
    }

    /**
     * @return the pSize
     */
    public int getpSize() {
        return pSize;
    }

    /**
     * @param pSize the pSize to set
     */
    public void setpSize(int pSize) {
        this.pSize = pSize;
    }

    
    public void insertarVertice(String pDato) {
        if (buscarVertice(pDato) == null) {
            Nodo_Vertice nuevo = new Nodo_Vertice(pDato);
            if (this.pFirst == null) {
                this.pFirst = this.pLast = nuevo;
            } else {
                this.pLast.setpNext(nuevo);
                this.pLast = nuevo;
            }
            this.pSize++;
        }
    }

    public Nodo_Vertice buscarVertice(String pDato) {
        Nodo_Vertice pAux = this.pFirst;
        while (pAux != null) {
            if (pAux.getpDato().equals(pDato)) {
                return pAux;
            }
            pAux = pAux.getpNext();
        }
        return null;
    }


    
}
