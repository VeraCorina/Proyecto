/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

/**
 * esta clase representa una arista osea la conexion entre dos proteinas
 * guarda el nodo al que va y tambien cuanto cuesta esa interaccion 
 * @author coco
 */
public class Nodo_Arista {
    private Nodo_Arista pNext;
    private Nodo_Vertice pData;
    private int costo_Interaccion;

    /**
     * constructor para inicialisar la arista con su destino y peso
     * @param pData es el vertice destino de la arista
     * @param costo_Interaccion es el valor de la relacion entre proteinas
     */
    public Nodo_Arista(Nodo_Vertice pData, int costo_Interaccion) {
        this.pData = pData;
        this.costo_Interaccion = costo_Interaccion;
        this.pNext = null;
    }

    /**
     * @return el siguiente nodo arista en la lista enlazada
     */
    public Nodo_Arista getpNext() {
        return pNext;
    }

    /**
     * @param pNext setea la siguiente arista de la lista
     */
    public void setpNext(Nodo_Arista pNext) {
        this.pNext = pNext;
    }

    /**
     * @return la data del vertice al que apunta esta conexion
     */
    public Nodo_Vertice getpData() {
        return pData;
    }

    /**
     * @param pData cambia el vertice destino de la arista
     */
    public void setpData(Nodo_Vertice pData) {
        this.pData = pData;
    }

    /**
     * @return el costo o peso de la interaccion biológica
     */
    public int getCosto_Interaccion() {
        return costo_Interaccion;
    }

    /**
     * @param costo_Interaccion cambia el valor del peso de la arista
     */
    public void setCosto_Interaccion(int costo_Interaccion) {
        this.costo_Interaccion = costo_Interaccion;
    }
}