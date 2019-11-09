
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class GestionOperaciones {
    
     ResultSet datos;
     
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

        datos = sentencia.executeQuery(consulta);
        
    }
        
    //Metodo para avanzar
    public void avanzar() throws SQLException
    {
        datos.next();
    }
    
    //Metodo para retroceder
    public void retroceder() throws SQLException
    {
        datos.previous();
    }
    
    //Metodo para acceder al primero
    public void primero() throws SQLException
    {
        datos.beforeFirst();
        datos.next(); //Esto se hace para colocarnos correctamente en la celda
    }
    
    //Metodo para acceder al ultimo
    public void ultimo() throws SQLException
    {
        datos.afterLast();
        datos.previous(); //Esto se hace para colocarnos correctamente en la celda
    }
    
    //Metodo que devuelve "TRUE" si es el primero
    public boolean isFirst() throws SQLException
    {
        return datos.isFirst();
    }
    
    //Metodo que devuelve "TRUE" si es el ultimo
    public boolean isLast() throws SQLException
    {
        return datos.isLast();
    }
    
    //Metodo que devuelve una columa pasandole como parametro un indice
    public String devolverColumna(int i) throws SQLException
    {
        return datos.getString(i);
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
    
     
  /*   
    public Object select(String consulta) throws SQLException
    {
        Conexion con = new Conexion();
        Object obj = new Object();
          
        datos = con.crearSentencia().executeQuery(consulta); //El "executeQuery" devuelve datos
        
        datos.last(); //me voy al último
        int tamano = datos.getRow(); //capturo el tamaño
        datos.beforeFirst(); // lo dejo donde estaba para tratarlo
        
        if (tamano == 1)
        {
            obj = datos;
            return obj;
        }
        else
        {
            ArrayList array = new ArrayList();
            while(datos.next()!= false)
            {
                array.add(datos);
            }
            return array;
        }
    }
 */
    /*   
    public ResultSet selectTablaB (String codigo_medico) throws SQLException
    {
       Conexion con = new Conexion();
        
       ResultSet Rset;
       PreparedStatement PreparedS;
       
       String consulta = "SELECT * FROM MEDICO WHERE COD_MED = ?";
       
       
       PreparedS = con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
       
       PreparedS.setInt(1,Integer.parseInt(codigo_medico));
       
       Rset = PreparedS.executeQuery();
       
       return Rset;
    }
    
    
    public int insert (String consulta) throws SQLException
    {
        Conexion con = new Conexion();
        
        con.crearSentencia().execute(consulta); // El "execute" no devuelve datos
        
        return 1; //Porque los insert solo devuelven un 1
    }
    
    public int udpate (String consulta) throws SQLException
    {
        Conexion con = new Conexion();
        
        con.crearSentencia().execute(consulta); // El "execute" no devuelve datos
        
        return 1; //Hay que cambiar esto
    }
 */ 
}
