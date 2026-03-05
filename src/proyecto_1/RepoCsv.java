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
 *
 * @author Nato
 */
public class RepoCsv {

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
