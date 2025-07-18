fun main() {


    var adversarios = ArrayList<Adversario>()
    var guardianEstelar = Factoria.crearGuardianEstelar()
    var ciclo = 1
    var totalAdversarios = 0
    val coronaCristal = CoronaCristal()
    //Se generan los cristales
    println("Comenzamos la simulacion")
    println("La Corona de Cristal Genera los Cristales del Universo")
    coronaCristal.asignacionDeCristalesBasicos() //asignamos los cristales basicos a la corona
    coronaCristal.asignacionCristalesPurpura() // asignamos los cristales purpura a la corona
    coronaCristal.removerCristales() //mezclamos el orden de las cristales para la busqueda de ellos
    println("Corona generando registro de cristales...")
    coronaCristal.guardarRegistro() //guarda un registro de todos los cristales para su posteriormente poder localizarlos


    while (guardianEstelar.vivo() && !guardianEstelar.cantidadCristalesPurpura()) {
        println("Ciclo ${ciclo}\n")
        println("Aparicion de adversarios: \n")
        //Generamos de 1 a 3 adversarios aleatorios
        if (adversarios.size < CONSTANTES.MAXIMO_ADVERSARIOS) {
            var random = (1..CONSTANTES.PROBABILIDAD_CANTIDAD_MAXIMA_ADVERSARIOS).random()
            while (random != 0 && adversarios.size < CONSTANTES.MAXIMO_ADVERSARIOS) {
                var adversario = Factoria.crearUnAdversario()
                println("${adversario.nombre} Se une a los Adversarios")
                totalAdversarios++
                adversarios.add(adversario)
                random--
            }
        } else {
            println("Maximo 100 adversarios, no se añaden mas")
        }
        //Mostramos el numero de adversarios que hay
        println("Total Adversarios: ${totalAdversarios} \n")
        println("Comienza la busqueda de Cristales... \n")
        //Comprobamos que existan queden cristales en existencia para poder buscar
        if (coronaCristal.existenciaCristales()) {
            for (i in adversarios) {
                println("El adversario ${i.nombre} esta buscando cristales..")
                if (i.probabilidadEncontrarCristal() && i.probabilidadEncontrarCristalPurpura() && coronaCristal.purpuraExistentes()) {
                    println("El adversario ${i.nombre} ha encontrado un cristal PURPURA")
                    i.conversionMaestroDeCristales() // se convierte en maestro de cristales
                    i.agnadirCristalaAlmacen(coronaCristal.devuelveCristalPurpura()) //añadimos el cristal al almacen del adversario
                } else if (i.probabilidadEncontrarCristal() && coronaCristal.cristalesBasicosExistentes()) {
                    println("El adversario ${i.nombre} ha encontrado un cristal basico")
                    i.agnadirCristalaAlmacen(coronaCristal.devuelveCristalBasico())
                } else println("El adversario ${i.nombre} no ha encontrado ningun cristal")
            }
        } else (println("No existen mas Cristales, los adversarios no pueden buscar mas, deberan de proteger los cristales que les quedan"))
        println("Cristales restantes: ${coronaCristal.cristalesRestantes}")
        println("Cristlaes Basicos restantes; ${coronaCristal.totalCristalesBasicos}")
        println("Cristales purpura restantes : ${coronaCristal.totalCristalesPurpuras}")
        //El guardian revisa al menos el 50% de los adverarios existentes
        var probabilidad = (((5 until 10).random()) / 10.0).toDouble()
        //calculamos el minimo de adversarios a revisar y redondeamos hacia arriba
        var cantidadArevisar = (adversarios.size * probabilidad).toInt().coerceAtLeast(adversarios.size / 2)
        //removemos la lista de adversarios tomamos(take) los adversarios para revisar
        var adversariosArevisar = adversarios.shuffled().take(cantidadArevisar)
        println("El Maestro esta en busca de Maestros De cristales..")
        for (i in adversariosArevisar) {
            if (i.maestroDeCristales) {
                println("El guardian se ha encontrado con el Maestro de Cristales ${i.nombre}")
                println("comienza la lucha")
                var batalla = guardianEstelar.batallaVsMaestroCristales(i) //el guardian lucha contra el maestro
                if (batalla) {
                    println("El guardian ha ganado la batalla y se queda con el cristal purpura")
                } else println("El guardian pierde vs ${i.nombre} y pierde resistencia...")
            }
        }
        println("Busqueda Terminada")

        guardianEstelar.mostrarCristalesPurpuraGuardian() //Mostramos Cristales Purpura del guardian
        guardianEstelar.mostrarResistencia() //Mostramos la resistencia del guardian

        //Mostramos los cristales que tiene los adversarios
        for (i in adversarios) i.mostrarCristales()
        ciclo++

    }
    if (guardianEstelar.cantidadCristalesPurpura()) {
        guardianEstelar.mostrarCristalesPurpuraGuardian()
        guardianEstelar.mostrarResistencia()
        println("El Guardian ha reunido todos los cristales Purpura, Gana la partida")
    } else if (!guardianEstelar.vivo()) println("Guardian abatido, Fin de la partida")




}