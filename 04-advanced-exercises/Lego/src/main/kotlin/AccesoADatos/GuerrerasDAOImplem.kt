package AccesoADatos

import Negocio.MujerGuerrera
import Utillidades.ConexionBBDD
import Utillidades.SQL_Guerreras
import java.sql.SQLException

class GuerrerasDAOImplem:GuerrerasDAO {
    override fun getAllGuerreras(): List<MujerGuerrera> {
        val guerreras = ArrayList<MujerGuerrera>()
        try{
            ConexionBBDD.conectar()

            val query = SQL_Guerreras.SELECT_ALL_GUERRERAS
            var preparedStatament = ConexionBBDD.getPreparedStatement(query)

            var resultSet = preparedStatament?.executeQuery()

            while (resultSet?.next() == true) {
                val nombre = resultSet.getString(SQL_Guerreras.COL_NOMBRE)
                val esperanzaVida = resultSet.getInt(SQL_Guerreras.COL_ESPERANZA_VIDA)
                val edad = resultSet.getInt(SQL_Guerreras.COL_EDAD)
                val inteligencia = resultSet.getInt(SQL_Guerreras.COL_INTELIGENCIA)
                val fuerza = resultSet.getInt(SQL_Guerreras.COL_FUERZA)

                val guerrera = MujerGuerrera(nombre, esperanzaVida, edad, inteligencia, fuerza)
                guerreras.add(guerrera)
            }
            preparedStatament?.close()
            resultSet?.close()


        }catch(e:Exception){
        println("Error al cargar Guerreras: ${e.message}")
        }
        return guerreras
    }

    override fun getRandomGuerreras(cantidad: Int): List<MujerGuerrera> {
        val guerreras = mutableListOf<MujerGuerrera>()

        try {

            ConexionBBDD.conectar()


            val query = SQL_Guerreras.SELECT_ALL_GUERRERAS
            val preparedStatement = ConexionBBDD.getPreparedStatement(query)
            preparedStatement?.setInt(1, cantidad)


            val resultSet = preparedStatement?.executeQuery()


            while (resultSet?.next() == true) {
                val nombre = resultSet.getString(SQL_Guerreras.COL_NOMBRE)
                val esperanzaVida = resultSet.getInt(SQL_Guerreras.COL_ESPERANZA_VIDA)
                val edad = resultSet.getInt(SQL_Guerreras.COL_EDAD)
                val inteligencia = resultSet.getInt(SQL_Guerreras.COL_INTELIGENCIA)
                val fuerza = resultSet.getInt(SQL_Guerreras.COL_FUERZA)

                val guerrera = MujerGuerrera(nombre, esperanzaVida, edad, inteligencia, fuerza)
                guerreras.add(guerrera)
            }


            resultSet?.close()
            preparedStatement?.close()

        } catch (e: SQLException) {
            println("Error al cargar guerreras aleatorias: ${e.message}")
        } finally {

            ConexionBBDD.desconectar()
        }

        return guerreras
    }

}