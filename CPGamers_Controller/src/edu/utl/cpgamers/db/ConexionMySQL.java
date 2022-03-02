package edu.utl.cpgamers.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Esta clase nos va a permitir abrir y cerrar la conexión con SGB (MySQL)
*/

public class ConexionMySQL 
{
    Connection conexion;
   /**
    * Metodo para generar y abrir una conexión con una BD de MySQL
    * @return Un objeto de tipo Connection
    * @throws Exception 
    */
    public Connection open() throws Exception
    {
        // Establecer el driver con el que se va a trabajaar
        String driver = "com.mysql.jdbc.Driver";
        // Establecer la ruta de conexión
        String url = "jdbc:mysql://bxoo20kikrwcwnbzekap-mysql.services.clever-cloud.com:3306/bxoo20kikrwcwnbzekap";
        //Establecer los valores para los permisos de acceso
        String user = "unonoiezp0ngpds2";
        String password = "rnInwWgmupTwb0vTMBaG";
        
        //Damos de alta el uso del driver
        Class.forName(driver);
        
        //Abrimos la conexión
        conexion = DriverManager.getConnection(url, user, password);
        
        //Retornamos la conexión que se ha creado y abierto
        return conexion; 
    }
    
    /**
     * Este método es para cerrar una conexión a BD de MySQL que esté abierta
     */
    
    public void close()
    {
        try {
            if(conexion != null)
            {
               conexion.close();
            }
        }
        catch (SQLException ex) 
            {
               ex.printStackTrace();
            }
    }
}
