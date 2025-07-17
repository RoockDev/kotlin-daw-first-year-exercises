fun main() {
    println(
        "Leídos dos números por teclado, restar al mayor el menor. Por ejemplo, si A=9 y B=3 entonces se debe mostrar:\n" +
                "“El primero es mayor y la resta es 6” "
    )
    println("Introduce el primero número")
    var num1 = readln().toIntOrNull()
    while (num1 == null) {
        println("Debes introducir un numero Entero")
        num1 = readln().toIntOrNull()
    }
    println("Introduce el segundo número")
    var num2 = readln().toIntOrNull()
    while (num2 == null) {
        println("Debes introducir un numero Entero")
        num2 = readln().toIntOrNull()
    }
    if (num1 > num2) {
        println("$num1 es mayor y la resta es ${num1 - num2}")

    } else if (num2 > num1) {
        println("$num2 es mayor y la resta es ${num2 - num1}")
    } else {
        println("Son iguales, debes introducir dos numeros diferentes")
    }


}