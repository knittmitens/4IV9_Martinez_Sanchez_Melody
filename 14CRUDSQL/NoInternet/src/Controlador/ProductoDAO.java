package Controlador;

import Modelo.ConexionBD;
import Modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void agregar(Producto producto) throws SQLException, Exception {
        String sql = "INSERT INTO libro (titulo, anio_pub, num_paginas, id_autor, id_genero) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getTitulo());
            ps.setInt(2, producto.getAnioPub());
            ps.setInt(3, producto.getNumPaginas());
            ps.setInt(4, producto.getIdAutor());
            ps.setInt(5, producto.getIdGenero());

            ps.executeUpdate();
        }
    }

    public Producto buscarPorId(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM libro WHERE id_libro = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return construirProductoDesdeResultSet(rs);
                }
            }
        }

        return null;
    }

    public List<Producto> listarTodos() throws SQLException, Exception {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM libro";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                productos.add(construirProductoDesdeResultSet(rs));
            }
        }

        return productos;
    }

    public void actualizar(Producto producto) throws SQLException, Exception {
        String sql = "UPDATE libro SET titulo = ?, anio_pub = ?, num_paginas = ?, id_autor = ?, id_genero = ? WHERE id_libro = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getTitulo());
            ps.setInt(2, producto.getAnioPub());
            ps.setInt(3, producto.getNumPaginas());
            ps.setInt(4, producto.getIdAutor());
            ps.setInt(5, producto.getIdGenero());
            ps.setInt(6, producto.getId());

            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException, Exception {
        String sql = "DELETE FROM libro WHERE id_libro = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Producto construirProductoDesdeResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_libro");
        String titulo = rs.getString("titulo");
        int anioPub = rs.getInt("anio_pub");
        int numPaginas = rs.getInt("num_paginas");
        int idAutor = rs.getInt("id_autor");
        int idGenero = rs.getInt("id_genero");

        return new Producto(id, titulo, anioPub, numPaginas, idAutor, idGenero);
    }
}