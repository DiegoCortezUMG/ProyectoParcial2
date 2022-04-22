/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaquetePeliculas;

import PaquetePeliculas.*;
import PaquetePeliculas.clsPelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPeliculas {

    private static final String SQL_SELECT = "SELECT id_pelicula, nombre_pelicula, clasif_pelicula, estado_pelicula FROM peliculas";
    private static final String SQL_INSERT = "INSERT INTO peliculas(nombre_pelicula, clasif_pelicula, estado_pelicula, ) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombre_pelicula=?, clasif_pelicula=?, estado_pelicula=? WHERE id_pelicula = ?";
    private static final String SQL_DELETE = "DELETE FROM peliculas WHERE id_pelicula=?";
    private static final String SQL_QUERY = "SELECT id_pelicula, nombre_pelicula, clasif_pelicula, estado_pelicula FROM peliculas WHERE nomreb_pelicula = ?";

    public List<clsPelicula> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPelicula pelicula = null;
        List<clsPelicula> peliculas = new ArrayList<clsPelicula>();
        try {
            conn = clsConexion2.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int peli_id = rs.getInt("id_pelicula");
                String peli_nombre = rs.getString("nombre_pelicula");
                String peli_clasif = rs.getString("clasif_pelicula");
                String peli_estado = rs.getString("estado_pelicula");

                pelicula = new clsPelicula();
                pelicula.setPeli_Id(peli_id);
                pelicula.setPeli_nombre(peli_nombre);
                pelicula.setPeli_clasif(peli_clasif);
                pelicula.setPeli_estado(peli_estado);

                peliculas.add(pelicula);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion2.close(rs);
            clsConexion2.close(stmt);
            clsConexion2.close(conn);
        }

        return peliculas;
    }

    public int insert(clsPelicula pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion2.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pelicula.getPeli_nombre());
            stmt.setString(2, pelicula.getPeli_clasif());
            stmt.setString(3, pelicula.getPeli_estado());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion2.close(stmt);
            clsConexion2.close(conn);
        }

        return rows;
    }

    public int update(clsPelicula pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion2.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pelicula.getPeli_nombre());
            stmt.setString(2, pelicula.getPeli_clasif());
            stmt.setString(3, pelicula.getPeli_estado());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion2.close(stmt);
            clsConexion2.close(conn);
        }

        return rows;
    }

    public int delete(clsPelicula pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion2.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pelicula.getPeli_Id());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion2.close(stmt);
            clsConexion2.close(conn);
        }

        return rows;
    }

    public clsPelicula query(clsPelicula pelicula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion2.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, pelicula.getPeli_nombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int peli_id = rs.getInt("id_pelicula");
                String peli_nombre = rs.getString("nombre_pelicula");
                String peli_clasif = rs.getString("clasif_pelicula");
                String peli_estado = rs.getString("estado_pelicula");

                pelicula = new clsPelicula();
                pelicula.setPeli_Id(peli_id);
                pelicula.setPeli_clasif(peli_clasif);
                pelicula.setPeli_estado(peli_estado);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion2.close(rs);
            clsConexion2.close(stmt);
            clsConexion2.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return pelicula;
    }
}
