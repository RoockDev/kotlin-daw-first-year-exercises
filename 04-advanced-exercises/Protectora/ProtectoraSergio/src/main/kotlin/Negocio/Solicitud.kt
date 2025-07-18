package org.example

class Solicitud {

    var tipoSolicitud: Int? = null // 0 acogida 1 adopcion
    var email: String? = null

        constructor(tipoSolicitud: Int?, email: String?) {}
    override fun toString(): String {
        return "Solicitud(tipoSolicitud=$tipoSolicitud, email=$email)"
    }

}