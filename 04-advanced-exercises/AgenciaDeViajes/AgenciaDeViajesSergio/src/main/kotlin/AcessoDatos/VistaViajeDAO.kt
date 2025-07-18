package AcessoDatos

import Negocio.VistaViaje

interface VistaViajeDAO {
    fun getAllViajes(): List<VistaViaje>
}