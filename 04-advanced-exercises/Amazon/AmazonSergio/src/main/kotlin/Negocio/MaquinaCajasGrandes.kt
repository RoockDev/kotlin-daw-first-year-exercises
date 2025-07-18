package Negocio

class MaquinaCajasGrandes: MaquinaGenerica {


    constructor()

    override fun agregarCajas(cajas: List<Caja>){

        cajas.forEach { caja ->
            if (caja.pesoActual > 100) historialDeCajasTransportadas.add(caja)
        }

    }

    override fun agregarCaja(caja: Caja): Int{ //Devuelve 0 si la rechaza y 1 si la acepta
        var cajaProcesada = 0
        if (caja.pesoActual > 100){
            historialDeCajasTransportadas.add(caja)
            cajaProcesada = 1
        }

        return cajaProcesada
    }

    override fun obtenerGradoUtilizacion(): Double {
        return (diasUtilizados/CONSTANTES.TOTAL_DIAS_MES_MCGG.toDouble()) * 100
    }
}