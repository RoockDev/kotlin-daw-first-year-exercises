package Negocio

import java.time.LocalDate

data class GastoFecha(var fecha: String, var gasto: Double){
    override fun toString(): String {
        return "GastoFecha(fecha='$fecha', gasto=$gasto)"
    }
}
