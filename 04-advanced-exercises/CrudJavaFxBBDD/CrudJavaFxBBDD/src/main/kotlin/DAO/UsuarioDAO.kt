package DAO

import Modelo.Usuario

interface UsuarioDAO {
    fun getUsuarioByEmail(email:String):Usuario?
    fun getAllUsuarios():List<Usuario>
    fun insertUsuario(usuario: Usuario):Boolean
    fun updateUsuario(usuario: Usuario):Boolean
    fun updateRol(usuario: Usuario):Boolean
    fun deleteUsuario(usuario: Usuario):Boolean
}