/*
 
 */
package PolinomioForma2;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 *  
 * @author PERSONAL
 */

public class MainForma2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<PolinomiosForma2> ListaPolinomios= new ArrayList<>();
        JOptionPane.showMessageDialog(null, "El siguiente programa se usa usa para almacenar, multiplicar, derivar y evaluar polinomios usando vector forma 2.");
        JOptionPane.showMessageDialog(null, "El polinimio debe ser de la forma 52x^2 + 25x^1 + 65, Tenga en cuenta que NO se pueden ingresar términos con igual exponente. Ademas solo recibe como variable x, exponentes positivos de hasta dos digitos","Instrucciones Iniciales",JOptionPane.WARNING_MESSAGE,null); 
        MenuPrincipal(ListaPolinomios);
  
        

    }
       
 /**    
  * Este método contiene el menu principal y a partir de este se traen todos
  * los métodos estaticos que desarrollan el programa. Para los métodos de
  * Derivar y evaluar se instancia un polinomio de la clase PolinomiosForma2
  * @param ListaPolinomios es la variable tipo lista dinámica que almacena todos
  * los polinomios
  * 
  */   
private static void MenuPrincipal(ArrayList<PolinomiosForma2> ListaPolinomios){
    
    
     
     Boolean ejecutar=true;   
     while(ejecutar){
        String [] Menu={"Almacenar Polinomio","Mostrar todos los polinomios","Multiplicar dos polinomios","Derivar Polinomios","Evaluar polinomio","Salir"};
        //La variable MenuEscogido me almacena la selección del usuario en la ventana
        String MenuEscogido=(String)JOptionPane.showInputDialog(null,"Seleccione la opcion que ejecutará", "MENU PRINCIPAL", 0,null,Menu,Menu[0]);
        try{
        if(MenuEscogido.equals("Almacenar Polinomio")){
            try{
            segundaVentana(ListaPolinomios);}catch(java.lang.UnsupportedOperationException exception){
            }
            break;
            
        }else if(MenuEscogido.equals("Mostrar todos los polinomios")){
            TerceraVentana(ListaPolinomios);
            for(int i=0;i<ListaPolinomios.size();i++){
                System.out.println("El polinomio en la posición "+i+" es: ");
            System.out.println(ListaPolinomios.get(i).toString());
                System.out.println("");
            }
        }else if(MenuEscogido.equals("Multiplicar dos polinomios")){
             
             try{
            primeraVentana(ListaPolinomios);}catch(java.lang.UnsupportedOperationException exception){
            }
             
             break;
        }else if(MenuEscogido.equals("Derivar Polinomios")){
            try{
            String cadena=TerceraVentanaMod(ListaPolinomios);
            PolinomiosForma2 PolDer= new PolinomiosForma2(leer(cadena));
            cuartaVentana(PolDer,ListaPolinomios);}catch(java.lang.ArrayIndexOutOfBoundsException exception){VentanaErrorVacio();}
            break;
        }else if(MenuEscogido.equals("Evaluar polinomio")){
            try{
            String cadena=TerceraVentanaMod(ListaPolinomios);
            PolinomiosForma2 PolEv= new PolinomiosForma2(leer(cadena));
            quintaVentana(PolEv,ListaPolinomios);}catch(java.lang.ArrayIndexOutOfBoundsException exception){VentanaErrorVacio();}
            break;
        }else{
            break;
        }}catch(java.lang.NullPointerException exception){}
     }
       
   
}

  /**
   * Este método estatico sirve para mostrar la ventana de multiplicación. 
   * Unicamente posiciona los métodos, llama los métodos que posiciona todo y 
   * las acciones
   * @param ListaPolinomios es la variable tipo lista dinámica que almacena todos
  * los polinomios
   */  
 
