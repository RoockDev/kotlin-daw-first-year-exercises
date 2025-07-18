fun main() {
    println("Los empleados de una fábrica trabajan por turnos: diurno y nocturno. Se debe calcular, modularmente, el jornal diario de acuerdo con los siguientes puntos:\n" +
            "- La tarifa por horas diurnas es de 20 €.\n" +
            "- La tarifa por horas nocturnas es de 35 €.\n" +
            "- Caso de ser domingo, la tarifa se incrementará en 10 € más para el turno diurno y 15 € más para el nocturno.\n")
    val TURNO = dimeTurno()
    val JORNADA = dimeJornada()
    val DIA = dimeDia()
    val DINERITO = calculoJornada(TURNO,JORNADA,DIA)
}

fun dimeTurno():Int{
    print("Dime el turno en el que trabajas [1] diurno [2] nocturno ")
    return readln().toInt()
}
fun dimeJornada():Int{
    println("Dime de cuantas horas es tu jornada actualmente")
    return readln().toInt()
}
fun dimeDia():Int{
    println("Si quieres calcular la jornada del domingo pulse 1, si no pulsa otro numero")
    return readln().toInt()
}
fun calculoJornada(num1:Int,num2:Int,num3:Int){
    if (num1==1 && num3!=1){
        println("Tu jornada laboral equivale ${num2*20} Euros")

    }else if (num1==1 && num3==1){
        println("Tu jornada laboral equivale a ${num2*30} Euros")
    }
    if (num1==2 && num3!=1){
        println("Tu jornada laboral equivale a ${num2*35} Euros")
    }else if (num1==2 && num3==1){
        println("Tu jornada laboral  equivale a ${num2*40} Euros")
    }

}