
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
    public static String contraseña = "sergio";
    
    public Statement objeto;
   
    //Metodo para la conexion con Postgres
    public static void crearConexionPostgres(String pass) throws Errores, ClassNotFoundException, SQLException, java.lang.Exception
    {
        if (pass.equalsIgnoreCase(contraseña))
        {
        

              //Clase que especifica el nombre de los controladores que se van
              //ha utilizar en la carga de la BD en este caso son los de Access
              Class.forName("org.postgresql.Driver");  //loads the driver
              //Class.forName("org.mysql.Driver");
                    //url es un texto que contiene la ruta del nombre o la direccion
                    //de conexon de la base da Datos conectada al JDBC
                    String url = "jdbc:postgresql://192.168.137.133:5432/HOSPITAL";

                    //Con es el objeto creado para la coneccion donde se especifican los
                    //parametros de la ubicacion de la BD, login si la base de datos
                    //posee seguridad y por ultimo la clave
                    //DriverManager.getConnection es el servicio que permite establecer
                    //la conexion ABRIR CONEXION!!!
                    conPostgres = DriverManager.getConnection(url, nombre, pass);
                    
                    //JOptionPane.showMessageDialog(null, "Conexion POSTGRES exitosa" ,"Estado de conexión", JOptionPane.PLAIN_MESSAGE);
        }
        else
        {
            throw new Errores(1);
        }
    }
    
    //Metodo para la conexion con MySql
    public static void crearConexionMysql(String pass) throws Errores, ClassNotFoundException, SQLException, java.lang.Exception
    {
        if (pass.equalsIgnoreCase(contraseña))
        {
        

              //Clase que especifica el nombre de los controladores que se van
              //ha utilizar en la carga de la BD en este caso son los de Access
              Class.forName("com.mysql.jdbc.Driver");

                    //url es un texto que contiene la ruta del nombre o la direccion
                    //de conexon de la base da Datos conectada al JDBC
                    String url2 = "jdbc:mysql://192.168.137.133:3306/HOSPITAL?useSSL=false";

                    //Con es el objeto creado para la coneccion donde se especifican los
                    //parametros de la ubicacion de la BD, login si la base de datos
                    //posee seguridad y por ultimo la clave
                    //DriverManager.getConnection es el servicio que permite establecer
                    //la conexion ABRIR CONEXION!!!
                    conMysql = DriverManager.getConnection(url2, nombre, pass);
                    
                    //JOptionPane.showMessageDialog(null, "Conexion MYSQL exitosa" ,"Estado de conexión", JOptionPane.PLAIN_MESSAGE);
        }
        else
        {
            throw new Errores(1);
        }
    }

    //Metodo que devuelve la conexion para poder acceder a la conexion en las consultas
    public Connection devolverConexion() throws SQLException
    {
        
        return conPostgres;
    }

    //Metodo para validar compañia que se le pasa el codigo de Compañia y se hace un PrepareStatemente
    public Boolean validarCompañia(String contraseña) throws SQLException,Errores
    {
        try {
            //ResultSet
            ResultSet RsetPost;
            ResultSet RsetMysQL;
            //PrepardStatemtent
            PreparedStatement comprobacion;
            
            String consulta = "SELECT * FROM COMPAÑIA WHERE COD_COMP= ?"; //Consulta
            
            comprobacion = conPostgres.prepareStatement(consulta, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //Hacemos el prepareStatement
            
            comprobacion.setInt(1, Integer.parseInt(contraseña)); //Pasamos el parametro "contraseña"
            
            RsetPost = comprobacion.executeQuery(); //Recogemos con un ResultSet
            
            //Se repite el proceso son MySql
            comprobacion = conMysql.prepareStatement(consulta, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            comprobacion.setInt(1, Integer.parseInt(contraseña));
            
            RsetMysQL = comprobacion.executeQuery();
            
            if (RsetPost.next() && RsetMysQL.next()) {  //Si ambos ResultSet devuelven informacion devuelven True
                System.out.println("Inicio de sesion bien");
                return true;
            } else { //En caso contrario se lanza los errores
                System.out.println("Inicio de sesion mal");
                throw new Errores(1);
            }
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }


    //Metodo para cerrar la conexion con la base de datos
    public static void cerrarConexion()
    {
        try
        {
            //Cierra la conexion de la Base de Datos Postgres y MySql
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
