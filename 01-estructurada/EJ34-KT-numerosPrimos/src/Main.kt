fun main() {
    println("Determina los numeros primos del 1 al 100")
    var number=0
for (i in 1..100){
    number++
    var contador = 0
    var i = 1
    for(i in i..number){
        if (number%i==0){
            contador++
        }
    }
    if (contador==2){
        println(number)
    }
}


}