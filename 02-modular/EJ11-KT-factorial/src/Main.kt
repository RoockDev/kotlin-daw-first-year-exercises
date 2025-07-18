fun main() {
    println("Hacer el factorial de un numero factorialmente")
    var numero = dimeDato()
    println("El factorial de $numero es ${factorial(numero)}")
}

fun dimeDato():Int{
    println("Introduce el numero del que quieres hacer el factorial")
    return readln().toInt()
}
fun factorial(numero:Int):Int{
   var result = 1
    //for (i in 1..numero){
      //  result *=i

    //}
    var numeroAux = numero
    while (numeroAux>1){
        result *= numeroAux
        numeroAux--

    }
    return result

}