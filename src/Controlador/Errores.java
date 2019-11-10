
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
    
    public void queError(int codigoError)
    {
        ClaseError error = new ClaseError();
        
        String mensaje=error.devolverError(codigoError);
        
        System.out.println(mensaje);
    }
    
    
    
    
}
