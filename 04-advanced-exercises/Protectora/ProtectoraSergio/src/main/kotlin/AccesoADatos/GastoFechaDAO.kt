package AccesoADatos

import Negocio.GastoFecha

interface GastoFechaDAO {
    fun getAllGastos(): List<GastoFecha>
    fun insertarGasto(gasto: GastoFecha): Boolean
}