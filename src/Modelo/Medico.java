
package Modelo;

import java.util.Date;

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

    public Medico(int cod_med, String nif_med, int comp_med, String nombre_med, Date fecha_med, int precioHora_med) {
        this.cod_med = cod_med;
        this.nif_med = nif_med;
        this.comp_med = comp_med;
        this.nombre_med = nombre_med;
        this.fecha_med = fecha_med;
        this.precioHora_med = precioHora_med;
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

    public void setNif_med(String nif_med) {
        this.nif_med = nif_med;
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
    
    
    
    
    
}

