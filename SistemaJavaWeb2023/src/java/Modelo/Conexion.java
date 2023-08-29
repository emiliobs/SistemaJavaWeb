package Modelo;

import  java.sql.Connection;
import java.sql.DriverManager;

public class Conexion
{

    private final String baseDatos = "bdsys";
    private final String servidor = "jdbc:mysql://localhost/" + baseDatos;
    private final String usuario = "root";
    private final String clave = "root";
    
    
    public Connection  Conectar()
    {
        Connection connection = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(servidor, usuario, clave);
            
//            System.out.println("Conexion Exitosa!");
        }
        catch (Exception e)
        {
            System.out.println("ERROR al Conectar - Clase Conexión: " + e.getMessage());
        }
        
        return connection;
    }
    
//    public static void main(String[] args)
//    {
//        Conexion conexion = new Conexion();
//        
//        System.out.println("Conectado!" + conexion.Conectar());
//    }

}
