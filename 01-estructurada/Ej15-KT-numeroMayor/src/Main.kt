fun main() {
    println("Calcula cual es el mayor de tres números que se piden por teclado")
    println("Introduce el primer numero")
    var num1 = readln().toInt()
    println("Introduce el segundo numero")
    var num2 = readln().toInt()
    println("Introduce el tercer numero")
    var num3 = readln().toInt()

    if ((num1 > num2) && (num1 > num3)) {
        println("El numero mayor es $num1")
    } else if ((num2>num1) && (num2>num3)){
        println("El numero mayor es $num2")
    } else if ((num3>num1) && (num3>num2)){
        println("El numero mayor es $num3")
    }else{
        println("ninguno es mayor sobre los otros dos")
    }

}

