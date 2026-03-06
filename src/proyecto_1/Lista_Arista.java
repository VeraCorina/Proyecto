/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

/**
 *
 * @author coco
 */
/**
 * esta clase maneja las conexiones de cada nodo
 * es basicamente una lista enlazada de las aristas
 * * @author coco
 */
public class Lista_Arista {

    private Nodo_Arista pFirst;
    private Nodo_Arista pLast;
    private int pSize;

    /**
     * constructor por defecto para la lista de aristas
     */
    public Lista_Arista() {
        this.pFirst = null;
        this.pLast = null;
        this.pSize = 0;
    }

    /**
     * devuelve la primera arista de la lista
     * @return la pFirst
     */
    public Nodo_Arista getpFirst() {
        return pFirst;
    }

    /**
     * pone una arista como la primera de la lista
     * @param pFirst la arista nueva
     */
    public void setpFirst(Nodo_Arista pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * dame la ultima arista que se agrego
     * @return la pLast
     */
    public Nodo_Arista getpLast() {
        return pLast;
    }

    /**
     * setea cual es la ultima arista horita
     * @param pLast la arista final
     */
    public void setpLast(Nodo_Arista pLast) {
        this.pLast = pLast;
    }

    /**
     * dice cuantas aristas tiene este vertice
     * @return el tamaño pSize
     */
    public int getpSize() {
        return pSize;
    }

    /**
     * para cambiar el tamaño de la lista de aristas
     * @param pSize el numero de aristas
     */
    public void setpSize(int pSize) {
        this.pSize = pSize;
    }

    /**
     * inserta una arista nueva conectando a otro nodo
     * @param pDato el nodo destino
     * @param costo el valor de la conexion
     */
    public void insertar(Nodo_Vertice pDato, int costo) {
        Nodo_Arista n = new Nodo_Arista(pDato, costo);
        if (this.pFirst == null) {
            this.pFirst = this.pLast = n;
        } else {
            this.pLast.setpNext(n);
            this.setpLast(n);
        }
        this.pSize++;
    }

    /**
     * quita una conexion especifica
     * @param pDato el nombre de la proteina a desconectar
     */
    public void eliminar(String pDato) {
        if (this.pFirst != null) {
            Nodo_Arista pAux = this.pFirst;

            if (pAux.getpData().getpDato().equals(pDato)) {
                this.pFirst = pAux.getpNext();
                if (this.pFirst == null) {
                    this.pLast = null;
                }
                this.pSize--;
            } else {

                while (pAux.getpNext() != null && !pAux.getpNext().getpData().getpDato().equals(pDato)) {
                    pAux = pAux.getpNext();
                }

                if (pAux.getpNext() != null) {

                    if (pAux.getpNext() == this.pLast) {
                        this.pLast = pAux;
                    }
                    pAux.setpNext(pAux.getpNext().getpNext());
                    this.pSize--;
                }
            }
        }
    }

    /**
     * busca si existe una arista hacia tal proteina
     * @param pDato el nombre buscado
     * @return el nodo de la arista si existe
     */
    public Nodo_Arista buscar(String pDato) {
        if (this.pFirst != null) {
            Nodo_Arista pAux = this.getpFirst();
            while (pAux != null && !pAux.getpData().equals(pDato)) {
                pAux = pAux.getpNext();
            }
            return pAux;
        }
        return null;
    }
    
    /**
     * imprime bonito todas las aristas de este nodo
     * @return un string con la lista de conexiones
     */
    public String verListaAristas(){
       
        String listaStr = "";
        Nodo_Arista pAux = this.pFirst;

        if (pAux == null) {
            return "La lista de aristas está vacía.";
        }

        while (pAux != null) {
            listaStr += "[Destino: " + pAux.getpData().getpDato() + " | Costo  Interaccion: " + pAux.getCosto_Interaccion()+ "]";
            
            pAux = pAux.getpNext();

            if (pAux != null) {
                listaStr += " -> ";
            }
        }

        return listaStr;
    
    }

}