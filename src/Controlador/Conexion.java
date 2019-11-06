
package Controlador;
import java.sql.*; 
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class Conexion {
    
        //Objeto Tipo conexion que contiene todos los parametros para interactuar 
        //con la BD se crea un objeto tipo con
    public static Connection conPostgres;
    public static Connection conMysql;
    
    //Lo necesario para conectarnos con la base de datos correctamente
    public static String nombre = "sergio";
    
    public Statement objeto;
   
    public static boolean crearConexionPostgres(String pass)
    {
        
         try
            {
              //Clase que especifica el nombre de los controladores que se van
              //ha utilizar en la carga de la BD en este caso son los de Access
              Class.forName("org.postgresql.Driver");  //loads the driver
              //Class.forName("org.mysql.Driver");
            }
            catch(ClassNotFoundException e)
            {
                    System.out.println("No encontro driver");
            }

            try
            {
                    //url es un texto que contiene la ruta del nombre o la direccion
                    //de conexon de la base da Datos conectada al JDBC
                    String url = "jdbc:postgresql://192.168.137.130:5432/HOSPITAL";

                    //Con es el objeto creado para la coneccion donde se especifican los
                    //parametros de la ubicacion de la BD, login si la base de datos
                    //posee seguridad y por ultimo la clave
                    //DriverManager.getConnection es el servicio que permite establecer
                    //la conexion ABRIR CONEXION!!!
                    conPostgres = DriverManager.getConnection(url, nombre, pass);
                    
                    //JOptionPane.showMessageDialog(null, "Conexion POSTGRES exitosa" ,"Estado de conexión", JOptionPane.PLAIN_MESSAGE);
                    return true;

            }
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos" ,"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            catch (java.lang.Exception ex) 
            {
                ex.printStackTrace ();
                return false;
            }
    }
    
    
    public static boolean crearConexionMysql(String pass)
    {
        
         try
            {
              //Clase que especifica el nombre de los controladores que se van
              //ha utilizar en la carga de la BD en este caso son los de Access
              Class.forName("com.mysql.jdbc.Driver");
            }
            catch(ClassNotFoundException e)
            {
                    System.out.println("No encontro driver");
            }

            try
            {
                    //url es un texto que contiene la ruta del nombre o la direccion
                    //de conexon de la base da Datos conectada al JDBC
                    String url2 = "jdbc:mysql://192.168.137.130:3306/HOSPITAL?useSSL=false";

                    //Con es el objeto creado para la coneccion donde se especifican los
                    //parametros de la ubicacion de la BD, login si la base de datos
                    //posee seguridad y por ultimo la clave
                    //DriverManager.getConnection es el servicio que permite establecer
                    //la conexion ABRIR CONEXION!!!
                    conMysql = DriverManager.getConnection(url2, nombre, pass);
                    
                    //JOptionPane.showMessageDialog(null, "Conexion MYSQL exitosa" ,"Estado de conexión", JOptionPane.PLAIN_MESSAGE);
                    return true;

            }
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos" ,"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            catch (java.lang.Exception ex) 
            {
                ex.printStackTrace ();
                return false;
            }
    }

  
    public Boolean validarCompañia(String contraseña) throws SQLException
    {

       String usuario = "Sanitas";
       ResultSet RsetPost;
       ResultSet RsetMysQL;
       PreparedStatement comprobacion;
       
       String consulta = "SELECT * FROM COMPAÑIA WHERE COD_COMP= ?";
       
       
       comprobacion = conPostgres.prepareStatement(consulta,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
       
       comprobacion.setInt(1,Integer.parseInt(contraseña));
       
       RsetPost = comprobacion.executeQuery();
       
       comprobacion = conMysql.prepareStatement(consulta,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
       
       comprobacion.setInt(1,Integer.parseInt(contraseña));
       
       RsetMysQL = comprobacion.executeQuery();
       
       
       if (RsetPost.next() && RsetMysQL.next())
       {         
           System.out.println("Inicio de sesion bien");
           return true;
       }
       else
       {
           System.out.println("Inicio de sesion mal");
           return false;
       }
        /*
            ResultSet result;
            
            objeto = conPostgres.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            result = objeto.executeQuery("SELECT NOMBRE_COMP, COD_COMP FROM COMPAÑIA WHERE NOMBRE_COMP =\'"+usuario+"\' AND COD_COMP ="+contraseña+";");
            
            if (result.next())
            {
                JOptionPane.showMessageDialog(null, "Bienvenida compañia "+usuario ,"Estado de conexión", JOptionPane.PLAIN_MESSAGE);    
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña erroneos "+result.getRow() ,"Error", JOptionPane.ERROR_MESSAGE);
                //Haria falta hacer el throws
                return false;
            }
        */
    }


    //Metodo para cerrar la conexion con la base de datos
    public static void cerrarConexion()
    {
        try
        {
            //Cierra la conexion de la Base de Datos
            conPostgres.close();
            conMysql.close();
            System.out.println("Cerrada la conexion con la Base de Datos");
        }
        catch(SQLException e)
        {
            System.out.println("Error al cerrar la conexion con la Base de datos. \n"+e);
        }
    }
    
}
