
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

    //Se crea el objeto de la clase de GestionOperaciones que es donde le pasaremos la info para hacer las consultas
    public ObtenerDatos() {
         gestion = new GestionOperaciones();
    }
    
    //Metodo que se le pasa el codigo de medico, crea la consulta  y se le pasa a otro metodo de la clase GestionOperaciones
    public void mostrarDatosMedicos (String codigo) throws Errores
    {
        int codigoCompañia = Integer.parseInt(codigo);
        String consulta = "SELECT * FROM MEDICO WHERE COMP_MED = ? ;";
        
        try {
            gestion.MostrarMedicos(consulta, codigoCompañia);
        } catch (SQLException ex) {
            System.out.println(ex.toString());    
            throw new Errores(1);
        }
    }
    
    //Metodo para modificar la fecha
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
    //Metodo para mostrar las consultas de un medico que se pasa por parametro
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
    
    //Metodo que devuelve array de las consultas de los medicos
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
    
    //Metodo que devuelve objeto de la consulta del medico
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

    //Metodo que devuelve un array de los pacientes
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
    
    //Metodo que crea una nueva consulta
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
    
    //Metodo que crea un nuevo medico
    public void nuevoMedico(Object objeto) throws Errores
    {
        
        String consulta = "INSERT INTO MEDICO VALUES (?,?,?,?, ?,?);";
        
        try {
            gestion.insertMedico(consulta, objeto);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
 
    }
    
    //Metodo para avanzar
    public void avanzar () throws Errores 
    {
        try {
            gestion.avanzar();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
    //Metodo para retroceder
    public void retroceder () throws Errores 
    {
        try {
            gestion.retroceder();
        } catch (SQLException ex) {
            System.out.println(ex.toString());      
            throw new Errores(1);
        }
    }
    
    //Metodo para ir al primero
    public void primero () throws Errores
    {
        try {
            gestion.primero();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
//Metodo para ir al ultimo
    public void ultimo() throws Errores 
    {
        try {
            gestion.ultimo();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new Errores(1);
        }
    }
    
    //Metodo que dice si estamos en el primero
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
    
    
    //Metodo que dice si estamos en el ultimo
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
