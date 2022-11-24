/*
 * 
 */
package PolinomioForma2;



/**
 *esta clase contiene todos los métodos de PolinomiosForma2
 * @author PERSONAL
 */
public class PolinomiosForma2 {
    private final Termino[] terminos;
  
    
/**
 * Este es el método constructor de un polinomio de la forma 2
 * @param terminos es un arreglo de terminos que contiene coeficiente y
 * exponente en cada posición
 */
    public PolinomiosForma2(Termino[] terminos){
    this.terminos=terminos;
    }
   /**
    * Este es un segundo constructor que no requiere de ninguna variable
    */
    public PolinomiosForma2(){
    this.terminos=null;
    }
    
    /**
     * Este Metodo obtiene el grado del polinomio
     * @return el grado del polinomio
     */
    public int getGrado(){
    return terminos[0].getExp();
    }
    /**
     * Este método convierte un polinomio forma 2 alamcenado en memoria en
     * una cadena de texto (String).
     * @return la cadena de texto
     */
    @Override
    public String toString(){
    StringBuilder polinomio=new StringBuilder();
    //Si el arreglo de terminos es nulo imprimo el valor cero como String
    if(terminos==null){
    return "0";
    }
    //Si el valor del arreglo no es nulo recorro el arreglo y voy imprimiendo uno a uno los terminos
    for (int i=0;i<terminos.length;i++){
    //Para el termino inicial se evalua si es mayor que cero para no poner el +
    if(i==0){
    int coeficiente= terminos[i].getCoef();
    int exponente=terminos[i].getExp();
      if(coeficiente>0){
          polinomio.append(coeficiente).append("x^").append(exponente);
      }else if(coeficiente<0){
          polinomio.append(coeficiente).append("x^").append(exponente);
      }
    }else{    
    int exponente=terminos[i].getExp();
    int coeficiente= terminos[i].getCoef();
    if(coeficiente>=0){
    polinomio.append("+");
    }
    polinomio.append(coeficiente).append("x^").append(exponente);
    }
    }
    return polinomio.toString();
        
    }

    /**
     * Este metodo retorna el arreglo que contiene los terminos de un polinomio
     * @return el vector terminos.
     */
    public Termino[] getTerminos(){
    return terminos;
    }
    
    /**
     * Este metodo recorre un arreglo para determinar cuantos terminos de 
     * diferente exponente hay
     * @param pT es un arreglo de terminos al cual se le va ejecutar el método
     * @return un entero que es la cantidad de terminos con distinto exponente
     */
    public int getExponentesDiferentes(Termino[] pT){
       
    //Creo la variable tamano para saber de que tamano quedara el arreglo simplificado 
    int tamano=pT.length;
    int contador=0;
        System.out.println(tamano);
    //Empiezo a recorrer el arreglo y voy comparando
    for (int i=0; i<pT.length;i++){
        for(int j=i+1; j<pT.length;j++){
            //Si los exponentes son iguales disminuyo en 1 el tamaño y asigno exponente -1 
            if(pT[i].getExp()==pT[j].getExp()) {
                contador++;
                if(pT[i].getCoef()+pT[j].getCoef()==0||pT[j].getCoef()==0||pT[i].getCoef()==0){
                    System.out.println("Entra");  
                    tamano--;
                }
                if(contador==1){
                tamano--;}
               }
               }
        contador=0;
    
    }
    return tamano;
    }
    /**
     * Este Método sirve para simplificar un polinomio almacenado en un vector 
     * de terminos, de tal forma que va a quedar con un solo termino por 
     * exponente. Requiere del método getExponentesDiferentes
     * @param pT es un vector de terminos de un polinomio.
     * @return un vector que contiene los terminos de un polinomio.
     */
    public Termino[] simplificar(Termino[] pT){
        Termino[] recorrido=pT;
      
        //Determino el tamaño del nuevo arreglo
        int tamano=getExponentesDiferentes(recorrido);
        System.out.println(tamano);
        
        Termino [] resultado= new Termino[tamano];
    int ubicacion=0;
    while (ubicacion<tamano) {   
    for(int i=0; i<pT.length;i++){
        int ci=pT[i].getCoef();
        int ei= pT[i].getExp();
        int suma=ci;
    for(int j=i+1; j<pT.length;j++){
        int ej=pT[j].getExp();
        int cj=pT[j].getCoef();
        if(ei==ej){
                suma=suma+cj;
                pT[j].setCoef(0);
                }
    }
    if(suma!=0){
    Termino t=new Termino(ei,suma);
    resultado[ubicacion]=t;
    ubicacion++;
    }
    }
    }
    return resultado;
    }
    /**
     * Este Método multiplica un objeto polinomio forma 2 instanciado por otro
     * que es solicitado en el método.
     * @param polB es un polinomior forma 2 que será multiplicado por el método
     * instanciado
     * @return polC, que es un polinomio forma 2 resultado de la multiplicación 
     */
    public PolinomiosForma2 multiplicar(PolinomiosForma2 polB){
        //Variables para manipular los terminos de los arreglos
        Termino[] terminosPolA=this.getTerminos();
        Termino[] terminosPolB=polB.getTerminos();
        //Se crea un arreglo para guardar el polinomio resultante
        Termino[] terminosPolC= new Termino[terminosPolA.length*terminosPolB.length];
        int k=0;
        for(int i=0;i<terminosPolA.length;i++){
         for(int j=0;j<terminosPolB.length;j++){
             int eC=(terminosPolA[i].getExp())+(terminosPolB[j].getExp());
             int cC=terminosPolA[i].getCoef()*terminosPolB[j].getCoef();
             terminosPolC[k]= new Termino(eC,cC);
             k++;
         }
        }
        
        
        
        Termino[] arreglo=ordenar(simplificar(eliminarNulos(terminosPolC)));
        PolinomiosForma2 polC= new PolinomiosForma2(arreglo);
        
        return polC;
    }
    
