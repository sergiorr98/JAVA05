/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
class ClaseError {
        
    String mensaje="";
    Date fecha = new Date();
    //Metodo que recibe el codigo de error, lo monta con la fecha y hora y lo devuelve
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
                mensaje = "Error en la fecha "+fechaCompleta+" "+hora;;
                return mensaje;
           case 3:
                mensaje = "Error en el DNI "+fechaCompleta+" "+hora;;
                return mensaje;
                     
       }
       mensaje = "Error inesperado";
       return mensaje;
    }
    
    //Metodo que recibe el codigo de error y lo escribe en un fichero log
    protected void escribirFicheroLog (int codigoError)
    {

            try {
                FileWriter archivo = new FileWriter(new File("log.txt"),true);
                        
                Date fecha = new Date();
                
                String fechaCompleta=""+fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+fecha.getYear();
                String hora = ""+fecha.getHours()+":"+fecha.getMinutes();
                
                switch (codigoError)
                {
                    case 1:
                        mensaje = "Error en la base de datos "+fechaCompleta+" "+hora;
                        break;
                    case 2:
                        mensaje = "Error en la fecha "+fechaCompleta+" "+hora;
                        break;
                    case 3:
                        mensaje = "Error en el DNI "+fechaCompleta+" "+hora;
                        break;
                }
                
                archivo.write(mensaje);
                archivo.write("\n");
                archivo.close();

            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
    }

}
