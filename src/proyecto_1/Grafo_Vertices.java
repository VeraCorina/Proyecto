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


    
    public void insertarArista(String origen, String destino, int costo) {
        Nodo_Vertice vOrigen = buscarVertice(origen);
        Nodo_Vertice vDestino = buscarVertice(destino);
        if (vOrigen != null && vDestino != null) {
            vOrigen.getLista_Aristas().insertar(vDestino, costo);
        }
    }

    public void eliminarVertice(String pDato) {
        if (this.pFirst != null) {
            if (this.pFirst.getpDato().equals(pDato)) {
                this.pFirst = this.pFirst.getpNext();
                if (this.pFirst == null) {
                    this.pLast = null;
                }
                this.pSize--;
            } else {
                Nodo_Vertice pAux = this.pFirst;
                while (pAux.getpNext() != null && !pAux.getpNext().getpDato().equals(pDato)) {
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

            Nodo_Vertice pActual = this.pFirst;
            while (pActual != null) {
                pActual.getLista_Aristas().eliminar(pDato);
                pActual = pActual.getpNext();
            }
        }
    }

    public String imprimirGrafo() {
        String resultado = "";
        Nodo_Vertice pAux = this.pFirst;
        if (pAux == null) {
            return "";
        }
        while (pAux != null) {
            resultado += "Vertice [" + pAux.getpDato() + "]: " + pAux.getLista_Aristas().verListaAristas() + "\n";
            pAux = pAux.getpNext();
        }
        return resultado;
    }
    
}
