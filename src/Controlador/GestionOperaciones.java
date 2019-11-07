
package Controlador;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class GestionOperaciones {
    
     ResultSet datos;
     
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
    
}
