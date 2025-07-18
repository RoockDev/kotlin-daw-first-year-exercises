package AcessoDatos

import Negocio.Usuario
import Utilidades.ConexionBBDD
import Utilidades.SQL_Usuario

class UsuarioDAOimp: UsuarioDAO {

    private val conexion = ConexionBBDD()

    override fun getAllUsuarios(): List<Usuario> {
        val listaUsuarios = ArrayList<Usuario>()
        conexion.conectar()
        try {
            val st = conexion.getStatement()
            val rs = st?.executeQuery(SQL_Usuario.SQL_SELECT_ALL)
            while (rs?.next() == true){
                val usuario = Usuario(rs.getInt("id"),rs.getString("nombre"),rs.getDate("fecha"))
                listaUsuarios.add(usuario)
            }
            st?.close()

        }catch (e: Exception){
            println(e.message)
        }finally {
            conexion.desconectar()
        }


        return listaUsuarios
    }

    override fun insertarUsuario(usuario: Usuario): Boolean {
        var insertado = false
        conexion.conectar()
        try {
            val ps = conexion.getPreparedStatement(SQL_Usuario.SQL_INSERT_USUARIO)
            ps?.setString(1, usuario.nombre)
            ps?.setDate(2, java.sql.Date(usuario.fecha.time))
            val result = ps?.executeUpdate()
            if (result != null) {
                insertado = true
            }
            ps?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }finally {
            conexion.desconectar()
        }

        return insertado

    }
}