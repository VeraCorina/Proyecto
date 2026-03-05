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
                nuevo.anterior = pLast;
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
            vDestino.getLista_Aristas().insertar(vOrigen, costo);

        }
    }

    public void eliminarVertice(String pDato) {
        if (this.pFirst != null) {
            if (this.pFirst.getpDato().equals(pDato)) {
                this.pFirst = this.pFirst.getpNext();
                if (this.pFirst == null) {
                    this.pLast = null;
                } else {
                    this.pFirst.anterior = null;
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
                    if (pAux.getpNext() != null) {
                        pAux.getpNext().anterior = pAux;
                    }
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

    public String recorridoDFS() {
        String recorrido = "";

        Nodo_Vertice aux = this.pFirst;

        while (aux != null) {
            if (!aux.visitado) {
                recorrido += this.dfs(recorrido, aux);
            }
            aux = aux.getpNext();
        }
        return recorrido;
    }

    public String dfs(String resultado, Nodo_Vertice aux) {
        resultado += aux.getpDato() + ", ";
        aux.visitado = true;

        Nodo_Arista aux2 = aux.getLista_Aristas().getpFirst();
        while (aux2 != null) {
            if (!aux2.getpData().visitado) {
                resultado = this.dfs(resultado, aux2.getpData());
            }
            aux2 = aux2.getpNext();
        }
        this.reinicio();
        return resultado;
    }

    public String bfs() {
        String recorrido = "";
        Nodo_Vertice aux = this.pFirst;
        Cola c = new Cola();
        c.encolar(this.pFirst);
        while (c.pFirst != null) {
            recorrido += aux.getpDato() + ", ";
            Nodo_Arista aux2 = aux.getLista_Aristas().getpFirst();

            while (aux2 != null) {
                if (!aux2.getpData().visitado) {
                    aux2.getpData().visitado = true;
                    c.encolar(aux2.getpData());
                }
                aux2 = aux2.getpNext();
            }

            aux = c.desencolar().getpDato();
        }
        this.reinicio();
        return recorrido;
    }

    public void reinicio() {
        Nodo_Vertice aux = this.pFirst;
        while (aux != null) {
            aux.visitado = false;
            aux = aux.getpNext();
        }

    }

    public String dijkstra(String nombreOrigen, String nombreDestino) {
        Nodo_Vertice origen = buscarVertice(nombreOrigen);
        Nodo_Vertice destino = buscarVertice(nombreDestino);

        if (origen == null || destino == null) {
            return "Prooteinas no encontradas";
        }

        Nodo_Vertice temp = this.getpFirst();
        while (temp != null) {
            temp.distancia = Double.POSITIVE_INFINITY;
            temp.anterior = null;
            temp.visitado = false;
            temp = temp.getpNext();
        }

        origen.distancia = 0;
        for (int i = 0; i < this.getpSize(); i++) {
            Nodo_Vertice u = null;
            double min = Double.POSITIVE_INFINITY;
            Nodo_Vertice nodoActual = this.getpFirst();

            while (nodoActual != null) {
                if (!nodoActual.visitado && nodoActual.distancia < min) {
                    min = nodoActual.distancia;
                    u = nodoActual;
                }
                nodoActual = nodoActual.getpNext();
            }

            if (u == null) {
                break;
            }

            u.visitado = true;
            if (u == destino) {
                break;
            }
            Nodo_Arista aristaAux = u.getLista_Aristas().getpFirst();
            while (aristaAux != null) {
                Nodo_Vertice v = aristaAux.getpData();
                if (!v.visitado) {
                    double peso = aristaAux.getCosto_Interaccion();
                    double nuevaDistancia = u.distancia + peso;

                    if (nuevaDistancia < v.distancia) {
                        v.distancia = nuevaDistancia;
                        v.anterior = u;
                    }
                }
                aristaAux = aristaAux.getpNext();
            }
        }

        if (destino.distancia == Double.POSITIVE_INFINITY) {
            return "No existe una ruta metaboica entre " + nombreOrigen + " y " + nombreDestino;
        }

        String ruta = "";
        Nodo_Vertice paso = destino;
        while (paso != null) {
            ruta = paso.getpDato() + (ruta.isEmpty() ? "" : " -> ") + ruta;
            paso = paso.anterior;
        }

        this.reinicio();
        return "Ruta Metabolica: " + ruta + "\nCosto Total: " + (int) destino.distancia;
    }
    
    public String identificarHubs() {
        if (this.pFirst == null) {
            return "vACIO";
        }

        Nodo_Vertice maxHub = this.pFirst;
        int maxGrado = this.pFirst.getLista_Aristas().getpSize();

        String reporte = "REPORTE DE CENTRALIDAD DE GRADO (HUBS):\n";
        Nodo_Vertice aux = this.pFirst;

        while (aux != null) {
            int gradoActual = aux.getLista_Aristas().getpSize();
            reporte += "- Protenia: " + aux.getpDato() + " | Grado: " + gradoActual + "\n";

            if (gradoActual > maxGrado) {
                maxGrado = gradoActual;
                maxHub = aux;
            }
            aux = aux.getpNext();
        }

        reporte += "\nDIANA TERAPETICA PRIMARIA:\n";
        reporte += "La proteina más esencial es " + maxHub.getpDato() + " con " + maxGrado + " conexiones";
        
        return reporte;
    }
}
