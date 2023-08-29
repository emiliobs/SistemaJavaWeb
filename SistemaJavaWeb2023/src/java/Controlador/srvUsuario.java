package Controlador;

import DAO.DAOUsuario;
import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "srvUsuario", urlPatterns =
{
    "/srvUsuario"
})
public class srvUsuario extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        try
        {
            if (accion != null)
            {
                switch (accion)
                {
                    case "verificar":                                          
 response.sendRedirect("index.jsp");
                       //Verificar(request, response);
                        break;
                    case "cerrar":
                        CerrarSession(request, response);
                    default:
                        response.sendRedirect("identificar.jsp");
                }
            }
            else
            {
                response.sendRedirect("identificar.jsp");
            }
        }
        catch (Exception e)
        {
            try
            {
                getServletConfig().getServletContext().getRequestDispatcher("/mensaje.jsp").forward(request, response);

            }
            catch (Exception e1)
            {
                System.out.println("ERROR en el srvUsuario: " + e1.getMessage());
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

    private void Verificar(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        HttpSession httpSession = null;
        DAOUsuario dAOUsuario = new DAOUsuario();
        Usuario usuario;
        Usuario getUsuario;
        usuario = ObtenerUsuario(request);
        usuario = dAOUsuario.IdentificarUsuario(usuario);

        System.out.println("Datos: " + usuario.getNombreUsuario() + " " + usuario.getClave() + " " + usuario.getCargo().getNombreCargo());

        if (usuario != null && usuario.getCargo().getNombreCargo().equals("Administrador"))
        {
            //httpSession.setAttribute("usuario", getUsuario);
            httpSession = request.getSession();
            httpSession.setAttribute("usuario", usuario);
           // request.setAttribute("mensaje", "Bienvenido al Sistema!");
           httpSession.setAttribute("mensaje", "Bienvenido al Sistema!");
            // getServletConfig().getServletContext().getRequestDispatcher("/Vistas/index.jsp").forward(request, response);
            response.sendRedirect("Vistas/index.jsp");

        }
        else if (usuario != null && usuario.getCargo().getNombreCargo().equals("Vendedor"))
        {
            httpSession.setAttribute("vendedor", usuario);
            getServletConfig().getServletContext().getRequestDispatcher("Vistas/formVendedor.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("mensaje", "Sorry:  Credenciales Incorrectas!");
            request.getRequestDispatcher("identificar.jsp").forward(request, response);
        }
    }

    private void CerrarSession(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("usuario", null);
        httpSession.invalidate();
        response.sendRedirect("identificar.jsp");
    }

    private Usuario ObtenerUsuario(HttpServletRequest request)
    {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(request.getParameter("txtUsu"));
        usuario.setClave(request.getParameter("txtPass"));

        return usuario;
    }

}
