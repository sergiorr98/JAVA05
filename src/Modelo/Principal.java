package Modelo;


import Vista.VentanaPrincipal;
import java.io.IOException;
import javax.swing.JPanel;



public class Principal {

   
    private static VentanaPrincipal prog = new VentanaPrincipal();//Objeto de VentanaPrincipal

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                prog.setVisible(true);
            }
        });
            
          
    }
    //Metodo para devolver el objeto creado anteriormente
    public  static VentanaPrincipal devolverVentana()
    {
        return prog;
    }
    
    //Metodo para cambio de panel
    public static void cambioDePanel (JPanel a)
    {
         prog.setContentPane(a);
         prog.pack();
    }
    
}
