package Negocio

import AcessoDatos.UsuarioDAOimp

class ServicioUsuario {

    var usuarioDAO = UsuarioDAOimp()

    fun usuarios(): List<Usuario>{
        return usuarioDAO.getAllUsuarios()
    }
}