private static void primeraVentana(ArrayList<PolinomiosForma2> ListaPolinomios) {

          //Segunda ventana
          JFrame frame1 = new JFrame("MULTIPLICACION");
        
        frame1.setSize(530, 220);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();    
        
        frame1.add(panel);
         placeComponents(panel,ListaPolinomios);  
        frame1.setVisible(true);     
        
    }

    /**
     * Este método sirve para posicionar todos los botones y campos de texto de
     * la Ventana 1 o de multipliación. Además, contiene todas las acciones de
     *los botones. Este método llama otros métodos para las acciones. 
     * @param panel1 es el panel creado para la primera ventana
     * @param ListaPolinomios es la variable tipo lista dinámica que almacena todos
  * los polinomios
     */
    private static void placeComponents(JPanel panel1,ArrayList<PolinomiosForma2> ListaPolinomios) {
        
        panel1.setLayout(null);
        panel1.setBackground(Color.blue);
              
        
        JLabel Pol1Label = new JLabel("Polinomio 1");
        Pol1Label.setBounds(10,20,80,25);
        panel1.add(Pol1Label);

        JTextField TextoPolinomioA = new JTextField(20);
        TextoPolinomioA.setBounds(100,20,195,25);
        panel1.add(TextoPolinomioA);
        
        JButton BotonPolA = new JButton("Ingresar");
        BotonPolA.setBounds(305, 20, 90, 25);
        panel1.add(BotonPolA);

        
        JLabel Pol2Label = new JLabel("Polinomio 2");
        Pol2Label.setBounds(10,50,80,25);
        panel1.add(Pol2Label);
        
        JTextField TextoPolinomioB = new JTextField(20);
        TextoPolinomioB.setBounds(100,50,195,25);
         TextoPolinomioB.setEditable(false);
        panel1.add(TextoPolinomioB);
        
        JButton BotonPolB = new JButton("Ingresar");
        BotonPolB.setBounds(305, 50, 90, 25);
        panel1.add(BotonPolB);
        BotonPolB.setEnabled(false);
        
         JLabel Pol3Label = new JLabel("P. Resultado");
        Pol3Label.setBounds(10,110,80,25);
        panel1.add(Pol3Label);

        JTextField TextoPolinomioC = new JTextField(20);
        TextoPolinomioC.setBounds(100,110,310,25);
         TextoPolinomioC.setEditable(false);
        panel1.add(TextoPolinomioC);
        
        JButton BotonMultiplicacion = new JButton("Multiplicación");
        BotonMultiplicacion.setBounds(40, 80, 120, 25);
        panel1.add(BotonMultiplicacion);  
        BotonMultiplicacion.setEnabled(false);
        
        JButton BotonMenuPral = new JButton("Inicio");
        BotonMenuPral.setBounds(180, 80, 120, 25);
        panel1.add(BotonMenuPral);
        BotonMenuPral.setEnabled(false);
        
        
        
                
        BotonPolA.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            
            String cadena=TextoPolinomioA.getText();
            Termino[] nuevo=leer(cadena);
            PolinomiosForma2 polA=new PolinomiosForma2(nuevo);
            ListaPolinomios.add(polA);
            
            
            
              if(TextoPolinomioA.getText().equalsIgnoreCase("")){
              TextoPolinomioB.setEditable(false);
        }else{
            TextoPolinomioB.setEditable(true);
            BotonPolB.setEnabled(true);
            TextoPolinomioA.setEditable(false);
            BotonPolA.setEnabled(false);
        };} 
        
        });
        
        BotonPolB.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            String cadena=TextoPolinomioB.getText();
            Termino[] nuevo1=leer(cadena);
            PolinomiosForma2 polB=new PolinomiosForma2(nuevo1);  
            ListaPolinomios.add(polB);
            
                    
                      
              if(TextoPolinomioB.getText().equalsIgnoreCase("")){
              TextoPolinomioB.setEditable(true);
              BotonPolB.setEnabled(true);
        }else{
            TextoPolinomioB.setEditable(false);
            BotonPolB.setEnabled(false);
            BotonMultiplicacion.setEnabled(true);
        };}
                
        });
        
         BotonMultiplicacion.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            PolinomiosForma2 polC=ListaPolinomios.get(ListaPolinomios.size()-1).multiplicar(ListaPolinomios.get(ListaPolinomios.size()-2));
            TextoPolinomioC.setText(polC.toString());
            ListaPolinomios.add(polC);
            BotonMultiplicacion.setEnabled(false);
            BotonMenuPral.setEnabled(true);
         ;} 
        
        });
         
         BotonMenuPral.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            MenuPrincipal(ListaPolinomios);
            
            
         ;} 

           
        
        });

    }


/**
 * Este método estático muestra la segunda ventana y que es de almacenamiento, 
 * ademas tambien posiciona los elementos de la ventana(Botones, Label, campos de 
 * texto).Finalmente, contiene las acciones de los distintos Botones
 * @param ListaPolinomios es la variable tipo lista dinámica que almacena todos
  * los polinomios
 */
