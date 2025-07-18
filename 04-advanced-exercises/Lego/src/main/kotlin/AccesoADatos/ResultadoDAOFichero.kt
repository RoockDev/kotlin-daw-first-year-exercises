package AccesoADatos

import Negocio.MujerGuerrera
import Negocio.Reto
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter

class ResultadoDAOFichero:ResultadoDAO {

    override fun guardarResultados(
        nombreFichero: String,
        guerrerasGanadoras: List<MujerGuerrera>,
        retosSuperados: List<Reto>
    ): Boolean {
        var guardado = false
         try {
            PrintWriter(FileWriter(nombreFichero)).use { writer ->
                writer.println(" RESULTADOS DEL JUEGO LEGO ")
                writer.println("Total de guerreras ganadoras: ${guerrerasGanadoras.size}")
                writer.println()

                writer.println("Guerreras ganadoras:")
                for (guerrera in guerrerasGanadoras) {
                    writer.println("- ${guerrera.nombre}: Fuerza: ${guerrera.fuerza}, Inteligencia: ${guerrera.indiceInteligencia}")
                }

                writer.println()
                writer.println("Retos superados:")
                for (reto in retosSuperados) {
                    writer.println("${reto.descripcion}")
                }
            }

            guardado = true
        } catch (e: IOException) {
            println("Error al guardar resultados: ${e.message}")

        }

        return guardado
    }

    override fun leerResultados(nombreFichero: String): String {

        var devuelto = ""
         try {
            val file = File(nombreFichero)
            if (!file.exists()) {
                devuelto = "El fichero $nombreFichero no existe."

            }

            val contenido = StringBuilder()
            file.forEachLine { linea ->
                contenido.append(linea).append("\n")
            }

            contenido.toString()
        } catch (e: IOException) {
            devuelto = "Error al leer resultados: ${e.message}"

        }

        return devuelto
    }
}