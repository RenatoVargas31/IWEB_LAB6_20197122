package com.example.iweb_lab06_20197122.servlets;

import com.example.iweb_lab06_20197122.beans.Pelicula;
import com.example.iweb_lab06_20197122.daos.VistasDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DetallesServlet", value = "/DetallesServlet")
public class DetallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // Retrieve movie list

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        VistasDao vistasDao = new VistasDao();

        switch (action){
            case "lista":
                //Obtener idPelicula de la vista de listaPeliculas.jsp
                int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
                //Obtener la pelicula en base al idPelicula
                Pelicula viewPelicula = vistasDao.obternerPeliculaPorId(idPelicula);
                request.setAttribute("viewPelicula", viewPelicula);
                RequestDispatcher rd = request.getRequestDispatcher("viewPelicula.jsp");
                rd.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
