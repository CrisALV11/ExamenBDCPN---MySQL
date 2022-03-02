package edu.utl.cpgamers.db;


import edu.utl.cpgamers.controller.ControllerVideojuego;
import edu.utl.cpgamers.model.Videojuego;

public class Prueba 
{
    public static void main(String[] args)
    {
        //probarMySQLNube();
        probarInsertar();
    }
    
    public static void probarMySQLNube()
    {
        ConexionMySQL objConn = new ConexionMySQL();
        try 
        {
            objConn.open();
            System.out.println(objConn.toString());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void probarInsertar()
    {
        try
        {
            Videojuego v = new Videojuego("Forza Horizon 5", "Xbox Series", "Playground Games", "Todo Público", "Deportes", 2021);
            ControllerVideojuego objCV = new ControllerVideojuego();
            int idG = objCV.insertarRegistro(v);
            System.out.println(idG);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
