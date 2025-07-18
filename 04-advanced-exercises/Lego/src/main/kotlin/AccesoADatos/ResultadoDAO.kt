package AccesoADatos

import Negocio.MujerGuerrera
import Negocio.Reto

interface ResultadoDAO {
    fun guardarResultados(
        nombreFichero: String,
        guerrerasGanadoras: List<MujerGuerrera>,
        retosSuperados: List<Reto>
    ): Boolean

    fun leerResultados(nombreFichero: String): String?
}