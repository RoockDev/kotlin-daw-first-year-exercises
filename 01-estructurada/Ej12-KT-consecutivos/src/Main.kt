fun main() {
    println("Disegna un algoritmo que pasando 3 numeros por teclado te diga si son consecutivos o no")

    println("Introduce el primer numero ")
    var num1 = readln().toInt()
    println("Introduce el segundo numero ")
    var num2 = readln().toInt()
    print("introduce el tercer numero ")
    var num3 = readln().toInt()
     if((num2 == num1 + 1) && (num3 == num2 + 1)){
         println("Los numeros son consecutivos")
     }else{
         println("los numeros no son consecutivos")
     }
}