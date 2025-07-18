package Negocio

import AccesoADatos.GuerrerasDAOImplem
import AccesoADatos.ResultadoDAOFichero
import Utillidades.Factoria

open class Tablero {

    var cantidadGuerreras = 0
    var equipoA = ArrayList<MujerGuerrera>()
    var equipoB = ArrayList<MujerGuerrera>()
    var retosEquipoA = ArrayList<Reto>()
    var retosEquipoB = ArrayList<Reto>()
    var guerrerasGanadoras = ArrayList<MujerGuerrera>()
    var retosSuperados = ArrayList<Reto>()
    var guerreraDAO = GuerrerasDAOImplem()
    var resultadoDAO = ResultadoDAOFichero()

    constructor(cantidadGuerreras: Int) {
        // Cargamos guerreras desde la base de datos
        var todasLasGuerreras = guerreraDAO.getRandomGuerreras(cantidadGuerreras * 2)

        // Dividimos las guerreras en dos equipos
        for (i in todasLasGuerreras.indices) {
            if (i < cantidadGuerreras) {
                equipoA.add(todasLasGuerreras[i])
            } else {
                equipoB.add(todasLasGuerreras[i])
            }
        }

        // Creamos los retos
        retosEquipoA.addAll(Factoria.crearRetos(cantidadGuerreras))
        retosEquipoB.addAll(Factoria.crearRetos(cantidadGuerreras))
    }

    open fun jugar() {
        // Limpiar resultados anteriores
        guerrerasGanadoras.clear()
        retosSuperados.clear()

        // Equipo A enfrenta sus retos
        println("EQUIPO RETOS")
        for (i in equipoA.indices) {
            var guerrera = equipoA[i]
            var reto = retosEquipoA[i]

            println("Guerrera: ${guerrera.nombre} enfrenta reto: ${reto.descripcion}")

            var puedeResolver = if (reto.esFuerza == true) {
                guerrera.puedeRealizarTarea(
                    reto.inteligenciaRequerida,
                    reto.edadMinima,
                    reto.edadMaxima,
                    true,
                    reto.fuerzaRequerida
                )
            } else {
                guerrera.puedeRealizarTarea(
                    reto.inteligenciaRequerida,
                    reto.edadMinima,
                    reto.edadMaxima,
                    true,
                    reto.fuerzaRequerida
                )
            }

            if (puedeResolver) {
                println("¡La guerrera ${guerrera.nombre} ha superado el reto")
                guerrerasGanadoras.add(guerrera)
                retosSuperados.add(reto)
            } else {
                println("La guerrera ${guerrera.nombre} no ha podido superar el reto.")
            }
            println()
        }

        // Equipo B enfrenta sus retos
        println(" EQUIPO B RETOS")
        for (i in equipoB.indices) {
            var guerrera = equipoB[i]
            var reto = retosEquipoB[i]

            println("Guerrera: ${guerrera.nombre} enfrenta reto: ${reto.descripcion}")

            var puedeResolver = if (reto.esFuerza == true) {
                guerrera.puedeRealizarTarea(
                    reto.inteligenciaRequerida,
                    reto.edadMinima,
                    reto.edadMaxima,
                    true,
                    reto.fuerzaRequerida
                )
            } else {
                guerrera.puedeRealizarTarea(
                    reto.inteligenciaRequerida,
                    reto.edadMinima,
                    reto.edadMaxima,
                    true,
                    reto.fuerzaRequerida
                )
            }

            if (puedeResolver) {
                println("¡La guerrera ${guerrera.nombre} ha superado el reto!")
                guerrerasGanadoras.add(guerrera)
                retosSuperados.add(reto)
            } else {
                println("La guerrera ${guerrera.nombre} no ha podido superar el reto.")
            }
            println()
        }


    }

    fun mostrarResultado(){
        println("RESULTADOS DEL JUEGO")
        println("Total de guerreras ganadoras: ${guerrerasGanadoras.size}")
        println("Total de retos superados: ${retosSuperados.size}")
    }

        // guardar resultados en fichero
    fun guardarResultado(nombreFichero:String):Boolean{
        var resultado = resultadoDAO.guardarResultados(nombreFichero,guerrerasGanadoras, retosSuperados)
        if (resultado) {
            println("Resultados guardados en el fichero: $nombreFichero")
        }

        return resultado
    }

    //leer y mostrar resultados desde un fichero
    fun leerYMostrarResultados(nombreFichero: String): Boolean {
        var mostrado = false
        val contenido = resultadoDAO.leerResultados(nombreFichero)

        if (contenido != null) {
            println("=== LECTURA DE RESULTADOS DESDE FICHERO ===")
            println(contenido)
            mostrado = true
        }
        return mostrado
    }

    // Métodos protegidos para que las subclases (TableroFX) puedan acceder
     fun obtenerEquipoA(): List<MujerGuerrera> = equipoA
     fun obtenerEquipoB(): List<MujerGuerrera> = equipoB
     fun obtenerRetosEquipoA(): List<Reto> = retosEquipoA
     fun obtenerRetosEquipoB(): List<Reto> = retosEquipoB
     fun obtenerGuerrerasGanadoras(): List<MujerGuerrera> = guerrerasGanadoras
    fun obtenerRetosSuperados(): List<Reto> = retosSuperados


}
