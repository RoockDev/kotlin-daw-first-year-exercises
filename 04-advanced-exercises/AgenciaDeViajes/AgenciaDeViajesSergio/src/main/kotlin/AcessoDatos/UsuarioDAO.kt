package AcessoDatos

import Negocio.Usuario

interface UsuarioDAO {
    fun getAllUsuarios(): List<Usuario>
    fun insertarUsuario(usuario: Usuario): Boolean
}