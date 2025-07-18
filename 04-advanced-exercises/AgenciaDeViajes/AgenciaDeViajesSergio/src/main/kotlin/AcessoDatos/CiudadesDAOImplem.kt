package AcessoDatos

import Negocio.Ciudad
import Utilidades.ConexionBBDD
import Utilidades.SQL_CIUDAD
import java.sql.PreparedStatement

class CiudadesDAOImplem: CiudadesDAO {
    private val conexion = ConexionBBDD()
    override fun insertarCiudad(ciudades: List<Ciudad>): Boolean {
        conexion.conectar()
        var ps: PreparedStatement? = null
        var result: Int? = null
        for (ciudad in ciudades){
             ps = conexion.getPreparedStatement(SQL_CIUDAD.SQL_INSERTAR_CIUDAD)
            ps?.setString(1,ciudad.nombre)
             result = ps?.executeUpdate()
        }

        ps?.close()
        conexion.desconectar()
        return result == 1

    }

    override fun getAllCiudades(): List<Ciudad> {
        conexion.conectar()
        val st = conexion.getStatement()
        val rs = st?.executeQuery(SQL_CIUDAD.SQL_BUSCAR_CIUDAD)
        val ciudades = ArrayList<Ciudad>()
        while (rs?.next() == true){
            val ciudad = Ciudad(rs.getInt("id"),rs.getString("ciudad"))
            ciudades.add(ciudad)
        }
        st?.close()
        conexion.desconectar()
        return ciudades
    }

}