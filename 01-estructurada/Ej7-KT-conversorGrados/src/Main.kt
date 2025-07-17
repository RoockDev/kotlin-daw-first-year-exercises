fun main() {
    println("Determina si un numero leido por teclado es bisiesto o no")
    println("Introduce un numero")

    var numero: Int = readln().toIntOrNull()!!

    while (numero==null){
        println("Introduce un numero")
        numero = readln().toIntOrNull()!!
    }
    if ((numero % 4 ==0 && numero % 100 !=0) || (numero % 400 ==0) ){
        println(" $numero es bisiesto")
    }else{
        println("$numero no es bisiesto")
    }

}