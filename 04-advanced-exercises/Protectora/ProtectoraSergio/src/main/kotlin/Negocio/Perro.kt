package org.example

import Utilidades.CONSTANTES
import java.time.LocalDate

class Perro: Animal {
    var raza: String? = null
    var tamanio: Double? = null
    var ppp: Boolean? = null
    var tratamientoVsLeishmania: Boolean? = null
    var catergoria: CategoriaPerro? = null
    constructor()
    constructor(
        nombre: String,
        tipo: String,
        sexo: String,
        edad: Int,
        sociables: Boolean,
        apadrinado: Boolean,
        raza: String,
        tamanio: Double,
        ppp: Boolean?,
        leishmanios: Boolean,
    ){
        this.nombre = nombre
        this.tipo = tipo
        this.sexo = sexo
        this.edad = edad
        this.sociables= sociables
        this.apadrinado= apadrinado
        this.raza = raza
        this.tamanio = tamanio
        this.ppp = ppp
        this.tratamientoVsLeishmania = leishmanios

    }
    constructor(
        nombre: String,
        fechaNacimiento: LocalDate,
        sexo: String,
        sociables: Boolean,
        raza: String,
        peso: Double,
        ppp: Boolean,
        tratamientoVsLeishmania: Boolean,
    ) {
        this.nombre = nombre
        this.fechaNacimiento = fechaNacimiento
        this.sexo = sexo
        this.sociables = sociables
        this.raza = raza
        this.tamanio = tamanio
        this.ppp = ppp
        this.tratamientoVsLeishmania = tratamientoVsLeishmania

    }

    fun calculatGastoVeterinario(): Double{
        var gasto = 0.0
        if (apadrinado == true){
            gasto = 0.0

        }else{
             gasto = CONSTANTES.VACUNA_RABIA.toDouble()
            if (tratamientoVsLeishmania == true){
                gasto += CONSTANTES.GASTO_LEISHMANIA * 12
            }
            if (ppp == true && !sociables!!){
                gasto *= CONSTANTES.SEDACCION

            }

        }
        return gasto
    }


    fun esCachorro(): Boolean{
        var esCachorro = false
        if (edad!!.toDouble() <= 1.5) esCachorro = true
        return esCachorro
    }

    fun calcularCantidadPienso(): Double{
        return when {
            esCachorro() -> 0.0
            tamanio!! <= 15.0 -> 0.2
            tamanio!! <= 25.0 -> 0.3
            else -> tamanio!! * 0.015
        }
    }

    override fun toString(): String {
        return "Perro(raza=$raza, tamanio=$tamanio, ppp=$ppp, tratamientoVsLeishmania=$tratamientoVsLeishmania, catergoria=$catergoria)"
    }


}