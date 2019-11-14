
package Modelo;

import Controlador.Errores;
import com.aeat.valida.Validador;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Sergio
 */
public class Medico {
    protected int cod_med; //Codigo de medico
    protected String nif_med; //Nif de medico (9 caracteres)
    protected int comp_med; //FK de la clase "COMPAÑIA"
    protected String nombre_med; //Nombre de medico
    protected Date fecha_med; //Fecha
    protected int precioHora_med; //Precio por hora

    public Medico(int cod_med, String nif_med, int comp_med, String nombre_med, Date fecha_med, int precioHora_med) throws Errores {
        this.cod_med = cod_med;
        setNif_med(nif_med);
        this.comp_med = comp_med;
        this.nombre_med = nombre_med;
        this.fecha_med = fecha_med;
        this.precioHora_med = precioHora_med;
    }
    
    public Medico()
    {
        
    }

    public int getCod_med() {
        return cod_med;
    }

    public void setCod_med(int cod_med) {
        this.cod_med = cod_med;
    }

    public String getNif_med() {
        return nif_med;
    }

    public void setNif_med(String nif_med) throws Errores {
        Validador val =  new Validador();
        int resultado = val.checkNif(nif_med);
        if (resultado > 0)
            this.nif_med = nif_med;
        else
            throw new Errores(3);

    }

    public int getComp_med() {
        return comp_med;
    }

    public void setComp_med(int comp_med) {
        this.comp_med = comp_med;
    }

    public String getNombre_med() {
        return nombre_med;
    }

    public void setNombre_med(String nombre_med) {
        this.nombre_med = nombre_med;
    }

    public Date getFecha_med() {
        return fecha_med;
    }

    public void setFecha_med(Date fecha_med) {
        this.fecha_med = fecha_med;
    }

    public int getPrecioHora_med() {
        return precioHora_med;
    }

    public void setPrecioHora_med(int precioHora_med) {
        this.precioHora_med = precioHora_med;
    }
    
        
    //Metodo para comprobar fecha
    public void comprobarFecha (GregorianCalendar fecha, String f) throws Errores
    {   
        
        //Recogemos la fecha actual en un vector de String con el separador que utilice
        String fechaDevuelta[] = f.split("-");
        Date fechaElegida = fecha.getTime(); //Recogemos en tipo Date la fecha nueva
        
        //Pasamos la fecha actuala GregorianCalendar y despues a tipo Date para despues comprobar
        GregorianCalendar fechaMedico = new GregorianCalendar(Integer.parseInt(fechaDevuelta[0]),(Integer.parseInt(fechaDevuelta[1]))-1, Integer.parseInt(fechaDevuelta[2]));
       
        Date fechaActual = fechaMedico.getTime();

        //Si la fecha es mas pequeña que la actual se lanza el error
        if (fechaElegida.before(fechaActual))
            throw new Errores(2);

    }
    
    
    
    
}

