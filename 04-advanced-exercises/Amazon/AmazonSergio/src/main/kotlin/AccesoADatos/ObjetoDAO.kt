package AccesoADatos

import Negocio.Objeto

interface ObjetoDAO {
    fun getObjetos():List<Objeto>
    fun insertObjeto(objeto: Objeto): Boolean
    fun updateObjeto(objeto: Objeto): Boolean
    fun deleteObjeto(id: Int): Boolean
}