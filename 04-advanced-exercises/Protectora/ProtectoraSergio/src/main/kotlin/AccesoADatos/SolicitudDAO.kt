package AccesoADatos

import org.example.Solicitud

interface SolicitudDAO {
    fun guardarSolicitud(nombreAnimal:String,tipoSolicitud: Int,email: String): Boolean
    fun leerSolicitudes(nombreAnimal:String): List<Solicitud>
}