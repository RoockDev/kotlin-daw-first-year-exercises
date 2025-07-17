fun main() {
    println("Realiza un algortimo que introducidas las notas de N alumnos nos indicará cuando aprobados\n" +
            "y suspensos hay, parearemos cuando haya una nota negativa, indica no solo cuantos suspensos\n" +
            "y aprobados hay , di tambien cuantos notables, sobresalientes y bienes hay \n")

            var nota = 0
            var suspensos = 0
            var aprobados = 0
            var suficientes = 0
            var bienes = 0
            var notables = 0
            var sobresalientes = 0

        do {
            println("Introduce la nota")
            nota = readln().toInt()
            if (nota>=5){
                aprobados++
            }else if (nota<5 && nota>=0){
                suspensos++
            }else
                aprobados=aprobados
                suspensos=suspensos
            if ((nota>=5) && (nota<6)){
                suficientes++
            }else if ((nota>=6) && (nota<7)){
                bienes++
            }else if ((nota>=7) && (nota <9)){
                notables++
            }else if ((nota>=9) && (nota <=10)){
                sobresalientes++
            }

        }while (nota>0)

        println("Este curso en la clase ha habido un total de $suspensos suspensos")
        println("Un total de $aprobados aprobados")
        println("entre los cuales hay $suficientes suficientes")
        println("$bienes bienes")
        println("$notables notables")
        println("$sobresalientes sobresalientes")

}