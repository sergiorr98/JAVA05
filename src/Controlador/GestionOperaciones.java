
package Controlador;

import Modelo.Medico;
import Modelo.Operacion;
import Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class GestionOperaciones {
    
    //ResultSet
     ResultSet datosMedicos;
     ResultSet datosConsultasMedicas;
     ResultSet datosPacientes;
     //Statement y PreparedStatement
     Statement sentencia;
     PreparedStatement sentenciaPreparada;
     //Objeto de la clase Conexion para devolver la conexion y poder hacer las sentencias
    Conexion con = new Conexion();


    //En el constructor se instancia la sentencia
    public GestionOperaciones() {
        
         try {
             sentencia = con.devolverConexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
         } catch (SQLException ex) {
             System.out.println("error");
         }
        
    }

    //Metodo que muestra medicos
    public void MostrarMedicos (String consulta, int codigo) throws SQLException
    {       
        sentenciaPreparada = con.devolverConexion().prepareStatement(consulta,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        sentenciaPreparada.setInt(1,codigo);
    
        datosMedicos = sentenciaPreparada.executeQuery();    
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
    
    //Metodo para modificar la fecha que devuelve el numero de filas afectadas
    public int updateFecha (Date fecha, String codigoMedico, String consulta) throws SQLException
    {
        int filasAct = 0;
        
        java.sql.Date fechaN = new java.sql.Date(fecha.getTime()); //Creamos fecha con formato SQL
        
        sentenciaPreparada = con.devolverConexion().prepareStatement(consulta,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //Configuramos la sentencia preparada
        
        //Valores
        sentenciaPreparada.setDate(1,fechaN);
        sentenciaPreparada.setInt(2,Integer.parseInt(codigoMedico));
        
        return filasAct = sentenciaPreparada.executeUpdate(); //Devuelve el numero de filas afectas

                
    }
    
    //Metodo para mostrar las consultas de los medicos, que devuelve un tamaño (para ver si se devuelve un objeto o una ArrayList)
    public int selectConsultaMedico (String consulta, int codigoMedico) throws SQLException
    {

        ResultSet copia;
        
        sentenciaPreparada = con.devolverConexion().prepareStatement(consulta,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        sentenciaPreparada.setInt(1,codigoMedico);
    
        datosConsultasMedicas = sentenciaPreparada.executeQuery();
                
        //Se hace un ResultSet de copia para obtener el tamaño
        copia = datosConsultasMedicas;
        copia.last();
        int tamaño = copia.getRow();
        copia.first();
        
        return tamaño;//Se devuelve el tamaño
    }
    
    //Si el tamaño del metodo anterior es mayor que 1 se devuelve la informacion en un ArrayList
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
    //Si el tamaño del metodo anterior es igual a 1 se devuelve la informacion en un objeto
    public Object objetoConsulta() throws SQLException
    {
        Operacion objeto = new Operacion (datosConsultasMedicas.getInt(1),datosConsultasMedicas.getInt(2), datosConsultasMedicas.getInt(3), datosConsultasMedicas.getInt(4), datosConsultasMedicas.getInt(5));
        return objeto;
    }
    
    //Metood que devuelve todos los pacientes en un ArrayList
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
    
    //Metood para insertar una Consulta
    public void insertConsulta (String consulta, int codigoMedico, int codigoPaciente, int tiempoConsulta, int numeroConsulta) throws SQLException
    {
        sentenciaPreparada = con.devolverConexion().prepareStatement(consulta,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        sentenciaPreparada.setInt(1,codigoMedico);
        sentenciaPreparada.setInt(2,codigoPaciente);
        sentenciaPreparada.setInt(3,numeroConsulta);
        sentenciaPreparada.setInt(4,tiempoConsulta);
        
        sentenciaPreparada.execute();
        
    }
    
    //Metodo para insertar medicos
    public void insertMedico (String consulta, Object objeto) throws SQLException
    {
        sentenciaPreparada = con.devolverConexion().prepareStatement(consulta,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        
        
        java.sql.Date fechaN = new java.sql.Date(((Medico)objeto).getFecha_med().getTime());
        
        sentenciaPreparada.setInt(1, ((Medico)objeto).getCod_med());
        sentenciaPreparada.setString(2, ((Medico)objeto).getNif_med());
        sentenciaPreparada.setInt(3, ((Medico)objeto).getComp_med());
        sentenciaPreparada.setString(4,((Medico)objeto).getNombre_med());
        sentenciaPreparada.setDate(5,fechaN);
        sentenciaPreparada.setInt(6, ((Medico)objeto).getPrecioHora_med());
        
        sentenciaPreparada.execute();
    }
}
