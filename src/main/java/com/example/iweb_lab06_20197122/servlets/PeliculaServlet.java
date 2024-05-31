package com.example.iweb_lab06_20197122.servlets;

import com.example.iweb_lab06_20197122.beans.Pelicula;
import com.example.iweb_lab06_20197122.daos.VistasDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PeliculaServlet", value = "/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve movie list
        VistasDao vistasDao = new VistasDao();
        ArrayList<Pelicula> listaPeliculas = vistasDao.obtenerListaPeliculas();

        // Set request attribute
        request.setAttribute("listaPeliculas", listaPeliculas);

        // Forward request to JSP
        RequestDispatcher rd = request.getRequestDispatcher("listaPeliculas.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
