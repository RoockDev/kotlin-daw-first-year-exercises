fun main() {
    println("Mostrar el mensaje: “¿Desea terminar (s/n)?”. El programa terminará cuando el usuario teclee ‘s’ o ‘S’;\n" +
            "en otro caso el programa continuará indefinidamente")

    do {
        println("Desea terminar(S/N)")
        var terminar = readln()
    }while (terminar != "s" && terminar != "S")
    println("el programa ha terminado")


}