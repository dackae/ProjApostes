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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        listaPartidos.add("Barcelona - Madrid (J2)");
        listaPartidos.add("Barcelona - Madrid (J1)");
        listaPartidos.add("Osasuna - Villareal");
        listaPartidos.add("A. Bilbao - A. Madrid");
        listaPartidos.add("Las Palmas - Rayo Vallecano");
        listaPartidos.add("Real Sociedad - Girona");
        getServletContext().setAttribute("listaPartidos", listaPartidos); //informacion guardada para todos los usuarios que se vayan a conectar a la pagina
        Map<String, String> resultadosPartidos = new HashMap<String, String>();
        resultadosPartidos.put("Barcelona - Madrid (J2)", "4-1");
        resultadosPartidos.put("Barcelona - Madrid (J1)", "1-1");
        resultadosPartidos.put("Osasuna - Villareal", "1-3");
        resultadosPartidos.put("A. Bilbao - A. Madrid", "1-1");
        resultadosPartidos.put("Las Palmas - Rayo Vallecano", "0-0");
        resultadosPartidos.put("Real Sociedad - Girona", "2-1");
        getServletContext().setAttribute("resultadosPartidos", resultadosPartidos);
        Map<String, String> fechasPartidos = new HashMap<String, String>();
        fechasPartidos.put("Barcelona - Madrid (J2)", "2025-02-15");
        fechasPartidos.put("Barcelona - Madrid (J1)", "2024-11-04");
        fechasPartidos.put("Osasuna - Villareal", "2024-12-11");
        fechasPartidos.put("A. Bilbao - A. Madrid", "2024-10-23");
        fechasPartidos.put("Las Palmas - Rayo Vallecano", "2024-11-26");
        fechasPartidos.put("Real Sociedad - Girona", "2024-11-05");
        getServletContext().setAttribute("fechasPartidos", fechasPartidos);
        List<String> listaCompeticiones = new ArrayList<>();
        listaCompeticiones.add("LaLiga");
        listaCompeticiones.add("Premier League");
        listaCompeticiones.add("Bundesliga");
        listaCompeticiones.add("Serie A");
        listaCompeticiones.add("League 1");
        getServletContext().setAttribute("listaCompeticiones", listaCompeticiones);
        

        List<Aposta> listaApostes = new ArrayList<>();
        getServletContext().setAttribute("listaApostes", listaApostes);
        serveisApostes = new serveisApostes();
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
        Map<String, String> resultadosPartidos = (HashMap<String, String>) getServletContext().getAttribute("resultadosPartidos");
        serveisApostes.verificarGanadores(listaApostes, resultadosPartidos);
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
            List<Aposta> listaFiltrada = serveisApostes.filtrarAposta(listaApostes, request);
            request.setAttribute("listaFiltrada", listaFiltrada);
            RequestDispatcher dispatcher = request.getRequestDispatcher("apostesFiltrades.jsp");
            dispatcher.forward(request, response);
        } else if ("ListarGanadores".equals(accion)){
            List<Aposta> listaGanadores = serveisApostes.listaGanadores(listaApostes);
            request.setAttribute("listaGanadores", listaGanadores);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaGanadores.jsp");
            dispatcher.forward(request, response);
        } else if ("filtraMontoUsuario".equals(accion)){
            List<Aposta> listaMontoUsuario = serveisApostes.filtraMontoUsuario(listaApostes, request);
            request.setAttribute("listaMontoUsuario", listaMontoUsuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listaMontoUsuario.jsp");
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
