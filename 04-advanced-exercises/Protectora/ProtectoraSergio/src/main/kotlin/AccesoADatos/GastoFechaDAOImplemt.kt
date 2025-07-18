package AccesoADatos

import Negocio.GastoFecha
import Utilidades.ConexionBBDD
import Utilidades.SQL_Gastos


class GastoFechaDAOImplemt: GastoFechaDAO {
    val conexion = ConexionBBDD()
    override fun getAllGastos(): List<GastoFecha> {
        val gastos = ArrayList<GastoFecha>()
        try {
            conexion.conectar()
            val preparedStatament = conexion.getPreparedStatement(SQL_Gastos.SELECT_ALL_GASTOS)
            val resulSet = preparedStatament?.executeQuery()

            while (resulSet?.next() == true){
                val gastoFecha = GastoFecha(resulSet.getString("fecha"),resulSet.getDouble("gasto"))
                gastos.add(gastoFecha)
            }
        }catch (e: Exception){
            e.printStackTrace()
            print("Error al obtener los gastos")
        }finally {
            conexion.desconectar()
            return gastos
        }


    }

    override fun insertarGasto(gasto: GastoFecha): Boolean {
        var insertada = false
        try {
            conexion.conectar()
            val preparedStatament = conexion.getPreparedStatement(SQL_Gastos.INSERT_GASTO)
            preparedStatament?.setString(1,gasto.fecha)
            preparedStatament?.setInt(2,gasto.gasto.toInt())
             if (preparedStatament?.executeUpdate() != null){
                 insertada = true
             }

        }catch (e: Exception){
            e.printStackTrace()
            print("Error al insertar el gasto")

        }finally {
            conexion.desconectar()
            return insertada

        }


    }


}