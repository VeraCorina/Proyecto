/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

/**
 * esta clase es la que hace la magia de leer y escribir los archivos csv
 * para no estar metiendo proteinas una por una como un loco.
 * maneja el explorador de archivos para que se vea mas pro.
 * @author Nato
 */
public class ManejadorArchivos {

    /**
     * este metodo abre el archivo y lee linea por linea para separar las
     * proteinas y el peso de la interaccion usando el delimitador de coma.
     * @param rutaArchivo es el file que el usuario eligio en el buscador.
     * @param grafoRed es el grafo donde vamos a ir metiendo todo lo que leamos.
     */
    public void importarDatosBio(File rutaArchivo, Grafo_Vertices grafoRed) {
        String textoFila;
        String delimitador = ",";

        try (BufferedReader lectorBuffer = new BufferedReader(new FileReader(rutaArchivo))) {
            while ((textoFila = lectorBuffer.readLine()) != null) {
                if (!textoFila.trim().isEmpty()) {
                    String[] columnas = textoFila.split(delimitador);
                    
                    if (columnas.length >= 3) {
                        String proteinaA = columnas[0].trim();
                        String proteinaB = columnas[1].trim();
                        int pesoInteraccion = Integer.parseInt(columnas[2].trim());
                        
                        grafoRed.insertarVertice(proteinaA);
                        grafoRed.insertarVertice(proteinaB);
                        grafoRed.insertarArista(proteinaA, proteinaB, pesoInteraccion);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Red metabólica cargada correctamente.");
        } catch (Exception error) {
            System.out.println("Error en lectura: " + error.getMessage());
        }
    }

    /**
     * sirve para guardar el estado actual del grafo en un archivo de texto
     * recorre todos los nodos y sus aristas para no dejar nada por fuera.
     * @param rutaArchivo la ruta donde se va a crear o sobreescribir el archivo.
     * @param grafoRed el objeto grafo que tiene toda la info de la red.
     */
    public void exportarDatosBio(File rutaArchivo, Grafo_Vertices grafoRed) {
        grafoRed.reinicio();
        
        try (PrintWriter escritor = new PrintWriter(new FileWriter(rutaArchivo, false))) {
            Nodo_Vertice vActual = grafoRed.getpFirst();
            
            while (vActual != null) {
                Nodo_Arista aActual = vActual.getLista_Aristas().getpFirst();
                
                while (aActual != null) {
                    if (!aActual.getpData().visitado) {
                        escritor.println(vActual.getpDato() + "," + 
                                       aActual.getpData().getpDato() + "," + 
                                       aActual.getCosto_Interaccion());
                    }
                    aActual = aActual.getpNext();
                }
                vActual.visitado = true;
                vActual = vActual.getpNext();
            }
            
            grafoRed.reinicio();
            JOptionPane.showMessageDialog(null, "Repositorio actualizado exitosamente.");
            
        } catch (IOException error) {
            System.out.println("Error en escritura: " + error.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar el archivo.");
        }
    }

    /**
     * este es el que lanza el buscador de archivos (el cuadrito de windows)
     * para que el usuario busque su archivo .csv comodamente.
     * @param grafoRed el grafo que va a recibir los datos despues de elegir el file.
     */
    public void ejecutarSelectorCarga(Grafo_Vertices grafoRed) {
        JFileChooser explorador = new JFileChooser();
        FileNameExtensionFilter filtroCsv = new FileNameExtensionFilter("Archivos de Datos (*.csv)", "csv");
        explorador.setFileFilter(filtroCsv);

        int seleccion = explorador.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoElegido = explorador.getSelectedFile();
            importarDatosBio(archivoElegido, grafoRed);
        }
    }
    
    /**
     * saca el menu para guardar el archivo y se asegura de que 
     * el nombre termine en .csv aunque el usuario se olvide de ponerlo.
     * @param grafoRed el grafo que queremos exportar al disco duro.
     */
    public void ejecutarSelectorGuardado(Grafo_Vertices grafoRed) {
        if (grafoRed == null || grafoRed.getpFirst() == null) {
            JOptionPane.showMessageDialog(null, "No hay datos en el grafo para guardar.");
            return;
        }

        JFileChooser salvador = new JFileChooser();
        salvador.setDialogTitle("Guardar Repositorio de Proteínas");
        
        FileNameExtensionFilter filtroCsv = new FileNameExtensionFilter("Archivo CSV (*.csv)", "csv");
        salvador.setFileFilter(filtroCsv);

        int seleccion = salvador.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File rutaDestino = salvador.getSelectedFile();
            
            String rutaStr = rutaDestino.getAbsolutePath();
            if (!rutaStr.toLowerCase().endsWith(".csv")) {
                rutaDestino = new File(rutaStr + ".csv");
            }

            exportarDatosBio(rutaDestino, grafoRed);
        }
    }
}