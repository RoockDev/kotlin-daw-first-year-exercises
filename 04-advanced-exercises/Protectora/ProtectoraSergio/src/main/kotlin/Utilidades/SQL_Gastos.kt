package Utilidades

object SQL_Gastos {
    const val SELECT_ALL_GASTOS= "SELECT * FROM gastofecha"
    const val INSERT_GASTO= "INSERT INTO gastofecha (fecha, gasto) VALUES (?, ?)"
}