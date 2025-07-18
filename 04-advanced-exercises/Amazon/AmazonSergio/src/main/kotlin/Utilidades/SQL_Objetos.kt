package Utilidades

object SQL_Objetos {
    const val SQL_INSERTAR_OBJETO = "INSERT INTO objetos(nombre,peso,peligroso) VALUES (?,?,?)"
    const val SQL_SELECT_OBJETOS = "SELECT * FROM objetos"
    const val SQL_DELETE_OBJETOS = "DELETE *  FROM objetos WHER id=?"
    const val SQL_UPDATE_OBJETO = "UPDATE objetos SET nombre=?, peso=?, peligroso=? WHERE id=?"
}