package Negocio

import java.io.Serializable
import java.util.Date

class UsuarioSerializable: Serializable {
    var id = 0
    var nombre = ""
    lateinit var fecha: Date

    constructor(id: Int, nombre: String, fecha: Date) {
        this.id = id
        this.nombre = nombre
        this.fecha = fecha
    }
}