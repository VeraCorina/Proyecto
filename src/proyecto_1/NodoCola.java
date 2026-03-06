/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

/**
 * esta clase representa un eslabon de la cola que usamos para el bfs
 * basciamente envuelve un vertice y apunta al siguiente que este en la fila.
 * @author coco
 */
public class NodoCola {
    private Nodo_Vertice pDato;
    private NodoCola pNext;
    
    /**
     * constructor sencillo para crear el nodo con el vertice que nos den.
     * @param data el vertice del grafo que queremos meter aqui.
     */
    public NodoCola(Nodo_Vertice data){
        this.pDato = data;
        pNext = null;
    }

    /**
     * nos devuelve el dato que tiene guardado el nodo (osea la proteina).
     * @return el vertice pDato.
     */
    public Nodo_Vertice getpDato() {
        return pDato;
    }

    /**
     * sirve para meterle un vertice nuevo al nodo si hace falta.
     * @param pDato el vertice que queremos setear.
     */
    public void setpDato(Nodo_Vertice pDato) {
        this.pDato = pDato;
    }

    /**
     * te dice quien es el siguiente en la cola o null si es el ultimo.
     * @return el puntero al siguiente nodo pNext.
     */
    public NodoCola getpNext() {
        return pNext;
    }

    /**
     * actualiza el puntero para decir cual es el proximo nodo en la secuencia.
     * @param pNext el nodo que ahora va a estar de tras.
     */
    public void setpNext(NodoCola pNext) {
        this.pNext = pNext;
    }
}