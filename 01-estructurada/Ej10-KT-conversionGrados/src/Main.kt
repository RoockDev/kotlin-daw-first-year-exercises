fun main() {
    println(
        "Realiza un conversor de grados Centígrados a grados Farenheit.\n" +
                " Nuestro algoritmo debe poder hacer la conversión en ambos sentidos."
    )


    println("Que conversion deseas hacer, C to F[1] o F to C[2]")
    var conversion = readln().toInt()
    if (conversion == 1) {
        println("Introduce los grados Centigrados")
        var gradosCentigrados = readln().toDouble()
        var gradosFarenheit = ((9 / 5) * gradosCentigrados) + 32
        println("$gradosCentigrados grados centigrados equivalen a $gradosFarenheit grados farenheit")
    } else if (conversion == 2) {
        println("introduce los grados fahrenheit")
        var gradosFarenheit = readln().toDouble()
        var gradosCentigrados = ((gradosFarenheit - 32) * 5) / 9
        println("$gradosFarenheit grados farenheit equivalen a $gradosCentigrados grados centigrados")
    }


}