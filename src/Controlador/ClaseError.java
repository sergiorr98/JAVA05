/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Date;

/**
 *
 * @author Sergio
 */
class ClaseError {
        
    String mensaje="";
    Date fecha = new Date();
    protected String devolverError(int codigoError)
    {
       String fechaCompleta=""+fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+fecha.getYear();
       String hora = ""+fecha.getHours()+":"+fecha.getMinutes();
        
       switch (codigoError)
       {
           case 1:
                mensaje = "Error en la base de datos "+fechaCompleta+" "+hora;
                return mensaje;
           case 2:
                mensaje = "Error en la fecha"+fechaCompleta+" "+hora;;
                return mensaje;
           case 3:
                mensaje = "Error en el DNI"+fechaCompleta+" "+hora;;
                return mensaje;
                     
       }
       mensaje = "Error inesperado";
       return mensaje;
    }
}
