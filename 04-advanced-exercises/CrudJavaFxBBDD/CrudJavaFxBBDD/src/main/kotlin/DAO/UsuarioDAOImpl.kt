package DAO

import Modelo.Rol
import Modelo.Usuario
import Util.ConexionBD
import java.sql.DriverManager.println
import java.sql.SQLException
import java.util.ArrayList

class UsuarioDAOImpl:UsuarioDAO {
    //hacemos una instancia a la conexion de bbdd
    private val conexion = ConexionBD()

    override fun getUsuarioByEmail(email: String): Usuario? {
        var usuario:Usuario? = null
        try {
            //Establecemos la conexion con la base de datos
            conexion.conectar()

            // Preparamos la consulta sql para buscar un usuario por email
            val query = "SELECT * FROM usuarios WHERE email = ?"
            val preparedStatement = conexion.getPreparedStatament(query)

            //Asignamos el valor del parametro (email)
            preparedStatement?.setString(1,email)

            //ejecutamos la consulta
            var resultSet = preparedStatement?.executeQuery()

            //si hay resultado,creamos un objeto usuario
            if (resultSet?.next()== true){
                val rolStr = resultSet.getString("rol")
                val rol = when(rolStr){
                    "ESTANDAR" -> Rol.ESTANDAR
                    "ADMINISTRADOR" -> Rol.ADMINISTRADOR
                    else -> Rol.ESTANDAR
                }

                usuario = Usuario(
                    email = resultSet.getString("email"),
                    nombre = resultSet.getString("nombre"),
                    apellidos = resultSet.getString("apellidos"),
                    edad = resultSet.getString("edad"),
                    password = resultSet.getString("password"),
                    rol = rol

                )
            }
            preparedStatement?.close()
        }catch (e:SQLException){
            println("Error al buscar usuario por mail: ${e.message}")
        }finally {
            //cerrar la conexion
            conexion.desconectar()
        }
        return usuario
    }

    override fun getAllUsuarios(): List<Usuario> {
        val usuarios = ArrayList<Usuario>()
        try {
            conexion.conectar()

            //consulta para obtener todos los usuarios
            val query = "SELECT * FROM usuarios"
            val statament = conexion.getStatament()
            val resultSet = statament?.executeQuery(query)

            // Recorremos todos los resultados y creamos objetos usuarios

            while (resultSet?.next() == true){
                val rolStr = resultSet.getString("rol")
                val rol = when(rolStr){
                    "ESTANDAR" -> Rol.ESTANDAR
                    "ADMINISTRADOR" -> Rol.ADMINISTRADOR
                    else -> Rol.ESTANDAR
                }

                val usuario = Usuario(
                    email = resultSet.getString("email"),
                    nombre = resultSet.getString("nombre"),
                    apellidos = resultSet.getString("apellidos"),
                    edad = resultSet.getString("edad"),
                    password = resultSet.getString("password"),
                    rol = rol
                )
            }
            statament?.close()

        }catch (e:SQLException){
            println("Error al obtener todos los usuarios: ${e.message}")
        }finally {
            conexion.desconectar()
        }
        return usuarios
    }

    override fun insertUsuario(usuario: Usuario): Boolean {
        var insertado = false
        try {
            conexion.conectar()

            //Consulta SQL para insertar un nuevo usuario
            val query = "INSERT INTO usuarios(email,nombre,apellidos,edad,password,rol) VALUES (?,?,?,?,?,?)"
            val preparedStatement = conexion.getPreparedStatament(query)

            //Asignamos los valores a cada uno de los parametros
            preparedStatement?.setString(1,usuario.email)
            preparedStatement?.setString(2,usuario.nombre)
            preparedStatement?.setString(3,usuario.apellidos)
            preparedStatement?.setString(4,usuario.edad)
            preparedStatement?.setString(5,usuario.password)
            preparedStatement?.setString(6,usuario.rol.toString())

            //executeUpdate() devuelve el numero de filas afectadas
            val resultado = preparedStatement?.executeUpdate()

            // si alguna fila ha sido afectado, el insert ha salido bien
            if (resultado == 1) insertado = true
            preparedStatement?.close()

        }catch (e:SQLException){
            println("Error al insertar un usuario: ${e.message}")
        }finally {
            conexion.desconectar()
        }
        return insertado
    }

    override fun updateUsuario(usuario: Usuario): Boolean {
        var update = false
        try {
            conexion.conectar()

            //Consulta SQL para actualizar datos de usuario por email(condicion WHERE)
            val query = "UPDATE usuarios SET nombre = ?, apellidos = ?, edad = ?, password = ? WHERE email = ? "
            val preparedStatement = conexion.getPreparedStatament(query)

            preparedStatement?.setString(1,usuario.nombre)
            preparedStatement?.setString(2,usuario.apellidos)
            preparedStatement?.setString(3,usuario.edad)
            preparedStatement?.setString(4,usuario.password)
            preparedStatement?.setString(5,usuario.email) // condicion WHERE

            //executeUpdate() devuelve el numero de filas afectadas
            val resultado = preparedStatement?.executeUpdate()
            if (resultado == 1) update = true
            preparedStatement?.close()

        }catch (e:SQLException){
            println("Error al actualizar datos: ${e.message}")
        }finally {
            conexion.desconectar()
        }
        return update
    }

    override fun updateRol(usuario: Usuario): Boolean {
        var cambioRol = false
        try {
            conexion.conectar()

            //Consulta para actualizar el rol del usuario
            val query = "UPDATE usuarios SET rol = ? WHERE email = ?"
            val preparedStatement = conexion.getPreparedStatament(query)

            preparedStatement?.setString(1,usuario.rol.toString())
            preparedStatement?.setString(2,usuario.email)

            //ExecuteUpdate()devuelve el numero de filas afectadas
            val resultado = preparedStatement?.executeUpdate()

            if (resultado == 1) cambioRol = true
            preparedStatement?.close()
        }catch (e:SQLException){
            println("Error al intentar actualizar el rol: ${e.message}")
        }finally {
            conexion.desconectar()
        }
        return cambioRol
    }

    override fun deleteUsuario(usuario: Usuario): Boolean {
        var borrado = false
        try {
            conexion.conectar()

            //Consulta para borrar un usuario por email
            val query = "DELETE from usuarios WHERE email = ?"
            val preparedStatement = conexion.getPreparedStatament(query)

            preparedStatement?.setString(1,usuario.email)

            //executeUpdate() devuelve el numero de filas afectadas
            val resultado = preparedStatement?.executeUpdate()

            if (resultado==1) borrado = true
            preparedStatement?.close()
        }catch (e:SQLException){
            println("Error al intentar borrar usuario: ${e.message}")
        }finally {
            conexion.desconectar()
        }
        return borrado
    }
}