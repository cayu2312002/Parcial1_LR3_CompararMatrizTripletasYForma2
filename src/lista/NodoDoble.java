package lista;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import matricesDispersas.Tripleta;

/**
 *
 */
public class NodoDoble {
    NodoDoble anterior, siguiente;
    Tripleta dato;
    
    public NodoDoble(Tripleta d){
        anterior = siguiente = null;
        dato = d;
    }
    
    public void asignaLI(NodoDoble x){
        anterior = x;
    }
    
    public void asignaLD(NodoDoble x){
        siguiente = x;
    }
    
    public void asignaDato(Tripleta d){
        dato = d;
    }
    
    public Tripleta retornaDato(){
        return dato;
    }
    
    public NodoDoble retornaLD(){
        return siguiente;
    }
    
    public NodoDoble retornaLI(){
        return anterior;
    }
}
