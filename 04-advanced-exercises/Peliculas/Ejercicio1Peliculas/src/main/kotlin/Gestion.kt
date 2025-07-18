package org.example

import java.io.File

class Gestion {
    val fichero = "peliculas.txt"


    fun agnadirPeliculas(titulo:String,director:String,duracion:String,agno:String){
        File(fichero).appendText("$titulo, $director, $duracion, $agno ")
        //appendText agnade al fichero y si no existe nada de crea la informacion
    }

    fun borrarPeli(titulo:String){
        //guardamos la lista de peliculas
        val peliculas = peliculas()
        //se busca el it que empieze por el titulo introducido e ignoramos mayuscuals y minusculas
        var peliculaAborrar = peliculas.find { it.startsWith(titulo,ignoreCase = true) }
        if (peliculaAborrar != null){
            val listaNueva = peliculas.filterNot { it == peliculaAborrar } // lista nueva con la pelicula it eliminada
            File(fichero).writeText(listaNueva.joinToString ("\n")) //writeText sobreescribe el fichero
        }

    }

    fun mostrarPeliculas(){
        val peliculas = peliculas()
        if (peliculas.isNotEmpty()){
            for ( i in peliculas){
                println("Pelicula: ${i} ")
            }
        }
    }

    //he intentado hacerlo con arraylist de otra manera pero no me funcionaba
    //asique lo he hecho como en el ejercicio del drive
    //pero he entendido y aprendido el funcionamiento
    fun peliculas():List<String>{
        return if (File(fichero).exists()){
            File(fichero).readLines()
        }else{
            emptyList()
        }
    }

}