fun main() {
    println("Calcula la superficie y el perímetro de un rectángulo cuyos datos pediremos por teclado")

    println("Introduce el largo del rectangulo")
    var largo= readln().toInt()
    println("Introduce el ancho del rectangulo")
    var ancho= readln().toInt()

    println("El perímetro del rectangulo es: ${2 * (largo + ancho)}")
    println("La superficie del rectangulo es: ${largo * ancho}")

}