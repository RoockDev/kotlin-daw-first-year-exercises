fun main() {
    println("Los empleados de una fabrica trabajan por turnos: diurnos y nocturnos\n"+
    "Se debe calcular el jornal diario de acuerdo con los siguientes puntos: \n" +
    "La tarifa por horas diurnas es de 20 $\n" +
    "La tarifa por horas nocturnas esde 35 $\n" +
    "en caso deser Domingo , diurno 10 $ mas y nocturno 15 $ mas.")

    val PRECIODIA = 20
    val PRIONOCHE = 35
    var jornal = 0
    println("Vamos a calcular el jornal que ganarás hoy")
    println("De que turno trabajarás hoy")
    var turno = readln()
    println("que dia es hoy?")
    var dia = readln()
    println("por ultimo, cuantas horas trabajas hoy")
    var horas = readln().toInt()

    if ((turno=="dia" && dia.equals("domingo")==false)){
        jornal = PRECIODIA*horas
        println("Tu jornal de hoy será $jornal $")
    }else if ((turno=="dia" && dia.equals("domingo")==true)) {
        jornal = (PRECIODIA+10) * horas
        println("Tu jornal de hoy será $jornal $")
    }else if ((turno=="noche" && dia.equals("domingo")==false)) {
        jornal = PRIONOCHE * horas
        println("Tu jornal de hoy será $jornal $")
    }else if ((turno=="noche" && dia.equals("domingo")==true)) {
        jornal = (PRIONOCHE + 15) * horas
        println("Tu jornal de hoy será $jornal $")
    }else{
        println("Debe de haber algo mal")
    }
}