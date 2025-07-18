package AcessoDatos

import Negocio.UsuarioSerializable
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

private fun ArrayList<UsuSerializable>.add(e: UsuarioSerializable) {}

object UsuSerializable {

    fun escribirEnArchivo(fichero: String,listaUsuarios: List<UsuarioSerializable>){
        var objectOutput: ObjectOutputStream? = null
        try {
            var fs = FileOutputStream(fichero)
            objectOutput = ObjectOutputStream(fs)
            objectOutput.writeObject(listaUsuarios)
        }catch (e: Exception){
            e.printStackTrace()
            print("Error al escribir en el fichero")
        }finally {
            objectOutput?.close()
        }

    }

    fun leerFichero(fichero: String): List<UsuarioSerializable>{
        var lista = ArrayList< UsuarioSerializable>()
        var fileInput: FileInputStream? = null
        var objectInput: ObjectInputStream? = null

        try {
            fileInput = FileInputStream(fichero)
            objectInput = ObjectInputStream(fileInput)
            while (objectInput.available() > 0){
                var item = objectInput.readObject() as UsuarioSerializable
                lista.add(item)
            }
        }catch (e: Exception){
            e.printStackTrace()
            print("Error al leer fichero")
        }finally {
            fileInput?.close()
            objectInput?.close()
        }

        return lista
    }
}