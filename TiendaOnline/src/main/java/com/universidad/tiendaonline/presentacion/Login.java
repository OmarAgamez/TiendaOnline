package com.universidad.tiendaonline.presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.universidad.tiendaonline.entidades.UsuarioWeb;
import com.universidad.tiendaonline.servicios.UsuarioServicio;

/** Ventana de ingreso. Solo captura datos y delega la lógica al servicio. */
public class Login extends JFrame {

    private final UsuarioServicio servicio;
    private final JTextField txtUsuario = new JTextField(15);
    private final JPasswordField txtContrasena = new JPasswordField(15);
    private final JButton btnIngresar = new JButton("Ingresar");
    private int intentos = 0;
    private static final int MAX_INTENTOS = 3;

    public Login(UsuarioServicio servicio) {
        this.servicio = servicio;
        initComponents();
    }

    private void initComponents() {
        setTitle("Tienda Online - Ingreso");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new java.awt.GridLayout(3, 2, 8, 8));
        add(new JLabel("Usuario:"));
        add(txtUsuario);
        add(new JLabel("Contraseña:"));
        add(txtContrasena);
        add(new JLabel());
        add(btnIngresar);
        btnIngresar.addActionListener(this::btnIngresarActionPerformed);
        pack();
        setLocationRelativeTo(null);
    }

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtContrasena.getPassword());
        if (usuario.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese usuario y contraseña",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        UsuarioWeb u = servicio.iniciarSesion(usuario, clave);
        if (u != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido: " + u.descripcion());
            new GestionClientes(servicio).setVisible(true);
            dispose();
            return;
        }
        intentos++;
        if (intentos >= MAX_INTENTOS) {
            JOptionPane.showMessageDialog(this, "Superó el máximo de intentos",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            btnIngresar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Intentos restantes: "
                    + (MAX_INTENTOS - intentos));
            txtContrasena.setText("");
        }
    }

}
