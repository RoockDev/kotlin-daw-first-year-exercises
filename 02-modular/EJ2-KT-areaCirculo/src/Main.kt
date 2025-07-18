fun main() {
    println("Disena un programa modular que calcule el area y la circunferencia" +
            "de un circulo cuyo radio se debe preguntar al usuario")
    var radio = dimeDatos()
    area(radio)
    circunferencia(radio)


}
fun dimeDatos():Int{
    println("Dime la longitud del radio")
     var dato = readln().toInt()
    return dato
}
fun area(r:Int){
    var pi = 3.14
    var area = pi *(r*r)
    println("El área del círculo es: $area")
}
fun circunferencia(r:Int){
    var pi= 3.14
    var circunferencia = 2*pi*r
    println("La circunferencia del circulo es: $circunferencia")

}
