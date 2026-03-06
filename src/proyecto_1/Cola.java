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
 * esta clase es para armar una cola normalita de toda la vida
 * sirve para ir guardando los nodos y sacarlos en orden
 * * @author coco
 */
public class Cola {
    NodoCola pFirst;
    NodoCola pLast;
    
    /**
     * el constructor que pone todo en null para empezar de cero
     */
    public Cola(){
        pFirst = null;
        pLast = null;
    }
    
    /**
     * mete un dato nuevo al final de la fila
     * @param dato el vertice que queremos encolar
     */
    public void encolar(Nodo_Vertice dato){
        NodoCola nuevo = new NodoCola(dato);
        if(this.pFirst != null){
            this.pLast.setpNext(nuevo);
            this.pLast = nuevo;
        }else{
            this.pFirst = this.pLast =nuevo;
                   
        }
    }
    
    /**
     * saca al primero de la cola porque ya le toca
     * @return el nodo que estaba de primero o null si no hay nadie
     */
    public NodoCola desencolar(){
        if(this.pFirst != null){
            NodoCola temp = this.pFirst;
            this.pFirst = this.pFirst.getpNext();
            return temp;
        }
        return null;
    }
}