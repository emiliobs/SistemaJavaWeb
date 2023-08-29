
package Modelo;


public class ComprobarConexion
{
    public static void main(String[] args)
    {
        Conexion conexion = new Conexion();
        
        if (conexion.Conectar() != null)
        {
            System.out.println("Conexión Exitosa ");
        }
        else
        {
            System.out.println("Conexión Erronea");
        }
    }
}
