fun main() {
    println("Vamos a comprobar las rutas de los guias de la empresa")
    for ( i in Constantes.MINIMO until Constantes.NUMEROTOTALGUIAS){
        println("${Factoria.devuelveGuiaConVariasRutas()}")
    }
}