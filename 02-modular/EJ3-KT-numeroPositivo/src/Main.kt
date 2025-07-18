fun main() {
    println("Determina si un numero leido por teclado es positivo o negativo mediante un programa modular")
    numeroPositivo()

}
fun dimeDato():Int{
    println("Introduce un numero: ")
    var numero = readln().toInt()
    return numero
}
fun  numeroPositivo(){
    var numEntero = dimeDato()
    if (numEntero>0){
        println("El numero entero es positivo")
    }else if(numEntero<0){
        println("El numero entero es negativo")
    }else println("Ha habido un error, Fin programa")
}