public static void segundaVentana(ArrayList<PolinomiosForma2> ListaPolinomios) {

          //Segunda ventana
           JFrame frame1 = new JFrame("ALMACENAMIENTO");
        
        frame1.setSize(500, 200);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();    
        
        frame1.add(panel1);
        frame1.setVisible(true);  
        
        panel1.setLayout(null);
            panel1.setBackground(Color.gray);
        
        JLabel PolAlmacenar = new JLabel("Polinomio");
        PolAlmacenar.setBounds(10,20,80,25);
        panel1.add(PolAlmacenar);

        JTextField TextoPolinomio = new JTextField(20);
        TextoPolinomio.setBounds(100,20,305,25);
        panel1.add(TextoPolinomio);
        TextoPolinomio.setEditable(true);
        
        JButton BotonIngresar = new JButton("Almacenar");
        BotonIngresar.setBounds(50, 60, 100, 25);
        panel1.add(BotonIngresar);
        BotonIngresar.setEnabled(true);
        
        JButton BotonIngresarOtro = new JButton("Almacenar Otro");
        BotonIngresarOtro.setBounds(290, 60, 130, 25);
        panel1.add(BotonIngresarOtro);
        BotonIngresarOtro.setEnabled(false);
        
        JButton BotonMenuPral = new JButton("Inicio");
        BotonMenuPral.setBounds(175, 60, 100, 25);
        panel1.add(BotonMenuPral);
        BotonMenuPral.setEnabled(true);
        
         BotonIngresar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            if(TextoPolinomio.getText().equals("")){
            }else{
            PolinomiosForma2 Nuevo=new PolinomiosForma2((leer(TextoPolinomio.getText())));
            ListaPolinomios.add(Nuevo);
            int pos=ListaPolinomios.lastIndexOf(Nuevo);
                BotonIngresarOtro.setEnabled(true);
                BotonIngresar.setEnabled(false);
                TextoPolinomio.setEditable(false);
            }        
                    ;}});
         
                  BotonIngresarOtro.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            
                BotonIngresarOtro.setEnabled(false);
                BotonIngresar.setEnabled(true);
                TextoPolinomio.setText("");
                TextoPolinomio.setEditable(true);
                   
                    ;}});

        
         BotonMenuPral.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            MenuPrincipal(ListaPolinomios);
           
            
         ;} 

            
        
        });
        
    }
/**
 * Este método estático muestra la ventana que contiene una lista desplegable
 * con todos los polinomios que estan almacenados en el arreglo de polinomios.
 * @param ListaPolinomios es la variable tipo lista dinámica que almacena todos
  * los polinomios
 */
private static void TerceraVentana(ArrayList<PolinomiosForma2> ListaPolinomios) {

          //Segunda ventana
          
        String [] Polinomios=new String[ListaPolinomios.size()];
        
        for(int i=0;i<ListaPolinomios.size();i++){ 
        
        Polinomios[i]=ListaPolinomios.get(i).toString();
        }//El array aqui creado muestra todos los Polinomios almecenados
        String MenuEscogido=(String)JOptionPane.showInputDialog(null,"Verifique los Polinomios almacenados", "POLINOMIOS ALMACENADOS", 0,null,Polinomios,Polinomios[0]);
        
        
               
    }

/**
 * Este método estático es una modificación del metodo terceraVentana en algunos
 * textos con instrucción para el usuario, muestra tambien todos lo polinomios 
 * almacenados, pero para que el usuario escoja el que desea derivar.
 * @param ListaPolinomios es la variable tipo lista dinámica que almacena todos
  * los polinomios
 * @return MenuEscogido que es la variable que contiene el polinomio que el 
 * usuario desea derivar
 */

private static String TerceraVentanaMod(ArrayList<PolinomiosForma2> ListaPolinomios) {

          //Segunda ventana
          
        String [] Polinomios=new String[ListaPolinomios.size()];
        
        for(int i=0;i<ListaPolinomios.size();i++){ 
        Polinomios[i]=ListaPolinomios.get(i).toString();
        }//El array aqui creado muestra todos los Polinomios almecenados
        String MenuEscogido=(String)JOptionPane.showInputDialog(null,"Seleccione el polinomio a Derivar o Evaluar", "POLINOMIOS ALMACENADOS", 0,null,Polinomios,Polinomios[0]);
        
        
        return MenuEscogido;       
    }
/**
 * Este Método estático muestra la ventana de derivada. Este método contiene el 
 * posicionamiento de todos los elementos de la ventana (botones, Label, campos 
 * de texto), y además tiene los métodos de los botones.
 * @param PolDer es un objeto de la clase PolinomioForma2 que es instanciado en 
 * la clase MenuPrincipal. Se obtiene de una selección hecha por el usuario
 * @param ListaPolinomios es la variable tipo lista dinámica que almacena todos
  * los polinomios
 */
