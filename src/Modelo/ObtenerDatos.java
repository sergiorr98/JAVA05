
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
    
    public int modificarFecha (Date fechaNueva, String codigo)
    {
        String consulta = "UPDATE MEDICO SET FECHA_MED = ? WHERE COD_MED = ?";
        int actualizados;
        try {
            actualizados = gestion.updateFecha(fechaNueva, codigo, consulta );
            return actualizados;
        } catch (SQLException ex) {
                System.out.println(ex.toString());
                return 0;
        }
    }
    
    public int mostrarConsultaMedico (String codigo)
    {
        int codigoMedico = Integer.parseInt(codigo);
        int numeroFilas=0;
        
        String consulta = "SELECT * FROM CONSULTA WHERE MED_CON = ?";
        
        try {
            numeroFilas = gestion.selectConsultaMedico(consulta, codigoMedico);
        } catch (SQLException ex) {
            Logger.getLogger(ObtenerDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("El numero de filas del medico "+codigo+" es "+numeroFilas);
        return numeroFilas;
    }
    
    public ArrayList devolverArrayConsultaMedico()
    {
        ArrayList <Consulta> array = new ArrayList();
        
        try {
            return array = gestion.listaConsultas();
        } catch (SQLException ex) {
            Logger.getLogger(ObtenerDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Object devolverObjetoConsultaMedico()
    {
        try {
             return gestion.objetoConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(ObtenerDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    
    public ArrayList mostrarPacientes()
    {
        String consulta = "SELECT * FROM PACIENTE";
        
        ArrayList <Paciente> array = new ArrayList();
        
        try {
            array = gestion.selectPaciente(consulta);
            return array;
        } catch (SQLException ex) {
            Logger.getLogger(ObtenerDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void avanzar () throws SQLException
    {
        gestion.avanzar();
    }
    
    
    public void retroceder () throws SQLException
    {
        gestion.retroceder();
    }
    
    
    public void primero () throws SQLException
    {
        gestion.primero();
    }
    
    public void ultimo() throws SQLException
    {
        gestion.ultimo();
    }
    
    public boolean isFirst() throws SQLException
    {
        Boolean bandera;
        bandera = gestion.isFirst();
        return bandera;
    }
    
    public boolean isLast() throws SQLException
    {   Boolean bandera;
        bandera =gestion.isLast();
        return bandera;
    }
    
    //Metodo que devuelve una columa pasandole como parametro un indice
    public String devolverColumna(int i) throws Errores
    {
        
        String palabra;
        try {
            palabra = gestion.devolverColumna(i);
            return palabra;
        } catch (SQLException ex) {
            throw new Errores(1);
        }
    }
    
    
}
