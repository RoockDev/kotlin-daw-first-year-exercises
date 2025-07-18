package AcessoDatos

import Negocio.Ciudad

interface CiudadesDAO {
    fun insertarCiudad(ciudades: List<Ciudad>): Boolean
    fun getAllCiudades():List<Ciudad>
}