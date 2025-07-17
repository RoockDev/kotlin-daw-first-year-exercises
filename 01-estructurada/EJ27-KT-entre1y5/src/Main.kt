fun main() {
    println("Disegna un algortimo que te pida numeros hasta que se introduzca un valor mayor que 100")

    println("Introduce un numero")
    var number = readln().toInt()
    while (number<=100){
        println("Introduce otro numero")
        number = readln().toInt()
    }
    println("De acuerdo, el programa ha finalizado")

}