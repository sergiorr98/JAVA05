
package Modelo;

import Controlador.Errores;
import Controlador.GestionOperaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ObtenerDatos {
       
    GestionOperaciones gestion;

    public ObtenerDatos() {
         gestion = new GestionOperaciones();
    }
    
    public void mostrarDatosMedicos (String codigo) throws Errores
    {
        int codigoCompañia = Integer.parseInt(codigo);
        String consulta = "SELECT * FROM MEDICO WHERE COMP_MED = "+codigoCompañia+";";
        
        try {
            gestion.MostrarMedicos(consulta);
        } catch (SQLException ex) {
            System.out.println(ex.toString());    
            throw new Errores(1);
        }
    }
    
    public int modificarFecha (Date fechaNueva, String codigo) throws Errores
    {
        String consulta = "UPDATE MEDICO SET FECHA_MED = ? WHERE COD_MED = ?";
        int actualizados;
        try {
            actualizados = gestion.updateFecha(fechaNueva, codigo, consulta );
            return actualizados;
        } catch (SQLException ex) {
                System.out.println(ex.toString());
                throw new Errores(1);
        }
    }
    
    public int mostrarConsultaMedico (String codigo) throws Errores
    {
        int codigoMedico = Integer.parseInt(codigo);
        int numeroFilas=0;
        
        String consulta = "SELECT * FROM CONSULTA WHERE MED_CON = ?";
        
        try {
            numeroFilas = gestion.selectConsultaMedico(consulta, codigoMedico);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
        
        return numeroFilas;
    }
    
    public ArrayList devolverArrayConsultaMedico() throws Errores
    {
        ArrayList <Operacion> array = new ArrayList();
        
        try {
            return array = gestion.listaConsultas();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
    public Object devolverObjetoConsultaMedico() throws Errores
    {
        try {
             Operacion objeto = (Operacion) gestion.objetoConsulta();
             return objeto;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
        
    }

    
    public ArrayList mostrarPacientes() throws Errores
    {
        String consulta = "SELECT * FROM PACIENTE";
        
        ArrayList <Paciente> array = new ArrayList();
        
        try {
            array = gestion.selectPaciente(consulta);
            return array;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
    public void nuevaConsulta(String codigoMedico, int codigoPaciente, String tiempoSeleccionado, int numeroConsulta) throws Errores
    {
        int codigo = Integer.parseInt(codigoMedico);
        int tiempo = Integer.parseInt(tiempoSeleccionado);
        
        String consulta = "INSERT INTO CONSULTA (MED_CON, PAC_CON, COD_CONSULTA, TIEMPO) VALUES(?,?,?,?);";
        
        try {
            gestion.insertConsulta(consulta, codigo, codigoPaciente, tiempo, numeroConsulta);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
    
    public void nuevoMedico(String codigoMedico, String nombreMedico, String codigoCompañia, String precioHora, String nifMedico, Date fechaElegida) throws Errores
    {
        int codigoM = Integer.parseInt(codigoMedico);
        int codigoComp = Integer.parseInt(codigoCompañia);
        int precioH = Integer.parseInt(precioHora);
        
        String consulta = "INSERT INTO MEDICO VALUES (?,?,?,?, ?,?);";
        
        try {
            gestion.insertMedico(consulta, codigoM, nombreMedico, codigoComp, precioH, nifMedico, fechaElegida);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
 
    }
    
    
    public void avanzar () throws Errores 
    {
        try {
            gestion.avanzar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
    
    public void retroceder () throws Errores 
    {
        try {
            gestion.retroceder();
        } catch (SQLException ex) {
            System.out.println(ex.toString());      
            throw new Errores(1);
        }
    }
    
    
    public void primero () throws Errores
    {
        try {
            gestion.primero();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
    public void ultimo() throws Errores 
    {
        try {
            gestion.ultimo();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
    public boolean isFirst() throws Errores
    {
        Boolean bandera = false;
        try {

            bandera = gestion.isFirst();
            return bandera;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }

    }
    
    public boolean isLast() throws Errores
    {   Boolean bandera = false;
        try {
            bandera =gestion.isLast();
            return bandera;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
    //Metodo que devuelve una columa pasandole como parametro un indice
    public String devolverColumna(int i) throws Errores
    {
        
        String palabra;
        try {
            palabra = gestion.devolverColumna(i);
            return palabra;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
    
}