private static void cuartaVentana(PolinomiosForma2 PolDer,ArrayList<PolinomiosForma2> ListaPolinomios) {

          //Segunda ventana
          JFrame frame3 = new JFrame("DERIVAR");
        
        frame3.setSize(500, 180);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel3 = new JPanel();    
        
        frame3.add(panel3);
        frame3.setVisible(true);  
        
        panel3.setLayout(null);
        
        JLabel PolDerLabel = new JLabel("Polinomio 1");
        PolDerLabel.setBounds(10,20,80,25);
        panel3.add(PolDerLabel);

        JTextField TextoPolinomioDer = new JTextField(20);
        TextoPolinomioDer.setBounds(100,20,305,25);
        panel3.add(TextoPolinomioDer);
        TextoPolinomioDer.setText(PolDer.toString());
        TextoPolinomioDer.setEditable(false);
        
        JButton BotonDerivar = new JButton("Derivar");
        BotonDerivar.setBounds(60, 50, 100, 25);
        panel3.add(BotonDerivar);
        BotonDerivar.setEnabled(true);
        
        JButton MenuPral = new JButton("Inicio");
        MenuPral.setBounds(180, 50, 100, 25);
        panel3.add(MenuPral);
        MenuPral.setEnabled(false);
        
        JLabel PolResulLabel = new JLabel("Polinomio 1");
        PolResulLabel.setBounds(10,80,80,25);
        panel3.add(PolDerLabel);

        JTextField TextoResulDer = new JTextField(20);
        TextoResulDer.setBounds(100,80,305,25);
        panel3.add(TextoResulDer);
        TextoResulDer.setEditable(false);
        
         BotonDerivar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            
            TextoResulDer.setText(PolDer.derivar().toString());
            ListaPolinomios.add(PolDer.derivar());
            MenuPral.setEnabled(true);
            BotonDerivar.setEnabled(false);
            
           
         ;}}); 
         MenuPral.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            
           MenuPrincipal(ListaPolinomios);
            
           
         ;}}); 
    }
/**
 * Este Método estático muestra la ventana para Evaluar un polinomio. Este
 * método contiene elposicionamiento de todos los elementos de la ventana 
 * (botones, Label, campos de texto), y además tiene los métodos de los botones.
 * @param PolEv es un objeto de la clase PolinomioForma2 que es instanciado en 
 * la clase MenuPrincipal. Se obtiene de una selección hecha por el usuario
 * @param ListaPolinomios es la variable tipo lista dinámica que almacena todos
  * los polinomios
 */
private static void quintaVentana(PolinomiosForma2 PolEv,ArrayList<PolinomiosForma2> ListaPolinomios) {

          //Segunda ventana
          JFrame frame4 = new JFrame("EVALUAR");
        
        frame4.setSize(500, 250);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel4 = new JPanel();    
        
        frame4.add(panel4);
        frame4.setVisible(true);  
        
        panel4.setLayout(null);
        
        JLabel PolEvLabel = new JLabel("Polinomio");
        PolEvLabel.setBounds(10,20,100,25);
        panel4.add(PolEvLabel);
        

        JTextField TextoPolinomioDer = new JTextField(20);
        TextoPolinomioDer.setBounds(120,20,305,25);
        panel4.add(TextoPolinomioDer);
        TextoPolinomioDer.setText(PolEv.toString());
        TextoPolinomioDer.setEditable(false);
        
         JLabel Presentacion = new JLabel("Por favor introduzca el numero con el que evaluará el polinomio");
        Presentacion.setBounds(30,50,380,25);
        panel4.add(Presentacion);
        
        JLabel Escalar = new JLabel("Num. a evaluar");
        Escalar.setBounds(10,80,100,25);
        panel4.add(Escalar);
        

        JTextField EscalarText = new JTextField(20);
        EscalarText.setBounds(120,80,50,25);
        panel4.add(EscalarText);
        EscalarText.setEditable(true);
        
                
        JButton BotonEvaluar = new JButton("Evaluar");
        BotonEvaluar.setBounds(100, 110, 100, 25);
        panel4.add(BotonEvaluar);
        BotonEvaluar.setEnabled(true);
        
        JButton BotonMenuPral = new JButton("Inicio");
        BotonMenuPral.setBounds(230, 110, 100, 25);
        panel4.add(BotonMenuPral);
        BotonMenuPral.setEnabled(true);
        
        JLabel PolResulLabel = new JLabel("Resultado");
        PolResulLabel.setBounds(10,140,100,25);
        panel4.add(PolResulLabel);

        JTextField TextoResulEv = new JTextField(20);
        TextoResulEv.setBounds(120,140,305,25);
        panel4.add(TextoResulEv);
        TextoResulEv.setEditable(false);
        
         BotonEvaluar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            double num=Double.parseDouble(EscalarText.getText());
            System.out.println("funciona**");
            TextoResulEv.setText(Double.toString(PolEv.evaluar(num)));
            BotonEvaluar.setEnabled(false);
           
         ;}}); 
         
           BotonMenuPral.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            MenuPrincipal(ListaPolinomios);
            dispose();
            
         ;} 

        
            private void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        
        });
        
    }
