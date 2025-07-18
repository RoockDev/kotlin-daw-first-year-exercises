package AccesoADatos

import Negocio.Caja
import java.io.File
import java.io.IOException
import java.io.PrintWriter

class HistorialCajasDAOImpleFichero {

    fun GuardarFicheroHistorialCajas(nombreFichero: String,historial: List<Caja>){

        try {
            val archivo = File(nombreFichero)
            PrintWriter(archivo).use { writer ->

                writer.println("Historial de cajas")

                historial.forEach { caja ->
                    writer.println("Caja ${caja.id} con ${caja.cantidadDeObjetosActuales} objetos y peso ${caja.pesoActual}")
                }

            }
        }catch (e: IOException){
            e.printStackTrace()
            println("Error al escribir en el fichero")
        }


    }

    fun leerFicheroHistorialCajas(){

    }
}