package Util


import java.sql.*
import java.sql.DriverManager.println

class ConexionBD{
    private val url = "jdbc:mysql://localhost/crud"
    private val user = "root"
    private val password = ""
    var conn: Connection? = null


    fun conectar(){
        try {
            //registrar el driver mysql
            Class.forName("com.mysql.cj.jdbc.Driver")
            // Establecer al conexion
            conn = DriverManager.getConnection(url, user, password)
            println("Conexion establecida con exito")
        }catch (e:SQLException){
            println("Error al intentar conectar con la base de datos: ${e.message}")
            e.printStackTrace()
        }catch (e:ClassNotFoundException){
            println("Driver de MySQL no encontrado: ${e.message}")
        }
    }

    fun desconectar(){
        try {
            conn?.close()
            println("Conexion cerrada")
        }catch (e:SQLException){
            println("Error al cerrar la conexion: ${e.message}")
            e.printStackTrace()
        }
    }

    fun getStatament():Statement?{
        return conn?.createStatement()
    }

    fun getPreparedStatament(sql:String):PreparedStatement?{
        return conn?.prepareStatement(sql)
    }
}