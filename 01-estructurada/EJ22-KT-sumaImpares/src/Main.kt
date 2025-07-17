fun main() {
    println("suma todos los numeros impares desde el 1 al 20 mostrando el resultado por pantalla\n" +
    "Generaliza luego este ejercicio para dos numeros que ingreses por teclaod deberia ir del menos al mayor")

    /*var suma = 0
    for (i in 1..20){
        if (i % 2 != 0){ //determina si el numero es impar
            suma +=i
        }
    }*/
   // println(suma)
    println("Introduce un numero")
    var num1 = readln().toInt()
    println("Introduce otro numero")
    var num2 = readln().toInt()

    val MENOR = minOf(num1,num2)
    val MAYOR = maxOf(num1, num2)

    var suma =0
    for (i in MENOR..MAYOR){
        if (i % 2 != 0){
            suma+=i
        }
    }
    println("La suma de los valores enter $MENOR y $MAYOR es $suma")
}