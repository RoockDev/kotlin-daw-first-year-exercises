package AccesoADatos

import org.example.Solicitud
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

class SolicitudDAOImplemt: SolicitudDAO {
    private val SOLICITUDES_DIR = "Solicitudes"

    init {
        val directorioSolicitudes = File(SOLICITUDES_DIR)
        if (!directorioSolicitudes.exists()) {
            directorioSolicitudes.mkdirs()
        }

    }

    override fun guardarSolicitud( nombreAnimal: String, tipoSolicitud: Int, email: String): Boolean {
            var guardado = false
            val archivoSolicitud = File("$SOLICITUDES_DIR/ $nombreAnimal.txt")
        try {
            //si el archivo existe devuelve true si no devuelve false
            val append = archivoSolicitud.exists()

            val filewritter = FileWriter(archivoSolicitud,append) // true = añadir al final
            val bufferedWritter = BufferedWriter(filewritter)

            val tipoTexto = if (tipoSolicitud == 0) "Acogida" else "Adopcion"

            //Escribimos la solicitud
            bufferedWritter.write("$tipoTexto $email")
            bufferedWritter.newLine() // Agregamos salto de linea

            //cerrramos los recursos
            bufferedWritter.close()
            filewritter.close()
            guardado = true

        }catch (e: IOException){
            e.printStackTrace()
            print("Erro al guardar la solicitud ")
        }

        return guardado
    }

    override fun leerSolicitudes(nombreAnimal: String): List<Solicitud> {
        val solicitudes = ArrayList<Solicitud>()
        val archivoSolicitud = File("$SOLICITUDES_DIR/ $nombreAnimal.txt")

        if (archivoSolicitud.exists()){
            try {
                archivoSolicitud.readLines().forEach { linea ->
                    //separamos el tipo y el email
                    val partes = linea.split(": ", limit = 2)
                    if (partes.size == 2){
                        val tipo = 0
                        when (partes[0].lowercase()){
                            "acogida" -> 0
                            "adopcion" -> 1
                            else -> -1
                        }
                        val email = partes[1]
                        if (tipo != -1){
                            var solicitud = Solicitud(tipo,email)
                            solicitudes.add(solicitud)
                        }


                    }

                }


            }catch (e: IOException){
                e.printStackTrace()
                print("Error al leer las solicitudes")
            }
        }

        return solicitudes

    }


}