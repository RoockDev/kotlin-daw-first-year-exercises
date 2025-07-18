package Negocio

import AcessoDatos.CiudadesDAOFichero
import AcessoDatos.CiudadesDAOImplem
import Utilidades.Constantes

class ServicioCiudad {
    var ciudadDAO = CiudadesDAOImplem()

    fun insertarEnBBDD(){
        ciudadDAO.insertarCiudad(CiudadesDAOFichero.leerCiudades(Constantes.ficheroCiudad))
    }

    fun fichero(){
        CiudadesDAOFichero.escribirCiudades(Constantes.ficheroCiudad,ciudadDAO.getAllCiudades())
    }
}