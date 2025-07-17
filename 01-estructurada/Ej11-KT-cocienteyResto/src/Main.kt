fun main() {
    println("Disegna un algoritmo que determine si tres numero pedidos por teclado\n" +
            "estan ordenados de menor a mayor(No quiero que se ordenen, solo indicar lo anterior).")

    println("Introduce el primer numero")
    var num1 = readln().toInt()
    println("Introduce el segundo numero")
    var num2 = readln().toInt()
    println("Introduce el tercer numero")
    var num3 = readln().toInt()

    if ((num1<num2 && num1<3) && num2<num3){
        println("Enhorabuena, los numeros estan ordenados de menor a mayor")
    }else{
        println("los numeros no estan ordenados de menor a mayor, sigue intentandolo")
    }

}

