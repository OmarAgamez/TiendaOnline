package com.universidad.tiendaonline.servicios;

import java.util.ArrayList;
import com.universidad.tiendaonline.datos.UsuarioRepositorio;
import com.universidad.tiendaonline.entidades.Administrador;
import com.universidad.tiendaonline.entidades.Cliente;
import com.universidad.tiendaonline.entidades.UsuarioWeb;

/** Capa de servicios: reglas de negocio de login y CRUD de clientes. */
public class UsuarioServicio {

    private final UsuarioRepositorio repositorio;

    public UsuarioServicio(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
        // Datos de prueba para la demostración
        repositorio.guardar(new Administrador("A1", "admin", "123"));
        repositorio.guardar(new Cliente("C1", "ana", "abc", "Ana Pérez", "3001234567", "ana@mail.com"));
    }

    /** @return el usuario autenticado o null si las credenciales son inválidas */
    public UsuarioWeb iniciarSesion(String usuario, String clave) {
        UsuarioWeb u = repositorio.buscarPorNombreUsuario(usuario);
        return (u != null && u.autenticar(usuario, clave)) ? u : null;
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (UsuarioWeb u : repositorio.listar()) {
            if (u instanceof Cliente) {
                clientes.add((Cliente) u);
            }
        }
        return clientes;
    }

    public Cliente consultarCliente(String id) {
        UsuarioWeb u = repositorio.buscarPorId(id);
        return (u instanceof Cliente) ? (Cliente) u : null;
    }

    public boolean modificarCliente(String id, String nombre, String telefono, String correo) {
        Cliente c = consultarCliente(id);
        if (c == null) {
            return false;
        }
        c.setNombre(nombre);
        c.setTelefono(telefono);
        c.setCorreoElectronico(correo);
        return true;
    }

    public boolean eliminarCliente(String id) {
        return consultarCliente(id) != null && repositorio.eliminar(id);
    }
        /**
     * Registra un nuevo cliente validando los datos.
     *
     * @throws ValidacionException si hay campos vacíos, o el ID o el usuario ya existen
     */
    public void registrarCliente(String id, String usuario, String clave,
            String nombre, String telefono, String correo) throws ValidacionException {
        if (id.isEmpty() || usuario.isEmpty() || clave.isEmpty()
                || nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            throw new ValidacionException("Todos los campos son obligatorios");
        }
        if (!correo.contains("@")) {
            throw new ValidacionException("El correo no es válido");
        }
        if (repositorio.buscarPorId(id) != null) {
            throw new ValidacionException("Ya existe un usuario con ese ID");
        }
        if (repositorio.buscarPorNombreUsuario(usuario) != null) {
            throw new ValidacionException("El nombre de usuario ya está en uso");
        }
        repositorio.guardar(new Cliente(id, usuario, clave, nombre, telefono, correo));
    }
}
