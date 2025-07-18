package Utillidades

object SQL_Guerreras {


    const val SELECT_ALL_GUERRERAS = "SELECT nombre, esperanza_vida, edad, inteligencia, fuerza FROM guerreras"
    const val SELECT_RANDOM_GUERRERAS = "SELECT nombre, esperanza_vida, edad, inteligencia, fuerza FROM guerreras ORDER BY RAND() LIMIT ?"

    // Columnas
    const val COL_NOMBRE = "nombre"
    const val COL_ESPERANZA_VIDA = "esperanza_vida"
    const val COL_EDAD = "edad"
    const val COL_INTELIGENCIA = "inteligencia"
    const val COL_FUERZA = "fuerza"
}