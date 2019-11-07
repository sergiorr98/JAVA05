/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Sergio
 */
class ClaseError {
        
    String mensaje="";
    
    protected String devolverError(int codigoError)
    {
       switch (codigoError)
       {
           case 1:
                mensaje = "Error en la base de datos";
                return mensaje;
           case 2:
                mensaje = "Error en el DNI";
                return mensaje;
           case 3:
                mensaje = "Error en la fecha";
                return mensaje;
                     
       }
       mensaje = "Error inesperado";
       return mensaje;
    }
}
