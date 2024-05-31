<%@ page import="com.example.iweb_lab06_20197122.beans.Pelicula" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.stream.Collectors" %><%--
  Created by IntelliJ IDEA.
  User: rlvs_
  Date: 30/05/2024
  Time: 01:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaPeliculas" scope="request" type="ArrayList<Pelicula>" />
<%
    // Sort the listaPeliculas list using Stream API
    listaPeliculas = (ArrayList<Pelicula>) listaPeliculas.stream()
            .sorted(Comparator.comparingDouble(Pelicula::getRating)
                    .thenComparingDouble(Pelicula::getBoxOffice).reversed())
            .collect(Collectors.toList());
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Películas</title>
</head>
<body>
<h1>Lista de Películas</h1>
<form action="<%=request.getContextPath()%>/PeliculaServlet?action=buscar" method="post" id="buscador">
    <input type="text" name="textoBuscar" placeholder="Buscar película..." value="<%= request.getAttribute("busqueda") != null ? request.getAttribute("busqueda") : "" %>">
    <button type="submit">Buscar</button>
</form>
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
        <td><a href="viewPelicula.jsp?idPelicula=<%= pelicula.getIdPelicula() %>"><%= pelicula.getTitulo() %></a></td>
        <td><%= pelicula.getDirector() %></td>
        <td><%= pelicula.getAnoPublicacion() %></td>
        <td><%= pelicula.getRating() %>/10</td>
        <td>$<%= new DecimalFormat("###,###.00").format(pelicula.getBoxOffice()) %></td>
        <td><%= pelicula.getGenero().getNombre() %></td> 
        <td><a href="listaActores.jsp?idPelicula=<%= pelicula.getIdPelicula() %>">Ver Actores</a></td>
    </tr>
    <% } %>
</table>
<style>
    table, th, td {
        border: 2px solid black;
        padding: 5px;
    }
    #buscador{
        margin-bottom: 20px;
    }
</style>
</body>
</html>
