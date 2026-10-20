package com.universidad.tiendaonline.presentacion;

import com.universidad.tiendaonline.servicios.UsuarioServicio;
import com.universidad.tiendaonline.servicios.ValidacionException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Ventana para registrar un nuevo cliente. Solo captura datos y delega
 * la lógica a la capa de servicios.
 */
public class RegistroCliente extends JDialog {

    private final UsuarioServicio servicio;
    private final Runnable alGuardar;
    private final JTextField txtId = new JTextField(15);
    private final JTextField txtUsuario = new JTextField(15);
    private final JPasswordField txtContrasena = new JPasswordField(15);
    private final JTextField txtNombre = new JTextField(15);
    private final JTextField txtTelefono = new JTextField(15);
    private final JTextField txtCorreo = new JTextField(15);
    private final JButton btnGuardar = new JButton("Guardar");
    private final JButton btnCancelar = new JButton("Cancelar");

    /**
     * @param padre ventana que abre este formulario
     * @param servicio capa de servicios
     * @param alGuardar acción que se ejecuta tras guardar (p. ej. refrescar la tabla)
     */
    public RegistroCliente(JFrame padre, UsuarioServicio servicio, Runnable alGuardar) {
        super(padre, "Registrar cliente", true);
        this.servicio = servicio;
        this.alGuardar = alGuardar;
        initComponents();
    }

    private void initComponents() {
        setLayout(new java.awt.GridLayout(7, 2, 8, 8));
        add(new JLabel("ID:")); add(txtId);
        add(new JLabel("Usuario:")); add(txtUsuario);
        add(new JLabel("Contraseña:")); add(txtContrasena);
        add(new JLabel("Nombre:")); add(txtNombre);
        add(new JLabel("Teléfono:")); add(txtTelefono);
        add(new JLabel("Correo:")); add(txtCorreo);
        add(btnGuardar); add(btnCancelar);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnCancelar.addActionListener(evt -> dispose());
        pack();
        setLocationRelativeTo(getOwner());
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            servicio.registrarCliente(txtId.getText().trim(),
                    txtUsuario.getText().trim(), new String(txtContrasena.getPassword()),
                    txtNombre.getText().trim(), txtTelefono.getText().trim(),
                    txtCorreo.getText().trim());
            JOptionPane.showMessageDialog(this, "Cliente registrado");
            alGuardar.run();
            dispose();
        } catch (ValidacionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}