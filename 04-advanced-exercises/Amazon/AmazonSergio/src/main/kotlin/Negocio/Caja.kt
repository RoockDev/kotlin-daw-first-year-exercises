package Negocio

import java.io.Serializable

class Caja(val cantidadMaximaDeObjetos: Int,val pesoMaximo: Double): Serializable {

    var id = 0
    var tipo : String = ""
    var cantidadDeObjetosActuales = 0
    var objetosActuales = ArrayList<Objeto>()
    var historicoDeObjetos = ArrayList<Objeto>()
    var pesoActual = 0.0
    var vecesDescargada = 0

    companion object{
        var contadorCajas = 0
    }

    init {
        contadorCajas++
        id = contadorCajas
    }


    fun getHistoricoDeObjetos(): ArrayList<Objeto>{
        return historicoDeObjetos
    }

    fun getMediaPesoPorObjeto(): Double{

        return  if (cantidadDeObjetosActuales == 0){
            0.0
        }else{
            pesoActual/cantidadDeObjetosActuales
        }
    }

    fun addObjetos(objetos: List<Objeto>): Int{ //devuelve int 0 = exito, -1 = fallo peso, -2 = fallo cantidad

        var resultado = 0
        for (i in objetos){
            val futuroPeso = pesoActual +i.peso
            if (futuroPeso > pesoMaximo){
                resultado = - 1 //peso maximo superado
                //println("Peso maximo superado")
            }

            val cantidadFutura = cantidadDeObjetosActuales + 1
            if (cantidadFutura > cantidadDeObjetosActuales){
                resultado = - 2 // cantidad maxima de objetos permitidos
                //println("Cantidad maxima de objetos permitidos superada")
            }

            //si no ha pasado por los if el objeto puede ser añadido a la caja
            pesoActual += i.peso
            cantidadDeObjetosActuales++
            objetosActuales.add(i)
            historicoDeObjetos.add(i)
            //println("Objeto añadido correctamente")
        }

        return resultado


    }


    fun descargaTodaLaCaja(): List<Objeto>{
        val objetoSacados = objetosActuales
        objetosActuales.clear()
        pesoActual = 0.0
        cantidadDeObjetosActuales = 0
        vecesDescargada++
        return objetoSacados

    }

    fun descargarPorCantidad(cantidad: Int): List<Objeto>{
        val objetosSacados = ArrayList<Objeto>()
        try {
            repeat(cantidad){
                if (cantidadDeObjetosActuales > 0){
                    val objetoAEliminar = objetosActuales.removeFirst()
                    objetosSacados.add(objetoAEliminar)
                    pesoActual -= objetoAEliminar.peso
                    cantidadDeObjetosActuales--
                }

            }
        }catch (e: Exception){
            if (cantidad < cantidadDeObjetosActuales){
                println("No se pudo descargar la cantidad solicitada")
            }
        }
        return objetosSacados
    }

    fun tieneObjetoPeligroso(): Boolean{
        var peligroso = false
        for (i in objetosActuales){
            if (i.peligroso){
                peligroso = true
            }
        }
        return peligroso
    }



}