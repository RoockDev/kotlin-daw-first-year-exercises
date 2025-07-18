package org.example

fun main() {
    println("Gestion de peliculas")
    var gest = Gestion()
    var salir = false
    while (!salir) {
        println(
            """
            Elige una opcion:
            [1] Agregar Pelicula
            [2] Borrar Pelicula
            [3] Mostrar Peliculas
            [4] Salir
        """.trimIndent()
        )
        var opcion = readln().toIntOrNull() ?: ""
        when (opcion) {
            1 -> {
                println("Introduce el titulo:")
                var titulo = readLine() ?: "Desconocido"
                println("Introduce el director:")
                var director = readLine() ?: "Desconocido"
                println("Introduce la duracion de la pelicula")
                var duracion = readLine() ?: "Desconocido"
                println("Introduce el agno de la pelicula")
                var agno = readLine() ?: "Desconocido"
                gest.agnadirPeliculas(titulo, director, duracion, agno)
                println("Pelicula agnadida correctamente")
            }

            //no borra correctamente, arreglarlo
            2 -> {
                println("Introduce la pelicula que quieres borrar:")
                var pelicula = readLine() ?: "Desconocido"
                gest.borrarPeli(pelicula)

            }

            3 -> gest.mostrarPeliculas()

            4 -> {
                println("Gracias por su visita")
                salir = true
            }

            else -> println("Introduce una opcion valida")

        }
    }
}