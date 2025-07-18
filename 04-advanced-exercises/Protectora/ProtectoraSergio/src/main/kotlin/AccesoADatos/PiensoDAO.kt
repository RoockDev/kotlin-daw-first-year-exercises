package AccesoADatos

import Negocio.CantidadKG
import org.example.Perro

interface PiensoDAO {
    fun calcularPiensoSemanal(perros: List<Perro>): CantidadKG
    fun guardarPiensoSemanal(cantidadKG: CantidadKG): Boolean
    fun leerPiensoSemanal(): CantidadKG?
}