package Negocio

import AccesoADatos.ObjetoDAOImpl
import kotlin.random.Random

object Factoria {

    fun generarMaquinaGenerica(): MaquinaGenerica{
        return MaquinaGenerica()
    }

    fun generarMaquinaCajasGrandes(): MaquinaCajasGrandes{
        return MaquinaCajasGrandes()
    }

    fun generarMaquinaObjetosPeligrosos(): MaquinaObjetoPeligroso{
        return MaquinaObjetoPeligroso()
    }

    fun generarCaja(): Caja{

        return Caja(CONSTANTES.CANTIDAD_MAXIMA_OBJETOS, CONSTANTES.PESO_MAXIMO)

    }

    fun generarObjetos(): List<Objeto>{
        val objetoDAO = ObjetoDAOImpl()

        return objetoDAO.getObjetos()

    }
}