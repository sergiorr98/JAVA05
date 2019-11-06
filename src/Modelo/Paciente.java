
package Modelo;

/**
 *
 * @author Sergio
 */
public class Paciente {
    protected int cod_pac; //Codigo de paciente
    protected String apellido_pac; //Apellido de paciente
    protected int edad_pac; //Edad del paciente

    public Paciente(int cod_pac, String apellido_pac, int edad_pac) {
        this.cod_pac = cod_pac;
        this.apellido_pac = apellido_pac;
        this.edad_pac = edad_pac;
    }

    public int getCod_pac() {
        return cod_pac;
    }

    public void setCod_pac(int cod_pac) {
        this.cod_pac = cod_pac;
    }

    public String getApellido_pac() {
        return apellido_pac;
    }

    public void setApellido_pac(String apellido_pac) {
        this.apellido_pac = apellido_pac;
    }

    public int getEdad_pac() {
        return edad_pac;
    }

    public void setEdad_pac(int edad_pac) {
        this.edad_pac = edad_pac;
    }



}
