fun main() {
    println("Determinar el numero de cifras de un numero(5 cifras maximo)")

    println("Introduce un numero")
    var numero = readln()
    while(numero.length>5){
        println("El numero no puede contener mas de 5 cifras")
        println("Introduzca de nuevo el numero")
        numero = readln()
    }
    //println("El numero $numero contiene ${numero.length} cifras")
    var contador = 0
    for (i in numero ){
        contador++
    }
    println("El numero $numero tiene $contador cifras")



}