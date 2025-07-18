package Negocio

import AcessoDatos.VistaViajeDAOImple

class ServicioVistaViaje {
    var vistaDAO = VistaViajeDAOImple()

    fun viajes(): List<VistaViaje>{

        return vistaDAO.getAllViajes()
    }
}