package AccesoADatos

import Utilidades.ConexionBBDD
import Utilidades.SQL_Animales
import org.example.Animal
import org.example.Perro


class AnimalDAOImplement:AnimalDAO {
    private val conexion = ConexionBBDD()
    override fun getAllAnimales(): List<Animal> {
        val animales = ArrayList<Animal>()
        try {
            conexion.conectar()
            val query = SQL_Animales.SELECT_ALL_ANIMALES
            val preparedStatament = conexion.getPreparedStatement(query)
            var resulSet = preparedStatament?.executeQuery()

            while (resulSet?.next() == true){
                val nombre = resulSet.getString("Nombre")
                val tipo = resulSet.getString("Tipo")
                val sexo = resulSet.getString("Sexo")
                val edad = resulSet.getInt("Edad")
                val sociable = resulSet.getBoolean("Sociable")
                val apadrinado = resulSet.getBoolean("Apadrinado")

                val animal = when (tipo.lowercase()){
                    "perro" ->{
                        val raza = resulSet.getString("Raza")
                        val tamanio = resulSet.getDouble("Tamaño")
                        val ppp = resulSet.getBoolean("PPP")
                        val leishmania = resulSet.getBoolean("Leishmania")
                        Perro(nombre,tipo,sexo,edad,sociable,apadrinado,raza,tamanio,ppp,leishmania)
                    }

                    "gato" -> {
                        val esterilizado = resulSet.getBoolean("Esterilizado")

                    }

                    else -> {
                        // Manejar cualquier otro tipo de animal
                        Animal()
                    }

                }
                animales.add(animal as Animal)

            }
        }catch (e: Exception){
            e.printStackTrace()
            print("Error al obtener animales")
        }finally {
            conexion.desconectar()
        }
        return animales
    }
}