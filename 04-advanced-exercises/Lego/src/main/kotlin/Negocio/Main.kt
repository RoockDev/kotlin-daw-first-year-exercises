package Negocio

import Utillidades.CONSTANTES

fun main(){


    fun main() {
        println("JUEGO LEGO ")
        println("Iniciando simulación")


        val cantidadGuerreras = 3  // guerreras por equipo
        val cantidadJuegos = 2     //  veces que se jugará

        println("Cantidad de guerreras por equipo: $cantidadGuerreras")
        println("Número de juegos a realizar: $cantidadJuegos")
        println()

        try {

            val tablero = Tablero(cantidadGuerreras)


            for (i in 1..cantidadJuegos) {
                println("JUEGO $i")
                tablero.jugar()
                println()
            }

            // Guardo resultados en fichero usando la clase DAO
            val nombreFichero = CONSTANTES.NOMBRE_FICHERO_RESULTADOS
            if (tablero.guardarResultado(nombreFichero)) {
                println("Resultados guardados correctamente en el fichero: $nombreFichero")
            } else {
                println("Error al guardar los resultados en el fichero.")
            }

            // muestro resultados desde el fichero
            if (!tablero.leerYMostrarResultados(nombreFichero)) {
                println("Error al leer los resultados del fichero.")
            }

        } catch (e: Exception) {
            println("Error durante la ejecución del juego: ${e.message}")
            e.printStackTrace()
        }

        println("FIN DEL JUEGO LEGO ")



    }
}