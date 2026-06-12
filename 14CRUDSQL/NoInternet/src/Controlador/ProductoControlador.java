package Controlador;

import Vista.ProductoVista;
import Modelo.Producto;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class ProductoControlador {

    private ProductoDAO dao;
    private ProductoVista vista;

    public ProductoControlador(ProductoDAO dao, ProductoVista vista) {
        this.dao = dao;
        this.vista = vista;

        inicializarEventos();
        cargarTabla();
    }

    private void inicializarEventos() {
        vista.getBtnAgregar().addActionListener(e -> agregar());
        vista.getBtnActualizar().addActionListener(e -> actualizar());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
        vista.getBtnBuscar().addActionListener(e -> buscar());
        vista.getBtnLimpiar().addActionListener(e -> vista.limpiarFormulario());

        vista.getTablaProductos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarProductoSeleccionado();
            }
        });
    }

    private void agregar() {
        try {
            Producto producto = construirProductoDesdeFormulario();
            if (producto == null) return;

            dao.agregar(producto);
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Libro agregado exitosamente.");
        } catch (NumberFormatException ex) {
            vista.mostrarError("Verifique que los campos numéricos sean válidos.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al agregar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void actualizar() {
        try {
            Producto producto = construirProductoDesdeFormulario();
            if (producto == null) return;

            dao.actualizar(producto);
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Libro actualizado exitosamente.");
        } catch (NumberFormatException ex) {
            vista.mostrarError("Verifique que los campos numéricos sean válidos.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al actualizar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void eliminar() {
        String idStr = vista.getTxtId().getText().trim();

        if (idStr.isEmpty()) {
            vista.mostrarError("Ingrese el ID del libro a eliminar.");
            return;
        }

        int id = Integer.parseInt(idStr);

        if (vista.confirmar("¿Está seguro de eliminar el libro con ID " + id + "?")) {
            try {
                dao.eliminar(id);
                cargarTabla();
                vista.limpiarFormulario();
                vista.mostrarMensaje("Libro eliminado.");
            } catch (SQLException ex) {
                vista.mostrarError("Error al eliminar: " + ex.getMessage());
            } catch (Exception ex) {
                vista.mostrarError("Error: " + ex.getMessage());
            }
        }
    }

    private void buscar() {
        String idStr = vista.getTxtId().getText().trim();

        if (idStr.isEmpty()) {
            vista.mostrarError("Ingrese el ID del libro a buscar.");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            Producto producto = dao.buscarPorId(id);

            if (producto != null) {
                cargarProductoEnFormulario(producto);
                vista.mostrarMensaje("Libro encontrado:\n" + producto.mostrarDetalle());
            } else {
                vista.mostrarError("No se encontró un libro con ID " + id);
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al buscar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private Producto construirProductoDesdeFormulario() {
        if (vista.getTxtTitulo().getText().trim().isEmpty()) {
            vista.mostrarError("El título es obligatorio.");
            return null;
        }

        int id = 0;

        if (!vista.getTxtId().getText().trim().isEmpty()) {
            id = Integer.parseInt(vista.getTxtId().getText().trim());
        }

        String titulo = vista.getTxtTitulo().getText().trim();
        int anioPub = Integer.parseInt(vista.getTxtAnioPub().getText().trim());
        int numPaginas = Integer.parseInt(vista.getTxtNumPaginas().getText().trim());
        int idAutor = Integer.parseInt(vista.getTxtIdAutor().getText().trim());
        int idGenero = Integer.parseInt(vista.getTxtIdGenero().getText().trim());

        return new Producto(id, titulo, anioPub, numPaginas, idAutor, idGenero);
    }

    private void cargarTabla() {
        DefaultTableModel modelo = vista.getModeloTabla();
        modelo.setRowCount(0);

        try {
            List<Producto> productos = dao.listarTodos();

            for (Producto p : productos) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getTitulo(),
                    p.getAnioPub(),
                    p.getNumPaginas(),
                    p.getIdAutor(),
                    p.getIdGenero()
                });
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al cargar libros: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void cargarProductoSeleccionado() {
        int fila = vista.getTablaProductos().getSelectedRow();
        if (fila < 0) return;

        int id = (int) vista.getModeloTabla().getValueAt(fila, 0);

        try {
            Producto producto = dao.buscarPorId(id);
            if (producto != null) {
                cargarProductoEnFormulario(producto);
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al cargar libro: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void cargarProductoEnFormulario(Producto producto) {
        vista.getTxtId().setText(String.valueOf(producto.getId()));
        vista.getTxtTitulo().setText(producto.getTitulo());
        vista.getTxtAnioPub().setText(String.valueOf(producto.getAnioPub()));
        vista.getTxtNumPaginas().setText(String.valueOf(producto.getNumPaginas()));
        vista.getTxtIdAutor().setText(String.valueOf(producto.getIdAutor()));
        vista.getTxtIdGenero().setText(String.valueOf(producto.getIdGenero()));
    }
}