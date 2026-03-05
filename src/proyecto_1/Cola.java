/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_1;

/**
 *
 * @author coco
 */
public class Cola {
    NodoCola pFirst;
    NodoCola pLast;
    
    public Cola(){
        pFirst = null;
        pLast = null;
    }
    
    public void encolar(Nodo_Vertice dato){
        NodoCola nuevo = new NodoCola(dato);
        if(this.pFirst != null){
            this.pLast.setpNext(nuevo);
            this.pLast = nuevo;
        }else{
            this.pFirst = this.pLast =nuevo;
                   
        }
    }
    
    public NodoCola desencolar(){
        if(this.pFirst != null){
            NodoCola temp = this.pFirst;
            this.pFirst = this.pFirst.getpNext();
            return temp;
        }
        return null;
    }
}
