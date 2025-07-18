package org.example

import AccesoADatos.AnimalDAOImplement
import AccesoADatos.GastoFechaDAOImplemt
import AccesoADatos.SolicitudDAOImplemt
import AccesoADatos.piensoDAOImplem
import Negocio.GastoFecha
import Utilidades.CONSTANTES

class Protectora {
    val nombre = "HUELLAS"
    val ubicacion = "Puertollano"
    var totalAnimales = ArrayList<Animal>()
    var presupuesto = (1000..15000).random()

    private val animalDAO = AnimalDAOImplement()
    private val solicitudDAO = SolicitudDAOImplemt()
    private val gastoFechaDAO = GastoFechaDAOImplemt()
    private val piensoDAO = piensoDAOImplem()

    fun agregarAnimal(animal: Animal) {
        totalAnimales.add(animal)
    }

    fun eliminarAnimal(animal: Animal) {
        totalAnimales.remove(animal)
    }

    fun calculaGastoAnimalMensual(): Int {
        return totalGastoLeishmania() +
                totalGastoPPPandNoSociable() +
                totalGastoEnVacunasPerros() +
                totalcontrolDeCelos()


    }

    fun actualizarPresupuestoTrasMes(){
        presupuesto -= calculaGastoAnimalMensual()
    }

    fun totalGastoLeishmania(): Int {
       var totalPerrosConLeishmanias = 0
        var gasto = 0
      for (i in totalAnimales){
          if (i is Perro && i.tratamientoVsLeishmania == true && i.apadrinado ==true){
              totalPerrosConLeishmanias++
          }
      }
        gasto = totalGastoLeishmania() * CONSTANTES.GASTO_LEISHMANIA
        return gasto
    }

    fun totalGastoPPPandNoSociable(): Int{
        var perrosPeligrososNoSociables = 0
        for (i in totalAnimales){
            if (i is Perro && i.sociables == false && i.ppp == true && i.apadrinado == true){
             perrosPeligrososNoSociables++
            }
        }

        return perrosPeligrososNoSociables * CONSTANTES.SEDACCION
    }

    fun totalGastoEnVacunasPerros(): Int{
        var gasto = 0
        for (i in totalAnimales){
            if (i is Perro && i.apadrinado == true){
                gasto += CONSTANTES.VACUNA_RABIA
            }
        }
        return gasto
    }

    fun totalcontrolDeCelos(): Int{
        var gasto = 0
        for (i in totalAnimales){
            if (i is Gato && i.apadrinado == true){
                gasto += CONSTANTES.CONTROL_DE_CELO
            }
        }
        return gasto
    }

    fun totalPerros(): Int {
        var totalPerros = 0
        for (i in totalAnimales) {
            if (i is Perro) {
                totalPerros++
            }
        }
        return totalPerros
    }

    fun totalGatos(): Int{
        var totalGatos = 0
        for (i in totalAnimales){
            if (i is Gato){
                totalGatos++
            }
        }
        return totalGatos

    }

    fun agnadirAnimalA(animal: Animal){
        totalAnimales.add(animal)
    }

    //Ejercicio 2

    fun mostrarAnimales(){
        println("\n ==== Informacion Animales ====")

        val animales = animalDAO.getAllAnimales()
        if (animales.isNotEmpty()){
            animales.forEach { animal ->
                println(animal.toString())
            }
        }else{
            println("No hay animales registrador")
        }
    }

    //Ejercicio 3 Registra una solicitud de acopcion o acogida

      fun solicitud(){
         var solicitado = false
         var nombre = ""
         var eleccion: Int? = null
         var email = ""
         while(!solicitado){
             println("\n ==== Registro de Solicitud ====")
             println("Introduce nombre de la mascota")
              nombre = readLine() ?: "${NombreAnimales.devuelveNombre()}"
             println("[0] acogida, [1] adopcion")
              eleccion = readLine()!!.toIntOrNull() ?: 0 // acogida por defecto
             println("Introduce un email")
              email = readLine() ?: "generico@generico.com"
             if (eleccion in 0..1) solicitado = true
         }

         if (solicitudDAO.guardarSolicitud(nombre, eleccion!!, email)){
             println("Solicitud enviada correctamenete")
         }else{
             println("Error al enviar solicitud")
         }

    }

    //Ejercicio 4 Calcular  los agstos del veterinario anuales y guardarlo en la bbdd

     fun calcularGastosVeterinario(){
        println("\n ==== Calculo de gastos de veterinario ==== ")
        val animales = animalDAO.getAllAnimales()
        var gastoTotal = 0.0

        if (animales.isNotEmpty()){
            animales.forEach { animal ->
                when(animal){
                    is Perro -> gastoTotal += animal.calculatGastoVeterinario()
                    is Gato -> gastoTotal += animal.calculatGastoVeterinario()
                    else -> println("Animal no encontrado")
                }
            }

            println("Gasto total anual: $gastoTotal")

            //añadimos el gasto calculado a la bbdd
            val fechaActual = FechasDeNacimiento.fechaAleatoria().toString()
            val gastoFecha = GastoFecha(fechaActual,gastoTotal)

            if (gastoFechaDAO.insertarGasto(gastoFecha)){
                println("Gastos añadidos correctamente a la base de datos")
            }else{
                println("Por lo que sea no se han podido añadir los gastos")
            }

        }else{
            println("No hay animales registrados")
        }
    }


    //Ejercicio 5: Calcular la cantidad de pienso semanal y guardarlo en un fichero
    fun calcularPiensoSemanal(){
        println("\n ==== Calculo de pienso semanal ====")
        val animales = animalDAO.getAllAnimales()
        //filtramos solo los animales que son perro
        val perros = animales.filterIsInstance<Perro>()

        if (perros.isNotEmpty()){
            val cantidadKG = piensoDAO.callcularPiensoSemanal(perros)

            //mostramos  los resultados
            println("Calculo de pienso para perros adultos")


            //Guardamos los resultados
            if (piensoDAO.guardarPiensoSemanal(
                    animales as ArrayList<Perro>,


                )){
                println("Datos guardados correctamente")
            }else println("No se ha podido registrar el pienso semanal")
        }


    }



}