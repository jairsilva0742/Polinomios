/*

 */

package PolinomioForma2;


/**
 * Esta clase crea objetos tipo Nodo que contienen la liga y el polinomio
 * @author PERSONAL
 */
public class Nodo {
    
    private Termino t;
    private Nodo liga;
    
    public Nodo(Termino t){
        this.t = t;
        liga = null;
    }

    public Termino getT() {
        return t;
    }

    public void setT(Termino t) {
        this.t = t;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
    
}
