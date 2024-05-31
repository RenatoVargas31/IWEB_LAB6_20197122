<%@ page import="com.example.iweb_lab06_20197122.beans.Pelicula" %>
<%@ page import="java.text.DecimalFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: rlvs_
  Date: 30/05/2024
  Time: 01:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="viewPelicula" type="com.example.iweb_lab06_20197122.beans.Pelicula" scope="request"/>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title><%= viewPelicula.getTitulo() %></title>
</head>
<body>
<h1><%= viewPelicula.getTitulo() %></h1>
<table>
    <tr><th>idPelícula</th><td><%= viewPelicula.getIdPelicula() %></td></tr>
    <tr><th>Director</th><td><%= viewPelicula.getDirector() %></td></tr>
    <tr><th>Año de Publicación</th><td><%= viewPelicula.getAnoPublicacion() %></td></tr>
    <tr><th>Rating</th><td><%= viewPelicula.getRating() %>/10</td></tr>
    <tr><th>Box Office</th><td>$<%= new DecimalFormat("###,###.00").format(viewPelicula.getBoxOffice()) %></td></tr>
    <tr><th>Género</th><td><%= viewPelicula.getGenero().getNombre() %></td></tr>
    <tr><th>Actores</th><td><a href="listaActores.jsp?idPelicula=<%= viewPelicula.getIdPelicula() %>">Ver Actores</a></td></tr>
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
