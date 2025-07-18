package AcessoDatos

import Negocio.Destino
import Utilidades.ConexionBBDD
import Utilidades.SQL_Destinos

class DestinosDAOImpl: DestinosDAO {

    private val conexion = ConexionBBDD()
    override fun getAllDestinos(): List<Destino> {
        conexion.conectar()
        val st = conexion.getStatement()
        val rs = st?.executeQuery(SQL_Destinos.SQL_SELECT_DESTINO)
        val destinos = ArrayList<Destino>()
        while (rs?.next() == true){
            val destino = Destino(rs.getInt("id"),rs.getString("nombre"))
            destinos.add(destino)
        }
        st?.close()
        conexion.desconectar()
        return destinos
    }

}