package AccesoADatos

import org.example.Perro
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter



class piensoDAOImplem{

    private val archivo_pienso = "piensoSemanal.txt"

    //caclulamos al cantidad de pienso necesario para los perros adultos
    // pair retorna primero al lista de perros y luego la cantidad
    fun callcularPiensoSemanal(perros: List<Perro>): Pair<List<Perro>, Double>{

        //Filtramos solo por perros adultos (no cachorros)
        val perrosAdultos = perros.filter{!it.esCachorro()}

        //calculamos el consumo diario de cada perro y multiplicarlo por 7 dias
        val cantidadTotal = perrosAdultos.sumOf { it.calcularCantidadPienso() * 7 }

        return Pair(perrosAdultos, cantidadTotal)

    }

    //guardamos el caculo en un archivo de texto
    //devuelve true si se ha realizado correctamente y devuelve false si no

    fun guardarPiensoSemanal(perros: ArrayList<Perro>): Boolean{
        var guardado = false
        val archivoPienso = File(archivo_pienso)
       var  cantidadTotal = callcularPiensoSemanal(perros)

        try {
            val fileWriter = FileWriter((archivoPienso))
            val bufferedWritter = BufferedWriter(fileWriter)

            bufferedWritter.write("Cantidad total de kilos de pienso: $cantidadTotal")
            bufferedWritter.newLine()
            bufferedWritter.write("Calculo de pienso semanal")
            bufferedWritter.newLine()

            perros.forEach { perro ->
                val consumoDiario = perro.calcularCantidadPienso()
                val consumoSemanal = consumoDiario * 7


                bufferedWritter.write("${perro.nombre} (${perro.raza}, ${String.format("%.2f", perro.tamanio)} kg): " +
                        "${String.format("%.2f", consumoDiario)} kg/día → " +
                        "${String.format("%.2f", consumoSemanal)} kg/semana")
                bufferedWritter.newLine()

            }
            //cerramos los recursos
            bufferedWritter.close()
            fileWriter.close()
            guardado = true
        }catch (e: Exception){
            e.printStackTrace()
            print("Error al guardar el archivo")
        }
        return guardado
    }

    //Leemos el contenido

    fun leerPienso(): String{
        val archivoPienso = File(archivo_pienso)

        if (archivoPienso.exists()){
            try {
                archivoPienso.readText()
            }catch (e: Exception){
                e.printStackTrace()
                print("Error al leer el archivo")

            }
        }
        return archivoPienso.readText()
    }

    fun calcularMediaPiensoSemanal(perros: ArrayList<Perro>): Boolean{
        val (perrosAdultos, cantidadTotal) = callcularPiensoSemanal(perros)
        return guardarPiensoSemanal(perrosAdultos as ArrayList<Perro>)
    }


}

