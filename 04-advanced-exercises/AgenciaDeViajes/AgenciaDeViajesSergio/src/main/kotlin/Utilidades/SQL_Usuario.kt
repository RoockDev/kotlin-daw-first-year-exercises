package Utilidades

object SQL_Usuario {
    const val SQL_SELECT_ALL = "SELECT * FROM usuarios"
    const val SQL_INSERT_USUARIO = "INSERT INTO usuarios (nombre, fecha) VALUES (?,?)"
}