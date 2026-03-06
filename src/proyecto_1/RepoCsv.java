/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;
    import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * esta clase se encarga de cargar y actualizar el repositorio csv
 * es basica para que no perdamos los datos al cerrar el programa
 * @author coco
 */
public class RepoCsv {

    /**
     * abre el buscador para que elijas el archivo y carga el grafo
     * @param grafo el objeto donde se va a reconstruir la red
     * @return el archivo que se cargo para guardarlo como referencia
     */
    public File cargarGrafo(Grafo_Vertices grafo) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv", "txt");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            this.leerArchivo(archivo, grafo);
            return archivo;
        }
        return null;
    }

    /**
     * lee el archivo plano y va insertando vertices y aristas uno por uno 
     * @param archivo el file fisico que vamos a leer
     * @param grafo la estructura donde se guarda la info
     */
    private void leerArchivo(File archivo, Grafo_Vertices grafo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] partes = linea.split(",");
                    if (partes.length == 3) {
                        String origen = partes[0].trim();
                        String destino = partes[1].trim();
                        int costo = Integer.parseInt(partes[2].trim());

                        grafo.insertarVertice(origen);
                        grafo.insertarVertice(destino);
                        grafo.insertarArista(origen, destino, costo);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * sobreescribe el archivo con la info nueva que tenga el grafo horita
     * @param archivo el lugar donde vamos a escribir los datos
     * @param grafo el grafo que tiene la red actualizada
     */
    public void actualizarRepositorio(File archivo, Grafo_Vertices grafo) {
        if (archivo == null) return;

        try (PrintWriter writer = new PrintWriter(archivo)) {
            Nodo_Vertice vActual = grafo.getpFirst();
            
            while (vActual != null) {
                Nodo_Arista aActual = vActual.getLista_Aristas().getpFirst();
                while (aActual != null) {
                    if (!aActual.getpData().visitado) {
                        writer.println(vActual.getpDato() + "," + 
                                     aActual.getpData().getpDato() + "," + 
                                     aActual.getCosto_Interaccion());
                    }
                    aActual = aActual.getpNext();
                }
                vActual.visitado = true;
                vActual = vActual.getpNext();
            }
            grafo.reinicio();
            
        } catch (Exception e) {
            System.err.println("Error al actualizar el repositorio: " + e.getMessage());
        }
    }
}