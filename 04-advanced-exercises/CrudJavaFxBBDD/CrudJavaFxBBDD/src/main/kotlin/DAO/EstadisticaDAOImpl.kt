package DAO

import Modelo.Estadistica
import Util.ConexionBD
import java.sql.DriverManager.println
import java.sql.SQLException

class EstadisticaDAOImpl:EstadisticaDAO {
    private val conexion = ConexionBD()
    override fun actualizaGanado(userMail: String): Boolean {
        var actualizado = false
        try {
            conexion.conectar()

            //verificamos si hay estadisticas para este usuario
            val estadistica = getEstadisticaByMail(userMail)

            if (estadistica!=null){
                // si existen, actualizamos incrementando ambos contadores
                val query = "UPDATE estadisticas SET partidasJugadas = partidasJugadas + 1, partigasGanadas = partidasGanadas + 1 WHERE email = ?"
                val preparedStatement = conexion.getPreparedStatament(query)

                preparedStatement?.setString(1,userMail)

                val resultado = preparedStatement?.executeUpdate()
                if (resultado == 1) actualizado = true
                preparedStatement?.close()
            }else{
                // si no existen, creamos un nuevo registro
                actualizado = insertarEstadisticas(userMail,1,1)
            }
        }catch (e:SQLException){
            println("Error al intentar actualizar la partidad; ${e.message}")
        }finally {
            conexion.desconectar()
        }
        return actualizado
    }

    override fun actualizaPerdido(userMail: String): Boolean {
        var actualizado = false
        try {
            conexion.conectar()

            //verificamos si hay estadistica para este usuario
            val estadistica = getEstadisticaByMail(userMail)

            if (estadistica!=null){
                //si existen, actualizamos incrementado el contador de partidas jugadas
                val query = "SELECT * FROM estadisticas SET partidasJugadas = partidasJugadas + 1 WHERE email = ?"
                val preparedStatement = conexion.getPreparedStatament(query)

                preparedStatement?.setString(1,userMail)

                val resultado = preparedStatement?.executeUpdate()
                if (resultado == 1) actualizado = true
                preparedStatement?.close()
            }else{
                // si no hay registro, creamos uno
                actualizado = insertarEstadisticas(userMail,1,0)
            }
        }catch (e:SQLException){
            println("Error al intentar actualizar las partidas jugadas. ${e.message}")
        }finally {
            conexion.desconectar()
        }
        return actualizado
    }

    override fun insertarEstadisticas(userMail: String, partidas: Int, ganadas: Int): Boolean {
        var insertada = false
        try {
            conexion.conn

            // Consulta para las nuevas estadisticas
            val query = "INSERT INTO estadisticas(email,partidasJugadas,partidasGanadas) VALUES(?,?,?)"
            val preparedStatement = conexion.getPreparedStatament(query)
             preparedStatement?.setString(1,userMail)
            preparedStatement?.setInt(2,partidas)
            preparedStatement?.setInt(3,ganadas)

            val resultado = preparedStatement?.executeUpdate()
            if (resultado == 1) insertada = true
            preparedStatement?.close()

        }catch (e:SQLException){
            println("Error al intentar insertar en estadisticas")
        }finally {
            conexion.desconectar()
        }
        return insertada
    }

    override fun getEstadisticaByMail(userMail: String): Estadistica? {
        var estadistica:Estadistica? = null
        try {
            conexion.conectar()

            //consulta para obtener las estadisticas de los usuarios por email
            val query = "SELECT * FROM estadisticas WHERE email = ?"
            val preparedStatement = conexion.getPreparedStatament(query)

            preparedStatement?.setString(1,userMail)
            var resultSet = preparedStatement?.executeQuery()

            if (resultSet?.next() == true){
                estadistica = Estadistica(
                    email =  resultSet.getString("email"),
                    partidasJugadas = resultSet.getInt("partidasJugdas"),
                    partidasGanadas = resultSet.getInt("partidasJugadas")
                )
            }
            preparedStatement?.close()

        }catch (e:SQLException){
            println("Error al obtener estadisticas: ${e.message}")
        }finally {
            conexion.desconectar()
        }
        return estadistica
    }


}