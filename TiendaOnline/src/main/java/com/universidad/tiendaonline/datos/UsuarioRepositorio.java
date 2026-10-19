package com.universidad.tiendaonline.datos;

import java.util.ArrayList;
import com.universidad.tiendaonline.entidades.UsuarioWeb;

/**
 * Capa de datos: guarda los usuarios en memoria con un ArrayList.
 * En el momento 3 solo se cambia aquí para persistir en archivos.
 */
public class UsuarioRepositorio {

    private final ArrayList<UsuarioWeb> usuarios = new ArrayList<>();

    public void guardar(UsuarioWeb usuario) {
        usuarios.add(usuario);
    }

    public UsuarioWeb buscarPorId(String id) {
        for (UsuarioWeb u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public UsuarioWeb buscarPorNombreUsuario(String nombreUsuario) {
        for (UsuarioWeb u : usuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario)) {
                return u;
            }
        }
        return null;
    }

    public boolean eliminar(String id) {
        UsuarioWeb u = buscarPorId(id);
        return u != null && usuarios.remove(u);
    }

    public ArrayList<UsuarioWeb> listar() {
        return usuarios;
    }
}
