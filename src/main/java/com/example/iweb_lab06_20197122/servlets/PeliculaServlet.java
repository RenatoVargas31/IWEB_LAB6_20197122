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
        response.setContentType("text/html");
        // Retrieve movie list

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        VistasDao vistasDao = new VistasDao();

        switch (action){
            case "lista":
                //Sacar del modelo
                ArrayList<Pelicula> listaPeliculas = vistasDao.obtenerListaPeliculas();

                //Mandar a la vista -> listaPeliculas.jsp
                request.setAttribute("listaPeliculas", listaPeliculas);
                RequestDispatcher rd = request.getRequestDispatcher("listaPeliculas.jsp");
                rd.forward(request, response);
                break;
            case "new":
                break;
            case "edit":
                break;
            case "del":
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        VistasDao vistasDao = new VistasDao();
        String action = request.getParameter("action") == null ? "crear" : request.getParameter("action");

        switch (action){
            case "buscar":
                String textBuscar = request.getParameter("textoBuscar");
                ArrayList<Pelicula> listaPeliculas = vistasDao.buscarPorTitulo(textBuscar);

                request.setAttribute("listaPeliculas",listaPeliculas);
                request.setAttribute("busqueda",textBuscar);
                request.getRequestDispatcher("listaPeliculas.jsp").forward(request,response);


                break;
        }
    }
}
