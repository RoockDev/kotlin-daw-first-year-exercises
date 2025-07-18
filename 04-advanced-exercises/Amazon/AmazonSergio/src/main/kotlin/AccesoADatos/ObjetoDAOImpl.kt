package AccesoADatos

import Negocio.Objeto
import Utilidades.ConexionBBDD
import Utilidades.SQL_Objetos

class ObjetoDAOImpl: ObjetoDAO {
    private val conexion = ConexionBBDD()
    override fun getObjetos(): List<Objeto> {
        val objetos = ArrayList<Objeto>()
        try {
            conexion.conectar()
            val query = SQL_Objetos.SQL_SELECT_OBJETOS
            val ps = conexion.getPreparedStatement(query)
            val rs = ps?.executeQuery()

            while (rs?.next() == true){
                val id = rs.getInt("id")
                val nombre = rs.getString("nombre")
                val peso = rs.getInt("peso")
                val peligroso = rs.getBoolean("peligroso")

                val objeto = Objeto(id,nombre,peso,peligroso)
                objetos.add(objeto)
                ps.close()

            }
        }catch (e: Exception){
            e.printStackTrace()
            println("Error al recuperar los objetos")
        }finally {
            conexion.desconectar()
        }
        return objetos

    }

    override fun insertObjeto(objeto: Objeto): Boolean {
        var insertado = false
        try {
            conexion.conectar()
            val query = SQL_Objetos.SQL_INSERTAR_OBJETO
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1,objeto.nombre)
            ps?.setInt(2,objeto.peso)
            ps?.setBoolean(3,objeto.peligroso)
            val resultado = ps?.executeUpdate()
            if (resultado != null)insertado = true
            ps?.close()

        }catch (e: Exception){
            e.printStackTrace()
            println("Eror al intentar insertar el objeto")
        }finally {
            conexion.desconectar()
        }

        return insertado

    }

    override fun updateObjeto(objeto: Objeto): Boolean {
        var actualizado = false
        try {
            conexion.conectar()
            val query = SQL_Objetos.SQL_UPDATE_OBJETO
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1,objeto.nombre)
            ps?.setInt(2,objeto.peso)
            ps?.setBoolean(3,objeto.peligroso)
            ps?.setInt(4,objeto.id)
            val resultado = ps?.executeUpdate()
            if (resultado != null) actualizado = true
            ps?.close()

        }catch (e: Exception){
            e.printStackTrace()
            println("Error al intentar actualizar el objeto")
        }finally {
            conexion.desconectar()
        }

        return actualizado
    }

    override fun deleteObjeto(id: Int): Boolean {
        var eliminado = false
        try {
            conexion.conectar()
            val query = SQL_Objetos.SQL_DELETE_OBJETOS
            val ps = conexion.getPreparedStatement(query)
            ps?.setInt(1,id)
            val resultado = ps?.executeUpdate()
            if (resultado != null) eliminado = true
            ps?.close()
        }catch (e: Exception){
            e.printStackTrace()
            println("Error al intentar eliminar el objeto")
        }

        return eliminado
    }
}