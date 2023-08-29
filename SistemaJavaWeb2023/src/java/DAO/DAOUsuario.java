package DAO;

import Modelo.Cargo;
import Modelo.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOUsuario extends Conexion
{

    public Usuario IdentificarUsuario(Usuario usuario) throws Exception
    {
      

        Usuario user = null;
        Conexion conexion;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
         String sql = "SELECT U.IDUSUARIO, C.NOMBRECARGO FROM USUARIO U "
                + "INNER JOIN CARGO C ON U.IDCARGO = C.IDCARGO "
                + "WHERE U.ESTADO = 1 AND U.NOMBREUSUARIO = '" + user.getNombreUsuario() + "' "
                + "AND U.CLAVE = '" + user.getClave() + "'";
         
        conexion = new Conexion();
        try
        {
            connection = conexion.Conectar();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet.next() == true)
            {
                user = new Usuario();
                
                
                user.setIdUsuario(resultSet.getInt("IDUSUARIO"));
                user.setNombreUsuario(user.getNombreUsuario());
                user.setCargo(new Cargo());
                user.getCargo().setNombreCargo(resultSet.getString("NOMBRECARGO"));
                user.setEstado(true);
                
                user.setIdUsuario(resultSet.getInt("IDUSUARIO"));
                user.setNombreUsuario(resultSet.getString("NOMBREUSUARIO"));
                user.setCargo(new Cargo());
                user.getCargo().setNombreCargo(resultSet.getString("NOMBRECARGO"));
                user.setEstado(true);
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR en DAOUsuario: " + e.getMessage());
        }
        finally
        {
            if (resultSet != null && resultSet.isClosed() == false)
            {
                resultSet.close();
            }
            resultSet = null;
            
            if (statement != null && statement.isClosed() == false)
            {
                statement.close();
            }
            statement = null;
   
            if (connection != null && connection.isClosed() == false)
            {
                connection.isClosed();
            }
            conexion = null;
            
        }
        

        return usuario;
        }
    }
