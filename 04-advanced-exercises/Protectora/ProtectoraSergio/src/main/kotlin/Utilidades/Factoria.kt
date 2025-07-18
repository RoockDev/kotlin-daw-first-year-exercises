package Utilidades

import org.example.Solicitud

object Factoria {

    fun devuelveSolicitud(): Solicitud{
        val emails = listOf("email1@email.com","email2@email.com", "email3#email.com", "email4@email.com")
        val numero = (0..1).random()
        return Solicitud(numero,emails.random())
    }
}