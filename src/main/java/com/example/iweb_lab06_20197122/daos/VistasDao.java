package com.example.iweb_lab06_20197122.daos;

import com.example.iweb_lab06_20197122.beans.Genero;
import com.example.iweb_lab06_20197122.beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class VistasDao {
    public ArrayList<Pelicula> obtenerListaPeliculas() {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        try{
            //Conexión a la base de datos
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/mydb";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            //Ejecución de la consulta
            String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero;";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Pelicula pelicula = new Pelicula();
                Genero genero = new Genero();
                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setDirector(rs.getString(3));
                pelicula.setAnoPublicacion(rs.getInt(4));
                pelicula.setRating(rs.getDouble(5));
                pelicula.setBoxOffice(rs.getDouble(6));
                genero.setNombre(rs.getString(7)); //Se obtiene el nombre del género
                pelicula.setGenero(genero);//Se asigna el género a la película

                listaPeliculas.add(pelicula);
            }

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return listaPeliculas;
    }
    public ArrayList<Pelicula> buscarPorTitulo(String titulo){

        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero WHERE titulo = ? or lower(titulo) like lower(?);";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,titulo);
            pstmt.setString(2,"%" + titulo + "%");

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula();
                    Genero genero = new Genero();
                    pelicula.setIdPelicula(rs.getInt(1));
                    pelicula.setTitulo(rs.getString(2));
                    pelicula.setDirector(rs.getString(3));
                    pelicula.setAnoPublicacion(rs.getInt(4));
                    pelicula.setRating(rs.getDouble(5));
                    pelicula.setBoxOffice(rs.getDouble(6));
                    genero.setNombre(rs.getString(7)); //Se obtiene el nombre del género
                    pelicula.setGenero(genero);//Se asigna el género a la película

                    listaPeliculas.add(pelicula);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPeliculas;
    }
}
