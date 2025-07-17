fun main() {
    println("Determina si un numero es primo o no")

    println("Introduce un numero")
    var number = readln().toInt()
    var contador = 0
    var i = 1
    for(i in i..number){
        if (number%i==0){
            contador++
        }
    }
    if (contador==2){
        println("es primo")
    }else
        println("no es primo")
}