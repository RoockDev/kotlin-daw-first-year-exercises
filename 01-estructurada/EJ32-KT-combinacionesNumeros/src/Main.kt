fun main() {
    println("ingresa dos numeros por teclado n y m y muestra todas sus combinaciones posibles")

    println("Ingresa un numero")
    var n = readln().toInt()
    println("Ingresa otro numero")
    var m = readln().toInt()

    var i = 1

    while (i<=n){
        var j = 1
        while (j<= m){
            println("$i $j")
            j++
        }
        i++
    }
}