/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mvm.daw.ur.projecteapostes.contolador;

import com.mvm.daw.ur.projecteapostes.model.Aposta;
import com.mvm.daw.ur.projecteapostes.model.serveisApostes;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isard
 */
@WebServlet(name = "controladorApostes", urlPatterns = {"/controladorApostes"})
public class controladorApostes extends HttpServlet {

    private serveisApostes serveisApostes;
    private int contadorIDs;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorApostes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorApostes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init() throws ServletException {
// Inicializar la lista de usuarios en el contexto de la aplicación 
        List<String> listaPartidos = new ArrayList<>(); // mejor que sea una tupla
        listaPartidos.add("Barcelona - Madrid");
        listaPartidos.add("Osasuna - Villareal");
        listaPartidos.add("A. Bilbao - A. Madrid");
        listaPartidos.add("Las Palmas - Rayo Vallecano");
        listaPartidos.add("Real Sociedad - Girona");
        getServletContext().setAttribute("listaPartidos", listaPartidos); //informacion guardada para todos los usuarios que se vayan a conectar a la pagina
        List<Aposta> listaApostes = new ArrayList<>();
        getServletContext().setAttribute("listaApostes", listaApostes);
        serveisApostes = new serveisApostes();
        List<Aposta> listaFiltrada = new ArrayList<>();
        listaFiltrada = null;
        getServletContext().setAttribute("listaFiltrada", listaFiltrada);

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
            throws ServletException, IOException {
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
            throws ServletException, IOException {
        String accion = request.getParameter("submit");
        List<Aposta> listaApostes = (ArrayList<Aposta>) getServletContext().getAttribute("listaApostes");
        List<Aposta> listaFiltrada = (ArrayList<Aposta>) getServletContext().getAttribute("listaFiltrada");
        if ("afegir".equals(accion)) {
            contadorIDs += 1;
            serveisApostes.afegirAposta(contadorIDs, listaApostes, request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaApostas.jsp");
            dispatcher.forward(request, response);
        } else if ("Borrar".equals(accion)) {
            serveisApostes.borrarAposta(listaApostes, request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaApostas.jsp");
            dispatcher.forward(request, response);
        } else if ("Editar".equals(accion)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("editarAposta.jsp");
            dispatcher.forward(request, response);
        } else if ("confirmar".equals(accion)) {
            serveisApostes.editarAposta(listaApostes, request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaApostas.jsp");
            dispatcher.forward(request, response);
        } else if ("Detalls".equals(accion)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("detallarAposta.jsp");
            dispatcher.forward(request, response);
        } else if ("Filtra".equals(accion)) {
            if (listaFiltrada == null) {
                listaFiltrada = new ArrayList<>();
            }
            String filtro = serveisApostes.filtrarAposta(listaFiltrada, listaApostes, request);
            request.setAttribute("filtro", filtro);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaApostas.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
