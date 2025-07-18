package AcessoDatos

import Negocio.Ciudad
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

object CiudadesDAOFichero {
    fun escribirCiudades(fichero: String,listaCiudades: List<Ciudad>) {
        val fichero = File(fichero)
        try {
            //si el archivo existe devuelve true si no devuelve false
            val append = fichero.exists()

            val fw = FileWriter(fichero,append)
            val bw = BufferedWriter(fw)
            for (ciudad in listaCiudades){
                bw.write(ciudad.nombre )
                bw.newLine() //agregamos salto de linea
            }

            bw.close()
            fw.close()
        }catch (e: Exception){
            e.printStackTrace()
            print("Error al escribir en el fichero")
        }
    }
    fun leerCiudades(fichero: String) : List<Ciudad>{
        val listaCiudades = ArrayList<Ciudad>()
        try {
            val fr = File(fichero).bufferedReader()
            var linea = fr.readLine()
            while (linea != null){
                val item = linea.split(",")
                listaCiudades.add(Ciudad(item[0].toInt(),item[1]))
                linea = fr.readLine()
            }
        }catch (e: Exception){
            e.printStackTrace()
            print("Error al leer el fichero")
        }
        return listaCiudades
    }


}