fun main() {
    println("Determinar modularmente si un numero es primo o no lo es")
    var numero = dimeDato()
    if (calculoPrimo(numero)){
        println("El numero que has introducido es primo")
    }
    else println("El numero que has introducido no es primo")

}
fun dimeDato():Int{
    println("Introduce el numero que quieres comprobar")
    return readln().toInt()
}
fun calculoPrimo(numero:Int):Boolean{
    var contador  = 0
    var primo = false
    for (i in 1..numero){
        if (numero%i==0){
            contador++
        }
    }
    if (contador==2){
        primo = true
    }
    return primo
}