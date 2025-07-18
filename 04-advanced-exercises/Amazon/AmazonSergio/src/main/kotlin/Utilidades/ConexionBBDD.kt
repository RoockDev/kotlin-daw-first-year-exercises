package Utilidades

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException
import java.sql.Statement

class ConexionBBDD {
    val url = "jdbc:mysql://localhost/Protectora"
    val user = "root"
    val password = ""
    var conn: Connection? = null



    fun conectar() {
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver")
            Class.forName("com.mysql.cj.jdbc.Driver")
            conn = DriverManager.getConnection(url, user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    fun desconectar() {
        try {
            conn?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun getStatement(): Statement? {
        return conn?.createStatement()
    }

    fun getPreparedStatement(sql: String): PreparedStatement? {
        return conn?.prepareStatement(sql)
    }
}