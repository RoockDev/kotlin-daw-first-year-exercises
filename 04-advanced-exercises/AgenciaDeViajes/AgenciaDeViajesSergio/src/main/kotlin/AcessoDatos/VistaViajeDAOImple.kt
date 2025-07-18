package AcessoDatos

import Negocio.VistaViaje
import Utilidades.ConexionBBDD
import Utilidades.SQL_Viaje

class VistaViajeDAOImple: VistaViajeDAO {

    private val conexion = ConexionBBDD()
    override fun getAllViajes(): List<VistaViaje> {
        val listaViajes = ArrayList<VistaViaje>()
        try {
            conexion.conectar()
            val st = conexion.getStatement()
            val rs = st?.executeQuery(SQL_Viaje.getView)
            while(rs?.next() == true){
                val viaje = VistaViaje(rs.getString("nombre"),rs.getString("destion"),rs.getDate("fecha_viaje"),rs.getBoolean("pagado"))
                listaViajes.add(viaje)
            }
            st?.close()
        }catch (e: Exception){
            println(e.message)
        }finally {
            conexion.desconectar()
        }
        return listaViajes

    }
}