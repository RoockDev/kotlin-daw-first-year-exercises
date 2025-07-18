fun main() {
    println(
        "Dados dos números enteros, realizar el algoritmo que calcule el cociente y el resto mediante restas sucesivas. Modularmente.\n" +
                "Ejemplo: 18 : 4\n" +
                "Se irá restando 18 – 4 = 14; 14 – 4 = 10; 10 – 4 = 6; 6 – 4 = 2\n" +
                "hasta que el resultado de la resta (2) es menor que el divisor (4)." +
                " Por lo tanto el cociente es el número de restas que se han hecho (4) y el resto es el valor de la última resta (2).\n")


    var dividendo = dimeDividendo()
    var divisor = dimeDivisor()
    calculo(dividendo,divisor)

}
fun dimeDividendo():Int{
    println("introduce el dividendo")
    return readln().toInt()
}
fun dimeDivisor():Int{
    println("introduce el divisor")
    return readln().toInt()
}
fun calculo(dividendo:Int,divisor:Int){
    var resta = 0
    var contador = 0
    var numeroAxu = dividendo
    while (numeroAxu>=divisor){
        resta = numeroAxu - divisor
        contador ++
        numeroAxu = resta
    }
    println("El cociente es $contador")
    println("El resto es $resta")
}
