fun main() {
    println("Dado el nombre o numero de un mes y el agno(comprobando si es bisiesto o no)\n"+
    "Deduce el numero de dias del mes")
    println("Introduce el mes que deseas comprobar")
    var mes = readln()
    println("introduce el agno")
    var agno = readln().toInt()

    val dias = dimeMes(mes,agno)
    if (dias !=null){
        println("el mes tiene $dias dias ")
    }




}
fun dimeBisiesto(agno:Int) :Boolean{
    return ((agno % 4 == 0 && agno % 100 != 0) || (agno % 400 ==0))

}
fun dimeMes(mes:String?, agno: Int) :Int?{
    return when(mes){
        "1", "enero" -> 31
        "2", "febrero" -> if (dimeBisiesto(agno)) 29 else 28
        "3", "marzo" -> 31
        "4", "abril" -> 30
        "5", "mayo" -> 31
        "6", "junio" -> 30
        "7", "julio" -> 31
        "8", "agosto" -> 31
        "9", "septiembre" -> 30
        "10", "octubre" -> 31
        "11", "nomviembre" -> 30
        "12", "diciembre" -> 31
        else -> null
    }





}


