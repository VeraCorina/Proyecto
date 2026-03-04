/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

/**
 *
 * @author coco
 */
public class Lista_Arista {

    private Nodo_Arista pFirst;
    private Nodo_Arista pLast;
    private int pSize;

    public Lista_Arista() {
        this.pFirst = null;
        this.pLast = null;
        this.pSize = 0;
    }

    /**
     * @return the pFirst
     */
    public Nodo_Arista getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo_Arista pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo_Arista getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo_Arista pLast) {
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

    public void eliminar(String pDato) {
        if (this.pFirst != null) {
            Nodo_Arista pAux = this.getpFirst();
            if (pAux.getpData().equals(pDato)) {
                this.setpFirst(this.getpFirst().getpNext());
            } else {
                while (pAux.getpNext() != null && !pAux.getpNext().getpData().equals(pDato)) {
                    pAux = pAux.getpNext();
                }

                if (pAux.getpNext() != null) {
                    pAux.setpNext(pAux.getpNext().getpNext());
                }
            }
        }
    }

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
    
    public String verListaAristas(){
       
        String listaStr = "";
        Nodo_Arista pAux = this.pFirst;

        if (pAux == null) {
            return "La lista de aristas está vacía.";
        }

        while (pAux != null) {
            listaStr += "[Destino: " + pAux.getpData() + " | Costo  Interaccion: " + pAux.getCosto_Interaccion()+ "]";
            
            pAux = pAux.getpNext();

            if (pAux != null) {
                listaStr += " -> ";
            }
        }

        return listaStr;
    
    }

}
