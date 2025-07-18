package Negocio

import Utillidades.CONSTANTES

open class SerVivo {
    var nombre = ""
    var esperanzaDeVida = 0
    var edad = 0




    constructor(nombre: String, esperanzaDeVida: Int, edad: Int){
        this.nombre = nombre
        this.esperanzaDeVida = esperanzaDeVida
        this.edad = edad
    }

    constructor(nombre:String){
        this.nombre = nombre
        this.esperanzaDeVida = 80 // valor por defecto
        this.edad = 0 // por defecto, nacen con edad 0
    }

    //comprobamos si esta vivo o muerto
    fun estaVivo():Boolean{
        return edad < esperanzaDeVida
    }

    //comprobamos estado vital
    fun obtenerEstadoVital():String{
        val aniosRestantes = esperanzaDeVida - edad

        return when{
            aniosRestantes <= 0 -> "Estoy muerto"
            aniosRestantes <= CONSTANTES.ANIOS_BORDE_MUERTE -> "Estoy muerto"
            aniosRestantes <= CONSTANTES.ANIOS_MUY_VIVO -> "Estoy vivo"
            else -> "Estoy muy vivo"
        }
    }

    override fun toString(): String {
        return "SerVivo(nombre='$nombre', esperanzaDeVida=$esperanzaDeVida, edad=$edad)"
    }

    //aumentamos la esperanza de vida (para sanadoreas)
    fun aumentarEsperanzaVida(anios:Int){
        esperanzaDeVida += anios
    }
    


}