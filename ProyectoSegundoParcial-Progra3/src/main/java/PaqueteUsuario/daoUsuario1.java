/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteUsuario;
import PaqueteUsuario.clsUsuario1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoUsuario1 {

    private static final String SQL_SELECT = "SELECT usuid, usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion FROM tbl_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET usunombre=?, usucontrasena=?, usuultimasesion=?, usuestatus=?, usunombrereal=?, usucorreoe=?, usutelefono=?, usudireccion=? WHERE usuid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE usuid=?";
    private static final String SQL_QUERY = "SELECT usuid, usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion FROM tbl_usuario WHERE usuid=?";
    private static final String SQL_QUERYN = "SELECT usuid, usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion FROM tbl_usuario WHERE usunombre=?";    

    public List<clsUsuario1> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsUsuario1 usuario = null;
        List<clsUsuario1> usuarios = new ArrayList<clsUsuario1>();
        try {
            conn = clsConexion2.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");

                usuario = new clsUsuario1();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);;
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion2.close(rs);
            clsConexion2.close(stmt);
            clsConexion2.close(conn);
        }

        return usuarios;
    }

    public int insert(clsUsuario1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion2.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsunombre());
            stmt.setString(2, usuario.getUsucontrasena());            

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

    public int update(clsUsuario1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion2.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsunombre());
            stmt.setString(2, usuario.getUsucontrasena());            
            stmt.setInt(9, usuario.getUsuid());

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

    public int delete(clsUsuario1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion2.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getUsuid());
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

    public clsUsuario1 query(clsUsuario1 usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion2.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getUsuid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");

                usuario = new clsUsuario1();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
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
        return usuario;
    }
public clsUsuario1 queryn(clsUsuario1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion2.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getUsunombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                String ultimasesion = rs.getString("usuultimasesion");
                String estatus = rs.getString("usuestatus");
                String nombrereal = rs.getString("usunombrereal");
                String correoe = rs.getString("usucorreoe");
                String telefono = rs.getString("usutelefono");
                String direccion = rs.getString("usudireccion");

                usuario = new clsUsuario1();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
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
        return usuario;
    }
    
}
