package Negocio

import java.io.Serializable

data class Objeto(val id: Int,val nombre: String,val peso: Int,val peligroso: Boolean): Serializable
