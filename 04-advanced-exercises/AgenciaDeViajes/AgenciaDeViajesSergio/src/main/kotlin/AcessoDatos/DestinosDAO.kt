package AcessoDatos

import Negocio.Destino

interface DestinosDAO {
    fun getAllDestinos(): List<Destino>
}