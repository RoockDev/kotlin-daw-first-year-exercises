package AccesoADatos

import Negocio.CantidadKG
import org.example.Perro
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class PiensoDAOSerializable: PiensoDAO {

    //nombre del archivo para guardar los datos
    private val archivo_pienso = "piensoSemanal.dat"


    override fun calcularPiensoSemanal(perros:List<Perro>): CantidadKG {
        //Filtramos los perros adultos, no cachorros
        val perrosAdultos = perros.filter { !it.esCachorro() }

        val cantidadTotal = perrosAdultos.sumOf { it.calcularCantidadPienso() * 7 }

        return CantidadKG(perrosAdultos, cantidadTotal)
    }


    override fun guardarPiensoSemanal(cantidadKG: CantidadKG): Boolean {
        var guardado = false
        val archivoPienso = File(archivo_pienso)
        try {
            val fileOutoutStream = FileOutputStream(archivoPienso)
            val objectOutputStream = ObjectOutputStream(fileOutoutStream)

            //Escribimos el objeto en el archivo
            objectOutputStream.writeObject(cantidadKG)

            //cerramos los recursos
            objectOutputStream.close()
            fileOutoutStream.close()
            print("Archivo guardado correctamente")
            guardado = true
        }catch (e: IOException){
            e.printStackTrace()
            print("Error al guardar el archivo")
        }
        return guardado
    }

    override fun leerPiensoSemanal(): CantidadKG? {
        var cantidadKG: CantidadKG? = null
        val archivoPienso = File(archivo_pienso)

        if (archivoPienso.exists()){
            try {

                //creamos el flujo de entrada para leer el objeto
                val fileInputStream = FileInputStream(archivoPienso)
                val objectoInputStream = ObjectInputStream(fileInputStream)

                //Leer el objeto desde el archivo
                cantidadKG = objectoInputStream.readObject() as CantidadKG

                // Cerramos los recursos
                objectoInputStream.close()
                fileInputStream.close()
            }catch (e: IOException){
                e.printStackTrace()
                print("Error al leer el archivo")
            }
        }
        return cantidadKG
    }
    fun calcularYguardarPiensoSemanal(perros:List<Perro>): Boolean{
        val cantidadKG = calcularPiensoSemanal(perros)
        return guardarPiensoSemanal(cantidadKG)
    }

    fun mostrarDetalle(cantidadKG: CantidadKG): String{

        val sb = StringBuilder()

        cantidadKG.perrosAdultos.forEach { perro ->
            val consumoDiario = perro.calcularCantidadPienso()
            val consumoSemanal = consumoDiario * 7
            sb.appendLine("${perro.nombre} (${perro.raza}, ${String.format("%.2f", perro.tamanio)} kg): " +
                    "${String.format("%.2f", consumoDiario)} kg/día → " +
                    "${String.format("%.2f", consumoSemanal)} kg/semana")
        }

        sb.appendLine("\nTOTAL SEMANAL: ${String.format("%.2f", cantidadKG.cantidadTotal)} kg")


        return sb.toString()


    }





}