package com.universidad.tiendaonline.presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.universidad.tiendaonline.entidades.Cliente;
import com.universidad.tiendaonline.servicios.UsuarioServicio;

/** Ventana de Consulta, Modificación y Eliminación de clientes. */
public class GestionClientes extends JFrame {

    private final UsuarioServicio servicio;
    private final JTextField txtId = new JTextField(8);
    private final JTextField txtNombre = new JTextField(12);
    private final JTextField txtTelefono = new JTextField(10);
    private final JTextField txtCorreo = new JTextField(14);
    private final JButton btnConsultar = new JButton("Consultar");
    private final JButton btnModificar = new JButton("Modificar");
    private final JButton btnEliminar = new JButton("Eliminar");
    private final DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Teléfono", "Correo"}, 0);
    private final JTable tabla = new JTable(modelo);

    public GestionClientes(UsuarioServicio servicio) {
        this.servicio = servicio;
        initComponents();
        refrescarTabla();
    }

    private void initComponents() {
        setTitle("Gestión de Clientes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel form = new JPanel();
        form.add(new JLabel("ID:")); form.add(txtId);
        form.add(new JLabel("Nombre:")); form.add(txtNombre);
        form.add(new JLabel("Tel:")); form.add(txtTelefono);
        form.add(new JLabel("Correo:")); form.add(txtCorreo);
        JPanel botones = new JPanel();
        botones.add(btnConsultar); botones.add(btnModificar); botones.add(btnEliminar);
        add(form, java.awt.BorderLayout.NORTH);
        add(new JScrollPane(tabla), java.awt.BorderLayout.CENTER);
        add(botones, java.awt.BorderLayout.SOUTH);
        btnConsultar.addActionListener(this::btnConsultarActionPerformed);
        btnModificar.addActionListener(this::btnModificarActionPerformed);
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
        setSize(750, 380);
        setLocationRelativeTo(null);
    }

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        Cliente c = servicio.consultarCliente(txtId.getText().trim());
        if (c == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado");
            return;
        }
        txtNombre.setText(c.getNombre());
        txtTelefono.setText(c.getTelefono());
        txtCorreo.setText(c.getCorreoElectronico());
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        boolean ok = servicio.modificarCliente(txtId.getText().trim(),
                txtNombre.getText().trim(), txtTelefono.getText().trim(), txtCorreo.getText().trim());
        JOptionPane.showMessageDialog(this, ok ? "Cliente modificado" : "Cliente no encontrado");
        refrescarTabla();
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        int r = JOptionPane.showConfirmDialog(this, "¿Eliminar el cliente?", "Confirmar",
                JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            boolean ok = servicio.eliminarCliente(txtId.getText().trim());
            JOptionPane.showMessageDialog(this, ok ? "Cliente eliminado" : "Cliente no encontrado");
            refrescarTabla();
        }
    }

    private void refrescarTabla() {
        modelo.setRowCount(0);
        for (Cliente c : servicio.listarClientes()) {
            modelo.addRow(new Object[]{c.getId(), c.getNombre(), c.getTelefono(), c.getCorreoElectronico()});
        }
    }
}
