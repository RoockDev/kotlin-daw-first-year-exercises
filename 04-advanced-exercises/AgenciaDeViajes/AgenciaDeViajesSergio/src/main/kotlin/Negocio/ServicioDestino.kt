package Negocio

import AcessoDatos.DestinosDAOImpl

class ServicioDestino {
    var destinoDAO = DestinosDAOImpl()

    fun destinos(): List<Destino>{
        return destinoDAO.getAllDestinos()
    }
}