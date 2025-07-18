package AccesoADatos

import Negocio.Caja
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class CajaPeligroDAOImplSerializable {

    private val nombreFichero = "CajasPeligrosas.txt"

    fun leerCajasPeligrosasFichero(): ArrayList<Caja>{
        val archivo = File(nombreFichero)
        var listaCajas = ArrayList<Caja>()

        try {
            if (archivo.exists()){
                val entrada = ObjectInputStream(FileInputStream(archivo))
                listaCajas = entrada.readObject() as ArrayList<Caja>
                entrada.close()
            }
        }catch (e: Exception){
            println("Error al recuperar las cajas")
        }

        return listaCajas
    }

    fun guardarCaja(caja: Caja){

        try {
            var cajas = leerCajasPeligrosasFichero()
            cajas.add(caja)

            val salida = ObjectOutputStream(FileOutputStream(nombreFichero))
            salida.writeObject(cajas)
            salida.close()
            println("Caja guardada correctamente")
        }catch (e: Exception){
            println("Error al guardar la caja")
        }
    }
}