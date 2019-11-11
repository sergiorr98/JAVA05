
package Controlador;

import Modelo.Operacion;
import Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class GestionOperaciones {
    
     ResultSet datosMedicos;
     ResultSet datosConsultasMedicas;
     ResultSet datosPacientes;
     
     Statement sentencia;
     PreparedStatement sentenciaPreparada;
     
    Conexion con = new Conexion();


    public GestionOperaciones() {
        
         try {
             sentencia = con.devolverConexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
         } catch (SQLException ex) {
             System.out.println("error");
         }
        
    }

    public void MostrarMedicos (String consulta) throws SQLException
    {

        datosMedicos = sentencia.executeQuery(consulta);   
    }
        
    //Metodo para avanzar
    public void avanzar() throws SQLException
    {
        datosMedicos.next();
    }
    
    //Metodo para retroceder
    public void retroceder() throws SQLException
    {
        datosMedicos.previous();
    }
    
    //Metodo para acceder al primero
    public void primero() throws SQLException
    {
        datosMedicos.beforeFirst();
        datosMedicos.next(); //Esto se hace para colocarnos correctamente en la celda
    }
    
    //Metodo para acceder al ultimo
    public void ultimo() throws SQLException
    {
        datosMedicos.afterLast();
        datosMedicos.previous(); //Esto se hace para colocarnos correctamente en la celda
    }
    
    //Metodo que devuelve "TRUE" si es el primero
    public boolean isFirst() throws SQLException
    {
        return datosMedicos.isFirst();
    }
    
    //Metodo que devuelve "TRUE" si es el ultimo
    public boolean isLast() throws SQLException
    {
        return datosMedicos.isLast();
    }
    
    //Metodo que devuelve una columa pasandole como parametro un indice
    public String devolverColumna(int i) throws SQLException
    {
        return datosMedicos.getString(i);
    }
    
    
    public int updateFecha (Date fecha, String codigoMedico, String consulta) throws SQLException
    {
        int filasAct = 0;
        
        java.sql.Date fechaN = new java.sql.Date(fecha.getTime());
        
        sentenciaPreparada = con.devolverConexion().prepareStatement(consulta,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        sentenciaPreparada.setDate(1,fechaN);
        sentenciaPreparada.setInt(2,Integer.parseInt(codigoMedico));
        
        return filasAct = sentenciaPreparada.executeUpdate();

                
    }
    
    public int selectConsultaMedico (String consulta, int codigoMedico) throws SQLException
    {

        ResultSet copia;
        
        sentenciaPreparada = con.devolverConexion().prepareStatement(consulta,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        sentenciaPreparada.setInt(1,codigoMedico);
    
        datosConsultasMedicas = sentenciaPreparada.executeQuery();
                
        copia = datosConsultasMedicas;
        copia.last();
        int tamaño = copia.getRow();
        copia.first();
        
        return tamaño;
    }
    
    public ArrayList listaConsultas() throws SQLException
    {
        ArrayList <Operacion> array = new ArrayList();
        
        int cont=0;
        Operacion obj = new Operacion(datosConsultasMedicas.getInt(1),datosConsultasMedicas.getInt(2), datosConsultasMedicas.getInt(3), datosConsultasMedicas.getInt(4), datosConsultasMedicas.getInt(5));
        array.add(obj);
        while(datosConsultasMedicas.next()!=false)
        {
            obj = new Operacion(datosConsultasMedicas.getInt(1),datosConsultasMedicas.getInt(2), datosConsultasMedicas.getInt(3), datosConsultasMedicas.getInt(4), datosConsultasMedicas.getInt(5));
            array.add(obj);
            cont++;
        }
        
        return array;
    }
    
    public Object objetoConsulta() throws SQLException
    {
        Operacion objeto = new Operacion (datosConsultasMedicas.getInt(1),datosConsultasMedicas.getInt(2), datosConsultasMedicas.getInt(3), datosConsultasMedicas.getInt(4), datosConsultasMedicas.getInt(5));
        return objeto;
    }
    
    
    public ArrayList selectPaciente(String consulta) throws SQLException
    {
        ArrayList <Paciente> array = new ArrayList();
        
        datosPacientes = sentencia.executeQuery(consulta);  
        
        datosPacientes.next();
        
        Paciente obj = new Paciente(datosPacientes.getInt(1),datosPacientes.getString(2), datosPacientes.getInt(3));
        array.add(obj);
        
        while(datosPacientes.next()!= false)
        {
            obj = new Paciente(datosPacientes.getInt(1),datosPacientes.getString(2), datosPacientes.getInt(3));
            array.add(obj);
        }
        
        return array;
    }
    
    
    public void insertConsulta (String consulta, int codigoMedico, int codigoPaciente, int tiempoConsulta, int numeroConsulta) throws SQLException
    {
        sentenciaPreparada = con.devolverConexion().prepareStatement(consulta,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        sentenciaPreparada.setInt(1,codigoMedico);
        sentenciaPreparada.setInt(2,codigoPaciente);
        sentenciaPreparada.setInt(3,numeroConsulta);
        sentenciaPreparada.setInt(4,tiempoConsulta);
        
        sentenciaPreparada.execute();
        
    }
    
    public void insertMedico (String consulta, int codigoMedico, String nombreMedico, int codigoCompañia, int precioHora, String nifMedico, Date fechaElegida) throws SQLException
    {
        //INSERT INTO MEDICO VALUES (65,'54179084P',10,'Alvaro','2019/10/12',40);
        sentenciaPreparada = con.devolverConexion().prepareStatement(consulta,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        java.sql.Date fechaN = new java.sql.Date(fechaElegida.getTime());
        
        sentenciaPreparada.setInt(1, codigoMedico);
        sentenciaPreparada.setString(2, nifMedico);
        sentenciaPreparada.setInt(3, codigoCompañia);
        sentenciaPreparada.setString(4,nombreMedico);
        sentenciaPreparada.setDate(5,fechaN);
        sentenciaPreparada.setInt(6, precioHora);
        
        sentenciaPreparada.execute();
    }
}
