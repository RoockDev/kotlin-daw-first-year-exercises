fun main() {
    println("Calular que numeros son primos desde el 1 hasta el 100")
    var numero = dimeLimite()
    calculaPrimoHasta(numero)

}
fun dimeLimite():Int{
    println("Dime hasta que numero quieres calcular los numeros primos")
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
fun calculaPrimoHasta(Hasta:Int){
    for (i in 1..Hasta){
        if (calculoPrimo(i)){
            println("$i es primo")
        }
    }
}