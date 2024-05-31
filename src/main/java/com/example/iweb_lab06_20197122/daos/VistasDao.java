package com.example.iweb_lab06_20197122.daos;

import com.example.iweb_lab06_20197122.beans.Genero;
import com.example.iweb_lab06_20197122.beans.Pelicula;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            ResultSet rs = stmt.executeQuery("SELECT p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre " +
                                                    "FROM Pelicula p " +
                                                    "JOIN Genero g ON p.idGenero = g.idGenero;");

            while(rs.next()){
                Pelicula pelicula = new Pelicula();
                Genero genero = new Genero();
                pelicula.setTitulo(rs.getString(1));
                pelicula.setDirector(rs.getString(2));
                pelicula.setAnoPublicacion(rs.getInt(3));
                pelicula.setRating(rs.getDouble(4));
                pelicula.setBoxOffice(rs.getDouble(5));
                genero.setNombre(rs.getString(6));
                pelicula.setGenero(genero);

                listaPeliculas.add(pelicula);
            }

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return listaPeliculas;
    }
}
