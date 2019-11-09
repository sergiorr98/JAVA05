
package Modelo;

/**
 *
 * @author Sergio
 */
public class Consulta {
    protected int med_con; //FK de la tabla MEDICO
    protected int pac_con; //FK de la tabla PACIENTE
    protected int cod_consulta; //Codigo de consulta
    protected int tiempo; //Tiempo de la consulta
    protected float precio_total; //En la BBDD es 0 por defecto

    public Consulta(int med_con, int pac_con, int cod_consulta, int tiempo, float precio_total) {
        this.med_con = med_con;
        this.pac_con = pac_con;
        this.cod_consulta = cod_consulta;
        this.tiempo = tiempo;
        this.precio_total = precio_total;
    }
    
    public Consulta()
    {
        
    }

    public int getMed_con() {
        return med_con;
    }

    public void setMed_con(int med_con) {
        this.med_con = med_con;
    }

    public int getPac_con() {
        return pac_con;
    }

    public void setPac_con(int pac_con) {
        this.pac_con = pac_con;
    }

    public int getCod_consulta() {
        return cod_consulta;
    }

    public void setCod_consulta(int cod_consulta) {
        this.cod_consulta = cod_consulta;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(float precio_total) {
        this.precio_total = precio_total;
    }
    
    
    
}
