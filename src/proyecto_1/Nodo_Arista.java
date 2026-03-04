/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

/**
 *
 * @author coco
 */
public class Nodo_Arista {
    private Nodo_Arista pNext;
    private Nodo_Vertice pData;
    private int costo_Interaccion;

    public Nodo_Arista(Nodo_Vertice pData, int costo_Interaccion) {
        this.pData = pData;
        this.costo_Interaccion = costo_Interaccion;
        this.pNext = null;
    }

    /**
     * @return the pNext
     */
    public Nodo_Arista getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodo_Arista pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the pData
     */
    public Nodo_Vertice getpData() {
        return pData;
    }

    /**
     * @param pData the pData to set
     */
    public void setpData(Nodo_Vertice pData) {
        this.pData = pData;
    }

    /**
     * @return the costo_Interaccion
     */
    public int getCosto_Interaccion() {
        return costo_Interaccion;
    }

    /**
     * @param costo_Interaccion the costo_Interaccion to set
     */
    public void setCosto_Interaccion(int costo_Interaccion) {
        this.costo_Interaccion = costo_Interaccion;
    }
    
    
    
    
    
}
