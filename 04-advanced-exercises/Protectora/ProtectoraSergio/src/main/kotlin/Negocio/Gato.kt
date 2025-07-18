package org.example

import Utilidades.CONSTANTES
import java.time.LocalDate

class Gato: Animal {
    var esterilizado: Boolean? = null

    constructor()
    constructor(
        nombre: String,
        tipo: String,
        sexo: String,
        edad: Int,
        sociables: Boolean,
        apadrinado: Boolean,
        esterilizado: Boolean
    ){
        this.nombre = nombre
        this.tipo = tipo
        this.sexo = sexo
        this.edad = edad
        this.sociables= sociables
        this.apadrinado= apadrinado
        this.esterilizado = esterilizado
    }
    constructor(
        nombre: String,
        estadoAnimal: EstadoAnimal,
        tipoAcogida: String,
        fechaNacimiento: LocalDate,
        sexo: String,
        sociables: Boolean,
        esterilizado: Boolean
    ){
        this.nombre = nombre
        this.estadoAnimal = estadoAnimal
        this.tipo= tipo
        this.fechaNacimiento = fechaNacimiento
        this.sexo = sexo
        this.sociables = sociables
        this.esterilizado = esterilizado
    }

    fun calculatGastoVeterinario(): Double{
        var gasto = 0.0
        if (apadrinado == true){
            gasto = 0.0
        }else{
            if (!esterilizado!!){
                gasto = CONSTANTES.CONTROL_DE_CELO.toDouble() * 12
            }
        }
        return gasto
    }

    fun esterilizar(){
        esterilizado = true
    }

    override fun toString(): String {
        return "Gato(esterilizado=$esterilizado)"
    }


}