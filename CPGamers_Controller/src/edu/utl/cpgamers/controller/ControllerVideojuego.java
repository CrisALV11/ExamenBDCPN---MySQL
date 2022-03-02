package edu.utl.cpgamers.controller;

import edu.utl.cpgamers.db.ConexionMySQL;
import edu.utl.cpgamers.model.Videojuego;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControllerVideojuego
{
    public int insertarRegistro(Videojuego v) throws Exception
    {
        //Definir la sentencia SQL para realizar la inserción de en la BD
        String query = "INSERT INTO videojuego(nombre, plataforma, marca, clasificacion, tipo, annioEstreno)"
                + "values(?, ?, ?, ?, ?, ?);";
        
        //Se declara la variable sobre la que se almacena el ID generado
        int idGenerado = -1;
        
        //Se genera un objeto de inserción y la abrimos
        ConexionMySQL conMySQL = new ConexionMySQL();
        Connection conn = conMySQL.open();
        
        /* 
            Generar un objeto que lleve la consulta a la BD
            Que permita recibir el id generado
        */
        PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        //Terminar la sentencia / Cargar el objeto pstmt
        pstmt.setString(1, v.getNombre());
        pstmt.setString(2, v.getPlataforma());
        pstmt.setString(3, v.getMarca());
        pstmt.setString(4, v.getClasificacion());
        pstmt.setString(5, v.getTipo());
        pstmt.setInt(6, v.getAnnioEstreno());
        
        //Generar un objeto que va a guardar el resultado devuelto de la consulta 
        ResultSet rs = null;
        
        //Ejecutamos la consulta
        pstmt.executeUpdate();
        
        //Solicitar al PrepareStatement el valor que se genero (id)
        rs = pstmt.getGeneratedKeys();
        
        //Tomar el valor generado
        if(rs.next())
        {
            idGenerado = rs.getInt(1);
            v.setId(idGenerado);
        }
        
        //Cerrar los objetos de conexión
        rs.close();
        pstmt.close();
        conMySQL.close();
        
        return idGenerado;
    }
}
