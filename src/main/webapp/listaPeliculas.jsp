<%@ page import="com.example.iweb_lab06_20197122.beans.Pelicula" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: rlvs_
  Date: 30/05/2024
  Time: 01:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% ArrayList<Pelicula> listaPeliculas = (ArrayList<Pelicula>) request.getAttribute("listaPeliculas");%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Películas</title>
</head>
<body>
<h1>Lista de Películas</h1>

<table>
    <tr>
        <th>Título</th>
        <th>Director</th>
        <th>Año de Publicación</th>
        <th>Rating</th>
        <th>Box Office</th>
        <th>Género</th>
        <th>Actores</th>
    </tr>
    <% for (Pelicula pelicula : listaPeliculas) { %>
    <tr>
        <td><a href="#"><%= pelicula.getTitulo() %></a></td>
        <td><%= pelicula.getDirector() %></td>
        <td><%= pelicula.getAnoPublicacion() %></td>
        <td><%= pelicula.getRating() %>/10</td>
        <td>$<%= new DecimalFormat("###,###.00").format(pelicula.getBoxOffice()) %></td>
        <td><%= pelicula.getGenero().getNombre() %></td> 
        <td><a href="#">Ver Actores</a></td>
    </tr>
    <% } %>
</table>
<style>
    table, th, td {
        border: 2px solid black;
        padding: 5px;
    }
</style>
</body>
</html>
