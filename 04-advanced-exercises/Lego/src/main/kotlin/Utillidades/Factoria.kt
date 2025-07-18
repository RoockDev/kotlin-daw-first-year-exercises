package Utillidades

import Negocio.Reto
import kotlin.random.Random

object Factoria {
    fun crearRetos(cantidad:Int):List<Reto>{
        val retos = ArrayList<Reto>()

        for(i in 1..cantidad){
            val inteligenciaRequerida = Random.nextInt(50, 151)
            val edadMinima = Random.nextInt(15, 41)
            val edadMaxima = Random.nextInt(edadMinima, 101)
            val esDeFuerza = Random.nextBoolean()
            val fuerzaRequerida = if (esDeFuerza) Random.nextInt(50, 201) else 0


            val descripcion = if (esDeFuerza ){
                "Reto de fuerza"
            }else{
                "Reto de habilidad"
            }

            val reto = Reto(
                inteligenciaRequerida,
                edadMinima,
                edadMaxima,
                esDeFuerza,
                fuerzaRequerida,
                descripcion
            )

            retos.add(reto)

        }

        return retos

    }
}