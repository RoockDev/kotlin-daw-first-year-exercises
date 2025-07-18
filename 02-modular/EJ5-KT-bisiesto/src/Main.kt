fun main() {
    println("Determina modularmente si un agno es bisiesto o no")
    agnoBisiesto()
}
fun dimeAgno():Int{
    println("Introduce un Agno")
    var agno = readln().toInt()
    return agno
}
fun agnoBisiesto(){
    var bisiesto = dimeAgno()
    if ((bisiesto%4==0) && (bisiesto%100!=0) || bisiesto%400==0){
        println("Es bisiesto")
    }else
        println("No es Bisiesto")
}