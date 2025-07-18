package org.example

import java.time.LocalDate
import java.time.Period

open class Animal {
    var estadoAnimal: EstadoAnimal? = null
    lateinit var nombre: String
    var idnombre = 1
    var tipo: String? = null
    var nombreIdentificador = nombre + idnombre
    var apadrinado: Boolean? = null // flase acodiga true apadrinado
    var fechaNacimiento: LocalDate? = null
    var edad : Int? = null
    var sexo: String? = null
    var sociables: Boolean? = null


    //Lista para guardar las solicitudes
    private val solicitudes = ArrayList<Solicitud>()




    companion object{
        private var contador = 1

    }

    constructor(){
        idnombre = contador
        contador++
        nombreIdentificador = nombre + idnombre

    }

    override fun toString(): String {
        return "Animal(estadoAnimal=$estadoAnimal, nombre='$nombre', idnombre=$idnombre, tipo=$tipo, nombreIdentificador='$nombreIdentificador', apadrinado=$apadrinado, fechaNacimiento=$fechaNacimiento, edad=$edad, sexo=$sexo, sociables=$sociables, solicitudes=$solicitudes)"
    }


}