    /**
     * Este método permite evaluar un polinomio forma 2 instanciado con un 
     * valor entero. Requiere del método potencia.
     * @param x es el entero con el que se evaluará el polinomio
     * @return acum que es un entero con el resultado posterior a la evaluación
     */
    public double evaluar(double x){
    int tamano=terminos.length;
    double acum=0;
    for (int i=0; i<tamano;i++){
    int e=terminos[i].getExp();
    int c= terminos[i].getCoef();
    acum=c*potencia(x,e) + acum;
    }
    return acum;
    }
   /**
    * Se crea un metodo que calcula la potencia de un numero  con un exponente 
    * entero mayor o igual a cero 
    * @param x es el entero que se va a evaluar.
    * @param exp es la pontencia que va a ser evaluado.
    * @return acum que es el resultado de la evaluación hecha
    */
   public double potencia(double x, int exp){
   double acum =1;
   for (int i=0; i<exp;i++){
   acum=acum*x;
   }
   return acum;
   }
   /**
    * Este Método sirve para ordenar el polinomio representado como arreglo en 
    * forma descendente de los exponentes
    * @param pT es un arreglo de terminos
    * @return resultado que es un vector obtenido tras el ordenamiento de 
    * terminos.
    */
   public Termino[] ordenar(Termino[] pT){

Termino[] t= pT;

//Empiezo a comparar el primer término con los demás
int k=0;
while(k<t.length){
for (int i=k+1; i<t.length; i++){
int ek=t[k].getExp();
int ei=t[i].getExp();
//Si el exponente ek es menor que el exponente que se encuentra en la posición i que se llamo ei
if(ek<ei){
int ci= t[i].getCoef();
int ck=t[k].getCoef();
Termino tk= new Termino(ek, ck);
Termino ti= new Termino(ei, ci);
//Intercambio los valores en los términos pongo en primera posición el termino con mayor exponente
t[k].setCoef(ci);
t[k].setExp(ei);
t[i].setCoef(ck);
t[i].setExp(ek);;
}}//fin si }
//fin for }
k=k+1; //fin while}
}
return t;
}
   /**
    * Este Método recibe un arreglo de terminos  y elimina los terminos con 
    * coeficiente cero.
    * @param pT es un arreglo de terminos que se va a evaluar
    * @return resultado que es un arreglo de terminos sin los terminos nulos
    */
public Termino[] eliminarNulos(Termino[] pT){
int tamaño=pT.length;
    System.out.println(tamaño);
for(int i=0; i<pT.length; i++){
if(pT[i].getCoef()==0){
tamaño--;
}

}
    System.out.println(tamaño);
Termino [] resultado= new Termino[tamaño];
int k=0;
for(int i=0; i<pT.length; i++){
if(pT[i].getCoef()!=0){
resultado[k]=pT[i];
k++;
   }
}
return resultado;
}
   
   
 
/**
 * Se crea el metodo que calcula la derivada de un polinomio
 * @return resultado que es un objeto PolinomioForma2 que deriva un objeto 
 * polinomio forma 2 instanciado
 */
   public PolinomiosForma2 derivar(){
   int tamano= this.terminos.length;
   //Se crea el arreglo donde se almacenaran los terminos de la derivada
   Termino[] derivada= new Termino[tamano];
   for(int i=0; i<tamano; i++){
   int c=terminos[i].getCoef();
   int e=terminos[i].getExp();
   Termino t= new Termino(e-1, c*e);
   derivada[i]=t;
   }
   //Se crea el objeto polinomio Forma2 donde se almacenara el resultado
   PolinomiosForma2 resultado= new PolinomiosForma2((eliminarNulos(derivada)));
   return resultado;        
   }
   

}
