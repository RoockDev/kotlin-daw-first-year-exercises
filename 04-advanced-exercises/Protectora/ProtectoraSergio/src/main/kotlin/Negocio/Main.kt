package org.example


fun main() {
 val huellas = Protectora() // Creamos la protectora con la que vamos a hacer la simualcion
 do {
     mostrarMenu()
     var eleccion = readln().toIntOrNull() ?: 0
     var salir = false
     when(eleccion){
         1 -> huellas.mostrarAnimales()
         2 -> huellas.solicitud()
         3 -> huellas.calcularGastosVeterinario()
         4 -> huellas.calcularPiensoSemanal()
         5 -> salir = true

     }

 }while (!salir)


}

fun mostrarMenu(){
    println("\n ===== Protectora de animales Huellas ======")
    println("1. Mostrar informacion de los animales")
    println("2.Registrar Solicitud de adopcion o acogida")
    println("3.Calcular gastos de veterinario actuales")
    println("4.Calcular pienso animal")
    println("5.Salir")

}

