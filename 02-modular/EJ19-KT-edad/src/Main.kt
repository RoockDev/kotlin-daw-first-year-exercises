fun main() {
    println("introduce el agno actual y el agno de nacimiento de una persona para calcular la edad actual")

    var fechaActual = fechaActual()
    var fechaNacimiento = fechaNacimiento()
    var edadActual = calculoEdad(fechaActual,fechaNacimiento)
    println("La edad es $edadActual")
}
fun fechaActual():Int{
    println("Dime en Agno actual")
    return readln().toInt()
}
fun fechaNacimiento():Int{
    println("Dime en que Agno nacistes")
    return readln().toInt()
}
fun calculoEdad(fechaActual:Int,fechaNacimiento:Int):Int{
    var edad = fechaActual - fechaNacimiento
    return edad
}