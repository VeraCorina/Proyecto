/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

/**
 *
 * @author coco
 */
public class NodoCola {
    private Nodo_Vertice pDato;
    private NodoCola pNext;
    
    public NodoCola(Nodo_Vertice data){
        this.pDato = data;
        pNext = null;
    }

    /**
     * @return the pDato
     */
    public Nodo_Vertice getpDato() {
        return pDato;
    }

    /**
     * @param pDato the pDato to set
     */
    public void setpDato(Nodo_Vertice pDato) {
        this.pDato = pDato;
    }

    /**
     * @return the pNext
     */
    public NodoCola getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoCola pNext) {
        this.pNext = pNext;
    }
}
