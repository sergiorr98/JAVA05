
package Controlador;

/**
 *
 * @author Sergio
 */
public class Errores extends Exception {

    protected int codigoError; //Codigo que se le pasa a la clase errores 
    
    public Errores(int codigoError) {
        this.codigoError = codigoError;
    }
    
    //Metodo que se le pasa el codigo de error, que se lo pasa a los de metodos de la clase ClaseError y posteriormente se muestra el mensaje por pantalla
    public void queError(int codigoError)
    {
        ClaseError error = new ClaseError();
        
        String mensaje=error.devolverError(codigoError);
        
        error.escribirFicheroLog(codigoError);
        
        System.out.println(mensaje);
    }
 
    
}
