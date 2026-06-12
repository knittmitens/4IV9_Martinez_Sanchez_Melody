package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductoVista extends JFrame {

    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    private JTextField txtId;
    private JTextField txtTitulo;
    private JTextField txtAnioPub;
    private JTextField txtNumPaginas;
    private JTextField txtIdAutor;
    private JTextField txtIdGenero;

    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnLimpiar;

    public ProductoVista() {
        setTitle("CRUD de Libros - Hobby Lectura");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout(10, 10));

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(39, 174, 96));

        JLabel lblTitulo = new JLabel("Sistema de Gestión de Libros");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);

        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(
            new String[]{"ID", "Título", "Año Publicación", "Páginas", "ID Autor", "ID Género"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.setRowHeight(25);

        JScrollPane scrollTabla = new JScrollPane(tablaProductos);
        add(scrollTabla, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout(10, 10));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInferior.add(crearPanelFormulario(), BorderLayout.CENTER);
        panelInferior.add(crearPanelBotones(), BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridLayout(2, 6, 8, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Datos del Libro"));

        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panel.add(txtTitulo);

        panel.add(new JLabel("Año Pub.:"));
        txtAnioPub = new JTextField();
        panel.add(txtAnioPub);

        panel.add(new JLabel("Páginas:"));
        txtNumPaginas = new JTextField();
        panel.add(txtNumPaginas);

        panel.add(new JLabel("ID Autor:"));
        txtIdAutor = new JTextField();
        panel.add(txtIdAutor);

        panel.add(new JLabel("ID Género:"));
        txtIdGenero = new JTextField();
        panel.add(txtIdGenero);

        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar por ID");
        btnLimpiar = new JButton("Limpiar");

        panel.add(btnAgregar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);
        panel.add(btnLimpiar);

        return panel;
    }

    public JTable getTablaProductos() {
        return tablaProductos;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public JTextField getTxtAnioPub() {
        return txtAnioPub;
    }

    public JTextField getTxtNumPaginas() {
        return txtNumPaginas;
    }

    public JTextField getTxtIdAutor() {
        return txtIdAutor;
    }

    public JTextField getTxtIdGenero() {
        return txtIdGenero;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public boolean confirmar(String mensaje) {
        return JOptionPane.showConfirmDialog(
            this,
            mensaje,
            "Confirmar",
            JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION;
    }

    public void limpiarFormulario() {
        txtId.setText("");
        txtTitulo.setText("");
        txtAnioPub.setText("");
        txtNumPaginas.setText("");
        txtIdAutor.setText("");
        txtIdGenero.setText("");
        tablaProductos.clearSelection();
    }
}