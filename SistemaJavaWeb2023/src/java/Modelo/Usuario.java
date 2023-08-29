
package Modelo;


public class Usuario
{
    private int idUsuario;
    private String nombreUsuario;
    private String clave;
    private boolean estado;
    
     //Relacion
    private Cargo cargo;

    public Usuario()
    {
    }

    public Usuario(int idUsuario, String nombreUsuario, String clave, boolean estado, Cargo cargo)
    {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.estado = estado;
        this.cargo = cargo;
    }

    public Cargo getCargo()
    {
        return cargo;
    }

    public void setCargo(Cargo cargo)
    {
        this.cargo = cargo;
    }

    public int getIdUsuario()
    {
        return idUsuario;
    }
    
 

    public void setIdUsuario(int idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario()
    {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave()
    {
        return clave;
    }

    public void setClave(String clave)
    {
        this.clave = clave;
    }

    public boolean isEstado()
    {
        return estado;
    }

    public void setEstado(boolean estado)
    {
        this.estado = estado;
    }
    
   
}
