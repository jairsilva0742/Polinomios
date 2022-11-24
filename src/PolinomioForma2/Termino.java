/*

 */

package PolinomioForma2;

/**
 * Esta clase crea objetos tipo termino que tienen coeficiente y exponente de 
 * los polinomios
 * @author PERSONAL
 */
public class Termino {
    
    public int exp;
    public int coef;

    public Termino(int exp, int coef) {
        this.exp = exp;
        this.coef = coef;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

}
