fun main() {
    println("Dada la hora por teclado, mostrarla con un segundo de incremento")
    var hora = dimaHora()
    var minutos = dimeMinuto()
    var segundos = dimeSegundo()
    var result= sumaSegundo(hora,minutos,segundos)
    println(result)

}
fun dimaHora():Int{
    println("Introduce la hora")
    return readln().toInt()
}
fun dimeMinuto():Int{
    println("dime los minutos que quieres ingresar")
    return readln().toInt()
}
fun dimeSegundo():Int{
    println("introduce los segundos que desea ingresas")
    return readln().toInt()
}
fun sumaSegundo(hora:Int, minutos:Int,segundos:Int):String{

    var incrementoSegundo = segundos + 1
    var incrementoMinuto = minutos
    var incrementoHora= hora

    if (incrementoSegundo>=60){
        incrementoSegundo -= 60
        incrementoMinuto +=1
    }
    if (incrementoMinuto>=60){
        incrementoMinuto -= 60
        incrementoHora += 1
    }
    if (incrementoHora>=24){
        incrementoHora -=24
    }
    var horaExacta = "son las $incrementoHora:$incrementoMinuto:$incrementoSegundo"
    return horaExacta
}