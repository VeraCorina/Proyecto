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
 * esta es la clase pesada del proyecto donde manejamos el grafo
 * tiene todos los algoritmos que pidio el profe para las proteinas
 * * @author coco
 */
public class Grafo_Vertices {

    private Nodo_Vertice pFirst;
    private Nodo_Vertice pLast;
    private int pSize;

    /**
     * inicializa el grafo vacio sin nada adentro
     */
    public Grafo_Vertices() {
        this.pFirst = null;
        this.pLast = null;
        this.pSize = 0;
    }

    /**
     * agarra el primer vertice de la lista
     * @return el pFirst
     */
    public Nodo_Vertice getpFirst() {
        return pFirst;
    }

    /**
     * cambia el primer vertice por otro
     * @param pFirst el nuevo pFirst
     */
    public void setpFirst(Nodo_Vertice pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * busca el ultimo vertice registrado
     * @return el pLast
     */
    public Nodo_Vertice getpLast() {
        return pLast;
    }

    /**
     * setea el ultimo vertice de la lista
     * @param pLast el nuevo pLast
     */
    public void setpLast(Nodo_Vertice pLast) {
        this.pLast = pLast;
    }

    /**
     * dime cuantos vertices hay en total horita
     * @return el tamaño pSize
     */
    public int getpSize() {
        return pSize;
    }

    /**
     * para cambiar el tamaño manualmente si hace falta
     * @param pSize el numero nuevo
     */
    public void setpSize(int pSize) {
        this.pSize = pSize;
    }

    /**
     * añade un vertice nuevo si es que no existe ya 
     * @param pDato el nombre de la protenia
     */
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

    /**
     * busca un vertice por el nombre para ver si esta
     * @param pDato el string a buscar
     * @return el nodo si lo encuentra o null si no
     */
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

    /**
     * conecta dos proteinas con un peso o costo
     * @param origen de donde sale
     * @param destino a donde llega
     * @param costo que tan fuerte es la interaccion
     */
    public void insertarArista(String origen, String destino, int costo) {
        Nodo_Vertice vOrigen = buscarVertice(origen);
        Nodo_Vertice vDestino = buscarVertice(destino);
        if (vOrigen != null && vDestino != null) {
            vOrigen.getLista_Aristas().insertar(vDestino, costo);
            vDestino.getLista_Aristas().insertar(vOrigen, costo);

        }
    }

    /**
     * borra un vertice y tambien quita sus conexiones
     * @param pDato la protenia a eliminar
     */
    public void eliminarVertice(String pDato) {
        if (this.pFirst == null) {
            return;
        }

        Nodo_Vertice aEliminar = buscarVertice(pDato);
        if (aEliminar == null) {
            return;
        }

        if (aEliminar == pFirst) {
            pFirst = pFirst.getpNext();
            if (pFirst != null) {
                pFirst.anterior = null;
            } else {
                pLast = null;
            }
        } else if (aEliminar == pLast) {
            pLast = pLast.anterior;
            if (pLast != null) {
                pLast.setpNext(null);
            } else {
                pFirst = null;
            }
        } else {
            aEliminar.anterior.setpNext(aEliminar.getpNext());
            aEliminar.getpNext().anterior = aEliminar.anterior;
        }

        Nodo_Vertice pAux = this.pFirst;
        while (pAux != null) {
            pAux.getLista_Aristas().eliminar(pDato);
            pAux = pAux.getpNext();
        }
        this.pSize--;
    }

    /**
     * genera un string con toda la info del grafo para verla
     * @return el texto del grafo completo
     */
    public String imprimirGrafo() {
        String resultado = "";
        Nodo_Vertice pAux = this.pFirst;
        if (pAux == null) {
            return "";
        }
        while (pAux != null) {
            resultado += "[" + pAux.getpDato() + "]: " + pAux.getLista_Aristas().verListaAristas() + "\n";
            pAux = pAux.getpNext();
        }
        return resultado;
    }

    /**
     * hace el recorrido en profundidad para ver los nodos
     * @return el string con el camino
     */
    public String recorridoDFS() {
        this.reinicio();
        String recorrido = "";
        Nodo_Vertice aux = this.pFirst;
        while (aux != null) {
            if (!aux.visitado) {
                recorrido = this.dfs(recorrido, aux);
            }
            aux = aux.getpNext();
        }
        return recorrido;
    }

    /**
     * funcion auxiliar recursiva para el dfs
     * @param resultado lo que llevamos acumulado
     * @param aux el nodo actual
     * @return el resultado actualizado
     */
    private String dfs(String resultado, Nodo_Vertice aux) {
        aux.visitado = true;
        resultado += aux.getpDato() + ", ";
        Nodo_Arista arista = aux.getLista_Aristas().getpFirst();
        while (arista != null) {
            if (!arista.getpData().visitado) {
                resultado = dfs(resultado, arista.getpData());
            }
            arista = arista.getpNext();
        }
        return resultado;
    }

    /**
     * resetea todos los nodos a no visitados para reusarlos
     */
    public void reinicio() {
        Nodo_Vertice aux = this.pFirst;
        while (aux != null) {
            aux.visitado = false;
            aux = aux.getpNext();
        }
    }

    /**
     * algoritmo para hallar el camino mas corto entre proteinas
     * @param nombreOrigen donde empezamos
     * @param nombreDestino donde terminamos
     * @return la ruta mas optima con el costo
     */
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
        return ruta + "\nCosto Total: " + (int) destino.distancia;
    }

    /**
     * saca un reporte de que proteinas tienen mas conexiones
     * @return un string con los hubs encontrados
     */
    public String identificarHubs() {
        if (this.pFirst == null) {
            return "vACIO";
        }

        Nodo_Vertice maxHub = this.pFirst;
        int maxGrado = this.pFirst.getLista_Aristas().getpSize();

        String reporte = "\n";
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

        reporte += "\n\n";
        reporte += "La proteina más esencial es " + maxHub.getpDato() + " con " + maxGrado + " conexiones";

        return reporte;
    }

    /**
     * muestra todos los nombres de los vertices que hay
     * @return el texto con los nombres
     */
    public String ver_vertices() {
        String vert = "";
        Nodo_Vertice aux = this.pFirst;

        while (aux != null) {
            vert += aux.getpDato() + ", ";
            aux = aux.getpNext();
        }

        return vert;
    }

    /**
     * hace el recorrido en anchura usando una cola
     * @return el camino por niveles
     */
    public String bfs() {
        this.reinicio();
        String recorrido = "";
        Nodo_Vertice verticeInicial = this.pFirst;

        while (verticeInicial != null) {
            if (!verticeInicial.visitado) {
                Cola c = new Cola();
                verticeInicial.visitado = true;
                c.encolar(verticeInicial);

                while (c.pFirst != null) {
                    Nodo_Vertice u = c.desencolar().getpDato();
                    recorrido += u.getpDato() + ", ";

                    Nodo_Arista aAux = u.getLista_Aristas().getpFirst();
                    while (aAux != null) {
                        if (!aAux.getpData().visitado) {
                            aAux.getpData().visitado = true;
                            c.encolar(aAux.getpData());
                        }
                        aAux = aAux.getpNext();
                    }
                }
            }
            verticeInicial = verticeInicial.getpNext();
        }
        return recorrido;
    }
}