fun main() {
    println("Calcula la superficie y el perímetro de un cuadrado cuyo lado pediremos por teclado.")

    println("Introduce la longitud del lado del cuadrado")
    var lado= readln().toInt()

    println("La superficie del cuadrado es: ${lado*lado}")
    println("El perimetro del cuadrado es: ${lado*4}")
}