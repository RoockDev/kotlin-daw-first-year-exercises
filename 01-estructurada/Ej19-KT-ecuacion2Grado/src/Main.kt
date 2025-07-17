import kotlin.math.sqrt
fun main() {
    println("Resolver ecuacion de Segundo Grado")

    println("Dime el primer coeficiente(a)")
    var a = readln().toInt()
    println("Dime el segundo coeficiente(b)")
    var b = readln().toInt()
    println("Dime el tercer coeficiente(c)")
    var c = readln().toInt()

    var determinanante = (b*b) - 4*a*c

    if (determinanante>0){
        var solucion1= (-b +sqrt(determinanante.toDouble()))/(2*a)
        var solcuion2=(-b -sqrt(determinanante.toDouble()))/(2*a)
        println("las soluciones de la ecuacion son $solucion1 y $solcuion2")

    }else if (determinanante==0) {
        var unicaSolucion = (-b) / (2 * a)
        println("la solucion de la raiz es $unicaSolucion")
    }else{
        println("no tiene solucion")
    }


}