/**
 * Este Método estático sirve para leer la cadena de String que el usuario pone
 * en los campos de texto, de tal forma que los valores de interes como 
 * coeficiente y exponente quedan almacenados en un vector de tipo Termino.
 * @param cadena es la cadena de texto obtenida del campo de texto
 * @return terminos que es un arreglo que contiene en cada posición un
 * coeficiente y un exponente.
 */
public static Termino[] leer(String cadena){
    int CantTerminos=1;
            char c1='+';
            char c2='-';
            char c3='x';
            char c4='^';
            char c5='0';
            char c6='1';
            char c7='2';
            char c8='3';
            char c9='4';
            char c10='5';
            char c11='6';
            char c12='7';
            char c13='8';
            char c14='9';
            
    for (int i = 1; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            
            //Desde este for pongo la restricción de que solo acepta numeros, x, +,- y ^-
            
            if(c==c1||c==c2||c==c3||c==c4||c==c5||c==c6||c==c7||c==c8||c==c9||c==c10||c==c11||c==c12||c==c13||c==c14){
            if(c==c1){
                CantTerminos++;
            }else if(c==c2){
                CantTerminos++;
            }}else{
                VentanaErrorIngreso();
                throw new NumberFormatException();
                
                
            }
            
                
            //Los terminos aumentan si hay un + o un -
}
    
    Termino[] terminos=new Termino[CantTerminos];
    StringBuilder Provisional= new StringBuilder();
    int j=0;
    int z=1;
for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            try{           
            if(c==c3){
                int b=0;
                int a=Integer.parseInt(Provisional.toString())*z;
                terminos[j] = new Termino(b,a);
                               
                Provisional.delete(0,Provisional.length());
                
            }
           
            else if(c==c4){
                i++;
                c = cadena.charAt(i);
                Provisional.append(c);
                if(i<cadena.length()-1){
                i++;
                c = cadena.charAt(i);
                if(c==c5||c==c6||c==c7||c==c8||c==c9||c==c10||c==c11||c==c12||c==c13||c==c14){
                    Provisional.append(c);
                    
                }else{
                i--;}}
                
                                           
                terminos[j].setExp(Integer.parseInt(Provisional.toString()));
                Provisional.delete(0,Provisional.length());
                j++;
            }else if(c==c1){
               z=1;
            }else if(c==c2){
                z=-1;
            }
            
            else{
                Provisional.append(c);
                
            }}catch(java.lang.NumberFormatException exception){VentanaErrorFormaIngreso();}
}
if(Provisional.toString().equalsIgnoreCase("")){
   
}else{
                                
                int b=0;
                int a=Integer.parseInt(Provisional.toString())*z;
                terminos[j] = new Termino(b,a);
                
}
return terminos;}
/**
 * Este Método muestra una ventana de advertencia al usuario cuando ingresa mal un valor
 */
private static void VentanaErrorIngreso() {
    JOptionPane.showMessageDialog(null, "Recuerde la forma del polinomio, solo debe incluir numeros,x, y ^. Revise porfavor","ERROR DE INGRESO",JOptionPane.WARNING_MESSAGE,null);
}
private static void VentanaErrorVacio() {
    JOptionPane.showMessageDialog(null, "Recuerde que debe primero almacenar polinomios","ERROR de MEMORIA",JOptionPane.WARNING_MESSAGE,null);
}
private static void VentanaErrorFormaIngreso() {
    JOptionPane.showMessageDialog(null, "Recuerde que el polinomio es de la forma 1x^2 + 25x^1 + 65; revise por favor el polinomio","ERROR de MEMORIA",JOptionPane.WARNING_MESSAGE,null);
}
}
