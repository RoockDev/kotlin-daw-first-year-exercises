fun main() {
    var galletas = ArrayList<Galleta>()
    var salir = false
    do {
        println("""Bienvenid@ a la fabrica de galletas:
        |Seleccione una opcion por favor:
        |1 - [fabricar galleta generica.]
        |2 - [fabricar galleta especial.]
        |3 - [fabricar galleta rellena. ]
        |4 - [fabricar galletita. ]
        |5 - [fabricar una galleta aleatorio. ]
        |6 - [consular nuestros ingredientes especiales. ]
        |7 - [consular la cantidad de galletas que han sido fabricadas. ]
        |8 - [salir. ]
    """.trimMargin())
        //si se introduce un valor erroneo se fabrica una galleta generica por defecto(hay que estar atento)
        var opcion = readln().toIntOrNull() ?: 1
        when (opcion){
            1 -> galletas.add(FactoriaGalletas.fabricaGalleta(1))
            2 -> galletas.add(FactoriaGalletas.fabricaGalleta(2))
            3 -> galletas.add(FactoriaGalletas.fabricaGalleta(3))
            4 -> galletas.add(FactoriaGalletas.fabricaGalleta(4))
            5 ->{
                var random = (1..4).random()
                galletas.add(FactoriaGalletas.fabricaGalleta(random))
            }
            6 -> FactoriaGalletas.imprimeSaboresEspeciales()

            7 -> FactoriaGalletas.imprimeGalletas()
            8 -> salir = true
            // si se introduce un valor mal fabrica una galleta generica por defecto
            else -> galletas.add(FactoriaGalletas.fabricaGalleta(1))
        }
    }while (!salir)
}