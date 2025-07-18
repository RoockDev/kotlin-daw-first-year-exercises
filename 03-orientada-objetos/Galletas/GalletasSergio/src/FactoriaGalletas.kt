class FactoriaGalletas {


    companion object{
        var totalGalletas = 0
        var totalEspeciales = 0
        var totalRellenas = 0
        var totalGalletitas = 0

        fun fabricaGalleta(opcion:Int):Galleta{
            return when(opcion){
                1-> {
                    totalGalletas++
                    println("Se acaba de fabricar una galleta generica")
                    Galleta()
                }
                2 -> {
                    totalGalletas++
                    totalEspeciales++
                    println("Se acaba de fabricar una galleta especial")
                    GalletaEspecial()
                }
                3 -> {
                    totalGalletas++
                    totalRellenas++
                    println("Se acaba defabricar una galleta rellena")
                    GalletaEspecial()
                }
                4 -> {
                    totalGalletas++
                    totalGalletitas++
                    println("Se acaba de fabricar una galletita")
                    Galletitas()
                }
                else -> {
                    totalGalletas++
                    Galleta()
                    // Crea una galleta generica si se introduce un valor negativo
                }

            }
        }

        //Mostramos el total de cada galleta que ahi
        fun imprimeGalletas(){
            println("Total Galletas: $totalGalletas")
            println("Galletas Especiales: $totalEspeciales")
            println("Galletas Rellenas: $totalRellenas")
            println("Galletitas: $totalGalletitas")
        }

        // Mostramos el resultado de los sabores especiales
        fun imprimeSaboresEspeciales(){
            for (i in SaboresEspeciales.values()){
                println(i.name)
            }
        }
    }

}